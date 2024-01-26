package sales;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JWTService {
    @Value("${security.jwt.expiration}")
    private String expiration;
    @Value("${security.jwt.signature-key}")
    private String signatureKey;

    public Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts.parser()
                .setSigningKey(signatureKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isValidToken(String token){
        try{
            Claims claims = getClaims(token);
            Date expirationDate = claims.getExpiration();
            LocalDateTime date = expirationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(date);
        }catch(Exception e){
            return false;
        }
    }

    public String getUserLogin (String token) throws ExpiredJwtException{
        return (String) getClaims(token).getSubject();
    }

    public String tokenGenerate(){
        long expString = Long.valueOf(expiration);
        LocalDateTime expirationDate = LocalDateTime.now().plusMinutes(expString);
        Instant instant = expirationDate.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        return Jwts.builder()
                .setSubject("123subject")
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, signatureKey)
                .compact();
    }
}
