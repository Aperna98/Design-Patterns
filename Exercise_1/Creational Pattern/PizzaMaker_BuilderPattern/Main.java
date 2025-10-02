import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] sauces = { "Marinara", "White", "BBQ", "Pesto" };
        String[] toppings = { "Veggies", "Pepperoni", "Chicken", "Corn" };
        String[] cheeses = { "Mozzarella", "Cheddar", "Parmesan" };
        String[] crusts = { "Thin", "Thick", "Stuffed" };
        String[] sizes = { "Small", "Medium", "Large" };

        System.out.println(" Welcome to Pizza Shop!\n");
        System.out.println("Default Pizza = Medium, Thin Crust, Marinara Sauce, Veggies, Mozzarella Cheese");
        System.out.print("Press 0 for Default Pizza or 1 to Customize: ");
        int choice = sc.nextInt();

        Pizza pizza;

        if (choice == 0) {
            pizza = new PizzaBuilder()
                    .sauce("Marinara")
                    .topping("Veggies")
                    .cheese("Mozzarella")
                    .crust("Thin")
                    .size("Medium")
                    .build();

        } else {
            System.out.print("Sauce [1.Marinara 2.White 3.BBQ 4.Pesto]: ");
            int sauceChoice = sc.nextInt();
            while (sauceChoice < 1 || sauceChoice > sauces.length) {
                System.out.print("Invalid choice! Enter a number between 1 and " + sauces.length + ": ");
                sauceChoice = sc.nextInt();
            }
            String sauce = sauces[sauceChoice - 1];

            System.out.print("Topping [1.Veggies 2.Pepperoni 3.Chicken 4.Corn]: ");
            int toppingChoice = sc.nextInt();
            while (toppingChoice < 1 || toppingChoice > toppings.length) {
                System.out.print("Invalid choice! Enter a number between 1 and " + toppings.length + ": ");
                toppingChoice = sc.nextInt();
            }
            String topping = toppings[toppingChoice - 1];

            System.out.print("Cheese [1.Mozzarella 2.Cheddar 3.Parmesan]: ");
            int cheeseChoice = sc.nextInt();
            while (cheeseChoice < 1 || cheeseChoice > cheeses.length) {
                System.out.print("Invalid choice! Enter a number between 1 and " + cheeses.length + ": ");
                cheeseChoice = sc.nextInt();
            }
            String cheese = cheeses[cheeseChoice - 1];

            System.out.print("Crust [1.Thin 2.Thick 3.Stuffed]: ");
            int crustChoice = sc.nextInt();
            while (crustChoice < 1 || crustChoice > crusts.length) {
                System.out.print("Invalid choice! Enter a number between 1 and " + crusts.length + ": ");
                crustChoice = sc.nextInt();
            }
            String crust = crusts[crustChoice - 1];

            System.out.print("Size [1.Small 2.Medium 3.Large]: ");
            int sizeChoice = sc.nextInt();
            while (sizeChoice < 1 || sizeChoice > sizes.length) {
                System.out.print("Invalid choice! Enter a number between 1 and " + sizes.length + ": ");
                sizeChoice = sc.nextInt();
            }
            String size = sizes[sizeChoice - 1];

            pizza = new PizzaBuilder()
                    .sauce(sauce)
                    .topping(topping)
                    .cheese(cheese)
                    .crust(crust)
                    .size(size)
                    .build();
        }

        System.out.println("\nYour pizza is ready: ");
        System.out.println(pizza);

        sc.close();
    }
}
