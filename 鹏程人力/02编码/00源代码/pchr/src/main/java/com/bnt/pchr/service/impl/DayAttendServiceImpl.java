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
    public DayAttend selectOne(Integer attendId) {
        return dayAttendMapper.selectById(attendId);
    }

    @Override
    public Boolean isAttended(DayAttend dayAttend, PageData<DayAttend> page) {
        Calendar startTime=Calendar.getInstance();
        startTime.set(Calendar.HOUR,9);
        startTime.set(Calendar.MINUTE,0);
        startTime.set(Calendar.SECOND,0);
        Calendar endTime=Calendar.getInstance();
        endTime.set(Calendar.HOUR,18);
        endTime.set(Calendar.MINUTE,0);
        endTime.set(Calendar.SECOND,0);
        page.addCriteria("startTime",startTime);
        page.addCriteria("endTime",endTime);
        page.getCriteriaMap();
        Map<String,Object> criteriaMap=page.getCriteriaMap();
        return null;
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
        System.out.println("当前" + time + ",上班" + startTime + ",下班" + endTime + ",超时" + overTime);
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
    public int compensateCard(DayAttend dayAttend) {
        int empId = dayAttend.getEmpId();
        QueryWrapper<DayAttend> qw = new QueryWrapper<>();
        qw.eq("emp_id", empId);
        qw.eq("attend_state", 4);//查询状态为补卡的次数
        int count = dayAttendMapper.selectCount(qw).intValue();
        if (count > 2) {
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