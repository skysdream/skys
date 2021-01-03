package servlet;

import bean.Applicant;
import dao.ApplicantDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/ApplicantRegisterServlet")
public class ApplicantRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Applicant applicant = new Applicant(0,name,email,password);
        ApplicantDao applicantDao = new ApplicantDao();
        Integer integer = applicantDao.selectCount(applicant.getApplicant_Email());
        //判断是否有相同的email
        if(integer>0){
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('申请注册的email已经被占用');");
                writer.write("window.location.href='login.html';");
                writer.write("</script>");
                writer.flush();
                writer.close();
                return;
        }
            boolean flag = applicantDao.saveApplicant(applicant);
            if(!flag){
                response.setContentType("text/html;charset=UTF-8");
                response.sendRedirect("/objectdesign/Login.html");
                return;
            }
            RequestDispatcher dis = request.getRequestDispatcher("/Register.html");
            dis.forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
