package com.mycompany.monoliticareto3.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("*")
public class AutorizacionFiltro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession sesion = ((HttpServletRequest)request).getSession();
        HttpServletRequest peticion = ((HttpServletRequest)request);
        
        if((peticion.getRequestURI().contains("/login"))||(peticion.getRequestURI().contains("/ingresarUsuario.jsp"))){
            chain.doFilter(request, response);
        }else{
            if(sesion.getAttribute("AUTORIZADO") == null){
                ((HttpServletResponse)response).sendRedirect("login");
                return;
            }else{
                chain.doFilter(request, response);
            }
            
        }
 
        
    }

    @Override
    public void destroy() {
        
    }
    
}
