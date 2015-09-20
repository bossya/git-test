/**
 * Created by BoSS on 04.06.2014.
 */
public class Cell {
    public static final int WATER = 0;
    public static final int BUFFER = 1;
    public static final int SHIP = 2;
    public static final int STRUCK_CELL = 3;

    private int stateOfCell = WATER;
    private Ship ship = null; // - ссылка на корабль, который попадает на данную ячейку

    public void setStateOfCell(int state) {
        stateOfCell = state;
    }

    public void setStateOfCell(int state, Ship ship) {
        stateOfCell = state;
        this.ship = ship;
    }

    public int getStateOfCell() {
        return stateOfCell;
    }

   public void shot() {
        switch (stateOfCell) {
            case WATER: {
                System.out.println("Мимо");
                break;
            }
            case BUFFER: {
                System.out.println("Мимо");
                break;
            }
            case SHIP: {
                String result = ship.hit();
                System.out.println(result);
                break;
            }
            case STRUCK_CELL: {
                System.out.println("Вы уже стреляли в эту ячейку");
                break;
            }
        }
        stateOfCell = STRUCK_CELL;
    }
}
