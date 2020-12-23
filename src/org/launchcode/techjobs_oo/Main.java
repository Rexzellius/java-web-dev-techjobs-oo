package org.launchcode.techjobs_oo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
       Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        Job job3 = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting Ability"));
        Job job4 = new Job(null, null, null, null, new CoreCompetency(""));
        Job job6 = new Job();
        Job job5 = new Job("I broke the Data, mom.", null, null, null, null);
        Job job7 = new Job("Rex Curtis Rexzellius Rufus", new Employer("Me"), new Location("Hell, Michigan"), new PositionType("Me"), new CoreCompetency("Technologically Incompetent"));
        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        jobs.add(job4);
        jobs.add(job6);
        jobs.add(job5);
        jobs.add(job7);

        for (Job job : jobs){
           System.out.println(job);
       }
    }

}
