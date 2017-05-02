package br.com.fiap.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controler)throws Exception {
	
		String uri = request.getRequestURI();
		if (uri.endsWith("loginForm") ||
			uri.endsWith("login") ||
			uri.contains("resources")){
			return true;
		}	
		
		if(request.getSession().getAttribute("usuarioLogado") != null){
			return true;
		}else{
			response.sendRedirect("/ModeloSpring/loginForm");
			return false;
		}
	}
}
