package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS5_1 {
	static boolean visited[][];	//방문체크
	static int iceCase[][];	//미로(1:벽)
	static int mx[] = {0, 0, -1, 1};
	static int my[] = {-1, 1, 0, 0};	//상 하 좌 우
	static Queue<Node> que = new LinkedList<>();
	
	static int nowx, nowy;	//현재위치 좌표
	static int N, M;	//가로 세로
	static int x, y;	//node좌표 입력값
	static int cnt;		//아이스크림 갯수
	
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
		iceCase = new int[N][M];
		
		for (int i=0;i<N;i++) {
			String[] str = br.readLine().split("");
			for (int j=0;j<M;j++) {
				iceCase[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		//얼음 틀의 한칸이 칸막이가 아니고 방문한 칸이 아닐때만 bfs 함수 실행 
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				if (iceCase[i][j] == 0 && !visited[i][j]) {
					BFS(i, j);
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static void BFS(int x, int y) {
		que.offer(new Node(x, y));
		//입력값 x,y를 큐에 입력
		
		visited[x][y] = true;
		//x, y 방문 체크
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			//큐의 처음 값을 node로 반환하고 큐에서 삭제
			
			for (int i=0;i<4;i++) {
				nowx = node.x + mx[i];
				nowy = node.y + my[i];
				//좌표를 상하좌우로 움직임
				
				if (iceCase_Check() == true && iceCase[nowx][nowy] ==0 && visited[nowx][nowy] == false) {
					//현재 좌표가 얼음 틀 안쪽 && 벽이 아님 && 방문한 곳이 아님  세 조건을 충족할때만 실행
					que.offer(new Node(nowx, nowy));
					visited[nowx][nowy] = true;
					//이동할 수 있는 칸이면 그 칸을 큐에 입력, 방문 체크
				}
			}
		}
		cnt++;
	}
	
	public static boolean iceCase_Check() {
		//현재 위치가 얼음 칸 안쪽에 위치하는지 체크
		if(nowx >= 0 && nowx < N && nowy >= 0 && nowy < M) return true;
		else return false;
	}
	
	
	
	/* 
	 교제의 자바 해답. 선언된 전역변수도 훨씬적고 DFS로 재귀를 이용해서 푼 방법
	public static int n, m;
    public static int[][] graph = new int[1000][1000];

    // DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
    public static boolean dfs(int x, int y) {
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (x <= -1 || x >=n || y <= -1 || y >= m) {
            return false;
        }
        // 현재 노드를 아직 방문하지 않았다면 (연결된 노드중 1이 아닌 노드 전부 방문해서 1로 변경하고 true리턴함)
        if (graph[x][y] == 0) {
            // 해당 노드 방문 처리(얼음 틀 배열과 방문 배열을 따로 구분하지 않고 그냥 1이 아닌 곳만 dfs를 호출)
            graph[x][y] = 1;
            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // 모든 노드(위치)에 대하여 음료수 채우기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 DFS 수행
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result); // 정답 출력 
    }  
	*/

}
