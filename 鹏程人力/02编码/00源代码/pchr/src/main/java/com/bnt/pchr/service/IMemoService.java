package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.Memo;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IMemoService {

   /**
    * 条件查询,返回对象列表
    * @param memo
    * @return
    */
    List<Memo> selectList(Memo memo);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<Memo> selectPage(IPage<Memo> page);

    /**
     * 分页查询
     *
     * @param pageData
     * @return
     */
    PageData<Memo> selectPage(PageData<Memo> pageData);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param memoId
    * @return
    */
    Memo selectOne(Integer memoId);
    
   /**
    * 根据ID删除
    *
    * @param memoId
    * @return
    */
    int deleteById(Integer memoId);
    
   /**
    * 根据条件删除
    *
    * @param memo
    * @return
    */
    int delete(Memo memo);

   /**
    * 添加
    *
    * @param  memo
    * @return
    */
    int insert(Memo memo);
    
   /**
    * 根据ID修改
    *
    * @param memo
    * @return
    */
   ResponseData updateById(Memo memo);

   /**
    * 根据条件修改
    *
    * @param memo
    * @return
    */
    int update(Memo memo);
}