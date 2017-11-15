package cc.somkiat.basicunittesting.exception;

public class NameContainsNonAlphabet extends BaseValidationException {

    public NameContainsNonAlphabet(String message) {
        super(message);
    }
}
