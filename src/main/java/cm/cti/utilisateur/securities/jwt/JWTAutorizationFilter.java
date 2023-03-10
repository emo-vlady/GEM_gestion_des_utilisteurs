package cm.cti.utilisateur.securities.jwt;

import static cm.connect.technology.lotostudio.customers.util.FormUtilitaire.getKeyToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import cm.connect.technology.lotostudio.customers.enums.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAutorizationFilter extends OncePerRequestFilter{
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		response.setHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials,authorization");
		if(request.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
		}else {
			try {
				String jwt = request.getHeader(SecurityConstants.HEADER_STRING);
				if(jwt==null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)) {
					chain.doFilter(request, response);
					return;
				}
				
				Claims claims = Jwts
						.parserBuilder()
						.setSigningKey(getKeyToken())
						.build()
						.parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIX, ""))
						.getBody();
				
				String username = claims.getSubject();
				@SuppressWarnings("unchecked")
				ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>)claims.get("roles");
				Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				roles.forEach(r->{
					authorities.add(new SimpleGrantedAuthority(r.get("authority")));
				});
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null , authorities);
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				chain.doFilter(request, response);
			}catch (ExpiredJwtException e) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}
	}

}

