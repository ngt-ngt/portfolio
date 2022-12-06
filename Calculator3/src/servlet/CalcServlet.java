package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CalcBeans;
import model.CalcLogic;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CalcBeans calcBeans = new CalcBeans();
		request.setAttribute("calcBeans", calcBeans);
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/calc.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//文字化け
		String num1 = request.getParameter("number1");
		String calc = request.getParameter("calc"); //プルダウンの演算子受け取り
		String num2 = request.getParameter("number2");
		if (num1.length() != 0 || num2.length() != 0) {

			CalcBeans calcBeans = new CalcBeans();
			calcBeans.setNum1(num1);
			calcBeans.setNum2(num2);
			calcBeans.setCalc(calc);

			CalcLogic calcLogic = new CalcLogic();
			calcLogic.excute(calcBeans); //メソッドにBeansを渡す

			request.setAttribute("calcBeans", calcBeans);
		} else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "＊入力されていません");
		}
		//フォワード
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/calc.jsp");
		disp.forward(request, response);

	}

}
