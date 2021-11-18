package filtros;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.io.IOException;
import java.security.Key;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;



@WebFilter("/*")
public class Autorizacion implements Filter {
    
    public static final Key LLAVE = MacProvider.generateKey();
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        //System.out.println("Llave"+LLAVE);
        HttpServletRequest servletRequest = (HttpServletRequest)request;
        String url = servletRequest.getRequestURI();
        if(url.contains("/usuarios/login")){
            chain.doFilter(request, response); 
        }else{
            String hash = servletRequest.getHeader("Authorization");
            
            if(hash==null || hash.trim().equals("")){
                //error 1
                response.setContentType("application/json");
                String respuesta = "{\"autorizacion\": \"no\"}";
                response.getWriter().write(respuesta);
                return;
            }
            
            //recordar que el token(hash) tiene el prefijo "Bearer "
            hash = hash.substring(7,(hash.length()));
            try{
                Jws<Claims> claims = Jwts.parser().setSigningKey(LLAVE).parseClaimsJws(hash); 
                chain.doFilter(request, response); 
            }catch(MalformedJwtException e){
                response.setContentType("application/json");
                String respuesta = "{\"autorizacion\": \"no_valido\"}";
                response.getWriter().write(respuesta);
                return;
            }catch(SignatureException e){
                response.setContentType("application/json");
                String respuesta = "{\"autorizacion\": \"no_valido\"}";
                response.getWriter().write(respuesta);
                return;
            }catch(ExpiredJwtException e){
                response.setContentType("application/json");
                String respuesta = "{\"autorizacion\": \"no_tiempo\"}";
                response.getWriter().write(respuesta);
                return;
            }catch(Exception e){
                response.setContentType("application/json");
                String respuesta = "{\"autorizacion\": \"no_valido\"}";
                response.getWriter().write(respuesta);
                return;
            }
            
                    
            

        }
    }

    @Override
    public void destroy() {
        
    }
    
}
