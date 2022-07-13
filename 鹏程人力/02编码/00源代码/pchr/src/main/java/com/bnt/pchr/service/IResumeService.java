package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.Resume;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IResumeService {

   /**
    * 条件查询,返回对象列表
    * @param resume
    * @return
    */
    List<Resume> selectList(Resume resume);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<Resume> selectPage(IPage<Resume> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param resumeId
    * @return
    */
    Resume selectOne(Integer resumeId);
    
   /**
    * 根据ID删除
    *
    * @param resumeId
    * @return
    */
    int deleteById(Integer resumeId);
    
   /**
    * 根据条件删除
    *
    * @param resume
    * @return
    */
    int delete(Resume resume);

   /**
    * 添加
    *
    * @param  resume
    * @return
    */
    int insert(Resume resume);
    
   /**
    * 根据ID修改
    *
    * @param resume
    * @return
    */
    int updateById(Resume resume);

   /**
    * 根据条件修改
    *
    * @param resume
    * @return
    */
    int update(Resume resume);
}