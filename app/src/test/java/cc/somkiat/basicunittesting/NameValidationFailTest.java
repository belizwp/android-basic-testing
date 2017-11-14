package cc.somkiat.basicunittesting;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cc.somkiat.basicunittesting.exception.BaseValidationException;
import cc.somkiat.basicunittesting.exception.EmptyNameException;
import cc.somkiat.basicunittesting.exception.NullNameException;

public class NameValidationFailTest {

    private NameValidator nameValidator = new NameValidator();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowNullNameExceptionWhenNameIsNull() throws BaseValidationException {
        thrown.expect(NullNameException.class);
        thrown.expectMessage("Name is null");

        String name = null;
        nameValidator.validate(name);
    }

    @Test
    public void shouldThrowEmptyNameExceptionWhenNameIsEmpty() throws BaseValidationException {
        thrown.expect(EmptyNameException.class);
        thrown.expectMessage("Name is empty");

        String name = "";
        nameValidator.validate(name);
    }

}
