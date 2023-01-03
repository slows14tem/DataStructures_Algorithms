package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Implementation4_1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int x = 1;
		int y = 1;

		
		String[] str = br.readLine().split(" ");
		
		
		for (int i=0;i<str.length;i++) {
			if ((str[i]).charAt(0) == 'L') x += -1;
			else if ((str[i]).charAt(0) == 'R') x += 1;
			else if ((str[i]).charAt(0) == 'U') y += -1;
			else y += 1;
			
			if (x < 1) x = 1;
			else if(x > N) x = N;
			else if(y < 1) y = 1;
			else if(y > N) y = N;
		}
		System.out.println(y + " " + x);
		
		
//		int[] dx = {-1, 1, 0, 0};
//		int[] dy = {0, 0, -1, 1};
//		int nx = 0, ny = 0;
//		char[] move_type = {'L', 'R', 'U', 'D'};
//		for (int i=0;i<str.length;i++) {
//			char plan = str[i].charAt(0);
//			for (int j=0;j<move_type.length;j++) {
//				if (plan == move_type[j]) {
//					nx = x + dx[j];
//					ny = y + dy[j];
//				}
//			}
//			if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
//			x = nx;
//			y = ny;
//		}
//		System.out.println(y + " " + x);
	}
}
