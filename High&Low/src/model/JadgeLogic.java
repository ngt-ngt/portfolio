package model;

public class JadgeLogic {
	/**
	 * 入力値と答えが合っているか、大か小か判定するメソッド
	 * @param numberBeans
	 */
	public void jadgeNum(NumberBeans numberBeans) {
		//ユーザーが入力した数値取得
		int userInput = numberBeans.getUserInput();
		//ランダム生成した答え取得
		int randomAns = numberBeans.getRandomAns();
		//List型にユーザーの入力数値履歴を追加していく
		numberBeans.getList().add(userInput);
		//入力されるごとのカウント用
		int count = numberBeans.getCount();
		//大きいか小さいか結果メッセージ用
		String message = numberBeans.getMessage();
		//		System.out.println("テスト用解答" + randomAns);		//テスト

		if (userInput < randomAns) {
			message = ("もっと大きな数字です");
			numberBeans.setCount(count + 1);
		} else if (userInput > randomAns) {
			message = ("もっと小さな数字です");
			numberBeans.setCount(count + 1);
		} else if (userInput == randomAns) {
			if (count < 2) {
				message = ("正解です！  評価：なんだ、ただの天才か。");
			} else if (count < 5) {
				message = ("正解です！  評価：やるやんけ");
			} else if (count < 10) {
				message = ("正解です！  評価：凡人");
			} else if (count < 15) {
				message = ("正解です！  評価：次はもっと早くなる！");
			}
		}
		numberBeans.setMessage(message);
	}

}
