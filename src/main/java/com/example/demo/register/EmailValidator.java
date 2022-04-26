package com.example.demo.register;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator
        implements Predicate<String>
{
    @Override
    public boolean test(String s) {
        // TODO: 26-Apr-22 Implement regex valid email check.
        return true;
    }
}
