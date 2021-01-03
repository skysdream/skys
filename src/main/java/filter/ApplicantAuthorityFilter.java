package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
            urlPatterns = { "*.jsp","*.html"},
            initParams = {@WebInitParam(name = "loginPage", value = "login.html")}
        )
public class ApplicantAuthorityFilter implements Filter {
    private String loginPage = "login.html";
    @Override
    public void destroy() {

    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //业务逻辑
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String requestPath = request.getRequestURI();
        // 判断被拦截的请求用户是否处于登录状态
        if (session.getAttribute("SESSION_APPLICANT") != null ||requestPath.contains("Register.html") ||requestPath.contains("login.html")||
            requestPath.contains("CommandLogin.jsp")||requestPath.contains("index.html")||requestPath.contains("ApplicantRegisterServlet")
            ||requestPath.contains("ApplicantLoginServlet") ||requestPath.contains("Head.html")||requestPath.contains("buttom.html")) {
            // 获取被拦截的请求地址及参数
            chain.doFilter(req, resp);
        } else {
            //将当前拦截的请求放行，让请求继续访问他要访问的资源
            response.sendRedirect("login.html");
        }
        return;
    }
    @Override
    public void init(FilterConfig config) throws ServletException {
        // 获取当请求被拦截时转向的页面
        loginPage = config.getInitParameter("loginPage");
        if (null == loginPage) {
            loginPage = "login.html";
        }
    }
}
