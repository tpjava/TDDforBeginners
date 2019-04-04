package main;


import java.math.BigDecimal;
import java.util.List;

public class Calculator {

    private Validation validation;

    public Calculator(Validation validation) {
        this.validation = validation;
    }

    public String add(String first, String second) {
        validateDecimals(first, second);
        return new BigDecimal(first).add(new BigDecimal(second)).toString();
    }

    public String subtract(String first, String second) {
        validateDecimals(first, second);
        return new BigDecimal(first).subtract(new BigDecimal(second)).toString();
    }

    public String multiply(String first, String second) {
        validateDecimals(first, second);
        return new BigDecimal(first).multiply(new BigDecimal(second)).toString();
    }

    public String divide(String first, String second) {
        if(new BigDecimal(second).equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        validateDecimals(first, second);
        return new BigDecimal(first).divide(new BigDecimal(second)).toString();
    }

    private void validateDecimals(String... values) {
        List<String> errors = this.validation.validate(values);

        if(!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }
    }
}
