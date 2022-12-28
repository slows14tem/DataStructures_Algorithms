package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_BFS_1260 {


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());
    int[][] graph = new int[N+1][N+1];

    for(int i=0;i<K;i++){
      String links = br.readLine();
      StringTokenizer stl = new StringTokenizer(links);
      int node1 = Integer.parseInt(stl.nextToken());
      int node2 = Integer.parseInt(stl.nextToken());
      graph[node1][node2]=1;
    }

    boolean[] visited = new boolean[N+1];

    DFS(graph, V, visited);

  }

  public void DFS(int[][] graph, int V, boolean[] visited){
    visited[V] = true;
    for (int i=0;i<)


  }
  
}
