package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.UserRole;
import com.bnt.pchr.mapper.UserRoleMapper;
import com.bnt.pchr.service.IUserRoleService;
import java.util.List;

@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    @Qualifier("userRoleMapper")
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> selectList(UserRole userRole){
        return null;
    }

    @Override
    public IPage<UserRole> selectPage(IPage<UserRole> page){
        return null;
    }

    @Override
    public UserRole selectOne(Integer userRoleId) {
        return null;
    }

    @Override
    public int deleteById(Integer userRoleId) {
    return 0;
    }

    @Override
    public int delete(UserRole userRole){
        return 0;
    }

    @Override
    public int insert(UserRole userRole) {
        return 0;
    }

    @Override
    public int updateById(UserRole userRole) {
        return 0;
    }

    @Override
    public int update(UserRole userRole) {
        return 0;
    }
}