package servlet;

import bean.Applicant;
import bean.Message;
import dao.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = "/ChangePictureServlet")
@MultipartConfig
public class ChangePictureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取文件名
        Part part = request.getPart("headshot");
        String fileName = part.getSubmittedFileName();
        String dir = this.getServletContext().getRealPath("/images");
        //判断 目录是否存在
        File imgDir = new File(dir);
        if (!imgDir.exists()) {
            imgDir.mkdirs();
        }
        //上传到服务器文件路径  imgDir+'/'+fileName
        part.write(dir + "/" +fileName);
        //将文件名保存到简历基本信息表，就是更新简历主键为1的记录的头像
        MessageDao resumeDAO=new MessageDao();
        //从Session中取出简历ID
        Message message=(Message) request.getSession().getAttribute("SESSION_MESSAGE");
        Integer resumeID = message.getWorker_Id();
        resumeDAO.updateHeadShot(resumeID,fileName);
        //根据简历id，查询简历对象,并将跟新后的表数据存入message；
        message  = resumeDAO.getResumeBasicInfoById(resumeID);

        Applicant applicant = (Applicant) request.getSession().getAttribute("SESSION_APPLICANT");
        //将更新后的message数据存入session中
        request.getSession().setAttribute("SESSION_MESSAGE",message);
        //保存到session并转发
        request.setAttribute("applicantInfo",applicant);
        //保存到session并转发
        request.setAttribute("messageInfo",message);
        //请求转发
       request.getRequestDispatcher("/MyMessage.jsp").forward(request,response);
//        response.sendRedirect("MyMessage.jsp");
        //response.sendRedirect("/offers/applicant/resume.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
