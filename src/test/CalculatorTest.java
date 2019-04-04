package test;

import main.Calculator;
import main.Validation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
Update calculator to change the add method to take two Strings which can contain decimals to two places and returns a String
Decimals more than two places should throw an exception.

Update the calculator to change the subtract method to take two Strings which can contain decimals to two places and returns a String.

Decimals more that two places should throw an exception.

We need to add a multiply method which passes two string decimals, first * second and returns a String.

We’ll need to throw an exception if more than two decimal places passed in for either value.

We need to add a divide method which passes in two string decimals to two decimal places, again first / second and return a String

We’ll need to throw an exception if more than two decimal places.

We’ll need to throw an exception if second value is zero as you’ll get a divide by zero exception

Create a validator class

Refactor the add method to validate using the validation class, removing the duplicate
validation code currently in this method.

Refactor the subtract method to validate using the validation class, removing the duplicate
validation code currently in this method.

Refactor the multiply method to validate using the validation class, removing the duplicate
validation code currently in this method

Refactor the divide method to validate using the validation class, removing the duplicate
validation code currently in this method.

*/
public class CalculatorTest {
    private Calculator calculator;
    private Validation validation;

    @Before
    public void setUp() {
        validation = new Validation();
        calculator = new Calculator(validation);
    }

    @Test
    public void shouldReturnInstanceOfCalculator() {
        Assert.assertNotNull(calculator);
    }

    @Test
    public void shouldReturn2When4DividedBy2IsPassedIn() {
        String result = calculator.divide("4","2");
        Assert.assertEquals("2", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSecondValueISZero() {
        calculator.divide("4","0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionWhenThreeDecimalPlaceValuePassedForDivideMethod() {
        calculator.divide("1.11", "1.111");
    }

    @Test
    public void shouldReturn4When2Times2IsPassedIn() {
        String result = calculator.multiply("2","2");
        Assert.assertEquals("4", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionWhenThreeDecimalPlaceValuePassedForMultiplyMethod() {
        calculator.multiply("1.11", "1.111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionWhenThreeDecimalPlaceValuePassed() {
        calculator.add("1.11", "1.111");
    }


    @Test
    public void shouldReturnTwoWhenOnePlusOneIsCalled() {
        String result = calculator.add("1.11", "1.11");
        Assert.assertEquals("2.22", result);
    }

    @Test
    public void shouldReturnNegativeTwoWhenNegOnePlusNegOneIsCalled() {
        String result = calculator.add("-1.11", "-1.11");
        Assert.assertEquals("-2.22", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionWhenThreeDecimalPlaceValuePassedToSubtractMethod() {
        calculator.subtract("1.11", "1.111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionWhenThreeDecimalPlaceValuePassedToSubtractMethod_2() {
        calculator.subtract("1.111", "1.11");
    }

    @Test
    public void shouldReturnOneWhenThreeSubtractTwoIsCalled() {
        String result = calculator.subtract("3.11", "2");
        Assert.assertEquals("1.11", result);
    }

    @Test
    public void shouldReturnMinusOneWhenMinusTwoSubtractMinusOneIsCalled() {
        String result = calculator.subtract("-2.11", "-1");
        Assert.assertEquals("-1.11", result);
    }
}
