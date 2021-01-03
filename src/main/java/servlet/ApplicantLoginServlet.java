package servlet;

import bean.Applicant;
import dao.ApplicantDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ApplicantLoginServlet")
public class ApplicantLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ApplicantDao applicantDAO=new ApplicantDao();
        Applicant applicant = applicantDAO.getApplicantByEmailAndPass(email,password);
        if(applicant!=null){
            request.getSession().setAttribute("SESSION_APPLICANT",applicant);
            response.sendRedirect("/objectdesign/MyMessageServlet");
        }else{
            response.sendRedirect("/objectdesign/login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
