package servlet;

import bean.Applicant;
import bean.Message;
import dao.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/MyMessageServlet")
public class MyMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String worker_id =request.getParameter("workname");
        Integer worker_id1 = 0;
        if(worker_id==null){
           worker_id1 = 1;
        }
        else{
            worker_id1 = Integer.parseInt(worker_id);
        }
        //创建数据库处理对象
        MessageDao messageDao = new MessageDao();
        //获取后端的用户信息
        Message message=messageDao.getResumeBasicInfoById(worker_id1);
        //获取session中保存的用户
        Applicant applicant = (Applicant) request.getSession().getAttribute("SESSION_APPLICANT");
        //将该用户的id与后端的详细信息绑定
        message.setApplicant_Id(applicant.getApplicant_Id());
        //将修改后的信息发送至数据库
        boolean flag = messageDao.updateMessage(message);
        //将获去到的message信息存入session
        request.getSession().setAttribute("SESSION_MESSAGE",message);
        //账号放入请求作用域，在简历展示页面显示该对象信息
        request.setAttribute("applicantInfo",applicant);
        //简历放入请求作用域，在简历展示页面显示该对象信息
        request.setAttribute("messageInfo", message);
        //请求转发到简历展示页面
        request.getRequestDispatcher("/MyMessage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
