package com.lanou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorHandles extends HandlerInterceptorAdapter {

	//��������Ϊ�˷�ֹ�ӿڲ�����
		//����������ʵ���˽ӿڵķ���
		//��ʹ���У��̳�������������ʹ��
		//������Ծ�����д��Щ������������ȫ��ʵ��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//��������ʱ��δִ�У��Ϳ�ʼִ����
		//����ֵ��true��ʾ�������̣��������һ������������������
        //false��ʾ�����жϣ����¼���ʧ�ܣ������������������������������������ʱ������Ҫͨ��response��������Ӧ��
		
		System.out.println("interceptor1------------perhandle");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//��������֮��
		//����ص�������ʵ�ִ������ĺ���������Ⱦ��ͼ֮ǰ����
		//��ʱ���ǿ���ͨ��modelAndView��ģ�ͺ���ͼ���󣩶�ģ�����ݽ��д�������ͼ���д���modelAndViewҲ����Ϊnull��
		
		System.out.println("interceptor2------------perhandle");
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
		//���������
		/*������������ϻص�������������ͼ��Ⱦ���ʱ�ص��������ܼ�������ǿ����ڴ˼�¼����ʱ�䲢�������ʱ�䣬�����Խ���һЩ��Դ����
		������try-catch-finally�е�finally��
		�������ô�����ִ������preHandle����true����������afterCompletion��*/
		System.out.println("interceptor3------------perhandle");
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	
}
