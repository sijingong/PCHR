package com.bnt.pchr.service;

import java.util.List;
import com.bnt.pchr.entity.Department;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IDepartmentService {
   /**
    * 查询,返回对象列表
    * @return
    */
    List<Department> selectList(Integer depState);
    
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
     * 查重
     * @param depNo
     * @return
     */
    int check(String depNo,Integer depId);
}