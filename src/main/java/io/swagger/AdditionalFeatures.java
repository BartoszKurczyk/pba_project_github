package io.swagger;

import io.swagger.exceptions.BadPasswordExcepiton;
import io.swagger.exceptions.BadUsernameException;
import io.swagger.exceptions.HMACIntegrityException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AdditionalFeatures {

    private final String userBasicAuth = "admin";

    private final String userBasicPasswd = "123456";

    byte[] secretKey = "123456".getBytes();

    public void BasicAuth(String token) {
        String tokenAfterReplace = token.replace("Basic ", "");

        byte[] decoded = Base64.getDecoder().decode(tokenAfterReplace);
        String decodedString = new String(decoded, StandardCharsets.UTF_8);
        String[] credentials = decodedString.split(":");

        if(!credentials[0].equals(userBasicAuth)) throw new BadUsernameException("Wrong username");
        if(!credentials[1].equals(userBasicPasswd)) throw  new BadPasswordExcepiton("Wrong password");
    }

    public void hmacCheck(String body, String hmacSignature) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] hmacSha256 = null;
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "HmacSHA256");
        mac.init(secretKeySpec);
        hmacSha256 = mac.doFinal(body.getBytes());
        String hmacSha256Hex = String.format("%032x", new BigInteger(1, hmacSha256));
        if (!hmacSignature.equals(hmacSha256Hex))
        {
            throw new HMACIntegrityException("Body of request has been changed");
        }
    }

}
