package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Racket {
	//ラケットサイズ
	public static final int WIDTH = 80;
	public static final int HEIGHT = 10;

	//ラケットの中心位置
	private int centerPos;

	public Racket() {
		//ラケットの位置を画面の真ん中で初期化
		centerPos = MainPanel.WIDTH / 2;
	}
	/*
	 * ラケットの描画
	 */
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(centerPos-WIDTH /2, MainPanel.HEIGHT- HEIGHT , WIDTH, HEIGHT);
	}
	/*
	 * ラケットの移動
	 */
	public void move(int pos) {
		centerPos = pos;

		//ラケットが画面からはみ出ないようにする
		if(centerPos < WIDTH / 2) {//左端に行ったら
			centerPos = WIDTH / 2;
		}else if (centerPos > MainPanel.WIDTH - WIDTH / 2) {//右端に行ったら
			centerPos = MainPanel.WIDTH - WIDTH /2;
		}
	}
	/**
	 * ボールに当たったらtrue
	 */
	public boolean collideWith(Ball ball) {
		//ラケットの四角形
		Rectangle racketRect = new Rectangle(centerPos -WIDTH /2, MainPanel.HEIGHT-HEIGHT,WIDTH,HEIGHT);
		//ボールの四角形
		Rectangle ballRect = new Rectangle(ball.getX(),ball.getY(),ball.getSize(),ball.getSize());

		//ラケットとボールの四角形が重なったら当たり判定
		if(racketRect.intersects(ballRect)) {
			return true;
		}
				return false;
	}
}
