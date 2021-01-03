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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/MyWorkerServlet3")
public class MyWorkerServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Applicant applicant = (Applicant) request.getSession().getAttribute("SESSION_APPLICANT");
        PrintWriter pw = response.getWriter();
        MessageDao messageDao = new MessageDao();
        List<Message> mymessage = messageDao.getAllMessage();
        if(mymessage!=null){
            for(Message m :mymessage){
                if(m.getSession_Id().equals("开发部")) {
                    pw.write("<tr>");
                    pw.write("<td >" + m.getWorker_Id() + "</td>");
                    pw.write("<td >" + m.getApplicant_Id() + "</td>");
                    pw.write("<td >" + m.getWorker_Name() + "</td>");
                    pw.write("<td >" + m.getWorker_sex() + "</td>");
                    pw.write("<td >" + m.getWorker_Age() + "</td>");
                    pw.write("<td >" + m.getSession_Id() + "</td>");
                    pw.write("<td >" + m.getWorker_position() + "</td>");
                    pw.write("<td >" + m.getWorker_Site() + "</td>");
                    pw.write("</tr>");
                }
            }
            if(applicant.getApplicant_Id()==2){
                pw.write("<tr>");
                pw.write("<td id='Worker_Id'></td>");
                pw.write("<td id='Applicant_Id'></td>");
                pw.write("<td id='Worker_Name'></td>");
                pw.write("<td id='Worker_sex'></td>");
                pw.write("<td id='Worker_Age'></td>");
                pw.write("<td id='Session_Id'></td>");
                pw.write("<td id='Worker_position'></td>");
                pw.write("<td id='Worker_Site'></td>");
                pw.write("</tr>");
                pw.write("<input type ='button' value='增加信息' id='addbtn'>");
            }
        }
        else {
           pw.write("error find");
        }
        pw.flush();
        pw.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
