package PC;

public abstract class PCDecorator implements PC {
    protected PC pc;

    public PCDecorator(PC pc) {
        this.pc = pc;
    }

    @Override
    public String getDescription() {
        return pc.getDescription();
    }

    @Override
    public double getCost() {
        return pc.getCost();
    }
}
