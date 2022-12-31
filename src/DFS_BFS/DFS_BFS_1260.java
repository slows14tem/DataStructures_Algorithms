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

//DFS/BFS, 최단 경로 알고리즘은 그래프 탐색 알고리즘의 한 유형
//DFS(Depth First Search) 깊이 우선 탐색	(재귀, 스택 활용)
//BFS(Breath First Search) 너비 우선 탐색	(큐 활용)

//https://blog.naver.com/PostView.naver?blogId=kiho0530&logNo=150139178186&redirect=Dlog&widgetTypeCall=true&directAccess=false

//https://velog.io/@cha-suyeon/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B9%8A%EC%9D%B4-%EC%9A%B0%EC%84%A0-%ED%83%90%EC%83%89DFS-%EA%B3%BC-%EB%84%88%EB%B9%84-%EC%9A%B0%EC%84%A0-%ED%83%90%EC%83%89BFS
