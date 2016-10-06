package ru.ibetter;

/**
 * Created by smit on 24.09.2016.
 */
public class DayAcc implements Comparable<DayAcc> {

    private static String KEY_DAY = "day";
    private static String KEY_BANK_VALUE = "bv";
    private static String KEY_MOVE_VALUE = "mv";
    private static String KEY_PR_VALUE = "pv";

    public String day;
    public Long bankValue;
    public Long moveValue;
    public Long prValue;
	
    public String getDay() {
        return day;
    }

    public Long getBankValue() {
        return bankValue;
    }

    public Long getMoveValue() {
        return moveValue;
    }

    public Long getPrValue() {
        return prValue;
    }




    public DayAcc(String day, Long bankValue, Long moveValue, Long prValue){
        this.day = day;
        this.bankValue = bankValue;
        this.moveValue = moveValue;
        this.prValue = prValue;
    }


    public DayAcc(String day, Integer bankValue, Integer moveValue, Integer prValue){
        this.day = day;
        this.bankValue = (bankValue != null) ? new Long(bankValue * 100) : null;
        this.moveValue = (moveValue != null) ? new Long(moveValue * 100) : null;
        this.prValue = (prValue != null) ? new Long(prValue * 100) : null;
    }

    @Override
    public int compareTo(DayAcc o) {
        return this.day.compareTo(o.day);
    }
}
