package com.bnt.pchr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.commons.vo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.Memo;
import com.bnt.pchr.mapper.MemoMapper;
import com.bnt.pchr.service.IMemoService;

import java.util.Date;
import java.util.List;

@Service("memoService")
public class MemoServiceImpl implements IMemoService {

    @Autowired
    @Qualifier("memoMapper")
    private MemoMapper memoMapper;

    @Override
    public List<Memo> selectList(Memo memo) {
        return null;
    }

    @Override
    public IPage<Memo> selectPage(IPage<Memo> page) {
        return null;
    }

    @Override
    public PageData<Memo> selectPage(PageData<Memo> pageData) {
        return memoMapper.selectPage(pageData);
    }

    @Override
    public Memo selectOne(Integer memoId) {
        return memoMapper.selectById(memoId);
    }

    @Override
    public int deleteById(Integer memoId) {
        return memoMapper.deleteById(memoId);
    }

    @Override
    public int delete(Memo memo) {
        return 0;
    }

    @Override
    public int insert(Memo memo) {
        memo.setCreateTime(new Date());
        return memoMapper.insert(memo);
    }

    @Override
    public ResponseData updateById(Memo memo) {
        QueryWrapper<Memo> qw=new QueryWrapper<>();
        qw.eq("memo_no",memo.getMemoNo());
        long count=memoMapper.selectCount(qw);
        if(count>0)
        {
            return ResponseData.FAIL(6002001,"公告编号已存在");
        }
        memo.setModifyTime(new Date());
        int rows=memoMapper.updateById(memo);
        return ResponseData.SUCCESS(rows);
    }

    @Override
    public int update(Memo memo) {
        return 0;
    }
}