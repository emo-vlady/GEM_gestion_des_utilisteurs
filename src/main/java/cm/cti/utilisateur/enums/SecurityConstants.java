package cm.cti.utilisateur.enums;

public class SecurityConstants {
    public static final String SECRET_KEY						= "7134743677397A24432646294A404E635266556A586E327235753878214125442A472D4B6150645367566B597033733676397924423F4528482B4D6251655468";
    public static final long EXPIRATION_TIME					= 36_000_000; // 1 hour
    public static final long EXPIRATION_HOUR					= 1_800_000; // 1/2 days
    public static final long TIME_DAY							= 86_400_000; // 1 days
    public static final String TOKEN_PREFIX						= "Bearer";
    public static final String HEADER_STRING					= "Authorization";
    public static final String TOKEN_ALGORITHME					= "HS512";
}
