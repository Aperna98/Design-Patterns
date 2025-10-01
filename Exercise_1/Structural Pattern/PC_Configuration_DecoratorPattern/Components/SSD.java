package Components;

import PC.PC;
import PC.PCDecorator;

public class SSD extends PCDecorator {
    public SSD(PC pc) {
        super(pc);
    }

    @Override
    public String getDescription() {
        return pc.getDescription() + ", SSD";
    }

    @Override
    public double getCost() {
        return pc.getCost() + 150.0;
    }
}
