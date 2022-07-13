package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.Leave;
import com.bnt.pchr.mapper.LeaveMapper;
import com.bnt.pchr.service.ILeaveService;
import java.util.List;

@Service("leaveService")
public class LeaveServiceImpl implements ILeaveService {

    @Autowired
    @Qualifier("leaveMapper")
    private LeaveMapper leaveMapper;

    @Override
    public List<Leave> selectList(Leave leave){
        return null;
    }

    @Override
    public IPage<Leave> selectPage(IPage<Leave> page){
        return null;
    }

    @Override
    public Leave selectOne(Integer leaveId) {
        return null;
    }

    @Override
    public int deleteById(Integer leaveId) {
    return 0;
    }

    @Override
    public int delete(Leave leave){
        return 0;
    }

    @Override
    public int insert(Leave leave) {
        return 0;
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