package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.WorkApply;
import com.bnt.pchr.mapper.WorkApplyMapper;
import com.bnt.pchr.service.IWorkApplyService;
import java.util.List;

@Service("workApplyService")
public class WorkApplyServiceImpl implements IWorkApplyService {

    @Autowired
    @Qualifier("workApplyMapper")
    private WorkApplyMapper workApplyMapper;

    @Override
    public List<WorkApply> selectList(WorkApply workApply){
        return null;
    }

    @Override
    public IPage<WorkApply> selectPage(IPage<WorkApply> page){
        return null;
    }

    @Override
    public WorkApply selectOne(Integer applyId) {
        return null;
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
        return 0;
    }

    @Override
    public int updateById(WorkApply workApply) {
        return 0;
    }

    @Override
    public int update(WorkApply workApply) {
        return 0;
    }
}