package com.bnt.pchr.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.Menu;
import com.bnt.pchr.mapper.MenuMapper;
import com.bnt.pchr.service.IMenuService;
import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {

    @Autowired
    @Qualifier("menuMapper")
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectList(Menu menu){
        return null;
    }

    @Override
    public IPage<Menu> selectPage(IPage<Menu> page){
        return null;
    }

    @Override
    public Menu selectOne(Integer menuId) {
        return null;
    }

    @Override
    public int deleteById(Integer menuId) {
    return 0;
    }

    @Override
    public int delete(Menu menu){
        return 0;
    }

    @Override
    public int insert(Menu menu) {
        return 0;
    }

    @Override
    public int updateById(Menu menu) {
        return 0;
    }

    @Override
    public int update(Menu menu) {
        return 0;
    }
}