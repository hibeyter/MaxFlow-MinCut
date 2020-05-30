package havuzproblemi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class MaxFlow {

    private int[][] allFlow;//graph üzerindeki bütün akışların tutulacagı matris   
    private int[][] allCapacity;// graph üzerindeki bütün edge kapasitelerinin tutulacagı matris
    private int[] parent;  // düğümün parenti burada tutulacak
    private boolean[] flags;// bfs ve dfs için gerekli olan ziyaret edildi mi bilgisinin tutulacagı  dizi
    private int sizeNode, sizeEdge, result = 0;//node sayısı edge sayısı ve flow result değeri
    private Map<String, Integer> allEdgeName;//Kullandıgımız kütüphane için gerekli  olan edge isimleri  burada tutulacak
    private List<String> minCutEdges;
    private List<Map<String, Integer>> stepToStep;

    public MaxFlow(int sizeNode, int sizeEdge) {
        this.sizeNode = sizeNode;
        this.sizeEdge = sizeEdge;
        this.allFlow = new int[sizeNode][sizeNode];
        this.allCapacity = new int[sizeNode][sizeNode];
        this.parent = new int[sizeNode];
        this.flags = new boolean[sizeNode];
        this.allEdgeName = new HashMap<>();
        this.stepToStep = new ArrayList<>();
    }

    public void addEdge(int parent, int child, int capacity) {
        this.allCapacity[parent][child] += capacity;//capacty matrisine edgenin  kapasitesini  ekledik
        String edgeName = parent + "-" + child + "-" + capacity;//eklenen edge adını mapimizde saklıyoruz
        allEdgeName.put(edgeName, 0);//edge ismini  mape ekledik
    }

    public int startFlow(int source, int target) {
        while (true) {
            final Queue<Integer> BFSqueue = new ArrayDeque<>();
            BFSqueue.add(source);
            for (int i = 0; i < this.sizeNode; ++i) {
                flags[i] = false;
            }
            flags[source] = true;
            boolean find = false;
            int nowNode;
            while (!BFSqueue.isEmpty()) {
                nowNode = BFSqueue.peek();
                if (nowNode == target) {
                    find = true;
                    break;
                }
                BFSqueue.remove();
                for (int i = 0; i < sizeNode; ++i) {
                    if (!flags[i] && allCapacity[nowNode][i] > allFlow[nowNode][i]) {
                        flags[i] = true;
                        BFSqueue.add(i);
                        parent[i] = nowNode;
                    }
                }
            }
            if (find == false) {
                break;
            }
            int temp = allCapacity[parent[target]][target] - allFlow[parent[target]][target];
            for (int i = target; i != source; i = parent[i]) {
                temp = Math.min(temp, (allCapacity[parent[i]][i] - allFlow[parent[i]][i]));
            }
            for (int i = target; i != source; i = parent[i]) {
                allFlow[parent[i]][i] += temp;
                allFlow[i][parent[i]] -= temp;
            }
            Map<String, Integer> tempMap = new HashMap<>();
            for (String string : allEdgeName.keySet()) {
                StringTokenizer tok = new StringTokenizer(string, "-");
                int parent = Integer.valueOf(tok.nextToken());
                int child = Integer.valueOf(tok.nextToken());
                tempMap.put(string, allFlow[parent][child]);
            }
            stepToStep.add(tempMap);
        }

        /* for (String string : allEdgeName.keySet()) {
            StringTokenizer tok = new StringTokenizer(string, "-");
            int parent = Integer.valueOf(tok.nextToken());
            int child = Integer.valueOf(tok.nextToken());
            allEdgeName.put(string, allFlow[parent][child]);
        }*/
        System.out.println(stepToStep);
        for (int i = 0; i < sizeNode; ++i) {
            result += allFlow[source][i];
        }
        minCutEdges = minCut(allCapacity, source, target);
        return result;
    }

    public Map<String, Integer> getAllEdgeName() {
        return allEdgeName;
    }

    public List<Map<String, Integer>> getStepToStep() {
        return stepToStep;
    }

    public List<String> getMinCutEdges() {
        return minCutEdges;
    }

    private boolean bfs(int[][] rGraph, int source, int target, int[] parent) {

        boolean[] flags = new boolean[rGraph.length];

        Queue<Integer> BFSqueue = new ArrayDeque<>();
        BFSqueue.add(source);
        flags[source] = true;
        parent[source] = -1;

        while (!BFSqueue.isEmpty()) {
            int nowNode = BFSqueue.peek();
            BFSqueue.remove();
            for (int i = 0; i < rGraph.length; i++) {
                if (rGraph[nowNode][i] > 0 && !flags[i]) {
                    BFSqueue.add(i);
                    flags[i] = true;
                    parent[i] = nowNode;
                }
            }
        }
        return flags[target];
    }

    private static void dfs(int[][] rGraph, int s, boolean[] flags) {
        flags[s] = true;
        for (int i = 0; i < rGraph.length; i++) {
            if (rGraph[s][i] > 0 && !flags[i]) {
                dfs(rGraph, i, flags);
            }
        }
    }

    public List<String> minCut(int[][] graph, int source, int target) {
        int node, edge;

        int[][] tempGraph = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                tempGraph[i][j] = graph[i][j];
            }
        }

        int[] parent = new int[graph.length];

        while (bfs(tempGraph, source, target, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (edge = target; edge != source; edge = parent[edge]) {
                node = parent[edge];
                pathFlow = Math.min(pathFlow, tempGraph[node][edge]);
            }

            for (edge = target; edge != source; edge = parent[edge]) {
                node = parent[edge];
                tempGraph[node][edge] = tempGraph[node][edge] - pathFlow;
                tempGraph[edge][node] = tempGraph[edge][node] + pathFlow;
            }
        }

        boolean[] flags = new boolean[graph.length];
        dfs(tempGraph, source, flags);
        List<String> data = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] > 0 && flags[i] && !flags[j]) {
                    data.add(i + "" + j);
                }
            }
        }
        return data;
    }
}
