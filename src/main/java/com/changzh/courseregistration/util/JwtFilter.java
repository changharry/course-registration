package com.changzh.courseregistration.util;

import com.auth0.jwt.interfaces.Claim;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@WebFilter(filterName = "JwtFilter", urlPatterns = "/api/*")
public class JwtFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        response.setCharacterEncoding("UTF-8");
        final String token = request.getHeader("authorization");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);
        }
        else {

            if (token == null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token Not Found!");
                return;
            }

            Map<String, Claim> userData = JwtUtil.verifyToken(token);
            if (userData == null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Illegal Token!");
                return;
            }
            Integer student_id = userData.get("student_id").asInt();
            String password= userData.get("password").asString();
            request.setAttribute("student_id", student_id);
            request.setAttribute("password", password);
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
    }
}