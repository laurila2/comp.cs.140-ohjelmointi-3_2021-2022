import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sudoku {

    // Width of Sudoku
    private final int N = 9;

    // The 9 x 9 Sudoku-grid
    private final char[][] grid;

    public Sudoku() {
        grid = new char[][] {
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
    }

    public void set(int i, int j, char c) {
        List<Character> sudoku_numbers;
        List<Integer> cell_indexes;
        sudoku_numbers = Arrays.asList(' ', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        cell_indexes = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);

        if (!cell_indexes.contains(i)) {
            System.out.println("Trying to access illegal cell (" + i + ", " + j + ")!");
        }
        else if (!sudoku_numbers.contains(c)) {
            System.out.println("Trying to set illegal character " + c + " to (" + i + ", " + j + ")!");
        }
        else {
            grid[i][j] = c;
        }
    }

    public boolean check() {
        // Check if a given row is valid
        for (int i = 0; i < N; i++) {
            Set<Character> checked_values_row = new HashSet<>();
            char[] row_all_values = grid[i];

            for (var value : row_all_values) {
                // Check for repeated values
                if (value != ' ' & !checked_values_row.add(value)) {
                        System.out.println("Row " + i + " has multiple " + value + "'s!");
                        return false;
                    }
                }
            }

        // Check if a column is valid
        for (int i = 0; i < N; i++) {
            Set<Character> column_values = new HashSet<>();
            for (int j = 0 ; j < N; j++) {
                char value = grid[j][i];
                    if (value != ' ' & !column_values.add(value)) {
                        System.out.println("Column " + i + " has multiple " + value + "'s!");
                        return false;
                    }
            }
        }

        // Check if 3x3 box is valid
        for (int row = 0; row < 9; row = row + 3) {
            for (int col = 0; col < 9; col = col + 3) {
                Set<Character>set = new HashSet<>();

                for(int r = row; r < row+3; r++) {
                    for(int c= col; c < col+3; c++) {

                        char value = grid[r][c];
                        // Checking for repeated values.
                        if (value != ' ' & !set.add(value)) {
                            if (c <= 3) {
                                c = 0;
                            }
                            else if ((c > 3) && (c <= 6)) {
                                c = 3;
                            }
                            else if ((c > 6) && (c <= 8)) {
                                c = 6;
                            }
                            if (r <= 3) {
                                r = 0;
                            }
                            else if ((r > 3) && (r <= 6)) {
                                r = 3;
                            }
                            else if ((r > 6) && (r <= 8)) {
                                r = 6;
                            }
                            System.out.printf("Block at (%d, %d) has multiple %s's!%n", r, c, value);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // A utility function to print grid
    public void print()
    {
        String top = "#####################################\n";
        String middle_div = "\n#####################################\n";
        String bottom = "#####################################\n";
        String divider_small = "\n#---+---+---#---+---+---#---+---+---#\n";
        String hash = "#";

        System.out.format(top);
        for (int i = 0; i < N; i++) {
            System.out.format("%1s", hash);
            for (int j = 0; j < N; j++) {
                if (j % 3 == 2) {
                    System.out.format(" " + grid[i][j] + " " + hash);
                }
                else {
                    System.out.format(" " + grid[i][j] + " " + "|");
                }
            }
            if (i != 8) {
                if (i % 3 == 2) {
                    System.out.format(middle_div);
                }
                else {
                    System.out.format(divider_small);
                }
            }
            else {
                System.out.println();
            }
        }
        System.out.format(bottom);
    }
}
