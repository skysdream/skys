package servlet;

import bean.Applicant;
import dao.ApplicantDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/EmailValidateServlet")
public class EmailValidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取页面邮箱数据
        String email = request.getParameter("email");
        //根据获取的邮箱值从后台获取该用户
        ApplicantDao applicantDao = new ApplicantDao();
        Applicant applicant = applicantDao.getApplicantByEmail(email);
        //创建输出流打印在页面
        PrintWriter pw = response.getWriter();
        //判断该用户的合法性
        if(applicant!=null) {
            if(applicant.getApplicant_Id()==2){
                pw.write("user right");
            }else{
                pw.write("user error");
            }
        }else{
            pw.write("user not exist");
        }
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
