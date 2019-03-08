package ch.trick77;

public class BridgedChain extends BaseChain {

    private int averageBlocktime;

    public BridgedChain(String name, int averageBlocktime) {
        super(name);
        this.averageBlocktime = averageBlocktime;
    }

    public int getAverageBlocktime() {
        return this.averageBlocktime;
    }

    public boolean isBlockDue(final int currentTime) {
        if (currentTime > 0 && currentTime % this.averageBlocktime == 0) {
            return true;
        }
        return false;
    }

}