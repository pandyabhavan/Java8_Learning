package com.java8.learning.combinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import  static com.java8.learning.combinatorPattern.ICombinatorPattern.PersonValidator;
import  static com.java8.learning.combinatorPattern.ICombinatorPattern.PersonValidator.*;

public interface ICombinatorPattern extends Function<Person, PersonValidator> {

    static ICombinatorPattern validateEmail(){
        return customer -> {
            return customer.getEmail().contains("@") ?
                    SUCCESS : EMAIL_NOT_VALID;
        };
    }

    static  ICombinatorPattern validatePhone(){
        return  person -> person.getPhone().length() == 10 ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static  ICombinatorPattern isAdult(){
        return  person -> Period.between(person.getDob(), LocalDate.now()).getYears() > 18 ? SUCCESS : IS_NOT_AN_ADULT;
    }

    default ICombinatorPattern and(ICombinatorPattern other){
        return  person ->  {
            PersonValidator result = this.apply(person);
            return result.equals(SUCCESS) ? other.apply(person) :  result;
        };
    }

    enum PersonValidator {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
