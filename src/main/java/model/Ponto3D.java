package model;

/**
 *
 * @author Igor J Rodrigues
 */
public class Ponto3D {

    public double[][] matriz;

    public Ponto3D(int x, int y, int z) {
        matriz = initMatrix();
        matriz[0][0] = x;
        matriz[1][1] = y;
        matriz[2][2] = z;
        matriz[3][3] = 1;
    }
    
    public double[][] initMatrix(){
        double[][] matriz;
        matriz = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = 0;
            }
        }
        return matriz;
    }
    
    double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }

        return result;
    }

    double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }
    
    
    public int[] projecaoCavalera(){
        double sen = 0.5253;
        double cos = 0.8509;
        
       
        
        return new int[]{(int) (matriz[0][0] + matriz[2][2] * cos), (int) (matriz[0][0] + matriz[2][2] * sen)};
    }

    public int[] projecaoOrtogonal(String eixo) {
        switch (eixo) {
            case "z" -> {
                return new int[]{(int) this.matriz[0][0], (int) this.matriz[1][1]};
            }
            case "y" -> {
                return new int[]{(int) this.matriz[0][0], (int) this.matriz[2][2]};
            }
            case "x" -> {
                return new int[]{(int) this.matriz[1][1], (int) this.matriz[2][2]};
            }
            default ->
                throw new AssertionError();
        }
    }
}
