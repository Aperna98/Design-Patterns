import java.util.*;

public class Main {

    private static String getValidChoice(Scanner sc, String choice, List<String> options) {
        while (true) {
            System.out.print(choice + " " + list(options) + ": ");
            String input = sc.nextLine().trim();
            System.out.println();

            try {
                int ch = Integer.parseInt(input);
                if (ch >= 1 && ch <= options.size()) {
                    return options.get(ch - 1);
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Invalid choice! Enter a number between 1 and " + options.size() + ".\n");
        }
    }

    private static String list(List<String> options) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < options.size(); i++) {
            sb.append(i + 1).append(". ").append(options.get(i));
            if (i < options.size() - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> sauces = List.of("Marinara", "White", "BBQ", "Pesto");
        List<String> toppings = List.of("Veggies", "Pepperoni", "Chicken", "Corn");
        List<String> cheeses = List.of("Mozzarella", "Cheddar", "Parmesan");
        List<String> crusts = List.of("Thin", "Thick", "Stuffed");
        List<String> sizes = List.of("Small", "Medium", "Large");

        String sauce = getValidChoice(sc, "Sauce", sauces);
        String topping = getValidChoice(sc, "Topping", toppings);
        String cheese = getValidChoice(sc, "Cheese", cheeses);
        String crust = getValidChoice(sc, "Crust", crusts);
        String size = getValidChoice(sc, "Size", sizes);

        Pizza pizza = new PizzaBuilder()
                .sauce(sauce)
                .topping(topping)
                .cheese(cheese)
                .crust(crust)
                .size(size)
                .build();

        System.out.println("\nYour pizza is ready:");
        System.out.println(pizza);

        sc.close();
    }
}
