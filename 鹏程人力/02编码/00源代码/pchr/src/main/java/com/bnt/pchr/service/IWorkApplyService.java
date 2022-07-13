package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.WorkApply;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IWorkApplyService {

   /**
    * 条件查询,返回对象列表
    * @param workApply
    * @return
    */
    List<WorkApply> selectList(WorkApply workApply);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<WorkApply> selectPage(IPage<WorkApply> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param applyId
    * @return
    */
    WorkApply selectOne(Integer applyId);
    
   /**
    * 根据ID删除
    *
    * @param applyId
    * @return
    */
    int deleteById(Integer applyId);
    
   /**
    * 根据条件删除
    *
    * @param workApply
    * @return
    */
    int delete(WorkApply workApply);

   /**
    * 添加
    *
    * @param  workApply
    * @return
    */
    int insert(WorkApply workApply);
    
   /**
    * 根据ID修改
    *
    * @param workApply
    * @return
    */
    int updateById(WorkApply workApply);

   /**
    * 根据条件修改
    *
    * @param workApply
    * @return
    */
    int update(WorkApply workApply);
}