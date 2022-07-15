package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.entity.Emp;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IEmpService {
   /**
    * 分页查询
    *
    * @param pageData
    * @return
    */
   PageData<Emp> selectPage(PageData<Emp> pageData);

    /**
     * 根据员工编号查询返回一个对象
     *
     * @param empNo
     * @return
     */
    Emp selectByEmpNo(String empNo);

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
     * 查重
     * @param empNo
     * @param idCard
     * @return
     */
    int check(String empNo,String idCard);
}