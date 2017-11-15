package cc.somkiat.basicunittesting.exception;

public class InvalidEmailException extends BaseValidationException {

    public InvalidEmailException(String message) {
        super(message);
    }
}
