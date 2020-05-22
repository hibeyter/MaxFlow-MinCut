package havuzproblemi;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxFlow {

    private int[][] allFlow; //max flow beetween i and j verticles
    private int[][] allCapacity; // edge capacity
    private int[] parent; //parent
    private boolean[] flags; //just for checking if visited  
    private int sizeNode, sizeEdge, result = 0;;

    public MaxFlow(int sizeNode, int sizeEdge) {
        this.sizeNode = sizeNode;
        this.sizeEdge = sizeEdge;
        this.allFlow = new int[sizeNode][sizeNode];
        this.allCapacity = new int[sizeNode][sizeNode];
        this.parent = new int[sizeNode];
        this.flags = new boolean[sizeNode];
    }

    public void addEdge(int parent, int child, long capacity) {
        this.allCapacity[parent][child] += capacity;
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
        }        
        /* System.out.println(0 + " 1 parent  " + flow[s][1]);
        System.out.println(0 + " 2 parent  " + flow[s][2]);
        System.out.println(1 + " 3 parent  " + flow[1][3]);
        System.out.println(1 + " 2 parent  " + flow[1][2]);
        System.out.println(3 + " 4 parent  " + flow[3][4]);
        System.out.println(2 + " 4 parent  " + flow[2][4]);
        System.out.println(3 + " 5 parent  " + flow[3][5]);
        System.out.println(4 + " 5 parent  " + flow[4][5]);*/

        for (int i = 0; i < sizeNode; ++i) {
            result += allFlow[source][i];
        }
        return result;
    }
}
