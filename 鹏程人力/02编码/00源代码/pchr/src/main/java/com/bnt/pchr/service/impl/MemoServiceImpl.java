package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.Memo;
import com.bnt.pchr.mapper.MemoMapper;
import com.bnt.pchr.service.IMemoService;
import java.util.List;

@Service("memoService")
public class MemoServiceImpl implements IMemoService {

    @Autowired
    @Qualifier("memoMapper")
    private MemoMapper memoMapper;

    @Override
    public List<Memo> selectList(Memo memo){
        return null;
    }

    @Override
    public IPage<Memo> selectPage(IPage<Memo> page){
        return null;
    }

    @Override
    public Memo selectOne(Integer memoId) {
        return null;
    }

    @Override
    public int deleteById(Integer memoId) {
    return 0;
    }

    @Override
    public int delete(Memo memo){
        return 0;
    }

    @Override
    public int insert(Memo memo) {
        return 0;
    }

    @Override
    public int updateById(Memo memo) {
        return 0;
    }

    @Override
    public int update(Memo memo) {
        return 0;
    }
}