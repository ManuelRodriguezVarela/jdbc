package gal.san.clemente.tarefa3_acceso_datos.exception;

public class ModelException extends Exception {

    public ModelException(String message) {
        super(message);
    }

    public ModelException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelException(Throwable cause) {
        super(cause);
    }
    
}
