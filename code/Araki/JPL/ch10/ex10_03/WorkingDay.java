package ch10.ex10_03;

import ch06.ex06_01.DayOfWeek;

public class WorkingDay{

    /**
     * 曜日を受けて、働く日であれば true そうでなければ false を返す
     * if-else版
     * @param w
     * @return
     */
    static boolean isWorkingDay_usingIf(DayOfWeek w) {
        
        if (w == DayOfWeek.SUNDAY || w == DayOfWeek.SATURDAY) {
            return false;
        }
        else {
            return true;
        }
    }
    
    /**
     * 曜日を受けて、働く日であれば true そうでなければ false を返す。
     * switch版
     * @param w
     * @return
     */
    static boolean isWorkingDay_usingSwitch(DayOfWeek w) {
        
        switch (w) {
        case SUNDAY:
        case SATURDAY:
            return false;
        default:
            return true;
        }
    }
    
    /*
     * switchで記載したほうが分かりやすい
     * */
}
