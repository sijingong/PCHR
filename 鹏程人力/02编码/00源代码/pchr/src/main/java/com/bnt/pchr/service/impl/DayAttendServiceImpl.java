package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.DayAttend;
import com.bnt.pchr.mapper.DayAttendMapper;
import com.bnt.pchr.service.IDayAttendService;

import java.text.SimpleDateFormat;
import java.util.*;

@Service("dayAttendService")
public class DayAttendServiceImpl implements IDayAttendService {

    @Autowired
    @Qualifier("dayAttendMapper")
    private DayAttendMapper dayAttendMapper;

    @Override
    public List<DayAttend> selectList(DayAttend dayAttend){
        return null;
    }

    @Override
    public IPage<DayAttend> selectPage(IPage<DayAttend> page){
        return null;
    }

    @Override
    public DayAttend selectOne(Integer attendId) {
        return null;
    }

    @Override
    public int deleteById(Integer attendId) {
    return 0;
    }

    @Override
    public int delete(DayAttend dayAttend){
        return 0;
    }

    @Override
    public int insert(DayAttend dayAttend) {
        Date attendTime=dayAttend.getAttendTime();//获取上班打卡时间
        //设置超时打卡时间
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.HOUR,12);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.YEAR,Calendar.MONTH+1,Calendar.DAY_OF_MONTH,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND);//超过此时间不可以进行打卡
        //设置上班时间
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR,9);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.YEAR,Calendar.MONTH+1,Calendar.DAY_OF_MONTH,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND);//记录早上上班打卡时间
        //设置下班时间
        Calendar c=Calendar.getInstance();
        c.set(Calendar.HOUR,18);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.YEAR,Calendar.MONTH+1,Calendar.DAY_OF_MONTH,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND);//记录晚上下班打卡时间
        //获取当前的系统时间
        long time=dayAttend.getAttendTime().getTime();
        long startTime=calendar.getTimeInMillis();//上班
        long endTime=c.getTimeInMillis();//下班
        long overTime=cal.getTimeInMillis();//超时
        if(attendTime==null){//未打上班卡
            if(time>overTime&&time<endTime){//设置超时状态
                dayAttend.setAttendState(5);
                dayAttend.setAttendTime(new Date());
                return dayAttendMapper.insert(dayAttend);
            }
            if(time>endTime){//在下班时打卡则不添加记录
                return 0;
            }
            if(time>startTime&&time<overTime){
                //设置为迟到状态
                dayAttend.setAttendState(2);
                dayAttend.setAttendTime(new Date());
                return dayAttendMapper.insert(dayAttend);
            }
            //正常上班状态
            dayAttend.setAttendTime(new Date());
            dayAttend.setAttendState(1);
            return dayAttendMapper.insert(dayAttend);
        }
        //已打上班卡，考察下班打卡时间
        long finalTime=new Date().getTime();
        if(dayAttend.getAttendState()!=null){
            if(finalTime<endTime){//迟到状态为早退
                dayAttend.setAttendState(3);
                dayAttend.setEndTime(new Date());
                return dayAttendMapper.insert(dayAttend);
            }//正常下班
            dayAttend.setAttendState(6);
        }
        /*return 100000;//打卡超时状态，只能进行补卡*/
        return dayAttendMapper.insert(dayAttend);
    }

    @Override
    public int compensateCard(DayAttend dayAttend) {
        int empId=dayAttend.getEmpId();
        int state=dayAttend.getAttendState();
        //如果没有打卡
        if(dayAttend.getAttendTime()==null){
            dayAttend.setAttendState(4);
            dayAttend.setSuppTime(new Date());//设置补卡时间
            return dayAttendMapper.insert(dayAttend);
        }//已打卡
            QueryWrapper<DayAttend> qw=new QueryWrapper<>();
            qw.eq("emp_id",empId);
            qw.eq("attend_state",state);
            int count=dayAttendMapper.selectCount(qw).intValue();
            if(count>3){
                //补卡次数超过3次
                return 9;
            }//将状态设置为补卡状态
            dayAttend.setAttendState(4);
            dayAttend.setSuppTime(new Date());
            return dayAttendMapper.insert(dayAttend);
        }


    @Override
    public int updateById(DayAttend dayAttend) {
        return 0;
    }

    @Override
    public int update(DayAttend dayAttend) {
        return 0;
    }
}