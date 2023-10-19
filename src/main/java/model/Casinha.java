package model;

/**
 *
 * @author Igor J Rodrigues
 */
public class Casinha {

    Ponto3D[] pontos;
    Ponto3D[][] linhas;

    public Casinha() {
        pontos = new Ponto3D[10];
        //Frente
        pontos[0] = new Ponto3D(0, 0, 0);
        pontos[1] = new Ponto3D(100, 0, 0);
        pontos[2] = new Ponto3D(100, 100, 0);
        pontos[3] = new Ponto3D(0, 100, 0);
        pontos[4] = new Ponto3D(50, 150, 0);
        //Trás
        pontos[5] = new Ponto3D(0, 0, 100);
        pontos[6] = new Ponto3D(100, 0, 100);
        pontos[7] = new Ponto3D(0, 100, 100);
        pontos[8] = new Ponto3D(100, 100, 100);
        pontos[9] = new Ponto3D(50, 150, 100);

        linhas = new Ponto3D[15][2];

        linhas[0] = new Ponto3D[]{pontos[0], pontos[1]};
        linhas[1] = new Ponto3D[]{pontos[0], pontos[3]};
        linhas[2] = new Ponto3D[]{pontos[0], pontos[5]};
        linhas[3] = new Ponto3D[]{pontos[1], pontos[6]};
        linhas[4] = new Ponto3D[]{pontos[1], pontos[2]};
        linhas[5] = new Ponto3D[]{pontos[2], pontos[4]};
        linhas[6] = new Ponto3D[]{pontos[2], pontos[8]};
        linhas[7] = new Ponto3D[]{pontos[3], pontos[7]};
        linhas[8] = new Ponto3D[]{pontos[3], pontos[4]};
        linhas[9] = new Ponto3D[]{pontos[4], pontos[9]};
        linhas[10] = new Ponto3D[]{pontos[5], pontos[7]};
        linhas[11] = new Ponto3D[]{pontos[5], pontos[6]};
        linhas[12] = new Ponto3D[]{pontos[6], pontos[8]};
        linhas[13] = new Ponto3D[]{pontos[8], pontos[9]};
        linhas[14] = new Ponto3D[]{pontos[9], pontos[7]};

    }
}
