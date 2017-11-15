package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.exception.BaseValidationException;

import static org.junit.Assert.assertTrue;

public class NameValidationPassTest {

    private NameValidator nameValidator = new NameValidator();

    @Test
    public void singleLowerCaseNameShouldPass() throws BaseValidationException {
        String name = "b";
        assertTrue(nameValidator.validate(name));
    }

    @Test
    public void shortLowerCaseNameShouldPass() throws BaseValidationException {
        String name = "bell";
        assertTrue(nameValidator.validate(name));
    }

    @Test
    public void singleUpperCaseNameShouldPass() throws BaseValidationException {
        String name = "B";
        assertTrue(nameValidator.validate(name));
    }

    @Test
    public void shortUpperCaseNameShouldPass() throws BaseValidationException {
        String name = "BELL";
        assertTrue(nameValidator.validate(name));
    }

    @Test
    public void shortUpperAndLowerCaseNameShouldPass() throws BaseValidationException {
        String name = "Belizwp";
        assertTrue(nameValidator.validate(name));
    }

    @Test
    public void fullNameShouldPass() throws BaseValidationException {
        String name = "Nakarin Kakanumporn";
        assertTrue(nameValidator.validate(name));
    }

    @Test
    public void fullNameWithTitleShouldPass() throws BaseValidationException {
        String name = "Mr. Nakarin Kakanumporn";
        assertTrue(nameValidator.validate(name));
    }
}
