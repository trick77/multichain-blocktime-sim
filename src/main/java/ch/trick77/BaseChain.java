package ch.trick77;

public class BaseChain {

    private int height;
    private String name;

    public BaseChain(String name) {
        this.name = name;
        height = 0;
    }

    public int getHeight() {
        return this.height;
    }

    public void increaseHeight() {
        this.height++;
    }

    public String getName() {
        return this.name;
    }

    public float getAverageBlocktime(int currentTime) {
        return currentTime / (float)this.height;
    }
}
