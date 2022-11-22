package gui;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	//サイズ
	private static final int SIZE = 8;

	// 位置（ボールを囲む矩形の左上隅）
	private int x, y;
	//速度
	private int vx, vy;

	//ランダム
//	private Random rand;

	public Ball() {
		//rand = new Random(System.currentTimeMillis());

		//位置を初期化
		//		x = rand.nextInt(MainPanel.WIDTH - SIZE);
		//		y = 0;
		x = (MainPanel.WIDTH - SIZE) / 2;
		y = (MainPanel.HEIGHT - Racket.HEIGHT - SIZE * 2);

		//速度を初期化（とりま固定）
		vx = 5;
		vy = 5;
	}

	/*
	 * ボールを描画
	 */
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, SIZE, SIZE);
	}

	/*
	 * ボールの移動
	 */
	public void move() {
		x += vx;
		y += vy;

		//左右の壁にぶつかったらバウンド
		if (x < 0 || x > MainPanel.WIDTH - SIZE) {
			boundX();
		}
		//下の壁にぶつかったらアウト
		if (y < 0 ) {
			boundY();
		}
	}

	/**
	 * x方向のバウンド
	 */
	public void boundX() {
		vx = -vx;

	}

	/**
	 * y方向のバウンド
	 */
	public void boundY() {
		vy = -vy;

	}

	/**
	 * 斜めにバウンド
	 * @return
	 */
	public void boundXY() {
		vx = -vx;
		vy = -vy;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public int getVX() {
        return vx;
    }

    public int getVY() {
        return vy;
    }

    public void setVX(int v) {
        vx = v;
    }

    public void setVY(int v) {
        vy = v;
    }
	public int getSize() {
		return SIZE;
	}
}
