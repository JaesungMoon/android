package com.jaesung.customobjectarraysample;

/**
 * Created by moon_jaesung on 2018/05/24.
 */

public class StudentRecord {


    public String name;
    public int rollNumber;
    public String departement;
    public float totalMark;
    boolean hasReservation;

    public  StudentRecord(){
        name           = "";
        rollNumber     = 0;
        departement    = "";
        totalMark      = 0;
        hasReservation = false;
    }
    public String toString() {
        return "[" + departement+ ","+ name + "," + rollNumber +"]";
    }

}
