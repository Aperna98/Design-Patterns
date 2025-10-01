import java.util.*;

import Components.*;
import PC.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static PC myPC = new BasePC();

    private static final Map<Integer, ComponentAdder> options = Map.of(
            1, pc -> new GPU(pc),
            2, pc -> new SSD(pc),
            3, pc -> new RGBLights(pc),
            4, pc -> new CoolingSystem(pc));

    public static void main(String[] args) {
        String menu = """
                === PC Configurator ===
                1. Add GPU (+$300)
                2. Add SSD (+$150)
                3. Add RGB Lights (+$50)
                4. Add Cooling System (+$100)
                5. Show Configuration
                6. Exit

                Enter choice: """;

        int choice;
        do {
            System.out.print(menu);
            choice = Integer.parseInt(sc.nextLine());
            handleChoice(choice);
        } while (choice != 6);

    }

    private static void handleChoice(int choice) {
        if (options.containsKey(choice)) {
            myPC = options.get(choice).add(myPC);
            System.out.println("\nAdded! Total Cost: $" + myPC.getCost() + "\n");
        }

        else if (choice == 5) {
            System.out.println("\nConfig: " + myPC.getDescription());
            System.out.println("Total Cost: $" + myPC.getCost() + "\n");
        }

        else if (choice == 6) {
            System.out.println("Exiting...\n");
        }

        else {
            System.out.println("Invalid choice\n");
        }
    }
}

interface ComponentAdder {
    PC add(PC pc);
}
