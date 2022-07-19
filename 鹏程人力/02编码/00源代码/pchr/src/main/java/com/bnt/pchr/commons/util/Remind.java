package com.bnt.pchr.commons.util;

import com.bnt.pchr.entity.Emp;
import com.bnt.pchr.entity.EmpContract;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Calendar;
import java.util.Date;

/**
 * 提醒工具包
 */
public class Remind {
    /**
     * 生日提醒(定时调用)
     * @param emp
     * @return
     */

    public static String birthdayRemind(Emp emp) {
        String message=null;
        //得出当前天在一年中所在的天
        Calendar nowDay = Calendar.getInstance();
        nowDay.setTime(new Date());
        int now = nowDay.get(Calendar.DAY_OF_YEAR);
        //得出生日在一年中所在的天
        Calendar birthday = Calendar.getInstance();
        birthday.setTime(emp.getBirthday());
        int birth = birthday.get(Calendar.DAY_OF_YEAR);
        if (birth - now == 8) {
             message = "还有七天"+emp.getEmpName()+"过生日啦!";
        } else if (birth - now == 4) {
             message = "还有三天"+emp.getEmpName()+"过生日啦!";
        } else if (birth - now == 0) {
             message = emp.getEmpName()+"今天过生日啦!";
        } else if (birth - now == -359) {
             message = "还有七天"+emp.getEmpName()+"过生日啦!";
        } else if (birth - now == -363) {
             message = "还有三天"+emp.getEmpName()+"过生日啦!";
        } else {
            return message;
        }
        return  message;
    }

    /**
     * 合同提醒(定时调用)
     * @return
     */

    public static String contractRemind( EmpContract empContract) {
        String message=null;
        //得出当前天在一年中所在的天
        Calendar nowDay = Calendar.getInstance();
        nowDay.setTime(new Date());
        int now = nowDay.get(Calendar.DAY_OF_YEAR);
        //得出合同截至日期在一年中所在的天
        Calendar deadline = Calendar.getInstance();
        deadline.setTime(empContract.getEndDate());
        int end = deadline.get(Calendar.DAY_OF_YEAR);
        if (end-now==31){
            message="合同还有一个月(31天)即将到期,请尽快办理手续!";
        }else if (end-now<0){
            message="你的合同已过期,";
        }
        else {
            return message;
        }
        return  message;
    }
}
