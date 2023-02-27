package cm.cti.utilisateur.securities.jwt;

import cm.cti.utilisateur.dto.LoginDto;
import cm.cti.utilisateur.enums.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtService {
	
	public String getUsername(String token) {
		return getClaim(token, Claims::getSubject);
	}
	
	public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getClaims(token);
		return claimsResolver.apply(claims);
		
	}
	
	public boolean isTokenExpired(String token) {
		return getExpiration(token).before(new Date());
	}

	private Date getExpiration(String token) {
		return getClaim(token, Claims::getExpiration);
	}

	private Key getKey() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SecurityConstants.SECRET_KEY));
	}
	
	public Claims getClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

	public String generateToken(LoginDto user, Collection<? extends GrantedAuthority> authorities) {
		return Jwts.builder()
				.setSubject(user.getUsername())
				.setIssuer("Secy Soft")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
				.signWith(getKey(), SignatureAlgorithm.HS512)
				.claim("roles", authorities)
				.compact();
	}

	
}
