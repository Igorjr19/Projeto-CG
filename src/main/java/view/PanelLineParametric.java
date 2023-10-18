package view;

import java.awt.Point;
import java.util.ArrayList;
import model.Graficos2D;

/**
 *
 * @author Igor J Rodrigues
 */
public class PanelLineParametric extends Panel2D {

    @Override
    public ArrayList<Point> desenhar(Point p1, Point p2) {
        return Graficos2D.drawLineParametric(p1, p2);
    }
    
}
