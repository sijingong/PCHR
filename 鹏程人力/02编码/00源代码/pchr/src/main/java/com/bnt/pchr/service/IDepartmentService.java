package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.Department;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IDepartmentService {

   /**
    * 条件查询,返回对象列表
    * @param department
    * @return
    */
    List<Department> selectList(Department department);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<Department> selectPage(IPage<Department> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param depId
    * @return
    */
    Department selectOne(Integer depId);
    
   /**
    * 根据ID删除
    *
    * @param depId
    * @return
    */
    int deleteById(Integer depId);
    
   /**
    * 根据条件删除
    *
    * @param department
    * @return
    */
    int delete(Department department);

   /**
    * 添加
    *
    * @param  department
    * @return
    */
    int insert(Department department);
    
   /**
    * 根据ID修改
    *
    * @param department
    * @return
    */
    int updateById(Department department);

   /**
    * 根据条件修改
    *
    * @param department
    * @return
    */
    int update(Department department);
}