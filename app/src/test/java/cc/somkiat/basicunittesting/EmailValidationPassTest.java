package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.exception.BaseValidationException;

import static org.junit.Assert.assertTrue;

public class EmailValidationPassTest {

    private EmailValidator emailValidator = new EmailValidator();

    @Test
    public void normalEmailPatternShouldPass() throws BaseValidationException {
        String email = "belizwp@live.com";
        assertTrue(emailValidator.validate(email));
    }

    @Test
    public void emailWithoutDotAtDomainShouldPass() throws BaseValidationException {
        String email = "belizwp@localhost";
        assertTrue(emailValidator.validate(email));
    }

    @Test
    public void emailWithManyDotAtDomainShouldPass() throws BaseValidationException {
        String email = "belizwp@it.kmitl.ac.th";
        assertTrue(emailValidator.validate(email));
    }

    @Test
    public void emailNameWithDashShouldPass() throws BaseValidationException {
        String email = "belizw-adminp@live.com";
        assertTrue(emailValidator.validate(email));
    }
}
