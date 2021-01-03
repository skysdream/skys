package servlet;

import bean.Applicant;
import bean.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/CreateMyCardServlet")
public class CreateMyCardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Applicant applicant = (Applicant) request.getSession().getAttribute("SESSION_APPLICANT");
        Message message = (Message)request.getSession().getAttribute("SESSION_MESSAGE");
        request.setAttribute("applicantInfo",applicant);
        request.setAttribute("messageInfo", message);
        request.getRequestDispatcher("/MyCard.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
