import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Identifiable> robots = new ArrayList<>();
        List<Identifiable> citizens = new ArrayList<>();

        String input = reader.readLine();
        while (!input.equals("End")){
            String[] tokens = input.split(" ");
            if (tokens.length == 2){
                Robot robot = new Robot(tokens[1], tokens[0]);
                robots.add(robot);
            } else {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                citizens.add(citizen);
            }
            input = reader.readLine();
        }

        String validationFakeId = reader.readLine();

        printFakeId(citizens, validationFakeId);
        printFakeId(robots, validationFakeId);

    }

    private static void printFakeId(List<Identifiable>list, String lastDigit) {
        for (Identifiable element : list) {
            if (element.getId().endsWith(lastDigit)) {
                System.out.println(element.getId());
            }
        }
    }
}
