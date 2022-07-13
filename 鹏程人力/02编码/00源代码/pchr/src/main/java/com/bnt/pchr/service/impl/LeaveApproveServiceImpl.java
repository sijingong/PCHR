package com.bnt.pchr.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.LeaveApprove;
import com.bnt.pchr.mapper.LeaveApproveMapper;
import com.bnt.pchr.service.ILeaveApproveService;
import java.util.List;

@Service("leaveApproveService")
public class LeaveApproveServiceImpl implements ILeaveApproveService {

    @Autowired
    @Qualifier("leaveApproveMapper")
    private LeaveApproveMapper leaveApproveMapper;

    @Override
    public List<LeaveApprove> selectList(LeaveApprove leaveApprove){
        return null;
    }

    @Override
    public IPage<LeaveApprove> selectPage(IPage<LeaveApprove> page){
        return null;
    }

    @Override
    public LeaveApprove selectOne(Integer leaveApproveId) {
        return null;
    }

    @Override
    public int deleteById(Integer leaveApproveId) {
    return 0;
    }

    @Override
    public int delete(LeaveApprove leaveApprove){
        return 0;
    }

    @Override
    public int insert(LeaveApprove leaveApprove) {
        return 0;
    }

    @Override
    public int updateById(LeaveApprove leaveApprove) {
        return 0;
    }

    @Override
    public int update(LeaveApprove leaveApprove) {
        return 0;
    }
}