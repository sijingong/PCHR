package com.bnt.pchr.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bnt.pchr.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.Notice;
import com.bnt.pchr.mapper.NoticeMapper;
import com.bnt.pchr.service.INoticeService;
import java.util.Date;
import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    @Qualifier("noticeMapper")
    private NoticeMapper noticeMapper;
    @Autowired
    @Qualifier("empMapper")
    private EmpMapper empMapper;

    @Override
    public List<Notice> selectList(Notice notice){
        return null;
    }

    @Override
    public IPage<Notice> selectPage(IPage<Notice> page){
        return null;
    }

    @Override
    public Notice selectOne(Integer noticeId) {
        return null;
    }

    @Override
    public int deleteById(Integer noticeId) {
    return noticeMapper.deleteById(noticeId);
    }

    @Override
    public int delete(Notice notice){
        return 0;
    }

    @Override
    public int insert(Notice notice) {
        notice.setReleaseTime(new Date());
        return noticeMapper.insert(notice);
    }

    @Override
    public int updateById(Notice notice) {
        return noticeMapper.updateById(notice);
    }

    @Override
    public int update(Notice notice) {
        return 0;
    }

}