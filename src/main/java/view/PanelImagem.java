package view;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Igor J Rodrigues
 */
public class PanelImagem extends javax.swing.JPanel {
    String imgPath;
    BufferedImage imgBuff;
    JLabel imageLabel;

    /**
     * Creates new form DialogImagem
     *
     * @param imgPath
     */
    public PanelImagem(String imgPath) {
        initComponents();
        try {
            abrirImagem(imgPath);
            exibirImagem();
            this.imgPath = imgPath;
        } catch (IOException ex) {
            Logger.getLogger(PanelImagem.class.getName()).log(Level.SEVERE, null, ex);
        }

        repaint();
        setVisible(true);
    }

    private void restaurar() {
        try {
            imgBuff.flush();
            abrirImagem(imgPath);
        } catch (IOException ex) {
            Logger.getLogger(PanelImagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void abrirImagem(String imgPath) throws IOException {
        File imageFile = new File(imgPath);
        Image img = ImageIO.read(imageFile);
        Image dimg = img.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        imgBuff = toBufferedImage(dimg);

        Image imgOg = ImageIO.read(imageFile);
    }

    private void reload() {
        this.remove(imageLabel);
        exibirImagem();
        imageLabel.repaint();
    }

    private void exibirImagem() {
        imageLabel = new JLabel();
        imageLabel.setSize(400, 400);
        ImageIcon iconImage = new ImageIcon(imgBuff);
        imageLabel.setIcon(iconImage);
        this.add(imageLabel);
        this.setLayout(null);
        imageLabel.setLocation(0, 0);
        imageLabel.setVisible(true);
    }

    private void tonsCinzaImagem() {
        for (int x = 0; x < imgBuff.getWidth(); x++) {
            for (int y = 0; y < imgBuff.getHeight(); y++) {
                int rgb = imgBuff.getRGB(x, y);
                int red = (rgb & 0x00ff0000) >> 16;
                int green = (rgb & 0x0000ff00) >> 8;
                int blue = rgb & 0x000000ff;

                int newRed = (red + green + blue) / 3;
                int newGreen = newRed;
                int newBlue = newRed;
                int newRGB = ((newRed & 0xff) << 16) | ((newGreen & 0xff) << 8) | (newBlue & 0xff);

                imgBuff.setRGB(x, y, newRGB);
            }
        }
    }

    private void negativoImagem() {
        for (int x = 0; x < imgBuff.getWidth(); x++) {
            for (int y = 0; y < imgBuff.getHeight(); y++) {
                int rgb = imgBuff.getRGB(x, y);
                int red = (rgb & 0x00ff0000) >> 16;
                int green = (rgb & 0x0000ff00) >> 8;
                int blue = rgb & 0x000000ff;

                int newRed = 255 - red;
                int newGreen = 255 - green;
                int newBlue = 255 - blue;
                int newRGB = ((newRed & 0xff) << 16) | ((newGreen & 0xff) << 8) | (newBlue & 0xff);

                imgBuff.setRGB(x, y, newRGB);
            }
        }
    }

    public void canal(String canal) {
        for (int x = 0; x < imgBuff.getWidth(); x++) {
            for (int y = 0; y < imgBuff.getHeight(); y++) {
                int rgb = imgBuff.getRGB(x, y);
                int red = (rgb & 0x00ff0000) >> 16;
                int green = (rgb & 0x0000ff00) >> 8;
                int blue = rgb & 0x000000ff;

                int canalEscolhido = rgb;
                if (canal.equals("r")) {
                    canalEscolhido = (red << 16) | (red << 8) | red;
                }
                if (canal.equals("g")) {
                    canalEscolhido = (green << 16) | (green << 8) | green;
                }
                if (canal.equals("b")) {
                    canalEscolhido = (blue << 16) | (blue << 8) | blue;
                }
                imgBuff.setRGB(x, y, canalEscolhido);
            }
        }
    }

    public int[] getPixel(Point p) {
        int x = p.x, y = p.y;
        int rgb = imgBuff.getRGB(x, y);
        int red = (rgb & 0x00ff0000) >> 16;
        int green = (rgb & 0x0000ff00) >> 8;
        int blue = rgb & 0x000000ff;
        return new int[]{red, green, blue};
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        return bimage;
    }

    public void operacoes(String op) {
        switch (op) {
            case "negativo" -> {
                negativoImagem();
                reload();
                return;
            }
            case "cinza" -> {
                tonsCinzaImagem();
                reload();
                return;
            }
            case "restaurar" -> {
                restaurar();
                reload();
                break;
            }
            case "r" -> {
                canal("r");
                reload();
                break;
            }
            case "g" -> {
                canal("g");
                reload();
                break;
            }
            case "b" -> {
                canal("b");
                reload();
                break;
            }
            default -> {
                return;
            }
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
