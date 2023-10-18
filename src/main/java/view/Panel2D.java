package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import model.Graficos2D;

/**
 *
 * @author Igor J Rodrigues
 */
public abstract class Panel2D extends javax.swing.JPanel {

    ArrayList<Point> points;
    Point p1;
    Point p2;
    /**
     * Creates new form Panel2D
     */
    public Panel2D() {
        initComponents();
        points = new ArrayList<Point>();
        this.setBackground(Color.white);
        interacaoMouse();
        repaint();
        setVisible(true);
    }

    public abstract ArrayList<Point> desenhar(Point p1, Point p2);
    
    public void interacaoMouse() {
        addMouseListener(
                new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e
            ) {
                p1 = e.getPoint();
            }
        }
        );
        addMouseListener(
                new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e
            ) {
                p2 = e.getPoint();
                points.addAll(desenhar(p1, p2));
                repaint();
            }
        }
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (p1 == null || p2 == null) {
            return;
        }
        g.setColor(Color.black);
        for (Point p : points) {
            g.fillOval(p.x, p.y, 5, 5);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
