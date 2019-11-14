import military.entities.*;
import military.enumaration.Corp;
import military.enumaration.State;
import military.interfaces.Commando;
import military.interfaces.Engineer;
import military.interfaces.Spy;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, PrivateImpl> soldiers = new TreeMap<>(Comparator.reverseOrder());
        String input = scanner.nextLine();
        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");

            if (tokens.length >= 5) {
                String type = tokens[0];
                int id = Integer.parseInt(tokens[1]);
                String firstName = tokens[2];
                String lastName = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                if (id > 0) {
                    switch (type) {
                        case "Private":
                            PrivateImpl priv = new PrivateImpl(id, firstName, lastName, salary);
                            System.out.println(priv);
                            soldiers.putIfAbsent(id, priv);
                            break;
                        case "LeutenantGeneral":
                            LieutenantGeneralImpl leutenantGeneral = new LieutenantGeneralImpl(
                                    id, firstName, lastName, salary);

                            for (Map.Entry<Integer, PrivateImpl> soldier : soldiers.entrySet()) {
                                for (int i = 5; i < tokens.length; i++) {
                                    if (soldier.getKey() == Integer.parseInt(tokens[i])) {
                                        leutenantGeneral.addPrivate(soldier.getValue());
                                    }
                                }
                            }
                            System.out.println(leutenantGeneral);
                            break;
                        case "Engineer":
                            if (tokens[5].equals(Corp.Airforces.toString()) || tokens[5].equals(Corp.Marines.toString())) {
                                Corp corp = Corp.valueOf(tokens[5]);
                                Engineer engineer = new EngineerImpl(
                                        id, firstName, lastName, salary, corp);

                                for (int i = 6; i < tokens.length; i += 2) {
                                    Repair repair = new Repair(tokens[i], Integer.parseInt(tokens[i + 1]));
                                    engineer.addRepair(repair);
                                }
                                System.out.println(engineer);
                            }
                            break;
                        case "Commando":
                            if (tokens[5].equals(Corp.Airforces.toString()) || tokens[5].equals(Corp.Marines.toString())) {
                                Commando commando = new CommandoImpl(id, firstName, lastName, salary,
                                        Corp.valueOf(tokens[5]));

                                for (int i = 6; i < tokens.length; i += 2) {
                                    if (tokens[i + 1].equals(State.inProgress.toString()) || tokens[i + 1].equals(State.Finished.toString())) {
                                        Mission mission = new Mission(tokens[i], State.valueOf(tokens[i + 1]));
                                        commando.addMission(mission);
                                    }
                                }
                                System.out.println(commando.toString());
                            }
                            break;
                        case "Spy":
                            Spy spy = new SpyImpl(
                                    id, firstName, lastName, Integer.parseInt(tokens[4]));
                            System.out.println(spy.toString());
                            break;
                        default:
                            break;
                    }
                }
            }
            input = scanner.nextLine();
        }
    }
}