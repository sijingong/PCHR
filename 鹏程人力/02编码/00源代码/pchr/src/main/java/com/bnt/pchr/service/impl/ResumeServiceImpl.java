package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.Resume;
import com.bnt.pchr.mapper.ResumeMapper;
import com.bnt.pchr.service.IResumeService;
import java.util.List;

@Service("resumeService")
public class ResumeServiceImpl implements IResumeService {

    @Autowired
    @Qualifier("resumeMapper")
    private ResumeMapper resumeMapper;

    @Override
    public List<Resume> selectList(Resume resume){
        return null;
    }

    @Override
    public IPage<Resume> selectPage(IPage<Resume> page){
        return null;
    }

    @Override
    public Resume selectOne(Integer resumeId) {
        return null;
    }

    @Override
    public int deleteById(Integer resumeId) {
    return 0;
    }

    @Override
    public int delete(Resume resume){
        return 0;
    }

    @Override
    public int insert(Resume resume) {
        return 0;
    }

    @Override
    public int updateById(Resume resume) {
        return 0;
    }

    @Override
    public int update(Resume resume) {
        return 0;
    }
}