package filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import conection.SingleConnection;

@WebFilter(urlPatterns = {"/*"}) // toda requisi�ao e resposta vai passar por este filtro
public class Filter implements javax.servlet.Filter{

	private static Connection connection;
	
	
	@Override
	public void destroy() {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			
		try {
			chain.doFilter(request, response);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
		
		
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		connection= SingleConnection.getConnection();
		System.out.println("Nao deu certo olhar");
	}

}