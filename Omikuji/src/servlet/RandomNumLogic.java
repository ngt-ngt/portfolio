package servlet;

import java.util.Random;

import model.KujiBeans;

public class RandomNumLogic {
	/**
	 * １〜５をランダムで生成し出た数が１なら１をリターンするメソッド
	 * @param kujiBeans
	 * @return
	 */
	public int execute(KujiBeans kujiBeans) {

		Random rnd = new Random();
		int num = rnd.nextInt(5);

		if (num == 1) {
			return 1;
		} else if (num == 2) {
			return 2;
		} else if (num == 3) {
			return 3;
		} else if (num == 4) {
			return 4;
		} else {
			return 5;
		}

	}
}
