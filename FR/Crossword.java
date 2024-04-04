public class Crossword
{
   /** Each element is a Square object with a color (black or white) and a number.
   * puzzle[r][c] represents the square in row r, column c.
   * There is at least one row in the puzzle.
   */
   private Square[][] puzzle;

   /** Constructs a crossword puzzle grid.
   Precondition: There is at least one row in blackSquares.
   Postcondition:
   * The crossword puzzle grid has the same dimensions as blackSquares.
   * The Square object at row r, column c in the crossword puzzle grid is black
   * - if and only if blackSquares[r][c] is true.
   * - The squares in the puzzle are labeled according to the crossword labeling rule.
   */
   public Crossword(boolean[][] blackSquares)
   { /* to be implemented in part (b) */ }

   /** Returns true if the square at row r, column c should be labeled with a positive number;
   * false otherwise.
   * The square at row r, column c is black if and only if blackSquares[r][c] is true.
   * Precondition: r and c are valid indexes in blackSquares.
   */
   private boolean toBeLabeled(int r, int c, boolean[][] blackSquares)
   { /* to be implemented in part (a) */ }

   // There may be instance variables, constructors, and methods that are not shown.
   public Square getSquare(int r, int c) { return puzzle[r][c]; }

}
