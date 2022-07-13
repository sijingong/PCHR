package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.Job;
import com.bnt.pchr.mapper.JobMapper;
import com.bnt.pchr.service.IJobService;
import java.util.List;

@Service("jobService")
public class JobServiceImpl implements IJobService {

    @Autowired
    @Qualifier("jobMapper")
    private JobMapper jobMapper;

    @Override
    public List<Job> selectList(Job job){
        return null;
    }

    @Override
    public IPage<Job> selectPage(IPage<Job> page){
        return null;
    }

    @Override
    public Job selectOne(Integer jobId) {
        return null;
    }

    @Override
    public int deleteById(Integer jobId) {
    return 0;
    }

    @Override
    public int delete(Job job){
        return 0;
    }

    @Override
    public int insert(Job job) {
        return 0;
    }

    @Override
    public int updateById(Job job) {
        return 0;
    }

    @Override
    public int update(Job job) {
        return 0;
    }
}