package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.Emp;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IEmpService {

   /**
    * 条件查询,返回对象列表
    * @param emp
    * @return
    */
    List<Emp> selectList(Emp emp);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<Emp> selectPage(IPage<Emp> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param empId
    * @return
    */
    Emp selectOne(Integer empId);
    
   /**
    * 根据ID删除
    *
    * @param empId
    * @return
    */
    int deleteById(Integer empId);
    
   /**
    * 根据条件删除
    *
    * @param emp
    * @return
    */
    int delete(Emp emp);

   /**
    * 添加
    *
    * @param  emp
    * @return
    */
    int insert(Emp emp);
    
   /**
    * 根据ID修改
    *
    * @param emp
    * @return
    */
    int updateById(Emp emp);

   /**
    * 根据条件修改
    *
    * @param emp
    * @return
    */
    int update(Emp emp);
}