import java.util.Random;

public class MiniMatrix {
    private int[] miniVector = new int[9];
    private int[][] miniMatrix = new int[3][3];
    Random newRandom = new Random();

    private boolean checkMatrix(int i, int[] vector) {
        for (int j = 0; j < i; j++) {
            if (vector[j] == vector[i]) {
                return true;
            }
        }
        return false;
    }

    public int[] newVector() {
        for (int i = 0; i < 9; i++) {
            boolean check = true;
            if ((i == 0)) {
                miniVector[i] = 1 + newRandom.nextInt(8);
            } else {
                while (check) {
                    miniVector[i] = 1 + newRandom.nextInt(9);
                    check = checkMatrix(i, miniVector);
                }
            }
        }
        return miniVector;
    }

    public int[][] newMatrix() {
        miniVector = newVector();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                miniMatrix[i][j] = miniVector[i * 3 + j];
            }
        }
        return miniMatrix;
    }

    public void printMatrix() {
        System.out.println("" + miniMatrix[0][0] + ", " + miniMatrix[0][1] + ", " + miniMatrix[0][2]);
        System.out.println("" + miniMatrix[1][0] + ", " + miniMatrix[1][1] + ", " + miniMatrix[1][2]);
        System.out.println("" + miniMatrix[2][0] + ", " + miniMatrix[2][1] + ", " + miniMatrix[2][2]);
        System.out.println("");
    }

    public int getValue(int i, int j){
        return miniMatrix[i][j];
    }
}
