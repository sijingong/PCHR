package com.bnt.pchr.service;

import java.util.List;
import com.bnt.pchr.entity.Job;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IJobService {

   /**
    * 查询,返回对象列表
    * @return
    */
    List<Job> selectList();
    
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
     * 查重
     * @param jobNo
     * @return
     */
    int check(String jobNo);
}