package com.nojsoft.conquian.constants;

/**
 * Created by jorge on 13/02/16.
 */
public class CardConstants {
    public static String [] cardNames = {"g01", "g02", "g03", "g04", "g05",
                                         "g06", "g07", "g08", "g09", "g10",
                                         "m01", "m02", "m03", "m04", "m05",
                                         "m06", "m07", "m08", "m09", "m10",
                                         "s01", "s02", "s03", "s04", "s05",
                                         "s06", "s07", "s08", "s09", "s10",
                                         "c01", "c02", "c03", "c04", "c05",
                                         "c06", "c07", "c08", "c09", "c10",};

    public static final int LOCATION_ACTUAL = 1;
    public static final int LOCATION_TABLE = 2;
    public static final int LOCATION_HAND = 3;

    public static final String SUBGROUP_ONE = "1";
    public static final String SUBGROUP_TWO = "2";
    public static final String SUBGROUP_THREE = "3";

    public static enum GameType {
        STRAIGHT, NONE, SAME_KIND
    }
}
