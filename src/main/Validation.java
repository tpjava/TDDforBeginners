package main;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Validation {
    public List<String> validate(String... values) {
        List<String> errors = new ArrayList<>();

        for(String value : values) {
            if(new BigDecimal(value).scale() > 2) {
                errors.add(String.format("Too many decimal places for value %s", value));
            }
        }
        return errors;
    }
}
