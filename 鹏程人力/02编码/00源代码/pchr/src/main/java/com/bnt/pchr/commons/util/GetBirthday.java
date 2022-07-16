package com.bnt.pchr.commons.util;

import com.bnt.pchr.entity.Emp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 计算生日
 */
public class GetBirthday {
    public static String bir(Emp emp) {
        //得到当前年
        String notes = null;
        SimpleDateFormat sfm = new SimpleDateFormat("yyyy");
        int nowYear = Integer.valueOf(sfm.format(new Date()));
        int nowYearDay = 0;
        if (nowYear / 400 == 0) {
            //今年是闰年
            nowYearDay = 366;
        } else {
            nowYearDay = 365;
        }
        //得到年中天
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        int nowDayInYear = ca.get(Calendar.DAY_OF_YEAR);
        //得到员工出生年份
        int empYear = Integer.valueOf(sfm.format(emp.getBirthday()));
        ca.setTime(emp.getBirthday());
        int empDayInYear = ca.get(Calendar.DAY_OF_YEAR);
        if (nowDayInYear - empDayInYear == 364 || empDayInYear - nowDayInYear == 1) {

            notes = emp.getEmpName() + "明天生日";
        }
        return notes;
    }
}
