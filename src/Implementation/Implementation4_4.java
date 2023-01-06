package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Implementation4_4 {
	
	static boolean visited[][];	//방문체크
	static int map[][];	//미로(0:벽)
	static int mx[] = {-1, 0, 1, 0};
	static int my[] = {0, -1, 0, 1};	//head 0, 1, 2, 3

	
	static int nowx, nowy;	//현재위치 좌표
	static int N, M;	//가로 세로
	static int x, y;	//바라보는 좌표
	static int sx, sy, head;	//시작 위치, 뱡향


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		visited = new boolean[N][M];
		map = new int[N][M];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st2.nextToken());
		sy = Integer.parseInt(st2.nextToken());
		head = Integer.parseInt(st2.nextToken());
		
		for (int i=0;i<N;i++) {
			String[] str = br.readLine().split("");
			for (int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		nowx = sx; nowy = sy;	//현재 좌표를 입력한 좌표로 변경
		visited[nowx][nowy] = true;
		int cnt=1;
		while(true) {
			for (int i=0;i<4;i++) {
				//x,y 에 head의 반시계방향의 좌표를 입력
				x = nowx + mx[head];
				y = nowy + my[head];
				if (head-1 < 0) head = 3;
				else head -= 1;
				//x, y의 자리가 이동 가능하면 현재 좌표를 x,y 로 변경
				if (map[y][x] == 0 && !visited[y][x]) {
					nowx = x; nowy = y;
					visited[y][x] = true;
					cnt++;
					//이동한 좌표에서 다시 반시계방향을 확인하는 반복문을 수행하기 위해 i=0으로 치환 
					i=0;
				}
			}
			//만약 4방향 다 이동 불가능하다면 현재 좌표에서 head방향으로 뒤로 한칸 이동
			nowx = nowx - mx[head];
			nowy = nowy - my[head];
			//뒤로 이동한 현재 좌표가 바다일 때 루프 종료
			if (map[nowy][nowx] == 1) break;
		}
		System.out.println(cnt);
		
	}

}
//바라보는 방향의 뒤로 한칸 이동하는게 -mx[head]만 하면 된다는 것을 끝까지 생각해 내지 못함.....