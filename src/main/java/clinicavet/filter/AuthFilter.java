package clinicavet.filter;
import jakarta.servlet.*; import jakarta.servlet.annotation.WebFilter; import jakarta.servlet.http.*; import java.io.IOException;
@WebFilter("/app/*")
public class AuthFilter implements Filter {
 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException { HttpServletRequest req=(HttpServletRequest) request; HttpServletResponse resp=(HttpServletResponse) response; HttpSession session=req.getSession(false); boolean logado=session != null && session.getAttribute("usuarioLogado") != null; if(logado){ chain.doFilter(request,response);} else { resp.sendRedirect(req.getContextPath()+"/login"); } }
}
