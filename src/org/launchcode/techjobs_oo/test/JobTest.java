package org.launchcode.techjobs_oo.test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job1;
    Job job2;
    Job jobWithFieldsSet;
    Job secondJobWithFieldsSet;

    @Before public void initializeTestData() {
        job1 = new Job();
        job2 = new Job();
        jobWithFieldsSet = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        secondJobWithFieldsSet = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void emptyTest() {
        assertEquals(10,10,.001);
    }

    @Test
    public void testSettingJobId() {
        String msg = "job1 id: " + job1.getId() + " job2 id:" + job2.getId();
        assertEquals(msg, 1, Math.abs(job2.getId() - job1.getId()));
    }

    @Test
    public void testUniqueJobIds(){
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobIdIteration(){
        assertEquals(job1.getId()+1, job2.getId());
    }

    @Test
    public void testJobsForInequality() {
        assertNotEquals(jobWithFieldsSet, secondJobWithFieldsSet);
    }

    @Test
    public void testToStringHasNewLineBeforeAndAfter() {
        assertTrue(job1.toString().startsWith("\n") && job1.toString().endsWith("\n"));
    }

    @Test
    public void testJobConstructorSetsAllFieldsWithNotNullTest(){
        assertNotNull(jobWithFieldsSet.getEmployer());
        assertNotNull(jobWithFieldsSet.getLocation());
        assertNotNull(jobWithFieldsSet.getPositionType());
        assertNotNull(jobWithFieldsSet.getCoreCompetency());
    }

    @Test
    public void testToStringPrintsFieldsAndData() {
        String expected = "\n" +
                "ID: " + jobWithFieldsSet.getId()+"\n"+
                "Name: Product Tester\n"+
                "Employer: ACME\n"+
                "Location: Desert\n"+
                "Position Type: Quality Control\n"+
                "Core Competency: Persistence\n";
        assertEquals(expected, jobWithFieldsSet.toString());
    }

    @Test
    public void testJobConstructorSetsAllFieldsWithBooleanTest() {
        boolean doesNameString = jobWithFieldsSet.getName() != null;
        boolean doesEmployer = jobWithFieldsSet.getEmployer() != null;
        boolean doesLocation = jobWithFieldsSet.getLocation() != null;
        boolean doesPositionType = jobWithFieldsSet.getPositionType() != null;
        boolean doesCoreCompetency = jobWithFieldsSet.getCoreCompetency() != null;
        boolean allFieldsOfNewJobClass = doesNameString && doesEmployer && doesLocation && doesPositionType && doesCoreCompetency;

        boolean setGivenName = jobWithFieldsSet.getName().equals("Product Tester");
        boolean setGivenEmployer = jobWithFieldsSet.getEmployer().toString().equals("ACME");
        boolean setGivenLocation = jobWithFieldsSet.getLocation().toString().equals("Desert");
        boolean setGivenPosition = jobWithFieldsSet.getPositionType().toString().equals("Quality Control");
        boolean setGivenCoreCompetency = jobWithFieldsSet.getCoreCompetency().toString().equals("Persistence");
        boolean allFieldsOfOriginalJobClass = setGivenName && setGivenEmployer && setGivenLocation && setGivenPosition && setGivenCoreCompetency;

        String message = String.format("\nFields match proper class?\nDoesNameString: %b, doesEmployer: %b, doesLocation: %b, doesPositionType: %b, doesCoreCompetency: %b,\n", doesNameString, doesEmployer, doesLocation, doesPositionType, doesCoreCompetency);
        message += String.format("\nInput of fields?\n setGivenName: %b, setGivenEmployer: %b, setGivenLocation: %b, setGivenPosition: %b, setGivenCoreCompetency: %b\n", setGivenName, setGivenEmployer, setGivenLocation, setGivenPosition, setGivenCoreCompetency);
        assertTrue(message, allFieldsOfNewJobClass && allFieldsOfOriginalJobClass);
    }


    @Test
    public void testToStringOnlyIdSetReturnOopsMsg() {
        assertEquals("\nOOPS! This job does not seem to exist.\n", job1.toString());
    }
}