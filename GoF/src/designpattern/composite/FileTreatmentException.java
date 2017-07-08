package designpattern.composite;

public class FileTreatmentException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = -3941010089533520220L;
    
    public FileTreatmentException() {
    }
    
    public FileTreatmentException(String msg) {
        super(msg);
    }
}
