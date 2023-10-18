package model;

/**
 *
 * @author Igor J Rodrigues
 */
public class Extra {
    //RGB <--> HSV: seguindo o exemplo do Paint do Windows 11
    public static double[] RGBtoHSV(double r, double g, double b) {
        //Normaliza os valores do RGB no intervalo [0, 1]
        double nR = r / 255;
        double nG = g / 255;
        double nB = b / 255;

        double max = Math.max(nR, Math.max(nG, nB));
        double min = Math.min(nR, Math.min(nG, nB));
        double dif = max - min;

        double h = -1;
        double s = -1;
        double v = max * 100;

        if (max != 0) {
            s = dif / max;
        } else {
            s = 0;
            h = 0;
            return new double[]{h, s, v};
        }

        if (nR == max) {
            h = (nG - nB) / dif;
        } else if (nG == max) {
            h = 2 + (nB - nR) / dif;
        } else if (nB == max) {
            h = 4 + (nR - nG) / dif;
        }

        h *= 60;
        if (h < 0) {
            h += 360;
        }

        s = s * 100.0;

        int hN = (int) Math.round(h);
        int sN = (int) Math.round(s);
        int vN = (int) Math.round(v);
        return new double[]{hN, sN, vN};
    }

    public static double[] HSVtoRGB(double h, double s, double v) {
        double r, g, b;

        s = s / 100;
        v = v / 100;

        if (s == 0) {
            r = v * 255;
            g = v * 255;
            b = v * 255;
            return new double[]{r, g, b};
        }

        h = h / 60;
        int i = (int) Math.floor(h);
        double f = h - i;
        double p = v * (1 - s);
        double q = v * (1 - s * f);
        double t = v * (1 - s * (1 - f));

        switch (i) {
            case 0 -> {
                r = v;
                g = t;
                b = p;
                break;
            }
            case 1 -> {
                r = q;
                g = v;
                b = p;
                break;
            }
            case 2 -> {
                r = p;
                g = v;
                b = t;
                break;
            }
            case 3 -> {
                r = p;
                g = q;
                b = v;
                break;
            }
            case 4 -> {
                r = t;
                g = p;
                b = v;
                break;
            }
            default -> {
                r = v;
                g = p;
                b = q;
                break;
            }
        }
        return new double[]{r * 155., g * 255., b * 255.};
    }
}
