package Practice;

class Items{
	private int x;
	private int y;
	private int dir;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public Items(int x, int y, int dir) {
		this.x=x;
		this.y=y;
		this.dir=dir;
	}

	@Override
	public String toString() {
		return "Items [x=" + x + ", y=" + y + ", dir=" + dir + "]";
	}
	
}

//struct items {
//int x, y, dir;
//};
//
//ostream& operator<<(ostream& os, items& item)
//{
//return os << item.x << "," << item.y << "," << item.dir;
//}
//

class Offsets{
	int a;
	int b;

	public Offsets(int a, int b) {
		this.a=a;
		this.b=b;		
	}
}

//struct offsets {
//int a, b;
//};
//
//enum directions { N, NE, E, SE, S, SW, W, NW }; enumeration 검색 0,1,2,3,4,5,6,7
//offsets moves[8];

//int maze[100][100];
//int mark[100][100];
//

public class MazingProblem {

	static Offsets[] moves = new Offsets[8];
	//moves[0] = new Offsets(-1,0);
	
	public static void path(int[][] maze, int[][] mark, int ix, int iy) {

		mark[1][1] = 1;
		MazeStackList st = new MazeStackList(50);
		Items temp = new Items(0, 0, 0);
//		temp.x = 1;
//		temp.y = 1;
//		temp.dir = 2;
		temp.setX(1);
		temp.setY(1);;
		temp.setDir(2);
		st.push(temp);
		System.out.println("초기:: " + temp.toString());

		while (!st.isEmpty()) // stack not empty
		{
			temp = st.pop(); // unstack
//			int i = temp.x; int j = temp.y; int d = temp.dir;
			int i = temp.getX();
			int j = temp.getY();
			int d = temp.getDir();

			while (d < 8) // moves forward
			{
				int g = i + moves[d].a;
				int h = j + moves[d].b;

				if ((g == ix) && (h == iy)) { // reached exit
					mark[g][h] = 1;			// output path
					System.out.println("the term near the exit: " + i + " " + j);
					System.out.println("exit: " + ix + " " + iy);
					return;
				}
				if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // new position
					mark[g][h] = 1;

//					temp.x = i;  temp.y = j; temp.dir = d;
					temp = new Items(i, j, d);
					st.push(temp); // stack it
					
					i = g; j = h; d = 0; // moves to (g,h)
	
				} else
					d++; // try next direction
			}
			
		}
		System.out.println("no path in maze ");
		
	}

	public static void main(String[] args) {
		int[][] maze = new int[100][100];
		int[][] mark = new int[100][100];


		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 }, 
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, 
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, 
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, 
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }, };
		//moves[0] = new Offsets(-1,0);
//		for (int ia = 0; ia < 8; ia++)
//			moves[ia] = new Offsets(0, 0);

//		moves[0].a = -1;		//a=y ,b=x
//		moves[0].b = 0;	//0=북
		moves[0] = new Offsets(-1,0);
//		moves[1].a = -1;
//		moves[1].b = 1;	//1=북동
		moves[1] = new Offsets(-1,1);
//		moves[2].a = 0;
//		moves[2].b = 1;	//2=동
		moves[2] = new Offsets(0,1);
//		moves[3].a = 1;
//		moves[3].b = 1;	//3=남동
		moves[3] = new Offsets(1,1);
//		moves[4].a = 1;
//		moves[4].b = 0;	//4=남
		moves[4] = new Offsets(1,0);
//		moves[5].a = 1;
//		moves[5].b = -1;	//5=남서
		moves[5] = new Offsets(1,-1);
//		moves[6].a = 0;
//		moves[6].b = -1;	//6=서
		moves[6] = new Offsets(0,-1);
//		moves[7].a = -1;
//		moves[7].b = -1;	//7=북서
		moves[7] = new Offsets(-1,-1);

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				if ((i == 0) || (j == 0) || (i == 13) || (j == 16))
					maze[i][j] = 1;
				else {
					maze[i][j] = input[i - 1][j - 1];
				}
				mark[i][j] = 0;

			}
		}
		System.out.println("maze[12,15]::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(maze[i][j] + " ");

			}
			System.out.println();
		}
		System.out.println("mark::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(mark[i][j] + " ");

			}
			System.out.println();
		}
		path(maze, mark, 12, 15);
		System.out.println("mark::");
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 15; j++) {
				System.out.print(mark[i][j] + " ");

			}
			System.out.println();
		}

	}
}
