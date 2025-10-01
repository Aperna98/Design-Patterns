public class Pizza {
    private final String sauce;
    private final String topping;
    private final String cheese;
    private final String crust;
    private final String size;

    public Pizza(PizzaBuilder b) {
        this.sauce = b.sauce;
        this.topping = b.topping;
        this.cheese = b.cheese;
        this.crust = b.crust;
        this.size = b.size;
    }

    @Override
    public String toString() {
        return String.format("%s crust %s pizza with %s sauce, topped with %s and %s cheese.",
                crust, size, sauce, topping, cheese);
    }
}