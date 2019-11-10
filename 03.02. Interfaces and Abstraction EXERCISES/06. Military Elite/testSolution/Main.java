package testSolution;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, List<String>> soldiers = new TreeMap<>(Comparator.reverseOrder());
        String format = "Name: %s %s Id: %d Salary: %.2f";
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String id = tokens[1];
            String firsName = tokens[2];
            String lastName = tokens[3];
            String salary = tokens[4];
            switch (tokens[0]) {
                case "Private":
                    System.out.println(String.format("Name: %s %s Id: %d Salary: %.2f", firsName, lastName,
                            Integer.parseInt(id), Double.parseDouble(salary)));
                    soldiers.putIfAbsent(Integer.parseInt(id), new ArrayList<>());
                    Collections.addAll(soldiers.get(Integer.parseInt(id)), firsName, lastName, id, salary);
                    break;
                case "LeutenantGeneral":
                    System.out.println(String.format(format, tokens[2], tokens[3],
                            Integer.parseInt(tokens[1]), Double.parseDouble(tokens[4])));

                    System.out.println("Privates:");
                    for (Map.Entry<Integer, List<String>> soldier : soldiers.entrySet()) {
                        for (int i = 5; i < tokens.length; i++) {
                            if (soldier.getKey() == Integer.parseInt(tokens[i])) {
                                System.out.println(String.format("  " + format, soldier.getValue().get(0),
                                        soldier.getValue().get(1), Integer.parseInt(soldier.getValue().get(2)),
                                        Double.parseDouble(soldier.getValue().get(3))));
                                break;
                            }
                        }
                    }
                    break;
                case "Engineer":
                    if (tokens[5].equals("Airforces") || tokens[5].equals("Marines")) {
                        System.out.println(String.format(format, firsName, lastName, Integer.parseInt(id),
                                Double.parseDouble(salary)));
                        System.out.println(String.format("Corps: %s", tokens[5]));
                        System.out.println("Repairs:");
                        for (int i = 6; i < tokens.length; i += 2) {
                            System.out.println(String.format("  Part Name: %s Hours Worked: %s",
                                    tokens[i], tokens[i + 1]));
                        }
                    }
                    // bachka
                    break;
                case "Commando":
                    if (tokens[5].equals("Airforces") || tokens[5].equals("Marines")) {
                        System.out.println(String.format(format, firsName, lastName, Integer.parseInt(id),
                                Double.parseDouble(salary)));
                        System.out.println(String.format("Corps: %s", tokens[5]));
                        System.out.println("Missions:");
                        for (int i = 6; i < tokens.length; i += 2) {
                            if (tokens[i + 1].equals("inProgress") || tokens[i + 1].equals("Finished")) {
                                System.out.println(String.format("  Code Name: %s State: %s",
                                        tokens[i], tokens[i + 1]));
                            }
                        }
                    }
                    break;
                case "Spy":
                    System.out.println(String.format("Name: %s %s Id: %s", firsName, lastName, id));
                    System.out.println(String.format("Code Number: %s", tokens[4]));
                    break;
            }
            input = scanner.nextLine();
        }
    }
}