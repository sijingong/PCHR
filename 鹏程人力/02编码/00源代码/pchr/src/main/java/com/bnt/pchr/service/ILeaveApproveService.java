package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.LeaveApprove;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface ILeaveApproveService {

   /**
    * 条件查询,返回对象列表
    * @param leaveApprove
    * @return
    */
    List<LeaveApprove> selectList(LeaveApprove leaveApprove);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<LeaveApprove> selectPage(IPage<LeaveApprove> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param leaveApproveId
    * @return
    */
    LeaveApprove selectOne(Integer leaveApproveId);
    
   /**
    * 根据ID删除
    *
    * @param leaveApproveId
    * @return
    */
    int deleteById(Integer leaveApproveId);
    
   /**
    * 根据条件删除
    *
    * @param leaveApprove
    * @return
    */
    int delete(LeaveApprove leaveApprove);

   /**
    * 添加
    *
    * @param  leaveApprove
    * @return
    */
    int insert(LeaveApprove leaveApprove);
    
   /**
    * 根据ID修改
    *
    * @param leaveApprove
    * @return
    */
    int updateById(LeaveApprove leaveApprove);

   /**
    * 根据条件修改
    *
    * @param leaveApprove
    * @return
    */
    int update(LeaveApprove leaveApprove);
}