package com.bnt.pchr.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.mapper.WorkApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.DayAttend;
import com.bnt.pchr.mapper.DayAttendMapper;
import com.bnt.pchr.service.IDayAttendService;

import java.util.*;

@Service("dayAttendService")
public class DayAttendServiceImpl implements IDayAttendService {

    @Autowired
    @Qualifier("dayAttendMapper")
    private DayAttendMapper dayAttendMapper;
    @Autowired
    @Qualifier("workApplyMapper")
    private WorkApplyMapper workApplyMapper;

    @Override
    public List<DayAttend> selectList(DayAttend dayAttend) {
        return null;
    }

    @Override
    public PageData<DayAttend> selectPage(PageData<DayAttend> page) {
        Map<String,Object> criteriaMap=page.getCriteriaMap();
        //获取开始时间
        if (criteriaMap.containsKey("startTime")) {
            String startTime = (String) criteriaMap.get("startTime");
            if (StrUtil.isNotEmpty(startTime)) {
                startTime = startTime.replaceAll("[-\\s:]", "");
                criteriaMap.put("begin", startTime);
            }
        }
        //下班时间
        if (criteriaMap.containsKey("endTime")) {
            String endTime = (String) criteriaMap.get("endTime");
            if (StrUtil.isNotEmpty(endTime)) {
                endTime = endTime.replaceAll("[-\\s:]", "");
                criteriaMap.put("end", endTime);
            }
        }
        return dayAttendMapper.selectTimeBetWeen(page);
    }

    @Override
    public int selectOne(int empId, String times) {
        QueryWrapper<DayAttend> wrapper=new QueryWrapper<>();
        wrapper.eq("emp_id",empId);
        List<DayAttend> dayAttendList=dayAttendMapper.selectList(wrapper);//查询出员工打卡记录表
        long time=Long.parseLong(times);//获取当前时间的毫秒数
        Integer state=null;//员工打卡状态
        for (DayAttend day:dayAttendList){
            Long attendTime=day.getAttendTime().getTime();//获取打卡开始时间
            Long endTime=day.getEndTime().getTime();//获取下班打卡时间
            if(attendTime==null){//当前并未打卡
                state=-2;
            }//已打上班卡但并未打下班卡
            if(attendTime!=null&&endTime==null&&(time-attendTime)<4*60*60*60*1000){
               state=day.getAttendState();//获取当前应打卡的状态
            }else if(attendTime!=null&&endTime!=null){//都已经打卡
                return 6;
            }
        }
        return state;
    }

    @Override
    public List<DayAttend> isAttended(DayAttend dayAttend) {
        QueryWrapper<DayAttend> qw = new QueryWrapper<>();
        qw.eq("emp_id",dayAttend.getEmpId());
        List<DayAttend> dayList = dayAttendMapper.selectList(qw);
        List<DayAttend> attended=new ArrayList<>();//用于存放已经打卡的记录
        for (DayAttend day:dayList){
            Date startTime = day.getAttendTime();
            long endTime = day.getEndTime().getTime();
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(startTime);
            //
            calendar.set(Calendar.MONTH,Calendar.MONTH+4);
            calendar.set(Calendar.HOUR,9);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND,0);
            long start = calendar.getTimeInMillis();
            System.out.println("标准上班："+calendar.getTime());
            calendar.set(Calendar.HOUR,18);
            System.out.println("标准下班："+calendar.getTime());
            //标准下班
            long end = calendar.getTimeInMillis();
            if(startTime.getTime()<=start&&end<=endTime){
                attended.add(day);//已经打卡
            }
        }
        return attended;
    }

    @Override
    public int deleteById(Integer attendId) {
        return dayAttendMapper.deleteById(attendId);
    }

    @Override
    public int delete(DayAttend dayAttend) {
        return 0;
    }


    @Override
    public int insert(DayAttend dayAttend) {

        Date date = new Date();
        Date attendTime = dayAttend.getAttendTime();//获取上班打卡时间
        //设置超时打卡时间
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 11);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        //设置上班时间
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 9);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        //设置下班时间
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR, 18);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        //获取当前的系统时间
        long time = new Date().getTime();
        long startTime = calendar.getTimeInMillis();//上班
        long endTime = c.getTimeInMillis();//下班
        long overTime = cal.getTimeInMillis();//超时
        if (attendTime == null) {//未打上班卡
            if (time > overTime && time < endTime) {//设置超时状态
                dayAttend.setAttendState(5);
                dayAttend.setAttendTime(date);
                return dayAttendMapper.insert(dayAttend);
            }
            if (time > startTime && time < overTime) {
                //设置为迟到状态
                dayAttend.setAttendState(2);
                dayAttend.setAttendTime(date);
                return dayAttendMapper.insert(dayAttend);
            }
            //正常上班状态
            dayAttend.setAttendTime(date);
            dayAttend.setAttendState(1);
            return dayAttendMapper.insert(dayAttend);
        } else if (time > endTime) {
            //在下班时打卡则不添加记录
            return -1;
        }
        if (attendTime != null) {
            //已打上班卡，考察下班打卡时间
            long finalTime = new Date().getTime();
            if (dayAttend.getAttendState() != null) {
                if (finalTime < overTime) {//未到中午十二点之前进行打卡
                    return 9;//未到下班打卡时间
                }
                if (finalTime < endTime && finalTime > overTime) {//迟到状态为早退
                    dayAttend.setAttendState(3);
                    dayAttend.setEndTime(date);
                    return dayAttendMapper.insert(dayAttend);
                }//正常下班
                dayAttend.setAttendState(6);
            }
        }
        /*return 100000;//打卡超时状态，只能进行补卡*/
        return dayAttendMapper.insert(dayAttend);
    }

    @Override
    public int queryCompensateCount(DayAttend dayAttend) {
        int empId = dayAttend.getEmpId();
        QueryWrapper<DayAttend> qw = new QueryWrapper<>();
        qw.eq("emp_id", empId);
        qw.eq("attend_state", 4);//查询状态为补卡的次数
        return dayAttendMapper.selectCount(qw).intValue();
    }

    @Override
    public int compensateCard(DayAttend dayAttend) {
        int empId = dayAttend.getEmpId();
        QueryWrapper<DayAttend> qw = new QueryWrapper<>();
        qw.eq("emp_id", empId);
        qw.eq("attend_state", 4);//查询状态为补卡的次数
        int count = dayAttendMapper.selectCount(qw).intValue();
        if (count > 3) {
            //补卡次数超过3次
            return 9;
        }
        //如果没有打卡
        if (dayAttend.getAttendTime() == null) {
            dayAttend.setAttendState(4);
            dayAttend.setSuppTime(new Date());//设置补卡时间
            return dayAttendMapper.insert(dayAttend);
        }//已打卡
        //将状态设置为补卡状态
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
        int attendId = dayAttend.getAttendId();
        QueryWrapper<DayAttend> wrapper = new QueryWrapper<>();
        wrapper.eq("attend_id", attendId);
        DayAttend dayAttend1 = dayAttendMapper.selectOne(wrapper);
        int state1 = dayAttend1.getAttendState();
        int state = dayAttend.getAttendState();
        dayAttend.setSuppTime(new Date());
        if (state == state1) {//未对该记录进行修改
            return -1;
        }
        return dayAttendMapper.updateById(dayAttend);
    }
}