package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Location extends JobField{
    private static int nextId = 1;

    public Location(String value) {
        super(nextId, value);
        nextId++;
    }

}