package dungeon;

import java.util.Scanner;

public class Dungeon {
	public static void main(String args[]) {
		//Mapクラスからランダムマップを取り出す
		Map rmap = new Map();
		char[][] map = rmap.RandomMap();

		int cnt = 5; //隠しコマンド回数制限用

		//初期座標をランダムで設定するメソッド呼び出し
		Position position = new Position();
		DataBeans data = new DataBeans();
		data = position.playerPosition(map);
		int x = data.getX();
		int y = data.getY();

		while (true) {//メインwhile

			//現在地を表示し周りが壁か通路かを判定する
			Judgement judge = new Judgement();
			judge.judge(map, x, y);

			//トラップマスに行ったらランダムで座標設定する
			if (map[x][y] == 'ロ') {
				System.out.println("!?!?!?!?!?!?!?!?!?!?!?");
				System.out.println();
				System.out.println("トラップだ！！");
				System.out.println();
				System.out.println("どこかに飛ばされた・・・");
				System.out.println();
				//初期位置設定と同じメソッドでワープ先を設定する
				data = position.playerPosition(map);
				 x = data.getX();
				 y = data.getY();

			}
			//＠マスでゴール
			if (map[x][y] == '＠') {
				System.out.println("**************");
				System.out.println("  ゴーール！！");
				System.out.println(" おめでとう！！");
				System.out.println("**************");
				break;
			}

			int C = 0;
			while (true) {//上下左右を入力し壁じゃなければx.y座標に+-する

				System.out.println("---------------------");
				System.out.println("　どちらに進みますか？");
				System.out.println("1~4の数字を入力して下さい");
				System.out.println("---------------------");
				System.out.println("1:上　2:下　3:左　4:右");
				System.out.println("---------------------");
				try {
					Scanner sc = new Scanner(System.in);
					C = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("半角数字を入力してください");
				}
				
				if (C == 1 && map[x - 1][y] != '＃') {
					x--;
					break;//このbreak地点で1個目のwhileに処理が戻る
				} else if (C == 1 && map[x - 1][y] == '＃') {
					System.out.println("上には行けません");
				}
				if (C == 2 && map[x + 1][y] != '＃') {
					x++;
					break;
				} else if (C == 2 && map[x + 1][y] != '・') {
					System.out.println("下には行けません");
				}
				if (C == 3 && map[x][y - 1] != '＃') {
					y--;
					break;
				} else if (C == 3 && map[x][y - 1] != '・') {
					System.out.println("左には行けません");

				}
				if (C == 4 && map[x][y + 1] != '＃') {
					y++;
					break;
				} else if (C == 4 && map[x][y + 1] != '・') {
					System.out.println("右には行けません");
				}

				//隠しコマンドで現在地をマップに表示させる
				if (C == 5 && cnt > 0) {
					for (int i = 0; i < map.length; i++) {
						for (int j = 0; j < map.length; j++) {
							//もし２回目以降の発動なら前回の＄を消して表示させたい
							if (map[i][j] == '＄') {
								map[i][j] = '・';
							}
							map[x][y] = '＄';
							System.out.print(map[i][j]);
						}
						System.out.println();
					}
					System.out.println("---------------------------------------");
					System.out.println("シークレットコマンド発動!!あなたの位置は＄です");
					cnt--;
					System.out.println("コマンド残り回数："+cnt);
					System.out.println("---------------------------------------");
				} else if (C == 5 && cnt <= 0) {
					System.out.println("------------------------------");
					System.out.println("シークレットパワーが足りない？！");
					System.out.println();
					System.out.println("オーマイガッ！！");
					System.out.println("------------------------------");
				}

			} //入力while
		} //メインwhile
	}//end main
}//end class
