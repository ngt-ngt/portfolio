package sample;

import java.util.Random;

public class Position {
	/*
	 * プレイヤーの初期位置をランダムで設定するメソッド
	 */
	public DataBeans playerPosition(char[][] map) {
		//Beansのインスタンス化
		DataBeans data = new DataBeans();

		while (true) { //通路の座標が出るまで繰り返す
			//ランダムで初期座標設定
			Random rnd = new Random();
			int x = rnd.nextInt(10);
			int y = rnd.nextInt(10);
			if (map[x][y] == '・') {

				data.setX(x);	//ランダムで出たxをセットしBeansに渡す
				data.setY(y);

				return data;	//インスタンスを返す
			}
		}
	}
}
