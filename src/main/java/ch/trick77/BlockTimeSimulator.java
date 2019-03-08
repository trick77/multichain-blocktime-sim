package ch.trick77;

import java.util.ArrayList;

public class BlockTimeSimulator {

    public static void main(String args[]) {
        ArrayList<BridgedChain> chains = new ArrayList<>();
        BaseChain collider = new BaseChain("blockcollider");
        chains.add(new BridgedChain("btc", (10*60)-9));
        chains.add(new BridgedChain("eth", 14));
        chains.add(new BridgedChain("lsk", 10));
        chains.add(new BridgedChain("neo", 60));

        MultiChain multiChain = new MultiChain(collider, chains);
        multiChain.simulate();
    }
}