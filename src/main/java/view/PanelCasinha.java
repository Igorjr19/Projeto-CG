package view;

import java.awt.Point;
import java.util.ArrayList;
import model.Graficos3D;

/**
 *
 * @author Igor J Rodrigues
 */
public class PanelCasinha extends Panel2D {

    @Override
    public ArrayList<Point> desenhar(Point p1, Point p2) {
        return Graficos3D.projecaoCavalera();
        }
    
}
