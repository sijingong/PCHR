package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
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
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<DayAttend> selectPage(IPage<DayAttend> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param attendId
    * @return
    */
    DayAttend selectOne(Integer attendId);
    
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
    * 添加
    *
    * @param  dayAttend
    * @return
    */
    int insert(DayAttend dayAttend);
    
   /**
    * 根据ID修改
    *
    * @param dayAttend
    * @return
    */
    int updateById(DayAttend dayAttend);

   /**
    * 根据条件修改
    *
    * @param dayAttend
    * @return
    */
    int update(DayAttend dayAttend);
}