package model;

import java.awt.Point;
import java.util.ArrayList;

public class Graficos2D {

    public static ArrayList<Point> drawLineLinear(Point a, Point b) {
        ArrayList<Point> linePoints = new ArrayList<Point>();
        int x1 = a.x, x2 = b.x, y1 = a.y, y2 = b.y;
        int deltaX = Math.abs(x2 - x1);
        int deltaY = Math.abs(y2 - y1);
        int x = y1, y = y1;

        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                y = i;
                Point p = new Point(x1, y);
                linePoints.add(p);
            }
            return linePoints;
        }

        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                x = i;
                Point p = new Point(x, y1);
                linePoints.add(p);
            }
            return linePoints;
        }

        double m = (double) (y2 - y1) / (double) (x2 - x1);

        if (deltaX > deltaY) {
            if (x1 > x2) {
                int aux = x1;
                x1 = x2;
                x2 = aux;
                aux = y1;
                y1 = y2;
                y2 = aux;
                x = x1;
                y = y1;
            }
            for (int i = x1; i <= x2; i++) {
                x = i;
                y = (int) (m * (x - x1) + y1);
                Point p = new Point(x, y);
                linePoints.add(p);
            }
        } else {
            if (y1 > y2) {
                int aux = y1;
                y1 = y2;
                y2 = aux;
                aux = x1;
                x1 = x2;
                x2 = aux;
                x = x1;
                y = y1;
            }
            for (int i = y1; i <= y2; i++) {
                x = (int) ((y - y1) / m + x1);
                y = i;
                Point p = new Point(x, y);
                linePoints.add(p);
            }
        }
        return linePoints;
    }

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
    public static ArrayList<Point> drawLineBresenham(Point a, Point b) {
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

    public static ArrayList<Point> drawLineParametric(Point a, Point b) {
        ArrayList<Point> linePoints = new ArrayList();
        for (double i = 0; i <= 1; i += 0.01) {
            System.out.println("i: " + i);
            int x = (int) (a.x + (b.x - a.x) * i);
            int y = (int) (a.y + (b.y - a.y) * i);
            Point p = new Point(x, y);
            linePoints.add(p);
        }
        return linePoints;
    }

    public static ArrayList<Point> drawCircleNormal(Point a, Point b) {
        ArrayList<Point> linePoints = new ArrayList();
        int r = (int) Math.sqrt(Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y), 2));
        for (int xi = -r; xi <= r; xi++) {
            int y = (int) Math.sqrt(r * r - xi * xi);
            Point p1 = new Point(a.x + xi, a.y + y);
            linePoints.add(p1);
            Point p2 = new Point(a.x + xi, a.y - y);
            linePoints.add(p2);
        }
        return linePoints;
    }

    public static ArrayList<Point> drawCircleParametric(Point a, Point b) {
        ArrayList<Point> linePoints = new ArrayList();
        int r = (int) Math.sqrt(Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y), 2));
        for (double i = 0; i < 6.28; i += 0.01) {
            int x = (int) (r * Math.cos(i));
            int y = (int) (r * Math.sin(i));
            Point p = new Point(x + a.x, y + a.y);
            linePoints.add(p);
        }
        return linePoints;
    }

    public static ArrayList<Point> drawCircleBresenham(Point a, Point b) {
        ArrayList<Point> linePoints = new ArrayList();
        int r = (int) Math.sqrt(Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y), 2));
        int x = 0;
        int y = r;
        int h = 1 - r;
        int dE = 3;
        int dSE = -2 * r + 5;

        addSymmetricPoints(linePoints, a, x, y);

        while (x < y) {
            if (h < 0) {
                h = h + dE;
                dE = dE + 2;
                dSE = dSE + 2;
            } else {
                h = h + dSE;
                dE = dE + 2;
                dSE = dSE + 4;
                y = y - 1;
            }
            x = x + 1;

            addSymmetricPoints(linePoints, a, x, y);
        }
        return linePoints;
    }

    private static void addSymmetricPoints(ArrayList<Point> points, Point center, int x, int y) {
        points.add(new Point(x + center.x, y + center.y));
        points.add(new Point(-x + center.x, y + center.y));
        points.add(new Point(x + center.x, -y + center.y));
        points.add(new Point(-x + center.x, -y + center.y));
        points.add(new Point(y + center.x, x + center.y));
        points.add(new Point(-y + center.x, x + center.y));
        points.add(new Point(y + center.x, -x + center.y));
        points.add(new Point(-y + center.x, -x + center.y));
    }
}
