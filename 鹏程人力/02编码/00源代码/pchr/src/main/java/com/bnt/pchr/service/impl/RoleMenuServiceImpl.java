package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.RoleMenu;
import com.bnt.pchr.mapper.RoleMenuMapper;
import com.bnt.pchr.service.IRoleMenuService;
import java.util.List;

@Service("roleMenuService")
public class RoleMenuServiceImpl implements IRoleMenuService {

    @Autowired
    @Qualifier("roleMenuMapper")
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<RoleMenu> selectList(RoleMenu roleMenu){
        return null;
    }

    @Override
    public IPage<RoleMenu> selectPage(IPage<RoleMenu> page){
        return null;
    }

    @Override
    public RoleMenu selectOne(Integer roleMenuId) {
        return null;
    }

    @Override
    public int deleteById(Integer roleMenuId) {
    return 0;
    }

    @Override
    public int delete(RoleMenu roleMenu){
        return 0;
    }

    @Override
    public int insert(RoleMenu roleMenu) {
        return 0;
    }

    @Override
    public int updateById(RoleMenu roleMenu) {
        return 0;
    }

    @Override
    public int update(RoleMenu roleMenu) {
        return 0;
    }
}