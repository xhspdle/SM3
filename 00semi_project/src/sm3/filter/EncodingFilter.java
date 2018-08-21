package sm3.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	String encoding=null;
	@Override
	public void destroy() {}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(encoding!=null) {
			request.setCharacterEncoding(encoding);
		}
		chain.doFilter(request, response);
	}
	@Override
	public void init(FilterConfig fc) throws ServletException {
		encoding=fc.getInitParameter("encoding");
	}
}
