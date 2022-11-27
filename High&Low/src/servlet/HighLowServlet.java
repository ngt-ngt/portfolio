package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.JadgeLogic;
import model.NumberBeans;

/**
 * Servlet implementation class HighLowServlet
 */
@WebServlet("/HighLowServlet")
public class HighLowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Beansに入った情報をゲットしたものをセッションスコープにセットしてJspにフォワードする
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NumberBeans numberBeans = new NumberBeans();
		HttpSession session = request.getSession();
		session.setAttribute("NumberBeans", numberBeans);

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/highLow.jsp");
		disp.forward(request, response);
	}

	/**
	 * jspに入力された情報を受け取ってLogicに渡して受け取ってjspに返す
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		//入力情報を受け取る
		String userInput = request.getParameter("userInput");
		//入力値チェック　何も入力されてない時エラーメッセージ
		if (userInput != null && userInput.length() != 0) {

			//セッションスコープの用意
			HttpSession session = request.getSession();
			NumberBeans numberBeans = (NumberBeans) session.getAttribute("NumberBeans");
			//int型にキャストしてBeansにセット
			numberBeans.setUserInput(Integer.parseInt(userInput));

			//ロジックを呼び出す 参照渡し
			JadgeLogic jadgeLogic = new JadgeLogic();
			jadgeLogic.jadgeNum(numberBeans);

			//何回も入力した情報が欲しいためセッションスコープに保存
			session.setAttribute("NumberBeans", numberBeans);
		} else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "＊入力されていません");
		}

		//フォワード
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/highLow.jsp");
		disp.forward(request, response);

	}

}
