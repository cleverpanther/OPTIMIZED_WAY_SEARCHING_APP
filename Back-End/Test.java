import java.util.*;

public class Test {
    public static void main(String[] args) {
        // TBD based on completed back-end architecture.
        // Front-end will be tested by visual input in contrast to the
        // back-end. Review phase will consist of feedback by review.

        // ------ Testing for the decision module ------
        ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
        ArrayList<Integer> distances = new ArrayList<Integer>();
        for (int setup = 0; setup < 4; setup++) {
            visitedNodes.add(setup);
            distances.add(Integer.MAX_VALUE);
        }
        // Setup the node for a graph with 4 vertices and 4 edges.
        Node n0 = new Node(0, 2.2435454434234, 1.2435454434256); // Gulf of Guinea.
        Node n1 = new Node(1, 1.3354544342742, 1.2435454235934); // Gulf of Guinea.
        Node n2 = new Node(2, 1.9835454434274, 2.2777454434274); // Gulf of Guinea.
        Node n3 = new Node(3, 1.7267454434274, 1.5724954434274); // Gulf of Guinea.
        // Setup the 4 edges in the graph.
        Pair p01 = new Pair(3, n0, n1);
        Pair p03 = new Pair(2, n0, n3);
        Pair p12 = new Pair(1, n1, n2);
        Pair p32 = new Pair(5, n3, n2);
        // Set up the set of connected paths for a given node.
        Set<Pair> s0 = new HashSet<Pair>();
        Set<Pair> s1 = new HashSet<Pair>();
        Set<Pair> s3 = new HashSet<Pair>();
        s0.add(p01);
        s0.add(p03);
        s1.add(p12);
        s3.add(p32);
        // Setup a map linking a node to a set of connected paths.
        Map<Node, Set<Pair>> decisionMap = new HashMap<Node, Set<Pair>>();
        decisionMap.put(n0, s0);
        decisionMap.put(n1, s1);
        decisionMap.put(n2, new HashSet<Pair>());
        decisionMap.put(n3, s3);
        // Run the decision module and print out the optimal path for this case.
        Decision decision = new Decision(decisionMap);
        ArrayList<Node> path = new ArrayList<Node>();
        System.out.println(decision.getDecision(n0, n2, path)); // Total distance = "4".
        System.out.println(path); // Optimal path should be: "[0, 1, 2]".
    }
}
