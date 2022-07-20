package com.bnt.pchr.service;

import java.util.List;

import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.entity.DayAttend;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IDayAttendService {

   /**
    * 条件查询,返回对象列表
    * @param dayAttend
    * @return
    */
    List<DayAttend> selectList(DayAttend dayAttend);
    
   /**
    * 根据时间段、关键字、状态进行分页查询
    *
    * @param page
    * @return
    */
    PageData<DayAttend> selectPage(PageData<DayAttend> page);

    /**
     * 根据员工id和打卡时间获取打卡状态
     * @param empId
     * @param times
     * @return
     */
    int selectOne(int empId,String times);

    /**
     * 查询已经打卡的列表
     * @param dayAttend
     * @return
     */
    List<DayAttend> isAttended(DayAttend dayAttend);
   /**
    * 根据ID删除
    *
    * @param attendId
    * @return
    */
    int deleteById(Integer attendId);
    
   /**
    * 根据条件删除
    *
    * @param dayAttend
    * @return
    */
    int delete(DayAttend dayAttend);

   /**
    * 添加上下班打卡记录
    *
    * @param  dayAttend
    * @return
    */
    int insert(DayAttend dayAttend);

    /**
     * 添加补卡记录
     * @param dayAttend
     * @return
     */
    int compensateCard(DayAttend dayAttend);
    
   /**
    * 根据ID修改
    *
    * @param dayAttend
    * @return
    */
    int updateById(DayAttend dayAttend);

   /**
    * 根据条件修改(状态)
    *
    * @param dayAttend
    * @return
    */
    int update(DayAttend dayAttend);
}