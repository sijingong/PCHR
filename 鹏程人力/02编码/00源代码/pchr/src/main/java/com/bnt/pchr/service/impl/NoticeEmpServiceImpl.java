package com.bnt.pchr.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.NoticeEmp;
import com.bnt.pchr.mapper.NoticeEmpMapper;
import com.bnt.pchr.service.INoticeEmpService;
import java.util.List;

@Service("noticeEmpService")
public class NoticeEmpServiceImpl implements INoticeEmpService {

    @Autowired
    @Qualifier("noticeEmpMapper")
    private NoticeEmpMapper noticeEmpMapper;

    @Override
    public List<NoticeEmp> selectList(NoticeEmp noticeEmp){
        return null;
    }

    @Override
    public IPage<NoticeEmp> selectPage(IPage<NoticeEmp> page){
        return null;
    }

    @Override
    public NoticeEmp selectOne(Integer noticeEmpId) {
        return null;
    }

    @Override
    public int deleteById(Integer noticeEmpId) {
    return 0;
    }

    @Override
    public int delete(NoticeEmp noticeEmp){
        return 0;
    }

    @Override
    public int insert(NoticeEmp noticeEmp) {
        return 0;
    }

    @Override
    public int updateById(NoticeEmp noticeEmp) {
        return 0;
    }

    @Override
    public int update(NoticeEmp noticeEmp) {
        return 0;
    }
}