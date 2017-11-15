package cc.somkiat.basicunittesting;

import cc.somkiat.basicunittesting.exception.BaseValidationException;
import cc.somkiat.basicunittesting.exception.EmptyNameException;
import cc.somkiat.basicunittesting.exception.NameContainsNonAlphabet;
import cc.somkiat.basicunittesting.exception.NullNameException;

public class NameValidator {

    public boolean validate(String name) throws BaseValidationException {
        isNull(name);
        isEmpty(name);
        isNameContainsNonAlphabet(name);
        return true;
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

    public void isNameContainsNonAlphabet(String name) throws NameContainsNonAlphabet {
        String regex = "^[A-Za-z .ก-๙]+$";

        if (!name.matches(regex)) {
            throw new NameContainsNonAlphabet("Name contains non alphabet character");
        }
    }
}
