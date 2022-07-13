package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.Job;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IJobService {

   /**
    * 条件查询,返回对象列表
    * @param job
    * @return
    */
    List<Job> selectList(Job job);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<Job> selectPage(IPage<Job> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param jobId
    * @return
    */
    Job selectOne(Integer jobId);
    
   /**
    * 根据ID删除
    *
    * @param jobId
    * @return
    */
    int deleteById(Integer jobId);
    
   /**
    * 根据条件删除
    *
    * @param job
    * @return
    */
    int delete(Job job);

   /**
    * 添加
    *
    * @param  job
    * @return
    */
    int insert(Job job);
    
   /**
    * 根据ID修改
    *
    * @param job
    * @return
    */
    int updateById(Job job);

   /**
    * 根据条件修改
    *
    * @param job
    * @return
    */
    int update(Job job);
}