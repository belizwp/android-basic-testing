package cc.somkiat.basicunittesting;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cc.somkiat.basicunittesting.exception.BaseValidationException;
import cc.somkiat.basicunittesting.exception.NullEmailException;

public class EmailValidationFailTest {

    private EmailValidator emailValidator = new EmailValidator();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowNullEmailExceptionWhenEmailIsNull() throws BaseValidationException {
        thrown.expect(NullEmailException.class);
        thrown.expectMessage("Email is null");

        String email = null;
        emailValidator.validate(email);
    }

}
