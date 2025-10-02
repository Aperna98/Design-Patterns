public class PizzaBuilder {
    String sauce = "Marinara";
    String topping = "Veggies";
    String cheese = "Mozzarella";
    String crust = "Thin";
    String size = "Medium";

    public PizzaBuilder sauce(String s) {
        this.sauce = s;
        return this;
    }

    public PizzaBuilder topping(String t) {
        this.topping = t;
        return this;
    }

    public PizzaBuilder cheese(String c) {
        this.cheese = c;
        return this;
    }

    public PizzaBuilder crust(String c) {
        this.crust = c;
        return this;
    }

    public PizzaBuilder size(String s) {
        this.size = s;
        return this;
    }

    public Pizza build() {
        return new Pizza(this);
    }
}
