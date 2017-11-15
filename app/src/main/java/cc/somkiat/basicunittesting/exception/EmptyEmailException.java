package cc.somkiat.basicunittesting.exception;

public class EmptyEmailException extends BaseValidationException {

    public EmptyEmailException(String message) {
        super(message);
    }
}
