package model;

/**
 *
 * @author Igor J Rodrigues
 */
public class Ponto3D {
    public int[][] matriz;
    
    public Ponto3D(int x, int y, int z){
        matriz = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = 0;
            }
        }
        matriz[0][0] = x;
        matriz[1][1] = y;
        matriz[2][2] = z;
        matriz[3][3] = 1;
    }
    
    public int[] projecaoOrtogonal(String eixo){
        switch (eixo) {
            case "z" -> {
                return new int[]{this.matriz[0][0], this.matriz[1][1]};
            }
            case "y" -> {
                return new int[]{this.matriz[0][0], this.matriz[2][2]};
            }
            case "x" -> {
                return new int[]{this.matriz[1][1], this.matriz[2][2]};
            }
            default -> throw new AssertionError();
        }
    }
}
