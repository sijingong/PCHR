package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.SysDictItem;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface ISysDictItemService {

   /**
    * 条件查询,返回对象列表
    * @param sysDictItem
    * @return
    */
    List<SysDictItem> selectList(SysDictItem sysDictItem);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<SysDictItem> selectPage(IPage<SysDictItem> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param dictId
    * @return
    */
    SysDictItem selectOne(Integer dictId);
    
   /**
    * 根据ID删除
    *
    * @param dictId
    * @return
    */
    int deleteById(Integer dictId);
    
   /**
    * 根据条件删除
    *
    * @param sysDictItem
    * @return
    */
    int delete(SysDictItem sysDictItem);

   /**
    * 添加
    *
    * @param  sysDictItem
    * @return
    */
    int insert(SysDictItem sysDictItem);
    
   /**
    * 根据ID修改
    *
    * @param sysDictItem
    * @return
    */
    int updateById(SysDictItem sysDictItem);

   /**
    * 根据条件修改
    *
    * @param sysDictItem
    * @return
    */
    int update(SysDictItem sysDictItem);
}