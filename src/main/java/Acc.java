
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;


/**
 * Сохраниение
 */


public class Acc {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");


    private String name;
    private int numberAcc;

    //снятие.внесение, Изменение процента, Остаток из банка
    private TreeSet<DayAcc> daily = new TreeSet<DayAcc>();

    //капитализация
    private boolean isCap = false;

    //День месяца капитализации
    private int dayCap = -1;

    private Date startDate;


    public Acc(String name, int numberAcc, TreeSet<DayAcc> daily, boolean isCap, int dayCap) {
        try {
            this.startDate = Acc.sdf.parse(daily.first().day);
        } catch (Exception e) {
            throw new IllegalArgumentException("Date is empty or is not good format");
        }
        this.name = name;
        this.numberAcc = 1;
        this.daily = daily;
        this.isCap = isCap;
        this.dayCap = dayCap;
    }









}
