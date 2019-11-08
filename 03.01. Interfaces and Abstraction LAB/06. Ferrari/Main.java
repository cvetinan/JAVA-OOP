import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Car ferrari = new Ferrari(input);
        System.out.println(ferrari.toString());

    }
}
