
import java.util.Scanner;

public class MapMove {

	public static void main(String[] args) {
		int input = 0;
		// マップの作成
		int[][] Array = new int[][] {
				{ 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 5, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1 } };

		int x = 1;
		int y = 1;

		while (true) {//配列の数字に合わせてどの文字を表示させるか判定する
			if(Array[x][y]==5 ) {
				System.out.println("GOAL!!!");
				break;
			}
			Array[x][y] = 9;
			// Playerの初期位置指定
			for (int i = 0; i < Array.length; i++) {
				for (int j = 0; j < Array.length; j++) {
					//もし0なら・を表示させ9なら＠を表示させる
					if (Array[i][j] == 0) {
						System.out.print("・");
					} else if (Array[i][j] == 1) {
						System.out.print("＃");
					} else if (Array[i][j] == 5) {
						System.out.print("Ｇ");
					} else if (Array[x][y] == 9) {
						System.out.print("＠");
					}
				}
				System.out.println();
			}

			while (true) {//入力判定し座標x,yに+-する
				//元いた座標に0を入れ直して、足跡つかないようにするやつ
				if (Array[x][y] == 9) {
					Array[x][y] = 0;
				}

				System.out.println("1:上　2:下　3:左 4:右　");
				//入力受付
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();

				if (input == 1 && Array[x - 1][y] == 0 || Array[x-1][y]==5) {
					x--;
					break;
				} else if (input == 1 && Array[x - 1][y] == 1) {
					System.out.println("上には行けない");
				}
				if (input == 2 && Array[x + 1][y] == 0 || Array[x+1][y]==5) {
					x++;
					break;
				} else if (input == 2 && Array[x + 1][y] == 1) {
					System.out.println("下には行けない");
				}
				if (input == 3 && Array[x][y - 1] == 0 || Array[x][y-1]==5) {
					y--;
					break;
				} else if (input == 3 && Array[x][y - 1] == 1) {
					System.out.println("左には行けない");
				};
				if (input == 4 && Array[x][y + 1] == 0 || Array[x][y+1]==5) {
					y++;
					break;
				} else if (input == 4 && Array[x][y + 1] == 1) {
					System.out.println("右には行けない");
				}
			}//入力while
		}//メインwhile
	}
}
