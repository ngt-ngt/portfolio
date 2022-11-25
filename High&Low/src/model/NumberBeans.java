package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 入力された情報や履歴をListに入れるためやランダムな答えメッセージなど必要な情報を持つBeansクラス
 * @author nagatayoshio
 *
 */
public class NumberBeans implements Serializable {
	private int userInput;
	private int randomAns;
	private String message;
	private List<Integer> list;

	//コンストラクタで答えのランダム数値を生成して宣言してる
	public NumberBeans() {
		this.randomAns = new Random().nextInt(100) + 1;
		list = new ArrayList<Integer>();
	}

	public int getUserInput() {
		return userInput;
	}

	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}

	public int getRandomAns() {
		return randomAns;
	}

	public void setRandomAns(int randomAns) {
		this.randomAns = randomAns;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

}
