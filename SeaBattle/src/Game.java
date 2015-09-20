import java.util.Scanner;

/**
 * Created by Andrew on 15.04.2014.
 */
public class Game {

    private static int x, y;

    private static void automaticShipsPlacement(Field field) {
        for (int i = 4; i >= 1; i--) {
            for (int j = 4; j >= i; j--) {
                new Ship(i, field).randomPlacement();
            }
        }
    }

    public static void main(String[] args) {
        Messages message = new Messages();
        message.lettersToNumber();
        message.hello();
        boolean collocationChoice = message.CollocationChoice();
        if (collocationChoice == true) {
            Field userField = new Field();
            Field computerField = new Field();
            automaticShipsPlacement(userField);
            automaticShipsPlacement(computerField);
            System.out.println("Корабли " + Messages.getUserName());
            userField.printField();
            System.out.println("Корабли копьютера");
            computerField.spyField();

            while (true) {
                System.out.print("Введите координату для выстрела в раскладке RU. Например Б2 :");
                Scanner input = new Scanner(System.in);
                String gamerChoice = input.nextLine();
                if (gamerChoice.equals("exit") ) {
                    System.exit(0);
                }
                x = Messages.getX(gamerChoice);
                y = Messages.getY(gamerChoice);
                computerField.shot(x, y);
            }
        } else {
            System.out.print("Неработает");
        }
    }
}
