package ch.trick77;

import java.util.ArrayList;
import java.util.List;

public class MultiChain {

    BaseChain baseChain = null;
    List<BridgedChain> bridgedChains = new ArrayList<>();

    MultiChain(BaseChain baseChain, ArrayList<BridgedChain> bridgedChains) {
        this.baseChain = baseChain;
        this.bridgedChains = bridgedChains;
    }

    public void dumpCurrentState(int currentSecond) {
        String dump = "time=" + currentSecond + " ";
        dump += baseChain.getName() + ".height=" + baseChain.getHeight();
        dump += " (average=" + baseChain.getAverageBlocktime(currentSecond) + ") ";
        for (BridgedChain bridgedChain: bridgedChains) {
            dump += bridgedChain.getName() + ".height=" + bridgedChain.getHeight() + " ";
        }
        System.out.println(dump);
    }

    private int calcMinIterations() {
        int iterations = 1;
        for (BridgedChain bridgedChain: bridgedChains) {
            iterations *= bridgedChain.getAverageBlocktime();
        }
        return iterations;
    }

    public void simulate() {
        int maxIterations = this.calcMinIterations();
        for (int currentSecond = 0; currentSecond < maxIterations; currentSecond++) {
            for (BridgedChain bridgedChain: bridgedChains) {
                if (bridgedChain.isBlockDue(currentSecond)) {
                    bridgedChain.increaseHeight();
                    baseChain.increaseHeight();

                    // comment out to make it faster
                    dumpCurrentState(currentSecond);
                }
            }
        }
        System.out.println("The average block time for the base chain is "
                + baseChain.getAverageBlocktime(maxIterations) + " seconds (after " + maxIterations + " seconds)");
    }
}