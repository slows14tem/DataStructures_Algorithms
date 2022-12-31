package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS_7562 {
	static boolean visited[][];	//방문체크
	static int board[][];	//이동거리 입력
	static int mx[] = {1, 2, 2, 1, -1, -2, -2, -1};
	static int my[] = {-2, -1, 1, 2, 2, 1, -1, -2};	//나이트 이동 방향(시계방향)
	static Queue<Node> que = new LinkedList<>();
	
	static int nowx, nowy;	//현재위치 좌표
	static int N, L;	//테스트 케이스 수, 체스판 가로세로
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
		//StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
		//N = Integer.parseInt(st.nextToken());

		for (int i=0;i<N;i++) {		
			L = Integer.parseInt(br.readLine()); 	//체스판 가로세로
			//L = Integer.parseInt(st.nextToken());
			visited = new boolean[L][L];	//방문체크용
			board = new int[L][L];		//이동거리 입력용
			String[] s = br.readLine().split(" ");	//나이트 현재 좌표
			String[] g = br.readLine().split(" ");	//나이트 목표 좌표
			BFS(Integer.parseInt(s[0]), Integer.parseInt(s[1]),	//현재좌표
					Integer.parseInt(g[0]), Integer.parseInt(g[1]));	//목표 좌표
			System.out.println(board[Integer.parseInt(g[0])][Integer.parseInt(g[1])]);
		}
	
	}
	
	public static void BFS(int x1, int y1, int x2, int y2) {
		que.offer(new Node(x1, y1));
		//스타트 좌표 큐에 입력
		
		visited[x1][y1] = true;
		//현재좌표 방문 체크

		while(!que.isEmpty()) {
			Node node = que.poll();
			//큐의 처음 값을 node로 반환하고 큐에서 삭제
			
			for (int i=0;i<mx.length;i++) {
				nowx = node.x + mx[i];
				nowy = node.y + my[i];
				//좌표를 8방향으로 움직임
				
				if (board_Check() == true && visited[nowx][nowy] == false) {
					//현재 좌표가 보드 안쪽 && 방문한적 없는 좌표 두 조건을 충족할 때 실행
					que.offer(new Node(nowx, nowy));
					visited[nowx][nowy] = true;
					board[nowx][nowy] = board[node.x][node.y] + 1;
					//이동할 수 있는 칸이면 그 칸을 큐에 입력, 방문 체크, 이동 전 node좌표값에서 1을 추가(지나온 최소 칸수)
				}
			}
		}	
	}
	
	public static boolean board_Check() {
		//현재 위치가 미로 칸 안쪽에 위치하는지 체크
		if(nowx >= 0 && nowx < L && nowy >= 0 && nowy < L) return true;
		else return false;
	}
}

//위의 코드에서 40번에서 에러 발생(java.util.NoSuchElementException)
//StringTokenizer를 사용하는 법에 익숙하지 않아서 발생
//N과 L을 StringTokenizer로 입력 받았는데 이 상황이라면 중간에 공백을 줘서 한줄에 입력해야 하는데
//문제의 입력사항은 엔터를 쳐서 다음줄에 입력받는 방식이라서 NoSuchElementException 발생
//N = Integer.parseInt(br.readLine()), L = Integer.parseInt(br.readLine())
//br.readLine()을 사용하여 문제의 입력방식에 맞게 입력받을 수 있게 변경

//https://m.blog.naver.com/ka28/221850826909