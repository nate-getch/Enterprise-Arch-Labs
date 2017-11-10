package cs544.exercise16_2.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cs544.exercise16_2.dao.HibernateUtil;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO implement actual session in view filter code
		try {
			Transaction tx = sf.getCurrentSession().beginTransaction();
			// pass the request along the filter chain
			System.out.println("receiving request");
			chain.doFilter(request, response);
			tx.commit();
			System.out.println("sending response");
		}
		catch(RuntimeException e) {
			System.out.println("Rollback " + e);
		}

	}

	public void destroy() {
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
