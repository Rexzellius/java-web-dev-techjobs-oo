package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Employer extends JobField {
    private static int nextId = 1;

    public Employer(String value) {
        super(nextId, value);
        nextId++;
    }

}