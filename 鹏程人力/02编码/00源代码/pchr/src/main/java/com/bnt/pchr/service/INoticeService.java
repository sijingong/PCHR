package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.Notice;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface INoticeService {

   /**
    * 条件查询,返回对象列表
    * @param notice
    * @return
    */
    List<Notice> selectList(Notice notice);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<Notice> selectPage(IPage<Notice> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param noticeId
    * @return
    */
    Notice selectOne(Integer noticeId);
    
   /**
    * 根据ID删除
    *
    * @param noticeId
    * @return
    */
    int deleteById(Integer noticeId);
    
   /**
    * 根据条件删除
    *
    * @param notice
    * @return
    */
    int delete(Notice notice);

   /**
    * 添加
    *
    * @param  notice
    * @return
    */
    int insert(Notice notice);
    
   /**
    * 根据ID修改
    *
    * @param notice
    * @return
    */
    int updateById(Notice notice);

   /**
    * 根据条件修改
    *
    * @param notice
    * @return
    */
    int update(Notice notice);
}