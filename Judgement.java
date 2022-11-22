package dungeon;

public class Judgement {
	/*
	 * 現在地の座標を表示し周りが壁か通路かを判定・表示するメソッド
	 */
	public void judge(char[][] map, int x, int y) {

//		System.out.println("----------------------");
		System.out.println("あなたの現在地は" + "[" + x + "," + y + "]" + "です");
		System.out.println("----------------------");
		System.out.println();
		System.out.print("　　上：");
		if (map[x - 1][y] == '＃') {
			System.out.println(" 壁");
			System.out.println();
		} else {
			System.out.println("通路");
			System.out.println();
		}
		System.out.print("左：");
		if (map[x][y - 1] == '＃') {
			System.out.print("壁");

		} else {
			System.out.print("通路");

		}
		System.out.print("　   右：");
		if (map[x][y + 1] == '＃') {
			System.out.println("壁");
			System.out.println();
		} else {
			System.out.println("通路");
			System.out.println();
		}
		System.out.print("　　下：");
		if (map[x + 1][y] == '＃') {
			System.out.println(" 壁");
			System.out.println();
		} else {
			System.out.println("通路");
			System.out.println();
		}
	}
}
