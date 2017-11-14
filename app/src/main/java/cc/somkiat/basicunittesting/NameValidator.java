package cc.somkiat.basicunittesting;

import cc.somkiat.basicunittesting.exception.BaseValidationException;
import cc.somkiat.basicunittesting.exception.NullNameException;

public class NameValidator {

    public boolean validate(String name) throws BaseValidationException {
        return !isNull(name);
    }

    public boolean isNull(String name) throws NullNameException {
        if (name == null) {
            throw new NullNameException("Name is null");
        }
        return true;
    }
}
