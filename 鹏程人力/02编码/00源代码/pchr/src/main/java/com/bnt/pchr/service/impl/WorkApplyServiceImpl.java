package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bnt.pchr.commons.vo.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.WorkApply;
import com.bnt.pchr.mapper.WorkApplyMapper;
import com.bnt.pchr.service.IWorkApplyService;

import java.util.Date;
import java.util.List;

@Service("workApplyService")
public class WorkApplyServiceImpl implements IWorkApplyService {

    @Autowired
    @Qualifier("workApplyMapper")
    private WorkApplyMapper workApplyMapper;

    @Override
    public List<WorkApply> selectList(WorkApply workApply){
        return workApplyMapper.selectByCondition(workApply);
    }

    @Override
    public IPage<WorkApply> selectPage(PageData<WorkApply> page){
        return workApplyMapper.selectApplyList(page);
    }

    @Override
    public WorkApply selectOne(Integer applyId) {
        return workApplyMapper.selectById(applyId);
    }

    @Override
    public int deleteById(Integer applyId) {
    return 0;
    }

    @Override
    public int delete(WorkApply workApply){
        return 0;
    }

    @Override
    public int insert(WorkApply workApply) {
        workApply.setCreateTime(new Date());//设置申请时间
        Date startTime=workApply.getStartTime();
        Date endTime=workApply.getEndTime();
        if(startTime.getTime()>endTime.getTime()){
            return 9;//错误的时间
        }
        return workApplyMapper.insert(workApply);
    }

    /**
     * 取消申请
     * @param workApply
     * @return
     */
    @Override
    public int updateById(WorkApply workApply) {
        workApply.setApplyState(4);//设置申请状态为4——取消
        workApply.setCreateTime(new Date());
        return workApplyMapper.updateById(workApply);
    }

    @Override
    public int update(WorkApply workApply) {
        QueryWrapper<WorkApply> qw=new QueryWrapper<>();
        int applyState=workApply.getApplyState();
        if(applyState==4){
            return 4;//已取消状态不可以再修改,该状态实现
        }
        qw.eq("apply_id",workApply.getApplyId());
        WorkApply apply=workApplyMapper.selectOne(qw);
        if(2==apply.getApplyState()){
            return 9;//审批状态为已通过
        }
        workApply.setApprTime(new Date());//设置审批时间
        return workApplyMapper.updateById(workApply);
    }
}