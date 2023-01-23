package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GootsDAO;
import dto.Account;
import dto.Product;

/**
 * Servlet implementation class GootsAll
 */
@WebServlet("/GootsAll")
public class GootsAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GootsAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//処理の始めにログイン状態のチェックを行う。
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("user");

		if(account == null){
			//セッションの中身がnullであれば不正アクセスと判断し
			//ログイン画面へ戻る
			String view = ".//";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		
	List<Product> gootsList = GootsDAO.selectAllGoots();
		
		request.setAttribute("list", gootsList);

		
		// 正常な画面を表示
		String view = "WEB-INF/view/gootsall.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	

	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
