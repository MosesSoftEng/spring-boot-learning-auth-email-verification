package com.example.demo.register;

import com.sun.xml.bind.v2.TODO;

import java.util.function.Predicate;

public class EmailValidator
        implements Predicate<String>
{
    @Override
    public boolean test(String s) {
        // TODO: 26-Apr-22 Implement regex valid email check.
        return true;
    }
}
