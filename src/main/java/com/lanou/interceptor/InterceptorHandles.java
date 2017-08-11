package com.lanou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorHandles extends HandlerInterceptorAdapter {

	//适配器：为了防止接口不兼容
		//适配器主动实现了接口的方法
		//在使用中，继承适配器的子类使用
		//子类可以决定重写那些方法，而不是全部实现
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//在请求发来时还未执行，就开始执行了
		//返回值：true表示继续流程（如调用下一个拦截器或处理器）；
        //false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
		
		System.out.println("interceptor1------------perhandle");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//处理请求之后
		//后处理回调方法，实现处理器的后处理（但在渲染视图之前），
		//此时我们可以通过modelAndView（模型和视图对象）对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
		
		System.out.println("interceptor2------------perhandle");
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
		//请求处理完成
		/*整个请求处理完毕回调方法，即在视图渲染完毕时回调，如性能监控中我们可以在此记录结束时间并输出消耗时间，还可以进行一些资源清理，
		类似于try-catch-finally中的finally，
		但仅调用处理器执行链中preHandle返回true的拦截器的afterCompletion。*/
		System.out.println("interceptor3------------perhandle");
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	
}
