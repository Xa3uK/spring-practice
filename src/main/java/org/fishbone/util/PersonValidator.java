package org.fishbone.util;

import org.fishbone.models.Person;
import org.fishbone.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
//        Person person = (Person) target;
//        if (personDAO.show(person.getEmail()) != null ) {
//            errors.rejectValue("email", "", "This email is already taken");
//        }
    }
}
