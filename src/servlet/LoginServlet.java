package servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if (beanCursoJsp.validarLoginSenha(login, senha)) {/* Validou corretamente, acessa a pagian liberada */ 
			
			RequestDispatcher dispachet = request.getRequestDispatcher("acessoliberado.jsp");
			dispachet.forward(request, response);
			
		}else {//caso a senha ou login errado sera redirecionado para pagina de acesso NEGADO	
			
			RequestDispatcher dispachet = request.getRequestDispatcher("acessonegado.jsp");
			dispachet.forward(request, response);
			
			
		}
		
		
	}	
	
	

}
