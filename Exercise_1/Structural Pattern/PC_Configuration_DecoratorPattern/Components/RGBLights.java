package Components;

import PC.PC;
import PC.PCDecorator;

public class RGBLights extends PCDecorator {
    public RGBLights(PC pc) {
        super(pc);
    }

    @Override
    public String getDescription() {
        return pc.getDescription() + ", RGB Lights";
    }

    @Override
    public double getCost() {
        return pc.getCost() + 50.0;
    }
}
