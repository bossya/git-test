import java.util.Random;

/**
 * Created by Andrew on 15.04.2014.
 */
public class Ship {

    private int numberOfDecks;
    private int health;
    private Field field;
    private Random random = new Random();

    public Ship(int numberOfDecks, Field field) {
        this.numberOfDecks = numberOfDecks;
        health = numberOfDecks;
        this.field = field;
        this.field.increaseNumberOfShips();
    }
    private int randomX() {
        return random.nextInt(10) + 1;
    }

    private int randomY() {
        return random.nextInt(10) + 1;
    }

    private boolean randomDirection() {
        return random.nextBoolean();
    }
    public void randomPlacement() {
        boolean is_placed = false;
        while (!is_placed) {
            is_placed = placeShip(randomX(), randomY(), randomDirection());
        }
    }
    public boolean placeShip (int x, int y, boolean shipIsHorizontal)
    {
        boolean success = true;

        if (shipIsHorizontal) {
            for (int i = 0; i < numberOfDecks; i++) {
                if (!field.cellIsFreeToPlacement(x + i, y)) {
                    success = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i < numberOfDecks; i++) {
                if (!field.cellIsFreeToPlacement(x, y + i)) {
                    success = false;
                    break;
                }
            }
        }
        if (success) {
            if (shipIsHorizontal) {
                for (int i = -1; i <= numberOfDecks; i++) {
                    field.setCell(x + i, y - 1, Cell.BUFFER);
                    field.setCell(x + i, y + 1, Cell.BUFFER);
                }
                field.setCell(x - 1, y, Cell.BUFFER);
                field.setCell(x + numberOfDecks, y, Cell.BUFFER);
                for (int i = 0; i < numberOfDecks; i++) {
                    field.setCell(x + i, y, Cell.SHIP, this);
                }
            } else {
                for (int i = -1; i <= numberOfDecks; i++) {
                    field.setCell(x - 1, y + i, Cell.BUFFER);
                    field.setCell(x + 1, y + i, Cell.BUFFER);
                }
                field.setCell(x, y - 1, Cell.BUFFER);
                field.setCell(x, y + numberOfDecks, Cell.BUFFER);
                for (int i = 0; i < numberOfDecks; i++) {
                    field.setCell(x, y + i, Cell.SHIP, this);
                }
            }
        }
        return success;
    }
    public String hit() {
        health--;
        if (health == 0) {
            field.decreaseNumberOfShips();
        }
        return (health > 0) ? "Ранил" : "Убил";
    }

}