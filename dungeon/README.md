# ゲーム説明

1.迷路は、10x10のchar型2次元配列


2.迷路には、壁、通路、出口、ワームホールの４種類の値がある。

  それぞれ以下で表される。
  
   壁='#'   
   通路='・'  
   出口='＠'   
   ワームホール='ロ' 
   
   
3.迷路のマップは、３種類からランダムに選ばれる。
     
     
4.プレイヤー座標の初期値は乱数によって決定する。
  もし座標が通路以外であった場合、再度座標を乱数で決定する。
  
  
5.プレイヤーの現在座標と上下左右が壁か通路か表示する。


6.出口とワームホールは通路として見える。


７.入力方向が壁の場合、もう一度移動方向を訪ねる。


8.移動先がワームホールの場合、プレイヤーの座標を乱数によって決定する。
  新しい座標が通路以外であった場合、再度座標を乱数で決定する。
  
  
9.移動先が出口の場合、終了。

*隠しコマンドがあるので見つけてみてください

# 【プレイ画面】
![スクリーンショット 2022-11-29 8 29 41](https://user-images.githubusercontent.com/112692236/204402526-b4b4b08d-2890-48cf-8d23-528d4092a6ab.png)


# メモ
・サイトを参考にアレンジして作成しました。

・二次元配列と、オブジェクト指向のクラスに分けたメソッドの呼び出しなどを学んだ。

