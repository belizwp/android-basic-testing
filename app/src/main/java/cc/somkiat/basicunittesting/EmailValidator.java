package cc.somkiat.basicunittesting;

import cc.somkiat.basicunittesting.exception.BaseValidationException;
import cc.somkiat.basicunittesting.exception.EmptyEmailException;
import cc.somkiat.basicunittesting.exception.InvalidEmailException;
import cc.somkiat.basicunittesting.exception.NullEmailException;

public class EmailValidator {

    public void validate(String email) throws BaseValidationException {
        checkNull(email);
        checkEmpty(email);
        checkValidEmail(email);
    }

    private void checkNull(String email) throws NullEmailException {
        if (email == null) {
            throw new NullEmailException("Email is null");
        }
    }

    private void checkEmpty(String email) throws EmptyEmailException {
        if (email.trim().isEmpty()) {
            throw new EmptyEmailException("Email is empty");
        }
    }

    private void checkValidEmail(String email) throws InvalidEmailException {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]";

        if (!email.matches(regex)) {
            throw new InvalidEmailException("Email is invalid");
        }
    }
}
