import java.util.;
class Pair{
    int node;
    int cost;
    Pair(int node,int cost){
        this.node = node;
        this.cost = cost;
    }
}
public class Solution {
    public int helper(int[][] edges, int n, int start) {
        ListPair graph[] = new ArrayList[n + 1];
        int cost[] = new int[n + 1];
        Arrays.fill(cost,Integer.MAX_VALUE2);
        cost[start] = cost[0] = 0;
        for(int i = 0 ; i = n ; i ++){
            graph[i] = new ArrayList();
        }
        for(int i = 0; i  edges.length ; i++){
            int srt = edges[i][0];
            int dst = edges[i][1];
            int cst = edges[i][2];
            graph[srt].add(new Pair(dst,cst));
        }
        
        // dijkstra's algorithm
        PriorityQueuePair pq = new PriorityQueue((a,b)-Integer.compare(a.cost,b.cost));
        pq.add(new Pair(start,0));
        int ans = 0;
        while(pq.size()  0){
            Pair poll = pq.poll();
            for(Pair i  graph[poll.node]){
                if(cost[i.node]  poll.cost + i.cost){
                    cost[i.node] = poll.cost + i.cost;
                    pq.add(new Pair(i.node,cost[i.node]));
                }
            }
        }
        for(int i  cost){
            ans = Math.max(ans,i);
        }
        return ans == Integer.MAX_VALUE  2  -1  ans;
    }
}