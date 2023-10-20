package model;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Igor J Rodrigues
 */
public class Graficos3D extends Graficos2D {
    private static Casinha casinha = new Casinha();
    
    public void restaurar(){
        casinha = new Casinha();
    }
    
    public static ArrayList<Point> projecaoOrtogonal(String eixo){
        ArrayList<Point> points = new ArrayList();
        for (Ponto3D[] linha : casinha.linhas) {
            int[] a = linha[0].projecaoOrtogonal(eixo);
            int[] b = linha[1].projecaoOrtogonal(eixo);
            points.addAll(drawLineBresenham(new Point(a[0], a[1]), new Point(b[0], b[1])));
        }
        return points;
    }
    
    public static ArrayList<Point> projecaoCavalera(){
        ArrayList<Point> points = new ArrayList();
        for (Ponto3D[] linha : casinha.linhas) {
            int[] a = linha[0].projecaoCavalera();
            int[] b = linha[1].projecaoCavalera();
            points.addAll(drawLineBresenham(new Point(a[0], a[1]), new Point(b[0], b[1])));
        }
        return points;
    }
}
