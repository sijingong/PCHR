package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.ResumeTemplate;
import com.bnt.pchr.mapper.ResumeTemplateMapper;
import com.bnt.pchr.service.IResumeTemplateService;
import java.util.List;

@Service("resumeTemplateService")
public class ResumeTemplateServiceImpl implements IResumeTemplateService {

    @Autowired
    @Qualifier("resumeTemplateMapper")
    private ResumeTemplateMapper resumeTemplateMapper;

    @Override
    public List<ResumeTemplate> selectList(ResumeTemplate resumeTemplate){
        return null;
    }

    @Override
    public IPage<ResumeTemplate> selectPage(IPage<ResumeTemplate> page){
        return null;
    }

    @Override
    public ResumeTemplate selectOne(Integer tempId) {
        return null;
    }

    @Override
    public int deleteById(Integer tempId) {
    return 0;
    }

    @Override
    public int delete(ResumeTemplate resumeTemplate){
        return 0;
    }

    @Override
    public int insert(ResumeTemplate resumeTemplate) {
        return 0;
    }

    @Override
    public int updateById(ResumeTemplate resumeTemplate) {
        return 0;
    }

    @Override
    public int update(ResumeTemplate resumeTemplate) {
        return 0;
    }
}