package validations;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class ValidatorUtil {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static <T> void validateEntity(T entity) {
        Set<ConstraintViolation<T>> violations = validator.validate(entity);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<T> violation : violations) {
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            }
            throw new RuntimeException("Validation failed");
        }
    }
}
