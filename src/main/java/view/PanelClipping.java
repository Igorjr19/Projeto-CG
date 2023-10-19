package view;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import model.Graficos2D;

/**
 *
 * @author Igor J Rodrigues
 */
public class PanelClipping extends Panel2D {
    private int xL, yB, xR, yT;

    public PanelClipping(int xL, int yB, int xR, int yT) {
        super();
        this.xL = xL;
        this.yB = yB;
        this.xR = xR;
        this.yT = yT;
        this.points.addAll(Graficos2D.rectangle(xL, yB, xR, yT));
        repaint();
    }
    
    
    @Override
    public ArrayList<Point> desenhar(Point p1, Point p2) {
        return Graficos2D.recorteRetas(p1, p2, xL, yB, xR, yT);
    }
    
}
