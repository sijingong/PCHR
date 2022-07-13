package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.Role;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IRoleService {

   /**
    * 条件查询,返回对象列表
    * @param role
    * @return
    */
    List<Role> selectList(Role role);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<Role> selectPage(IPage<Role> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param roleId
    * @return
    */
    Role selectOne(Integer roleId);
    
   /**
    * 根据ID删除
    *
    * @param roleId
    * @return
    */
    int deleteById(Integer roleId);
    
   /**
    * 根据条件删除
    *
    * @param role
    * @return
    */
    int delete(Role role);

   /**
    * 添加
    *
    * @param  role
    * @return
    */
    int insert(Role role);
    
   /**
    * 根据ID修改
    *
    * @param role
    * @return
    */
    int updateById(Role role);

   /**
    * 根据条件修改
    *
    * @param role
    * @return
    */
    int update(Role role);
}