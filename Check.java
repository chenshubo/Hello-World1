package cn.lvb.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 import aParking.web.servlet.client.JdbcUtil;

 import   java.sql.* ;
 import java.util.*  ;
import cn.lvb.bean.*  ;
import cn.lvb.dao.*   ;
 import cn.lvb.dao.impl.*;

/**
 * Servlet implementation class Check
 */
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
 		String username=request.getParameter("username");
 		String password=request.getParameter("password");
 		UserDAO dao = new  UserDAOImpl();	
 		
 		
 		User user = dao.login2(username, password);
 		
 		
 		if(user.getJud().equals("admin")){
 			
 			request.getSession().setAttribute("number",username);  
	 			//request.getRequestDispatcher("client/AdminMain.jsp").forward(request, response);
	 			
	 			response.setHeader("Refresh", "0;URL="+request.getContextPath()+"/client/AdminMain.jsp");

	 		
 		}
 		else  	if(user.getJud().equals("user")){
 			
 			request.getSession().setAttribute("user",username);  
 			response.setHeader("Refresh", "0;URL="+request.getContextPath()+"/client/userMain.jsp");

 		}
 		else  {
 			 response.getWriter().write("µÇÂ¼Ê§°Ü");
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
