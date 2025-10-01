package Components;

import PC.PC;
import PC.PCDecorator;

public class CoolingSystem extends PCDecorator {
    public CoolingSystem(PC pc) {
        super(pc);
    }

    @Override
    public String getDescription() {
        return pc.getDescription() + ", Cooling System";
    }

    @Override
    public double getCost() {
        return pc.getCost() + 100.0;
    }
}
