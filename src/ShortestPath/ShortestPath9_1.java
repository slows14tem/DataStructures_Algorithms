package ShortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ShortestPath9_1 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//2차원 그래프 생성 후 값을 무한값으로 두고 초기화
		int[][] graph = new int[N+1][N+1];
		for (int i=0;i<N+1;i++) {
			Arrays.fill(graph[i], 987654321);
		}
		
		//출발지와 도착지가 같으면 0으로
		for (int i=1;i<N+1;i++) {
			for (int j=1;j<N+1;j++) {
				if (i==j) graph[i][j] = 0;
			}
		}
		
		//간선정보 입력받아서 초기화
		for (int i=0;i<M;i++) {
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			//양방향이라서 양방향 초기화
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
				
		StringTokenizer st2 = new StringTokenizer(bf.readLine());
		int X = Integer.parseInt(st2.nextToken());
		int K = Integer.parseInt(st2.nextToken());
		
		//점화식으로 플로이드 워셜 알고리즘 수행
		for (int k=1;k<N+1;k++) {
			for (int i=1;i<N+1;i++) {
				for (int j=1;j<N+1;j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
		
		//결과 출력
		int dist = graph[1][K]+graph[K][X];
		if (dist >= 987654321) dist = -1;
		System.out.println(dist);

	}

}

