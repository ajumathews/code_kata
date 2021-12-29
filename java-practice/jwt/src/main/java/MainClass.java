import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class MainClass {

    public static void main(String[] args) {

        String jwt = createJWT("123","export","exportSubject",2121213);

        Claims claims = decodeJWT(jwt);
        System.out.println(claims);

    }

    public static Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary("hellossdsdsdsdsddsdsssssssssssssssssssssssssssssssssssasa"))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    public static String createJWT(String id, String issuer, String subject, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        System.out.println(signatureAlgorithm.getJcaName());

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("rZdgs68QJuHZsg4sq_B8Oz-76RiNgsv8zsphNg10af2HTYdZvod3MEK2jQc8DRQO4HHkqRd0SkgxeneL_dGWtI1gyWqtIa-wx0eQuc2ITAR_E1pLWI_FCP_BIZ2zsNugu3hss2jWZYX2DCk8286Dd8b1-fm5fEEdN50ZtTTZVxLklG_g4ky6O4AtE3MTW9b96e_VdL7_D-hBpK6Rgzr3AikM3I_gH7ngstRNT8e5vOLSYdsZN2mI6aSRifz7Fr6p20RLjt9S-74uxamOSMGdX8NbmWqLaN2nqK7O2p4Isv08QQ3SWIYP-6iLh6ZvU5KzwpJcOwEAeL82xhf8H-gRfw");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }
}
