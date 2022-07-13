package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.Role;
import com.bnt.pchr.mapper.RoleMapper;
import com.bnt.pchr.service.IRoleService;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    @Qualifier("roleMapper")
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectList(Role role){
        return null;
    }

    @Override
    public IPage<Role> selectPage(IPage<Role> page){
        return null;
    }

    @Override
    public Role selectOne(Integer roleId) {
        return null;
    }

    @Override
    public int deleteById(Integer roleId) {
    return 0;
    }

    @Override
    public int delete(Role role){
        return 0;
    }

    @Override
    public int insert(Role role) {
        return 0;
    }

    @Override
    public int updateById(Role role) {
        return 0;
    }

    @Override
    public int update(Role role) {
        return 0;
    }
}