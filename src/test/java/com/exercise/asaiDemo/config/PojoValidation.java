package com.exercise.asaiDemo.config;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PojoValidation {
    @Test
    public void executeOpenPojoValidationsWithSetter() {

        List<PojoClass> pojoClasses = PojoClassFactory.getPojoClasses("com.exercise.asaiDemo.entity");

        Assertions.assertEquals(2, pojoClasses.size());

        Validator validator =
                ValidatorBuilder.create()
                        .with(new GetterMustExistRule())
                        .with(new SetterMustExistRule())
                        .with(new SetterTester())
                        .with(new GetterTester())
                        .build();

        validator.validate(pojoClasses);
    }
}
