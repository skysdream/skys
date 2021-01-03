package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener("统计在线人数")
public class LoginUserCountListener implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //session创建后会调用

        //统计信息ServletContext
        ServletContext context=se.getSession().getServletContext();
        //人数servletContext中取
        Integer count=(Integer)context.getAttribute("count");
        if(count==null){
            count=0;
        }else{
            count++;
        }
        context.setAttribute("count",count);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //session销毁会调用
        ServletContext context=se.getSession().getServletContext();
        Integer count=(Integer)context.getAttribute("count");
        count--;
        context.setAttribute("count",count);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }
}
