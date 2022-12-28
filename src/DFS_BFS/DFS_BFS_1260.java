package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS_1260 {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		int N = Integer.parseInt(st.nextToken());	//node
		int K = Integer.parseInt(st.nextToken());	//link
		int V = Integer.parseInt(st.nextToken());	//first search
		int[][] graph = new int[N+1][N+1];

		for(int i=0;i<K;i++){
			//그래프를 행렬로 변경
			String links = br.readLine();
			StringTokenizer stl = new StringTokenizer(links);
			int node1 = Integer.parseInt(stl.nextToken());
			int node2 = Integer.parseInt(stl.nextToken());
			graph[node1][node2]=1;
			graph[node2][node1]=1;
		}

		boolean[] visited = new boolean[N+1];
		DFS(graph, V, visited);
		System.out.println();
		visited = new boolean[N+1];
		BFS(graph, V, visited);

	}

	public static void DFS(int[][] graph, int V, boolean[] visited){
		visited[V] = true;
		System.out.print(V + " ");
		for (int i=1;i<graph[V].length;i++) {
			if (graph[V][i] == 1 && !visited[i]) {
				DFS(graph, i, visited);
			}
		}
	}
	
	public static void BFS(int[][] graph, int V, boolean[] visited) {
		System.out.print(V + " ");
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		visited[V]=true;
		while(true) {
			for (int i=1;i<graph[V].length;i++) {
				if(graph[V][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i]=true;
					System.out.print(i + " ");
				}
			}
			q.remove(V);
			
			int size = q.size();
			if(size == 0) break;
			V = q.peek();
		}
	}
}
