public class Sudoku {
    private int[][] sudoku = new int[9][9];
    private MiniMatrix mini  = new MiniMatrix();


    private void setSudoku(int[][] sudoku, MiniMatrix mini, int i, int j){
        int iFirst = 3*j;
        int jFirst = 3*i;

        int iMini = 0;
        for(int p = iFirst; p < (iFirst+3); p++){
            int jMini = 0;
            for (int r = jFirst; r < (jFirst+3); r++){
                sudoku[p][r] = mini.getValue(iMini,jMini);
                jMini++;
            }
            iMini++;
        }
    }

    private boolean checkColumn(int[][] sudoku, int iFirst, int jFirst){
        for (int j = jFirst; j < (jFirst + 3); j++){
             for (int i = 0; i < (iFirst + 3); i++){
                 int k = i + 1;
                 while (k < (iFirst + 3)){
                     if (sudoku[k][j] == sudoku[i][j]){
                         return true;
                     }
                     k++;
                 }
            }
        }
        return false;
    }

    private boolean checkRow(int[][] sudoku, int iFirst, int jFirst){
        for (int i = iFirst; i < (iFirst + 3); i++){
            for (int j = 0; j < (jFirst + 3); j++){
                int k = j + 1;
                while (k < (jFirst + 3)){
                    if (sudoku[i][k] == sudoku[i][j]){
                        return true;
                    }
                    k++;
                }
            }
        }
        return false;
    }

    public int[][] newSudoku(){
        boolean complete = true;

        while (complete) {
            for (int i = 0; i < 3; i++) {
                int jFirst = 3 * i;
                for (int j = 0; j < 3; j++) {
                    int iFirst = 3 * j;
                    int count = 0;
                    boolean check = true;

                    if (complete) {
                        while (check) {
                            count++;
                            System.out.println(i + ", " + j);
                            mini.newMatrix();
                            mini.printMatrix();
                            setSudoku(sudoku, mini, i, j);
                            boolean checkCol = checkColumn(sudoku, iFirst, jFirst);
                            boolean checkRow = checkRow(sudoku, iFirst, jFirst);

                            if (!checkCol & !checkRow) {
                                check = false;
                            }

                            if (count > 100000){
                                check = false;
                                complete = false;
                            }
                        }
                    }
                }
            }
            if(!complete){
                complete = true;
            }else{
                complete = false;
            }
        }
        return sudoku;
    }

    public void printSudoku(){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j< 9; j++){
                System.out.print(sudoku[i][j] + ", ");
            }
            System.out.println("");
        }
    }
}