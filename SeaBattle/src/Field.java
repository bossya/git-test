/**
 * Created by Andrew on 15.04.2014.
 */

public class Field {

    private Cell[][] cell = new Cell[12][12];
    private int numberOfShips = 0;

    public Field() {
        fillField();
    }

    private void fillField() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                cell[i][j] = new Cell();
            }
        }
    }
    public void printField() {
        System.out.println("  А Б В Г Д Е Ж З И К");
        for (int i = 1; i < 11; i++) {
            if (i < 10) {
                System.out.print(i + " ");
            } else {
                System.out.print(i);
            }
            for (int j = 1; j < 11; j++) {
                if ( cell[j][i].getStateOfCell() == 2 ) {
                    System.out.print("Q|");
                } else {
                    System.out.print("_|");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public void spyField() {
        System.out.println("  А Б В Г Д Е Ж З И К");
        for (int i = 1; i < 11; i++) {
            if (i < 10) {
                System.out.print(i + " ");
            } else {
                System.out.print(i);
            }
            for (int j = 1; j < 11; j++) {
                if ( cell[j][i].getStateOfCell() == 2 ) {
                    System.out.print("_|");
                } else {
                    System.out.print("_|");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void increaseNumberOfShips() {
        numberOfShips++;
    }

    public boolean cellIsFreeToPlacement(int x, int y) {
        int state = Cell.SHIP;
        if ( x <= 10 && y <= 10 )
        {
            state = cell[x][y].getStateOfCell();
        }
        return ( state == Cell.WATER );
    }

    public void setCell(int x,int y, int state) {
        cell[x][y].setStateOfCell(state);
    }

    public void setCell(int x,int y, int state, Ship ship) {
        cell[x][y].setStateOfCell(state, ship);
    }
    public void decreaseNumberOfShips() {
        numberOfShips--;
        if (numberOfShips == 0) {
            System.out.println("Победа");
            System.exit(0);
        }
    }
    public void shot(int x, int y) {
        cell[x][y].shot();
    }
}
