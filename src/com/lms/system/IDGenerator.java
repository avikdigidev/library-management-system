package com.lms.system;

public class IDGenerator {
    /*We should always try to avoid creating of utility classes
    * as it discourages the basic OOPS principle
    * Only in case of some classes which has some activity
    *
    * //TODO how to prevent them then?
    *
    * */

    private IDGenerator() {
    }

    public static int getUniqueID() {
        return (int) Math.random();
    }
}
