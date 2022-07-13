package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.RoleMenu;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IRoleMenuService {

   /**
    * 条件查询,返回对象列表
    * @param roleMenu
    * @return
    */
    List<RoleMenu> selectList(RoleMenu roleMenu);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<RoleMenu> selectPage(IPage<RoleMenu> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param roleMenuId
    * @return
    */
    RoleMenu selectOne(Integer roleMenuId);
    
   /**
    * 根据ID删除
    *
    * @param roleMenuId
    * @return
    */
    int deleteById(Integer roleMenuId);
    
   /**
    * 根据条件删除
    *
    * @param roleMenu
    * @return
    */
    int delete(RoleMenu roleMenu);

   /**
    * 添加
    *
    * @param  roleMenu
    * @return
    */
    int insert(RoleMenu roleMenu);
    
   /**
    * 根据ID修改
    *
    * @param roleMenu
    * @return
    */
    int updateById(RoleMenu roleMenu);

   /**
    * 根据条件修改
    *
    * @param roleMenu
    * @return
    */
    int update(RoleMenu roleMenu);
}