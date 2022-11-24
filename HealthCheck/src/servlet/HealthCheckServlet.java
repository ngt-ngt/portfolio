package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HealthBeans;
import model.HealthCheckLogic;

/**
 * Servlet implementation class HealthCheckServlet
 */
@WebServlet("/HealthCheckServlet")
public class HealthCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

/**
 * 今回はサーブレット実行時にまずdoGetが動いてhealthCheck.jspを動かす
 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/healthCheck.jsp");
				disp.forward(request, response);
	}

	/**
	 * 入力された情報を受け取って渡す
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラで入力情報取得
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");

		//入力値をDouble型にキャストしてBeansへセット
		HealthBeans healthBeans = new HealthBeans();
		healthBeans.setHeight(Double.parseDouble(height));
		healthBeans.setWeight(Double.parseDouble(weight));

		//ロジックの呼び出し 引数にインスタンスを入れて参照渡ししている
		HealthCheckLogic healthCheckLogic = new HealthCheckLogic();
		healthCheckLogic.healthCheck(healthBeans);


		//リクエストスコープに保存
		request.setAttribute("healthBeans", healthBeans);

		//フォワード
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/healthCheckResult.jsp");
		disp.forward(request, response);
	}

}
