package DSA.Practice.TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static void ticTacToe() {
        Scanner scan = new Scanner(System.in);

        String[][] matrix = {
                {" "},{" "},{" "},
                {" "},{" "},{" "},
                {" "},{" "},{" "}
        };

        int countO = 0;
        int countX = 0;
        int countStep = 1;

        System.out.print("Чтоб начать игру [Начать] или [']: ");
        String firstMove = scan.next().toLowerCase();

        for (int i = 0; i < matrix.length; i += 3) {
            for (int j = 0; j < 3; j++) {
                System.out.print(Arrays.toString(matrix[i + j]));
            }
            System.out.println();
        }

        upperFor:
        while (countStep < 11) {
            if ("начать".equals(firstMove) || "'".equals(firstMove)) {
                countX++;
            }

            int move;

            if ((matrix[0][0].equals("X") && matrix[1][0].equals("X") && matrix[2][0].equals("X")) ||
                    (matrix[3][0].equals("X") && matrix[4][0].equals("X") && matrix[5][0].equals("X")) ||
                    (matrix[6][0].equals("X") && matrix[7][0].equals("X") && matrix[8][0].equals("X")) ||
                    (matrix[0][0].equals("X") && matrix[3][0].equals("X") && matrix[6][0].equals("X")) ||
                    (matrix[1][0].equals("X") && matrix[4][0].equals("X") && matrix[7][0].equals("X")) ||
                    (matrix[2][0].equals("X") && matrix[5][0].equals("X") && matrix[8][0].equals("X")) ||
                    (matrix[0][0].equals("X") && matrix[4][0].equals("X") && matrix[8][0].equals("X")) ||
                    (matrix[2][0].equals("X") && matrix[4][0].equals("X") && matrix[6][0].equals("X"))) {
                System.out.println("X победил");
                return;
            } else if ((matrix[0][0].equals("0") && matrix[1][0].equals("0") && matrix[2][0].equals("0")) ||
                    (matrix[3][0].equals("0") && matrix[4][0].equals("0") && matrix[5][0].equals("0")) ||
                    (matrix[6][0].equals("0") && matrix[7][0].equals("0") && matrix[8][0].equals("0")) ||
                    (matrix[0][0].equals("0") && matrix[3][0].equals("0") && matrix[6][0].equals("0")) ||
                    (matrix[1][0].equals("0") && matrix[4][0].equals("0") && matrix[7][0].equals("0")) ||
                    (matrix[2][0].equals("0") && matrix[5][0].equals("0") && matrix[8][0].equals("0")) ||
                    (matrix[0][0].equals("0") && matrix[4][0].equals("0") && matrix[8][0].equals("0")) ||
                    (matrix[2][0].equals("0") && matrix[4][0].equals("0") && matrix[6][0].equals("0"))) {
                System.out.println("0 победил");
                return;
            } else if (countStep == 10) {
                System.out.println("Игра закончилась");
                return;
            }
            if (countO < countX) {

                System.out.printf("Ход %d [X]: ", countStep);
                move = scan.nextInt();

                if (Arrays.stream(matrix[move - 1]).allMatch(n -> n.equals(" "))) {
                    matrix[move - 1][0] = "X";
                }

                countO = 3 + countO;
                countX--;
                countStep++;

            } else if (countO > countX) {

                System.out.printf("Ход %d [0]: ", countStep);
                move = scan.nextInt();

                if (Arrays.stream(matrix[move - 1]).allMatch(n -> n.equals(" "))) {
                    matrix[move - 1][0] = "0";
                }

                countX++;
                countO--;
                countStep++;

            }
            for (int i = 0; i < matrix.length; i += 3) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(Arrays.toString(matrix[i + j]));
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ticTacToe();
    }
}
