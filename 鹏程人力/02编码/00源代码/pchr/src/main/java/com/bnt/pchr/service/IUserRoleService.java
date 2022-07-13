package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.UserRole;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IUserRoleService {

   /**
    * 条件查询,返回对象列表
    * @param userRole
    * @return
    */
    List<UserRole> selectList(UserRole userRole);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<UserRole> selectPage(IPage<UserRole> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param userRoleId
    * @return
    */
    UserRole selectOne(Integer userRoleId);
    
   /**
    * 根据ID删除
    *
    * @param userRoleId
    * @return
    */
    int deleteById(Integer userRoleId);
    
   /**
    * 根据条件删除
    *
    * @param userRole
    * @return
    */
    int delete(UserRole userRole);

   /**
    * 添加
    *
    * @param  userRole
    * @return
    */
    int insert(UserRole userRole);
    
   /**
    * 根据ID修改
    *
    * @param userRole
    * @return
    */
    int updateById(UserRole userRole);

   /**
    * 根据条件修改
    *
    * @param userRole
    * @return
    */
    int update(UserRole userRole);
}