package com.bnt.pchr.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.entity.WorkApply;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IWorkApplyService {

   /**
    * 条件查询,返回对象列表,根据申请状态查询审批列表
    * @param workApply
    * @return
    */
    List<WorkApply> selectList(WorkApply workApply);
    
   /**
    * 分页查询根据
    *
    * @param page
    * @return
    */
    IPage<WorkApply> selectPage(PageData<WorkApply> page);
    
   /**
    * 根据ID查询返回一个申请记录
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
    * 添加工作申请
    *
    * @param  workApply
    * @return
    */
    int insert(WorkApply workApply);
    
   /**
    * 根据ID修改——取消审批申请
    *
    * @param workApply
    * @return
    */
    int updateById(WorkApply workApply);

   /**
    * 根据条件修改——处理审批申请
    *
    * @param workApply
    * @return
    */
    int update(WorkApply workApply);
}