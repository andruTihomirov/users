package com.users.vallidators.password;

import com.users.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author atsikhamirau on 21.02.2019
 */
public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserDto user = (UserDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}