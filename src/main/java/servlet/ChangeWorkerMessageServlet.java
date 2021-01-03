package servlet;

import bean.Message;
import dao.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/ChangeWorkerMessageServlet")
public class ChangeWorkerMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Message message = new Message();
        message.setWorker_Name(request.getParameter("user1_name"));
        message.setWorker_sex(request.getParameter("user1_sex"));
        message.setWorker_Age(request.getParameter("user1_age"));
        message.setSession_Id(request.getParameter("user1_sessid"));
        message.setWorker_position(request.getParameter("user1_position"));
        message.setWorker_Site(request.getParameter("user1_site"));
        //创建message数据库操作对象
        MessageDao messageDao = new MessageDao();
        boolean flag=messageDao.saveSingerMessage(message);
        PrintWriter pw = response.getWriter();
        if(flag){
            pw.write("数据修改成功");
        }else{
            pw.write("数据修改失败");
        }
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
