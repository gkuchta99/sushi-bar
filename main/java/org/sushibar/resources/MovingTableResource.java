package org.sushibar.resources;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class MovingTableResource {
    private char[][] sushiBar = new char[10][36];
    private char[] foodLine = new char[18];
    public static final char FOOD = '1';
    public static final char EMPTY = '_';

    public MovingTableResource() {
        Arrays.fill(foodLine, EMPTY);
        for (char[] row : sushiBar)
            Arrays.fill(row, ' ');
        genCustomers();
        genLines();
        genCookers();
        updateFoodLine();
    }

    public synchronized void setFoodLineElement(int index, char value) {
        this.foodLine[index] = value;
    }

    public synchronized void updateFoodLine() {
        int foodLineIndexCounter = 0;
        for (int i = 7; i < 29; i = i + 4) {
            sushiBar[1][i] = foodLine[foodLineIndexCounter];
            foodLineIndexCounter++;
        }

        for (int i = 3; i < 8; i = i + 2) {
            sushiBar[i][31] = foodLine[foodLineIndexCounter];
            foodLineIndexCounter++;
        }

        for (int i = 27; i > 6; i = i - 4) {
            sushiBar[8][i] = foodLine[foodLineIndexCounter];
            foodLineIndexCounter++;
        }

        for (int i = 7; i > 2; i = i - 2) {
            sushiBar[i][4] = foodLine[foodLineIndexCounter];
            foodLineIndexCounter++;
        }


    }

    private void genLines() {
        for (int i = 9; i < 29; i = i + 4) {
            sushiBar[1][i] = '>';
            sushiBar[8][i] = '<';
        }
        for (int i = 4; i < 8; i = i + 2) {
            sushiBar[i][31] = 'v';
            sushiBar[i][4] = '^';
        }
        sushiBar[2][30] = '\\';
        sushiBar[2][5] = '/';
        sushiBar[8][5] = '\\';
        sushiBar[8][30] = '/';
    }

    private void genCustomers() {
        int customerCounter = 1;
        for (int i = 7; i < 30; i = i + 4) {
            sushiBar[0][i] = 'm';
            sushiBar[0][i + 1] = '0';
            sushiBar[0][i + 2] = Character.forDigit(customerCounter, 10);
            customerCounter++;
        }
        for (int i = 3; i < 8; i = i + 2) {
            sushiBar[i][33] = 'm';
            sushiBar[i][34] = '0';
            sushiBar[i][35] = Character.forDigit(customerCounter, 10);
            customerCounter++;
        }
        customerCounter = 0;
        for (int i = 27; i > 6; i = i - 4) {
            sushiBar[9][i] = 'm';
            sushiBar[9][i + 1] = '1';
            sushiBar[9][i + 2] = Character.forDigit(customerCounter, 10);
            customerCounter++;
        }
        for (int i = 7; i > 2; i = i - 2) {
            sushiBar[i][0] = 'm';
            sushiBar[i][1] = '1';
            sushiBar[i][2] = Character.forDigit(customerCounter, 10);
            customerCounter++;
        }

    }

    private void genCookers() {
        sushiBar[2][7] = 'k';
        sushiBar[2][8] = '0';
        sushiBar[2][9] = '1';

        sushiBar[2][26] = 'k';
        sushiBar[2][27] = '0';
        sushiBar[2][28] = '2';

        sushiBar[7][7] = 'k';
        sushiBar[7][8] = '0';
        sushiBar[7][9] = '4';

        sushiBar[7][26] = 'k';
        sushiBar[7][27] = '0';
        sushiBar[7][28] = '3';
    }


    public synchronized void moveLine() {
        char[] tempFoodLine = new char[18];
        for (int i = 0; i < tempFoodLine.length; i++) {
            if (i == 17) {
                tempFoodLine[0] = foodLine[17];
            } else {
                tempFoodLine[i + 1] = foodLine[i];
            }
        }
        foodLine = Arrays.copyOf(tempFoodLine, tempFoodLine.length);
        updateFoodLine();
    }

}
