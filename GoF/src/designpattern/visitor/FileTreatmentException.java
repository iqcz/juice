package designpattern.visitor;

public class FileTreatmentException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 6111491741599267144L;
    public FileTreatmentException() {
    }
    public FileTreatmentException(String msg) {
        super(msg);
    }
}
