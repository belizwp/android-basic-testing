package cc.somkiat.basicunittesting;

import cc.somkiat.basicunittesting.exception.BaseValidationException;
import cc.somkiat.basicunittesting.exception.EmptyEmailException;
import cc.somkiat.basicunittesting.exception.NullEmailException;

public class EmailValidator {

    public void validate(String email) throws BaseValidationException {
        checkNull(email);
        checkEmpty(email);
    }

    private void checkNull(String email) throws NullEmailException {
        if (email == null) {
            throw new NullEmailException("Email is null");
        }
    }

    public void checkEmpty(String email) throws EmptyEmailException {
        if (email.trim().isEmpty()) {
            throw new EmptyEmailException("Email is empty");
        }
    }

}
