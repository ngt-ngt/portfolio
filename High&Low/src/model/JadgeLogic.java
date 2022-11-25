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
		//大きいか小さいか結果メッセージ用
		String message = numberBeans.getMessage();
		//		System.out.println("テスト用解答" + randomAns);		//テスト

		if (userInput < randomAns) {
			message = ("もっと大きな数字です");
		} else if (userInput > randomAns) {
			message = ("もっと小さな数字です");
		} else if (userInput == randomAns) {
			message = ("正解です！");
		}
		numberBeans.setMessage(message);
	}

}
