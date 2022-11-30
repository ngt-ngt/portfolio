package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.KujiBeans;

/**
 * Servlet implementation class OmikujiServlet
 */
@WebServlet("/OmikujiServlet")
public class OmikujiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 実行されるとdoGetが動いてBeansとLogicを使って値をセットしてJSPにフォワードする
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Beansをインスタンス化
		KujiBeans kujiBeans = new KujiBeans();
		//Logicを呼び出す
		RandomNumLogic rndNumLogic = new RandomNumLogic();
		int kujiNum = rndNumLogic.execute(kujiBeans);
		//returnされた値をBeansにセット
		kujiBeans.setKujiNum(kujiNum);

		//リクエストスコープに保存
		request.setAttribute("kujiBeans", kujiBeans);
		//				System.out.println(kujiNum);//テスト用

		//フォワード
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/kujiResult.jsp");
		disp.forward(request, response);
	}

	/**
	 * 今回post使ってません
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
