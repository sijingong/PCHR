package com.bnt.pchr.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.SysDictItem;
import com.bnt.pchr.mapper.SysDictItemMapper;
import com.bnt.pchr.service.ISysDictItemService;
import java.util.List;

@Service("sysDictItemService")
public class SysDictItemServiceImpl implements ISysDictItemService {

    @Autowired
    @Qualifier("sysDictItemMapper")
    private SysDictItemMapper sysDictItemMapper;

    @Override
    public List<SysDictItem> selectList(SysDictItem sysDictItem){
        return null;
    }

    @Override
    public IPage<SysDictItem> selectPage(IPage<SysDictItem> page){
        return null;
    }

    @Override
    public SysDictItem selectOne(Integer dictId) {
        return null;
    }

    @Override
    public int deleteById(Integer dictId) {
    return 0;
    }

    @Override
    public int delete(SysDictItem sysDictItem){
        return 0;
    }

    @Override
    public int insert(SysDictItem sysDictItem) {
        return 0;
    }

    @Override
    public int updateById(SysDictItem sysDictItem) {
        return 0;
    }

    @Override
    public int update(SysDictItem sysDictItem) {
        return 0;
    }
}