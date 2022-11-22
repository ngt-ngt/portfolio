package sample;

import java.io.Serializable;

public class DataBeans implements Serializable {
	//フィールド値
	private int x;
	private int y;
	private char[][] map;

	//引数なしのコンストラクタ
	public DataBeans() {
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char[][] getMap() {
		return map;
	}

	public void setMap(char[][] map) {
		this.map = map;
	}

}
