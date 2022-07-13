package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.Menu;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IMenuService {

   /**
    * 条件查询,返回对象列表
    * @param menu
    * @return
    */
    List<Menu> selectList(Menu menu);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<Menu> selectPage(IPage<Menu> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param menuId
    * @return
    */
    Menu selectOne(Integer menuId);
    
   /**
    * 根据ID删除
    *
    * @param menuId
    * @return
    */
    int deleteById(Integer menuId);
    
   /**
    * 根据条件删除
    *
    * @param menu
    * @return
    */
    int delete(Menu menu);

   /**
    * 添加
    *
    * @param  menu
    * @return
    */
    int insert(Menu menu);
    
   /**
    * 根据ID修改
    *
    * @param menu
    * @return
    */
    int updateById(Menu menu);

   /**
    * 根据条件修改
    *
    * @param menu
    * @return
    */
    int update(Menu menu);
}