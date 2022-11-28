import java.awt.Toolkit;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PackLike {
	// Beep音鳴らすやつらしい
	public static void beep() {
		Toolkit.getDefaultToolkit().beep();
	}

	public static void main(String args[]) {

		char[][] Map = new char[][] {
				{ ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',
						'#', '#', ' ' },
				{ ' ', '#', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '#', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o',
						'o', '#', ' ' },
				{ ' ', '#', 'o', '#', '#', '#', 'o', '#', '#', '#', 'o', '#', 'o', '#', '#', '#', 'o', '#', '#', '#',
						'o', '#', ' ' },
				{ ' ', '#', 'o', '#', ' ', '#', 'o', '#', ' ', '#', 'o', '#', 'o', '#', ' ', '#', 'o', '#', ' ', '#',
						'o', '#', ' ' },
				{ ' ', '#', 'o', '#', '#', '#', 'o', '#', '#', '#', 'o', '#', 'o', '#', '#', '#', 'o', '#', '#', '#',
						'o', '#', ' ' },
				{ ' ', ' ', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o',
						'o', ' ', ' ' },
				{ ' ', '#', 'o', '#', '#', '#', 'o', '#', 'o', '#', '#', '#', '#', '#', 'o', '#', 'o', '#', '#', '#',
						'o', '#', ' ' },
				{ ' ', '#', 'o', '#', '#', '#', 'o', '#', 'o', '#', '#', '#', '#', '#', 'o', '#', 'o', '#', '#', '#',
						'o', '#', ' ' },
				{ ' ', '#', 'o', 'o', 'o', 'o', 'o', '#', 'o', 'o', 'o', '#', 'o', 'o', 'o', '#', 'o', 'o', 'o', 'o',
						'o', '#', ' ' },
				{ ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',
						'#', '#', ' ' } };

		// TODO:出来ればカーソルキーで操作したい
		// TODO:Enterキー押さずに進んで欲しい
		// TODO:敵キャラ増やす
		// TODO:パワーボール作って取ったら敵を倒せる
		// TODO:敵キャラ通ったとこにoを入れてるけど、oか空白か判断して影響しないようにしたい

		int playerX = 0; // 座標指定用にx,y用意
		int playerY = 0;
		playerX = 5;
		playerY = 11;
		Map[playerX][playerY] = '@'; // パックマンの初期位置指定
		int score = 0; // 得点用
		int clearPoint = 8100; // ゲームクリアポイント
		int input = 0; // 入力用

		// 敵キャラ用
		Random rnd = new Random();
		int enemyG = 0; // 1~4のランダム
		// 敵キャラ用ランダム配置
		int enemyX = 0;
		int enemyY = 0;
		while (true) {
			Random rnd1 = new Random();
			Random rnd2 = new Random();
			enemyX = rnd1.nextInt(10);
			enemyY = rnd2.nextInt(23);
			if (Map[enemyX][enemyY] != '#' && Map[enemyX][enemyY] != '@' && Map[enemyX][enemyY] != ' ') {
				Map[enemyX][enemyY] = 'V';
				break;
			}
		}

		System.out.println("@:プレイヤー　　o:ポイントボール　　V:敵");
		while (true) {// メインループ

			//更新された座標にプレイヤーをセット
			Map[playerX][playerY] = '@';
			Map[enemyX][enemyY] = 'V'; // 敵キャラ用

			System.out.println("☆スコア" + clearPoint + "点でゲームクリア");
			for (int i = 0; i < Map.length; i++) {// マップ表示
				for (int j = 0; j < Map.length + 13; j++) {
					System.out.print(Map[i][j]);
				}
				System.out.println();
			}
			System.out.println("スコア：" + score);

			// クリアポイントでゲームクリア
			if (score == clearPoint) {
				System.out.println("CREAR!!!");
				beep();
				break;
			}

			
// 			System.out.println("player：" + input);	//テスト用
// 			System.out.println("enemyG：" + enemyG);	//テスト用

			//角で隣接したらアウトなるバグ対策
			//playerが上か下かつ敵が左か右または、playerが左か右かつ敵が上か下
			if (((input == 1 || input == 2) && (enemyG == 3 || enemyG == 4)) ||
					((input == 3 || input == 4) && (enemyG == 1 || enemyG == 2))) {

				if (Map[playerX][playerY] == 'V') {
					System.out.println("GAME OVER");
// 					// 確認用
// 					System.out.println("player" + playerX + ":" + playerY);
// 					System.out.println("enemy" + enemyX + ":" + enemyY);
// 					System.out.println("player" + input);
// 					System.out.println("enemyG" + enemyG);
					break;
				}

			} else {
				//すれ違い対策
				//player座標にVが入ってたらアウトまたは、input1でプレイヤーが上、かつ、敵が2で下、かつ、enemyXがplayerX+1と一緒、かつ、enemyYとplayerYが一緒
				if (Map[playerX][playerY] == 'V'

						|| (input == 1 && enemyG == 2 && (enemyX == playerX + 1 && enemyY == playerY))
						|| (input == 2 && enemyG == 1 && (enemyX == playerX - 1 && enemyY == playerY))
						|| (input == 3 && enemyG == 4 && (enemyX == playerX && enemyY == playerY + 1))
						|| (input == 4 && enemyG == 3 && (enemyX == playerX && enemyY == playerY - 1)))

				{
					System.out.println("GAME OVER");
					// 確認用
// 					System.out.println("player" + playerX + ":" + playerY);
// 					System.out.println("enemy" + enemyX + ":" + enemyY);
// 					System.out.println("player" + input);
// 					System.out.println("enemyG" + enemyG);
					Map[playerX][playerY] = ' ';
					break;
				}
			}

			while (true) { // 入力受けて壁とか判定して座標とスコア更新する

				//				// 確認用
// 				System.out.println("player" + playerX + ":" + playerY);
// 				System.out.println("enemy" + enemyX + ":" + enemyY);

				// 通ったとこにはスペースを入れる
				if (Map[playerX][playerY] == '@') {
					Map[playerX][playerY] = ' ';
				}

				// 敵キャラ通ったとこにoを入れてるけど、oか空白か判断して影響しないようにしたい
				//検証中
				if (Map[enemyX][enemyY] == 'V') {
					Map[enemyX][enemyY] = 'o';
				} else {
					Map[enemyX][enemyY] = ' ';
				}

				System.out.println("1:上　2:下　3:左　4:右");// 1:上 2:下 3:左 4:右
				try {
					Scanner sc = new Scanner(System.in); // 入力受付
					input = sc.nextInt();
				} catch (InputMismatchException e) { //数字以外は受け付けない
					System.out.println("１～４の数字を入力して下さい");
				}

				//敵キャラが壁以外の座標に行くようにループする　角で止まり続ける現象対策
				while ((Map[enemyX][enemyY] == 'o' || Map[enemyX][enemyY] == ' ')) {
					// 敵キャラ用　ループ内で毎回ランダムセットしないと敵が動かない
					enemyG = rnd.nextInt(4) + 1; // 1~4のランダム
					// enemyG = 1;	//テスト用

					//敵キャラを外に出したくない とりあえず外に出ないようにしてる
					if (enemyG == 4 && enemyX == 5 && enemyY == 20) {
						enemyY--;
						System.out.println("右");
						break;

					} else if (enemyG == 3 && enemyX == 5 && enemyY == 2) {
						enemyY++;
						System.out.println("左");
						break;
					}

					//Vが通った後に影響を出したくない　移動先がoならo スペースならスペース
					// 敵キャラ用分岐 手直し版

					if (enemyG == 1 && Map[enemyX-1][enemyY] == 'o') {
						Map[enemyX][enemyY] = 'o';
						enemyX--;
						break;
					} else if (enemyG == 1 && Map[enemyX-1][enemyY] == ' ') {
						Map[enemyX][enemyY] = ' ';
						enemyX--;
						break;

					} else if (enemyG == 1 && Map[enemyX - 1][enemyY] == '#') {
//						break;

					} else if (enemyG == 2 && Map[enemyX + 1][enemyY] == 'o') {
						Map[enemyX][enemyY] = 'o';
						enemyX++;
						break;
					} else if (enemyG == 2 && Map[enemyX + 1][enemyY] == ' ') {
						Map[enemyX][enemyY] = ' ';
						enemyX++;
						break;

					} else if (enemyG == 2 && Map[enemyX + 1][enemyY] == '#') {
//						break;

					} else if (enemyG == 3 && Map[enemyX][enemyY - 1] == 'o') {
						Map[enemyX][enemyY] = 'o';
						enemyY--;
						break;
					} else if (enemyG == 3 && Map[enemyX][enemyY - 1] == ' ') {
						Map[enemyX][enemyY] = ' ';
						enemyY--;
						break;

					} else if (enemyG == 3 && Map[enemyX ][enemyY -1] == '#') {
//						break;

					} else if (enemyG == 4 && Map[enemyX][enemyY + 1] == 'o') {
						Map[enemyX][enemyY] = 'o';
						enemyY++;
						break;
					} else if (enemyG == 4 && Map[enemyX][enemyY + 1] == ' ') {
						Map[enemyX][enemyY] = ' ';
						enemyY++;
						break;
					} else if (enemyG == 4 && Map[enemyX] [enemyY+1] == '#') {
//						break;
					}
				}

				//ワープ通路。もしプレイヤー座標が5,1になったら5,21座標にプレイヤーを代入
				//if (input == 3 && Map[playerX][playerY] == Map[5][0]) { ←この書き方だとうまく座標判定出来なかった。
				if (input == 3 && playerX == 5 && playerY == 1) {

					playerX = 5;
					playerY = 21;
					Map[playerX][playerY] = '@';
					break;
				}
				//ワープ通路。もしプレイヤー座標が5,21になったら5,1座標にプレイヤーを代入
				if (input == 4 && playerX == 5 && playerY == 21) {
					playerX = 5;
					playerY = 1;
					Map[playerX][playerY] = '@';
					break;

				}

				// プレイヤー用の分岐
				if (input == 1 && Map[playerX - 1][playerY] == 'o') {
					playerX--;
					score += 100; // oを拾ったらscore+100
					break;
					// 戻りたい時scoreは変えず座標だけ変える
				} else if (input == 1 && Map[playerX - 1][playerY] == ' ') {
					playerX--;
					break;
					// 行き先は壁（#）なら行けなくする
				} else if (input == 1 && Map[playerX - 1][playerY] == '#') {
					System.out.println("壁です");
					break;
				}

				if (input == 2 && Map[playerX + 1][playerY] == 'o') {
					playerX++;
					score += 100;
					break;
				} else if (input == 2 && Map[playerX + 1][playerY] == ' ') {
					playerX++;
					break;
				} else if (input == 2 && Map[playerX + 1][playerY] == '#') {
					System.out.println("壁です");
					break;
				}

				if (input == 3 && Map[playerX][playerY - 1] == 'o') {
					playerY--;
					score += 100;
					break;
				}
				if (input == 3 && Map[playerX][playerY - 1] == ' ') {
					playerY--;
					break;

				} else if (input == 3 && Map[playerX][playerY - 1] == '#') {
					System.out.println("壁です");
					break;
				}

				if (input == 4 && Map[playerX][playerY + 1] == 'o') {
					playerY++;
					score += 100;
					break;
				} else if (input == 4 && Map[playerX][playerY + 1] == ' ') {
					playerY++;
					break;
				} else if (input == 4 && Map[playerX][playerY + 1] == '#') {
					System.out.println("壁です");
					break;
				}

			} // 入力判定while
		} // メインwhile
	}

}
