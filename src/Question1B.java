//Assume you were hired to create an application for an ISP, and there is n number of network devices, such as
//routers, that are linked together to provides internet access to home user users. You are given a 2D array that
//represents network connections between these network devices such that a[i]=[xi,yi] where xi is connected to yi
//device. Suppose there is a power outage on a certain device provided as int n represents id of the device on which
//power failure occurred)), Write an algorithm to return impacted network devices due to breakage of the link
//between network devices. These impacted device list assists you notify linked consumers that there is a power
//outage and it will take some time to rectify an issue. Note that: node 0 will always represent a source of internet or
//gateway to international network..

import java.util.ArrayList;
import java.util.List;
public class Question1B {
    private static final int N = 8;

    private static boolean[] visited;
    private static List<Integer> impactedDevices;
    private static List<List<Integer>> adj;

    // Function to create adjacency list
    private static void createAdjList(int[][] edges) {
        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
    }

    // Function to get all impacted devices
    private static void getImpactedDevices(int targetDevice) {
        visited = new boolean[N];
        impactedDevices = new ArrayList<>();
        dfs(targetDevice);
    }

    // Function to perform DFS
    private static void dfs(int node) {
        visited[node] = true;
        for (int next : adj.get(node)) {
            if (!visited[next]) {
                impactedDevices.add(next);
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 6}, {2, 4}, {4, 6}, {4, 5}, {5, 7}};
        int targetDevice = 4;

        createAdjList(edges);
        getImpactedDevices(targetDevice);

        System.out.println("Impacted Devices: " + impactedDevices);
    }
}