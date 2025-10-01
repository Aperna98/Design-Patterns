package Components;

import PC.PC;
import PC.PCDecorator;

public class GPU extends PCDecorator {
    public GPU(PC pc) {
        super(pc);
    }

    @Override
    public String getDescription() {
        return pc.getDescription() + ", GPU";
    }

    @Override
    public double getCost() {
        return pc.getCost() + 300.0;
    }
}
