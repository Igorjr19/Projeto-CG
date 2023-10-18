package model;

import java.awt.Point;
import java.util.ArrayList;

public class Graficos2D {

    private static ArrayList<Point> drawLineLow(Point a, Point b) {
        ArrayList<Point> linePoints = new ArrayList<Point>();
        int x1 = a.x, x2 = b.x, y1 = a.y, y2 = b.y;
        int dx = x2 - x1, dy = y2 - y1;
        int x = x1, y = y1;
        int yi = 1;

        if (dy < 0) {
            yi = -1;
            dy = -dy;
        }

        int d = 2 * dy - dx;
        int dE = 2 * dy;
        int dNE = 2 * (dy - dx);

        for (int i = x1; i <= x2; i++) {
            Point p = new Point(x, y);
            linePoints.add(p);
            if (d > 0) {
                y = y + yi;
                d = d + dNE;
            } else {
                d = d + dE;
            }
            x++;
        }
        return linePoints;
    }

    private static ArrayList<Point> drawLineHigh(Point a, Point b) {
        ArrayList<Point> linePoints = new ArrayList<Point>();
        int x1 = a.x, x2 = b.x, y1 = a.y, y2 = b.y;
        int dx = x2 - x1, dy = y2 - y1;
        int x = x1, y = y1;
        int xi = 1;

        if (dx < 0) {
            xi = -1;
            dx = -dx;
        }

        int d = 2 * dx - dy;
        int dE = 2 * dx;
        int dNE = 2 * (dx - dy);

        for (int i = y1; i <= y2; i++) {
            Point p = new Point(x, y);
            linePoints.add(p);
            if (d > 0) {
                x = x + xi;
                d = d + dNE;
            } else {
                d = d + dE;
            }
            y++;
        }
        return linePoints;
    }

    // Algoritmo de Bresenham Generalizado
    public static ArrayList<Point> drawLine(Point a, Point b) {
        ArrayList<Point> linePoints;
        int x1 = a.x, x2 = b.x, y1 = a.y, y2 = b.y;

        if (Math.abs(y2 - y1) < Math.abs(x2 - x1)) {
            if (x1 > x2) {
                linePoints = drawLineLow(b, a);
            } else {
                linePoints = drawLineLow(a, b);
            }
        } else {
            if (y1 > y2) {
                linePoints = drawLineHigh(b, a);
            } else {
                linePoints = drawLineHigh(a, b);
            }
        }
        return linePoints;
    }
}
