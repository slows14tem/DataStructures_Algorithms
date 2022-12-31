package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS_2178 {
	static boolean visited[][];	//방문체크
	static int maze[][];	//미로(0:벽)
	static int mx[] = {0, 0, -1, 1};
	static int my[] = {-1, 1, 0, 0};	//상 하 좌 우
	static Queue<Node> que = new LinkedList<>();
	
	static int nowx, nowy;	//현재위치 좌표
	static int N, M;	//가로 세로
	static int x, y;	//node좌표 입력값
	
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로

		visited = new boolean[N][M];
		maze = new int[N][M];
		
		for (int i=0;i<N;i++) {
			String[] str = br.readLine().split("");
			for (int j=0;j<M;j++) {
				maze[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		BFS(0, 0);
		System.out.println(maze[N-1][M-1]);
		
	}
	
	public static void BFS(int x, int y) {
		que.offer(new Node(x, y));
		//최초 0,0 큐에 입력
		
		visited[x][y] = true;
		//0,0 방문 체크
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			//큐의 처음 값을 node로 반환하고 큐에서 삭제
			
			for (int i=0;i<4;i++) {
				nowx = node.x + mx[i];
				nowy = node.y + my[i];
				//좌표를 상하좌우로 움직임
				
				if (Maze_Check() == true && maze[nowx][nowy] != 0 && visited[nowx][nowy] == false) {
					//현재 좌표가 미로 안쪽 && 벽이 아님 && 방문한 곳이 아님  세 조건을 충족할때만 실행
					que.offer(new Node(nowx, nowy));
					visited[nowx][nowy] = true;
					maze[nowx][nowy] = maze[node.x][node.y] + 1;
					//이동할 수 있는 칸이면 그 칸을 큐에 입력, 방문 체크, 이동 전 node좌표값에서 1을 추가(지나온 최소 칸수 == 그래프 이론 가중치의 개념??)
				}
			}
		}	
	}
	
	public static boolean Maze_Check() {
		//현재 위치가 미로 칸 안쪽에 위치하는지 체크
		if(nowx >= 0 && nowx < N && nowy >= 0 && nowy < M) return true;
		else return false;
	}
}

//DFS알고리즘 특성상 최단거리를 찾으려면 완전 탐색을 하고 그중에서 가장 작은 값을 선택해야 하는데 경로가 아주 많을 수 있으므로 시간 복잡도가 매우 커진다. 
//반면 BFS는 최단거리를 보장하기 때문에 이러한 문제들(최단거리 구하기)은 BFS로 풀어야 한다.

//https://coding-factory.tistory.com/602 (큐 관련)
