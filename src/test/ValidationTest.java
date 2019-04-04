package test;

import main.Validation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/*
Create a validate method which returns a List<String> of errors and accepts a vargs array of Strings -
signature will be public List<String> validate(String... values) .  Write a unit test which returns an empty list.

Using TDD Pass a single String with decimal value 1.111 in to the validate method.
Assert that a List<String> of size 1 is returned containing the message 'Too many decimal places for value 1.111.'

Using TDD Pass a two Strings with three decimal places with values 1.111, 2.222 in to the validate method.
Assert that a List<String> of size 2 is returned containing the messages
'Too many decimal places for value 1.111.',
'Too many decimal places for value 2.222.'

AC: Pass an instance of the Validator class in to the Calculator constructor so that the Add, Subtract, Multiply
and Divide methods can use it to validate their values rather than use the duplicate code we currently have.

 */

public class ValidationTest {
    private Validation validation;

    @Before
    public void setUp() {
        validation = new Validation();
    }


    @Test
    public void shouldReturnValidationClass() {
        Assert.assertNotNull(validation);
    }

    @Test
    public void shouldReturnEmptyListWhenNoErrorsPassedIn() {
        List<String> errors =  validation.validate("1.11", "2.22");
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void shouldReturnOneErrorInListWhenErrorDecimalPassedIn() {
        List<String> errors = validation.validate("1.111");
        Assert.assertEquals(1, errors.size());
        Assert.assertEquals("Too many decimal places for value 1.111", errors.get(0));

    }

    @Test
    public void shouldReturnListOfTwoErrors() {
        List<String> errors = validation.validate("1.111", "2.222", "3.33");
        Assert.assertEquals(2, errors.size());
        Assert.assertEquals("Too many decimal places for value 1.111", errors.get(0));
        Assert.assertEquals("Too many decimal places for value 2.222", errors.get(1));
    }
}
