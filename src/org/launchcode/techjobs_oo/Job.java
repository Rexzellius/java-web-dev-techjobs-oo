package org.launchcode.techjobs_oo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Job {

    private final int ID;
    private static int nextId = 1;
    private final String noDataAvailable = "Data not available.";
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        ID = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    //TODO: write out equals & hashcode methods.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return ID == job.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, employer, location, positionType, coreCompetency);
    }

    //TODO: write out if dataAvailable of String & dataAvailable of JobField values that will return the noDataAvailable string
    // if one or more credentials have not been included.

    private String dataAvailable(String string) {
        return string != null && !string.equals("") ? string : noDataAvailable ;
    }
    private String dataAvailable(JobField jobField) {
        return jobField != null && !jobField.getValue().equals("") ? jobField.getValue() : noDataAvailable ;
    }

    //TODO: write toString method.

    @Override
    public String toString() {
        String id = Integer.toString(getId());
        String name =  dataAvailable(this.name);
        String employer =  dataAvailable(this.employer);
        String location =  dataAvailable(this.location);
        String positionType = dataAvailable(this.positionType);
        String coreCompetency = dataAvailable(this.coreCompetency);
        List<String> allStrings = Arrays.asList(name, employer, location, positionType, coreCompetency);
        // ensure that dataAvailable returns true/false if the string has/has not any credentials of Job.class in Main listed.
        boolean dataAvailable = !allStrings.stream().allMatch(aString -> aString.equals(noDataAvailable));

        return  dataAvailable ?
                String.format("\n" +
                        "ID: %s\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n", id, name, employer, location, positionType, coreCompetency)
                : "\nOOPS! This job does not seem to exist.\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return ID;
    }

}
