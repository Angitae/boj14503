import java.util.*;

public class Main {
	static int N, M, t = 0, sum = 1;
	static int[] dx = { 0, -1, 0, 1 }; //행 이동 위한 배열
	static int[] dy = { -1, 0, 1, 0 }; //열 이동 위한 ㅂ열
	static int[][] map = new int[51][51]; //map크기
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		int r = scan.nextInt()+1;
		int c = scan.nextInt()+1; 
		int d = scan.nextInt();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = scan.nextInt();
			}
		}//map 설정

		map[r][c] = 2; 
		bfs(r, c, d);
		System.out.println(sum);
	}

	public static void bfs(int x, int y, int d) {
		while (true) {
			if (map[x + dx[d]][y + dy[d]] == 0) {
				sum = sum + 1; //청소하고 더하고
				map[x += dx[d]][y += dy[d]] = 2; //표시
				d = (d + 3) % 4;
				t = 0;
				continue;
			} else {
				d = (d + 3) % 4;
				t++;
			}

			if (t == 4) {
				x = x + dx[(d + 3) % 4];
				y = y + dy[(d + 3) % 4];
				t = 0;
			}

			if (map[x][y] == 1)
				break;
		}
	}
}