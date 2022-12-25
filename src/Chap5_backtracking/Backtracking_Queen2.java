package Chap5_backtracking;

public class Backtracking_Queen2 {
	//정답을 좌표로 모두 출력
	public static void SolveQueen(int[][] d) {

		int count = 0;	//스택 카운트
		int cnt = 0;	//정답 개수 카운트
		int ix = 0, iy = 0;	//x,y좌표
		Stack2 st = new Stack2(d.length);
		Point p = new Point(ix, iy);
		d[ix][iy] = 1;		
		st.push(p);
		count++;
		while (count < d.length) {
			iy++;
			while (iy < d.length)
			{
				while (ix < d[0].length) {
					if (CheckMove(d, ix, iy)) {
						p = new Point(ix, iy);
						st.push(p);
						count++;
						d[ix][iy] = 1;
						break;
					}
					ix++;
				}
				if (count == d.length) {
					st.dump();
					//정답 출력(좌표단위로)
					cnt++;
					System.out.println(cnt);
					ix = d[0].length;
				}
				if (count == 0) {
					return;	//모든 정답 출력 한 후에 스택에 값을 다 지우면 함수를 종료하기 위해서
				}
				if (ix != d[0].length) {
					ix=0;
					break;
				} else {
					ix=st.peek().getX();
					iy=st.peek().getY();
					d[ix][iy] = 0;
					ix++;
					p = st.pop();
					count--;
				}				
			}
		}
	}

	public static boolean checkRow(int[][] d, int y) {
		for (int i = 0; i < d.length; i++)
	        if (d[i][y]==1)
	            return false;	  
		return true;
	}

	public static boolean checkCol(int[][] d, int x) {
		for (int i = 0; i < d[0].length; i++)
	        if (d[x][i]==1)
	            return false;	
		return true;
	}

	public static boolean checkDiagSW(int[][] d, int cx, int cy) {
		//x++, y-- or x--, y++ where 0<= x,y <= 7
		while(true) {
			cx++;
			cy--;
			if (cx>=d.length || cy<0) {
				return true;
			}
			if (d[cx][cy]==1) {
				return false;
			}
		}
	}

	//남동 대각선 체크
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {
		//x++, y++ or x--, y--
		while(true) {
			cx--;
			cy--;
			if (cx<0 || cy<0) {
				return true;
			}
			if (d[cx][cy]==1) {
				return false;
			}
		}
	}
    public static boolean CheckMove(int[][]d, int x, int y) {
    	//(x,y)로 이동 가능한지를 check
    	if(checkRow(d, y) && checkCol(d, x) && checkDiagSW(d,x,y) && checkDiagSE(d,x,y)) {
    		return true;
    	}
    	return false;
    	 	
    }

	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[row][col];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		SolveQueen(data);

//		for (int i = 0; i < data.length; i++) {
//			for (int j = 0; j < data[0].length; j++) {
//				System.out.print(" " + data[i][j]);
//			}
//			System.out.println();
//		}
	}
}
