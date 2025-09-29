import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();             //запуск игры
        game.mainMenu();
    }

    static public int takeIntNumber(String text){           //проверка ввода int
        int y = 0;
        boolean isCorrect = false;
        while(!isCorrect){
            try{
                Scanner in = new Scanner(System.in);
                System.out.println(text);
                y = in.nextInt();
                isCorrect = true;
            } catch (InputMismatchException e){
                System.out.println("Неправильный ввод!");
            }
        }
        return y;
    }
}