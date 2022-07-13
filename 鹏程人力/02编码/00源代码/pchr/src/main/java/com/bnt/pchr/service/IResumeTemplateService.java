package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.ResumeTemplate;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IResumeTemplateService {

   /**
    * 条件查询,返回对象列表
    * @param resumeTemplate
    * @return
    */
    List<ResumeTemplate> selectList(ResumeTemplate resumeTemplate);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<ResumeTemplate> selectPage(IPage<ResumeTemplate> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param tempId
    * @return
    */
    ResumeTemplate selectOne(Integer tempId);
    
   /**
    * 根据ID删除
    *
    * @param tempId
    * @return
    */
    int deleteById(Integer tempId);
    
   /**
    * 根据条件删除
    *
    * @param resumeTemplate
    * @return
    */
    int delete(ResumeTemplate resumeTemplate);

   /**
    * 添加
    *
    * @param  resumeTemplate
    * @return
    */
    int insert(ResumeTemplate resumeTemplate);
    
   /**
    * 根据ID修改
    *
    * @param resumeTemplate
    * @return
    */
    int updateById(ResumeTemplate resumeTemplate);

   /**
    * 根据条件修改
    *
    * @param resumeTemplate
    * @return
    */
    int update(ResumeTemplate resumeTemplate);
}