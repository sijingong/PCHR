package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bnt.pchr.commons.vo.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.Leave;
import com.bnt.pchr.mapper.LeaveMapper;
import com.bnt.pchr.service.ILeaveService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("leaveService")
public class LeaveServiceImpl implements ILeaveService {

    @Autowired
    @Qualifier("leaveMapper")
    private LeaveMapper leaveMapper;

    @Override
    public List<Leave> selectList(Leave leave){
        QueryWrapper qw=new QueryWrapper<>();
        return leaveMapper.selectList(qw);
    }

    @Override
    public PageData<Leave> selectPage(PageData<Leave> pageData) {
        return leaveMapper.selectList(pageData);
    }

    @Override
    public IPage<Leave> selectPage(IPage<Leave> page){
        return null;
    }

    @Override
    public Leave selectOne(Integer leaveId) {
        return leaveMapper.selectById(leaveId);
    }

    @Override
    public int deleteById(Integer leaveId) {
        return leaveMapper.deleteById(leaveId);
    }

    @Override
    public int delete(Leave leave){
        return 0;
    }

    @Override
    public int insert(Leave leave) {
        //计算请假时间
        /*long startTime=leave.getCreateTime().getTime();
        long endTime=leave.getDestoryTime().getTime();
        long time=endTime-startTime;
        if(time<=0)
        {
            return 2;
        }else
        {
            long days=time/(1000*60*60*24);//相差天数
            time=time%(1000*60*60*24);//不够一天的毫秒数
            long hours=time/(1000*60*60);//相差小时数
            time=time%(1000*60*60);//不够一小时的毫秒数
            long minutes=time/(1000*60);//相差分钟数
            System.out.println(days+"天"+hours+"小时"+minutes+"分钟");
        }*/
        leave.setApplyTime(new Date());
        leave.setApplyState(1);
        return leaveMapper.insert(leave);
    }

    @Override
    public int updateById(Leave leave) {
        return 0;
    }

    @Override
    public int update(Leave leave) {
        return 0;
    }
}