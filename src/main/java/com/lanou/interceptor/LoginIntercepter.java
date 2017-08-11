package com.lanou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercepter implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url=request.getRequestURI();
		System.out.println(url);
		if(url.indexOf("login")>0){
			
			return true;
			
		}
		
		
		
		
		// �����󷢹�����ʱ������ȷ����û��username
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("usename");
		/* ��name����ֵ������ͨ���� */
		if (name != null && !name.equals("")) {
			return true;
		}
		/* ���û�У���ת����¼ҳ�� */
		else {

			request.getRequestDispatcher("/WEB-INF/pages/one.jsp").forward(request, response);
			return false;
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
