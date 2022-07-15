package com.bnt.pchr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public List<Job> selectList(){
        QueryWrapper<Job> qw = new QueryWrapper<>();
        return jobMapper.selectList(qw);
    }

    @Override
    public Job selectOne(Integer jobId) {
        QueryWrapper<Job> qw = new QueryWrapper<>();
        qw.eq("job_id",jobId);
        return jobMapper.selectOne(qw);
    }

    @Override
    public int deleteById(Integer jobId) {
    return jobMapper.deleteById(jobId);
    }

    @Override
    public int insert(Job job) {
        return jobMapper.insert(job);
    }

    @Override
    public int updateById(Job job) {
        return jobMapper.updateById(job);
    }

    @Override
    public int check(String jobNo) {
        QueryWrapper<Job> qw = new QueryWrapper<>();
        qw.eq("job_no",jobNo);
        return jobMapper.selectCount(qw).intValue();
    }
}