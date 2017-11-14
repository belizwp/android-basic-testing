package cc.somkiat.basicunittesting;

import cc.somkiat.basicunittesting.exception.BaseValidationException;
import cc.somkiat.basicunittesting.exception.EmptyNameException;
import cc.somkiat.basicunittesting.exception.NullNameException;

public class NameValidator {

    public void validate(String name) throws BaseValidationException {
        isNull(name);
        isEmpty(name);
    }

    public void isNull(String name) throws NullNameException {
        if (name == null) {
            throw new NullNameException("Name is null");
        }
    }

    public void isEmpty(String name) throws EmptyNameException {
        if (name.isEmpty()) {
            throw new EmptyNameException("Name is empty");
        }
    }
}
