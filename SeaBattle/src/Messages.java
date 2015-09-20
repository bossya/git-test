/**
 * Created by Andrew on 15.04.2014.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Messages {

    private static String userName;
    private static ArrayList<String> letterToNumber = new ArrayList<String>();
    private static boolean collocationChoice;

    public static int getX(String gamerChoice) {
        String letter = gamerChoice.substring(0, 1);
        return letterToNumber.indexOf(letter);
    }

    public static int getY(String gamerChoice) {
        String letter = gamerChoice.substring(1, 2);
        int number = Integer.parseInt(letter);
        if (gamerChoice.length() == 3) {
            number = 10;
        }
        return number;
    }

    public void lettersToNumber() {
        setLetterToNumber();
    }

    private static void setLetterToNumber() {
        letterToNumber.add(" ");
        letterToNumber.add("А");
        letterToNumber.add("Б");
        letterToNumber.add("В");
        letterToNumber.add("Г");
        letterToNumber.add("Д");
        letterToNumber.add("Е");
        letterToNumber.add("Ж");
        letterToNumber.add("З");
        letterToNumber.add("И");
        letterToNumber.add("К");
    }

    public void hello() {
        System.out.println("Добро пожаловать в игру SeaBattle.");
        System.out.print("Введите имя игрока: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        userName = name;
        System.out.println("Привет "+name+" !");
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Messages.userName = userName;
    }

    public Boolean CollocationChoice() {
        System.out.print("Расставить корабли автоматически Y/N: ");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        if (choice.equals("y") || choice.equals("Y")) {
            System.out.println ("Расставляем корабли ..");
            System.out.println ();
            collocationChoice = true;
            return collocationChoice;
        }
        else if (choice.equals("n") || choice.equals("N")) {
            System.out.println("Ручной режим");
            collocationChoice = false;
        }
        else {
            System.out.println("Вы ничего не выбрали");
            collocationChoice = false;
        }
        return collocationChoice;
    }
}
