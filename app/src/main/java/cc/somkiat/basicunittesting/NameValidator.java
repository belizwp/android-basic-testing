package cc.somkiat.basicunittesting;

import cc.somkiat.basicunittesting.exception.BaseValidationException;
import cc.somkiat.basicunittesting.exception.EmptyNameException;
import cc.somkiat.basicunittesting.exception.NameContainsNonAlphabet;
import cc.somkiat.basicunittesting.exception.NameMixLangException;
import cc.somkiat.basicunittesting.exception.NullNameException;

public class NameValidator {

    public boolean validate(String name) throws BaseValidationException {
        isNull(name);
        isEmpty(name);
        isValidName(name);
        return true;
    }

    public void isNull(String name) throws NullNameException {
        if (name == null) {
            throw new NullNameException("Name is null");
        }
    }

    public void isEmpty(String name) throws EmptyNameException {
        if (name.trim().isEmpty()) {
            throw new EmptyNameException("Name is empty");
        }
    }

    public void isValidName(String name) throws BaseValidationException {
        String regex = "^[A-Za-z .ก-๙]+$";
        String regEng = "(?=.*[A-Za-z]).*";
        String regTha = "(?=.*[ก-๙]).*";

        boolean noAlphabet = name.matches(regex);
        boolean haveEng = name.matches(regEng);
        boolean haveTha = name.matches(regTha);

        if (!noAlphabet) {
            throw new NameContainsNonAlphabet("Name contains non alphabet character");
        } else if (haveEng && haveTha) {
            throw new NameMixLangException("Name contains mix language");
        }
    }
}
