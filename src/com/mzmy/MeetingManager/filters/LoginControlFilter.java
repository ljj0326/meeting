package com.mzmy.MeetingManager.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mzmy.MeetingManager.model.vo.EmpVo;

/**
 * 只有登陆才能访问某些页面
 * 
 * Servlet Filter implementation class LoginControlFilter
 */
public class LoginControlFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginControlFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		//获取请求对象
		HttpServletRequest request=(HttpServletRequest)req;
		//使用请求对象获得绘画对象
		HttpSession session=request.getSession();
		//获得session中的属性
		EmpVo ev=(EmpVo)session.getAttribute("ev");
		//判断
		if(ev==null){
			//带数据
			request.setAttribute("msg","请登录以后访问！！！");
			//请求转发
			request.getRequestDispatcher("../login.jsp").forward(request, res);
		}
		
		chain.doFilter(request, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
