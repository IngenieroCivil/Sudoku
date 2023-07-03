public class Game {
    public static void main(String[] args) {
//        MiniMatrix sudoku = new MiniMatrix();
//        sudoku.newMatrix();
//        sudoku.printMatrix();
//
//        System.out.println(sudoku.getValue(1,0));
        Sudoku sudoku =  new Sudoku();
        sudoku.newSudoku();
        sudoku.printSudoku();
    }
}
