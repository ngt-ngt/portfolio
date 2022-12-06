package model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 入力と答えの情報を持つBeans
 * @author nagatayoshio
 *
 */
public class CalcBeans implements Serializable {
	private String num1;
	private String num2;
	private BigDecimal ans;
	private String calc; //演算子用

	public CalcBeans() {

	}
	public String getCalc() {
		return calc;
	}

	public void setCalc(String calc) {
		this.calc = calc;
	}

	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public BigDecimal getAns() {
		return ans;
	}

	public void setAns(BigDecimal result2) {
		this.ans = result2;
	}

}
