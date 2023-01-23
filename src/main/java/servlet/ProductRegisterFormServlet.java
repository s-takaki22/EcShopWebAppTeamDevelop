package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;
import dto.Product;

/**
 * Servlet implementation class ProductRegisterFormServlet
 */
@WebServlet("/ProductRegisterFormServlet")
public class ProductRegisterFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductRegisterFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("user");
		if(account == null){
			String view = "./";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String category=request.getParameter("category");
		int price =Integer.parseInt( request.getParameter("price"));
		String content=request.getParameter("content");
		int stock = Integer.parseInt( request.getParameter("stock"));
		Product pr=new Product(-1, name, category, price, content, stock);
		session.setAttribute("input-product", pr);
		String view="WEB-INF/view/product-register-confirm.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
