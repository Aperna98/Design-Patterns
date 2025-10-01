package PC;

public class BasePC implements PC {
    @Override
    public String getDescription() {
        return "Base PC (CPU + RAM)";
    }

    @Override
    public double getCost() {
        return 500.0;
    }
}
