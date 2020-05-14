package com.lustre.mall.core.utils;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Map;
import java.util.Set;

public class ValidatorUtil {
    private static Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();

    public static <T> String validate(T obj){
        Map<String,StringBuffer> errorMap = null;
        Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
        final StringBuilder sb = new StringBuilder();

        if (set != null && !set.isEmpty()) {
            set.forEach(cv -> {
                sb.append(cv.getMessage()+",");
            });

            sb.deleteCharAt(sb.length()-1);

            return sb.toString();
        }

        return null;
    }


}
