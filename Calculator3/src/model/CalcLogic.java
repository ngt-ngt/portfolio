package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcLogic {

	public BigDecimal excute(CalcBeans calcBeans) {
		//newするやり方だと入力値がもらえなかった　引数でBeansもらわないといけない
		//		CalcBeans calcBeans = new CalcBeans();
		String num1 = calcBeans.getNum1();
		String num2 = calcBeans.getNum2();

		//BigDecimalを使って計算すると小数点も正確に計算出来る
		BigDecimal bd1 = new BigDecimal(num1);
		BigDecimal bd2 = new BigDecimal(num2);

		//    	System.out.println(bd1 + ":" + bd2); //テスト用

		switch (calcBeans.getCalc()) {

		case "+":
			BigDecimal result2 = bd1.add(bd2);
			calcBeans.setAns(result2);
			break;
		case "-":
			result2 = bd1.subtract(bd2);
			calcBeans.setAns(result2);
			break;
		case "×":
			result2 = bd1.multiply(bd2);
			calcBeans.setAns(result2);
			break;
		case "÷":
			result2 = bd1.divide(bd2, 20, RoundingMode.HALF_UP);	//小数点20桁まで表示
			calcBeans.setAns(result2);
			break;
		}
		return calcBeans.getAns();

	}

}
