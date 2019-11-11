import entities.AddCollection;
import entities.AddRemoveCollection;
import entities.MyListImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        int removeCount = Integer.parseInt(scanner.nextLine());
        if (removeCount > 100) {
            return;
        }

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        int[][] output = new int[3][tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            output[0][i] = addCollection.add(tokens[i]);
            output[1][i] = addRemoveCollection.add(tokens[i]);
            output[2][i] = myList.add(tokens[i]);
        }


        String[][] removedItem = new String[2][removeCount];
        for (int i = 0; i < removeCount; i++) {
            removedItem[0][i] = addRemoveCollection.remove();
            removedItem[1][i] = myList.remove();
        }

        printResult(output, removedItem);
    }

    private static void printResult(int[][] output, String[][] removedItem) {
        for (int[] rows : output) {
            for (int  cols : rows) {
                System.out.print(cols + " ");
            }
            System.out.println();
        }

        for (String[] strings : removedItem) {
            System.out.println(String.join(" ", strings));
        }
    }
}
