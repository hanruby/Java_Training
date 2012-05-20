package ch10.ex10_03;

import ch06.ex06_01.DayOfWeek;

public class WorkingDay{

    static boolean isWorkingDay_usingIf(DayOfWeek w) {
        
        if (w == DayOfWeek.SUNDAY || w == DayOfWeek.SATURDAY) {
            return false;
        }
        else {
            return true;
        }
    }
    
    static boolean isWorkingDay_usingSwitch(DayOfWeek w) {
        
        switch (w) {
        case SUNDAY:
        case SATURDAY:
            return false;
        default:
            return true;
        }
    }
}
