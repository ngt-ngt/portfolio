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

		// TODO:敵が外の空白通路に行って配列外に行ったらエラー起こす対処

		int playerX = 0; // 座標指定用にx,y用意
		int playerY = 0;
		playerX = 5;
		playerY = 11;
		Map[playerX][playerY] = '@'; // パックマンの初期位置指定
		int score = 0; // 得点用
		int clearPoint = 10000; // ゲームクリアポイント
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

			//敵に当たったらゲームオーバー
			System.out.println("player：" + input);
			System.out.println("enemyG：" + enemyG);

			//角で隣接したらアウトなるバグ対策
			//playerが上か下かつ敵が左か右または、playerが左か右かつ敵が上か下
			if (((input == 1 || input == 2) && (enemyG == 3 || enemyG == 4)) ||
					((input == 3 || input == 4) && (enemyG == 1 || enemyG == 2))) {

				System.out.println("テスと");

				if (Map[playerX][playerY] == 'V') {
					System.out.println("GAME OVER1");
					// 確認用
					System.out.println("player" + playerX + ":" + playerY);
					System.out.println("enemy" + enemyX + ":" + enemyY);
					System.out.println("player" + input);
					System.out.println("enemyG" + enemyG);
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
					System.out.println("GAME OVER2");
					// 確認用
					System.out.println("player" + playerX + ":" + playerY);
					System.out.println("enemy" + enemyX + ":" + enemyY);
					System.out.println("player" + input);
					System.out.println("enemyG" + enemyG);
					Map[playerX][playerY] = ' ';
					break;
				}
			}

			while (true) { // 入力受けて壁とか判定して座標とスコア更新する

				//				// 確認用
				System.out.println("player" + playerX + ":" + playerY);
				System.out.println("enemy" + enemyX + ":" + enemyY);

				// 通ったとこにはスペースを入れる
				if (Map[playerX][playerY] == '@') {
					Map[playerX][playerY] = ' ';
				}
				//敵の通ったあとがoの設定用
//				if (Map[enemyX][enemyY] == 'V')  {
//					Map[playerX][playerY] = 'o';
//				}

				// 敵キャラ通ったとこにoを入れてるけど、oか空白か判断して影響しないようにしたい
				//検証中
				if (Map[enemyX][enemyY] == 'V') {
					if ((enemyG == 1 && enemyX == enemyX + 1 && Map[enemyX+1][enemyY] == 'o')
							|| (enemyG == 2 && enemyX == enemyX - 1 && Map[enemyX-1][enemyY] == 'o')
							|| (enemyG == 3 && enemyY == enemyY + 1 && Map[enemyX][enemyY+1] == 'o')
							|| (enemyG == 4 && enemyY == enemyY - 1 && Map[enemyX][enemyY-1] == 'o')) {
						Map[enemyX][enemyY] = 'o';
					} else {
						Map[enemyX][enemyY] = ' ';
					}
				}
				//				else if (Map[enemyX][enemyY] == 'V' && (enemyG == 1 && Map[enemyX-1][enemyY] == ' ') || (enemyG == 2 && Map[enemyX+1][enemyY] == ' ')
				//				||  (enemyG == 3 && Map[enemyX][enemyY-1] == ' ') || (enemyG == 4 && Map[enemyX][enemyY+1] == ' ')) {
				//					Map[enemyX][enemyY] = ' ';
				//				}

				// 敵キャラ通ったとこにoを入れてるけど、oか空白か判断して影響しないようにしたい
				//				if (Map[enemyX][enemyY] == 'V') {
				//					for(int i =0; i<Map.length; i++) {
				//						for(int j =0; j<Map.length; j++) {
				//							if(Map[i][j] == 'o') {
				//								Map[enemyX][enemyY] = 'o';
				//							}else if(Map[i][j] == ' ') {
				//								Map[enemyX][enemyY] = ' ';
				//							}
				//						}
				//
				//						}
				//					}

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
					//										enemyG = 4; // 1~4のランダム
					// 敵キャラ用分岐 手直し版
					if (enemyG == 1 && (Map[enemyX - 1][enemyY] == 'o' || Map[enemyX - 1][enemyY] == ' ')) { // 上にいく
						enemyX--;
						break;

					} else if (enemyG == 2 && (Map[enemyX + 1][enemyY] == 'o' || Map[enemyX + 1][enemyY] == ' ')) { // 下に行く
						enemyX++;
						break;
					} else if (enemyG == 3 && (Map[enemyX][enemyY - 1] == 'o' || Map[enemyX][enemyY - 1] == ' ')) { // 左行く
						enemyY--;
						break;
					} else if (enemyG == 4 && (Map[enemyX][enemyY + 1] == 'o' || Map[enemyX][enemyY + 1] == ' ')) { // 右に行く
						enemyY++;
						break;
					}
				}

				//敵キャラを外に出したくない試し中
				//			if (enemyG == 4 && enemyX == 5 && enemyY == 21) {
				//				enemyX ++;
				//				enemyY--;
				//				System.out.println("★test");
				//			}

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
