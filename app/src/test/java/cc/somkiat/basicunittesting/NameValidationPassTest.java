package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.exception.BaseValidationException;

import static org.junit.Assert.assertTrue;

public class NameValidationPassTest {

    private NameValidator nameValidator = new NameValidator();

    @Test
    public void singleLowerCaseNameShouldPass() throws BaseValidationException {
        String name = "b";
        assertTrue("", nameValidator.validate(name));
    }

}