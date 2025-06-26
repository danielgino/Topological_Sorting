package question1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question1 {
    public static void main(String[] args) {
        int graphSize=4;
        List <List<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < graphSize; i++) {
            graph.add(new ArrayList<>());
        }
        //0->A
        //1->B
        //2->C
        //3->D
        graph.get(0).add(1);
        graph.get(1).add(3);
        graph.get(1).add(2);
        graph.get(2).add(3);

        System.out.println("All routes that end With D");
        System.out.println("A->B->D");
        System.out.println("A->C->D");
        System.out.println("B->C->D");
        System.out.println("B->D");
        System.out.println("C->D");
        System.out.println("D");

        System.out.println("Section B: ");
        int[] result = countPathsToEachNode(graph, graphSize);

        System.out.println("Number of paths ending at each node:");
        for (int i = 0; i < graphSize; i++) {
            char node = (char) ('A' + i);
            System.out.println(node + ": " + result[i]);
        }


    }

    public static int[] countPathsToEachNode(List<List<Integer>> graph, int n) {
        int[] inDegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (int v : graph.get(u)) {
                inDegree[v]++;
            }
        }

        int[] dp = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                dp[v] += dp[u];
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        return dp;
    }
}