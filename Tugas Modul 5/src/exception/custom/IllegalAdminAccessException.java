package exception.custom;

public class IllegalAdminAccessException extends Exception {
    public IllegalAdminAccessException(String message) {
        super(message);
    }
}
//pengecualian untuk memeriksa atau menunjukkan bahwa ada upaya akses yang tidak valid