public class PizzaBuilder {

    String sauce = "Marinara";
    String topping = "Veggies";
    String cheese = "Mozzarella";
    String crust = "Thin";
    String size = "Medium";

    public PizzaBuilder sauce(String s) {
        if (s != null && !s.isBlank())
            this.sauce = s.trim();
        return this;
    }

    public PizzaBuilder topping(String t) {
        if (t != null && !t.isBlank())
            this.topping = t.trim();
        return this;
    }

    public PizzaBuilder cheese(String c) {
        if (c != null && !c.isBlank())
            this.cheese = c.trim();
        return this;
    }

    public PizzaBuilder crust(String c) {
        if (c != null && !c.isBlank())
            this.crust = c.trim();
        return this;
    }

    public PizzaBuilder size(String s) {
        if (s != null && !s.isBlank())
            this.size = s.trim();
        return this;
    }

    public Pizza build() {

        String sz = size.toLowerCase();
        if (!sz.equals("small") && !sz.equals("medium") && !sz.equals("large")) {
            System.out.println("Unknown size '" + size + "' — using default 'Medium'.");
            this.size = "Medium";
        }
        return new Pizza(this);
    }
}