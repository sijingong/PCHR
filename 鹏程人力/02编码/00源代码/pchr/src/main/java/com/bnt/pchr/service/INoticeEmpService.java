package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.NoticeEmp;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface INoticeEmpService {

   /**
    * 条件查询,返回对象列表
    * @param noticeEmp
    * @return
    */
    List<NoticeEmp> selectList(NoticeEmp noticeEmp);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<NoticeEmp> selectPage(IPage<NoticeEmp> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param noticeEmpId
    * @return
    */
    NoticeEmp selectOne(Integer noticeEmpId);
    
   /**
    * 根据ID删除
    *
    * @param noticeEmpId
    * @return
    */
    int deleteById(Integer noticeEmpId);
    
   /**
    * 根据条件删除
    *
    * @param noticeEmp
    * @return
    */
    int delete(NoticeEmp noticeEmp);

   /**
    * 添加
    *
    * @param  noticeEmp
    * @return
    */
    int insert(NoticeEmp noticeEmp);
    
   /**
    * 根据ID修改
    *
    * @param noticeEmp
    * @return
    */
    int updateById(NoticeEmp noticeEmp);

   /**
    * 根据条件修改
    *
    * @param noticeEmp
    * @return
    */
    int update(NoticeEmp noticeEmp);
}