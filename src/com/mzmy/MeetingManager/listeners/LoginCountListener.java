package com.mzmy.MeetingManager.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mzmy.MeetingManager.model.dao.impldao.ImplLoginCountDao;

/**
 * Application Lifecycle Listener implementation class LoginCountListener
 *
 */
public class LoginCountListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public LoginCountListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         //数据库获取数据
    	int count=new ImplLoginCountDao().selLoginCount();
    	//获得上下文对象
    	ServletContext ctx=arg0.getServletContext();
    	//设置属性
    	ctx.setAttribute("count", count+"");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // 获得上下文对象
    	ServletContext ctx=arg0.getServletContext();
    	//获取上下文中的数据
    	String str=(String)ctx.getAttribute("count");
    	//判断
    	if(str!=null&&str!=""){
    		int count=Integer.parseInt(str);
    		//将数据更新到数据库
    		new ImplLoginCountDao().updLoginCount(count);
    	}
    }
	
}
