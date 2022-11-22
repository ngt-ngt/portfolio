package marubatu;

import java.util.Scanner;

public class Marubatu {

	public static void main(String[] args) {
		char[][] gamebord = { { '1', '|', '2', '|', '3' },
				{ '-', '-', '-', '-', '-', },
				{ '4', '|', '5', '|', '6' },
				{ '-', '-', '-', '-', '-', },
				{ '7', '|', '8', '|', '9' } };

		//		TODO;入力済みの判断どうするか

		int cnt = 0;//引き分け用のカウント

		//◯×ボード表示
		gamebord(gamebord);

		while (true) {//メインwhile

			//player◯の入力
			System.out.println("player◯のターン　1〜９の数字を選んで下さい");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();

			switch (input) {
			case 1:
				if(gamebord[0][0] == '1') {
						gamebord[0][0] = '◯';
				cnt++;
				break;
				} else {
					System.out.println("ここには入力できません");
				}break;
			case 2:
				if(gamebord[0][2] == '2') {
					gamebord[0][2] = '◯';
			cnt++;
			break;
			} else {
				System.out.println("ここには入力できません");
			}break;
			case 3:
				if(gamebord[0][4] == '3') {
					gamebord[0][4] = '◯';
			cnt++;
			break;
			} else {
				System.out.println("ここには入力できません");
			}break;
			case 4:
				if(gamebord[2][0] == '4') {
					gamebord[2][0] = '◯';
			cnt++;
			break;
			} else {
				System.out.println("ここには入力できません");
			}break;
			case 5:
				if(gamebord[2][2] == '5') {
					gamebord[2][2] = '◯';
			cnt++;
			break;
			} else {
				System.out.println("ここには入力できません");
			}break;
			case 6:
				if(gamebord[2][4] == '6') {
					gamebord[2][4] = '◯';
			cnt++;
			break;
			} else {
				System.out.println("ここには入力できません");
			}break;
			case 7:
				if(gamebord[4][0] == '7') {
					gamebord[4][0] = '◯';
			cnt++;
			break;
			} else {
				System.out.println("ここには入力できません");
			}break;
			case 8:
				if(gamebord[4][2] == '8') {
					gamebord[4][2] = '◯';
			cnt++;
			break;
			} else {
				System.out.println("ここには入力できません");
			}break;
			case 9:
				if(gamebord[4][4] == '9') {
					gamebord[4][4] = '◯';
			cnt++;
			break;
			} else {
				System.out.println("ここには入力できません");
			}break;
			}

			//この時点で◯が揃ったら◯の勝利
			gamebord(gamebord);
			if (judgement(gamebord, cnt) == 1) {
				System.out.println("◯の勝ち");
				break;
			} else if (judgement(gamebord, cnt) == 0) {
				System.out.println("引き分け");
				break;
			}

			//player×の入力
			while (true) {
				System.out.println("player×のターン　1〜９の数字を選んで下さい");
				Scanner sc2 = new Scanner(System.in);
				int input2 = sc2.nextInt();

				switch (input2) {
				case 1:
					if(gamebord[0][0] == '1') {
							gamebord[0][0] = '×';

					break;
					} else {
						System.out.println("ここには入力できません");
						break;
					}
				case 2:
					if(gamebord[0][2] == '2') {
						gamebord[0][2] = '×';
				break;
				} else {
					System.out.println("ここには入力できません");
				}
					break;
				case 3:
					if(gamebord[0][4] == '3') {
						gamebord[0][4] = '×';
				break;
				} else {
					System.out.println("ここには入力できません");
				}
					break;
				case 4:
					if(gamebord[2][0] == '4') {
						gamebord[2][0] = '×';
				break;
				} else {
					System.out.println("ここには入力できません");
				}
					break;
				case 5:
					if(gamebord[2][2] == '5') {
						gamebord[2][2] = '×';
				break;
				} else {
					System.out.println("ここには入力できません");
				}
					break;
				case 6:
					if(gamebord[2][4] == '6') {
						gamebord[2][4] = '×';
				break;
				} else {
					System.out.println("ここには入力できません");
				}
					break;
				case 7:
					if(gamebord[4][0] == '7') {
						gamebord[4][0] = '×';
				break;
				} else {
					System.out.println("ここには入力できません");
				}
					break;
				case 8:
					if(gamebord[4][2] == '8') {
						gamebord[4][2] = '×';
				break;
				} else {
					System.out.println("ここには入力できません");
				}
					break;
				case 9:
					if(gamebord[4][4] == '9') {
						gamebord[4][4] = '×';

				break;
				} else {
					System.out.println("ここには入力できません");
				}
					break;

				default:System.out.println("ここには入力できません");
				}


				gamebord(gamebord);
				break;

			} //×のターンwhileここまで
				//×が揃っていたら×の勝利
			if (judgement(gamebord, cnt) == 2) {
				System.out.println("×の勝ち");
				break;
			} else if (judgement(gamebord, cnt) == 0) {
				System.out.println("引き分け");
				break;
			}
		} //メインwhileここまで

	}

	/*
	 * ◯×ボード表示メソッド
	 */
	public static void gamebord(char[][] gamebord) {
		for (int i = 0; i < gamebord.length; i++) {
			for (int j = 0; j < gamebord.length; j++) {
				System.out.print(gamebord[i][j]);
			}
			System.out.println();
		}
	}

	/*
	 * 勝敗の判定メソッド
	 */
	public static int judgement(char[][] gamebord, int cnt) {
		for (int i = 0; i <= 4; i++) {
			//◯の勝利条件
			if (gamebord[i][0] == '◯' && gamebord[i][2] == '◯' && gamebord[i][4] == '◯') {
				return 1;
			} else if (gamebord[0][i] == '◯' && gamebord[2][i] == '◯' && gamebord[4][i] == '◯') {
				return 1;
			} else if (gamebord[0][0] == '◯' && gamebord[2][2] == '◯' && gamebord[4][4] == '◯') {
				return 1;
			} else if (gamebord[0][4] == '◯' && gamebord[2][2] == '◯' && gamebord[4][0] == '◯') {
				return 1;
			}
			//×の勝利条件
			if (gamebord[i][0] == '×' && gamebord[i][2] == '×' && gamebord[i][4] == '×') {
				return 2;
			} else if (gamebord[0][i] == '×' && gamebord[2][i] == '×' && gamebord[4][i] == '×') {
				return 2;
			} else if (gamebord[0][0] == '×' && gamebord[2][2] == '×' && gamebord[4][4] == '×') {
				return 2;
			} else if (gamebord[0][4] == '×' && gamebord[2][2] == '×' && gamebord[4][0] == '×') {
				return 2;
			}
		}
		if (cnt == 5) {

			return 0;
		}
		return 3;//何も指定してないので適当な数字
	}
}