package cc.somkiat.basicunittesting;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cc.somkiat.basicunittesting.exception.BaseValidationException;
import cc.somkiat.basicunittesting.exception.EmptyEmailException;
import cc.somkiat.basicunittesting.exception.InvalidEmailException;
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

    @Test
    public void shouldThrowEmptyEmailExceptionWhenEmailIsEmpty() throws BaseValidationException {
        thrown.expect(EmptyEmailException.class);
        thrown.expectMessage("Email is empty");

        String email = "";
        emailValidator.validate(email);
    }

    @Test
    public void shouldThrowInvalidEmailExceptionWhenEmailIsWord() throws BaseValidationException {
        thrown.expect(InvalidEmailException.class);
        thrown.expectMessage("Email is invalid");

        String email = "Belize";
        emailValidator.validate(email);
    }
}
