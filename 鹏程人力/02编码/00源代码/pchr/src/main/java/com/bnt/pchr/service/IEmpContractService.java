package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.bnt.pchr.entity.EmpContract;


/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
public interface IEmpContractService {

   /**
    * 条件查询,返回对象列表
    * @param empContract
    * @return
    */
    List<EmpContract> selectList(EmpContract empContract);
    
   /**
    * 分页查询
    *
    * @param page
    * @return
    */
    IPage<EmpContract> selectPage(IPage<EmpContract> page);
    
   /**
    * 根据ID查询返回一个对象
    *
    * @param contractId
    * @return
    */
    EmpContract selectOne(Integer contractId);
    
   /**
    * 根据ID删除
    *
    * @param contractId
    * @return
    */
    int deleteById(Integer contractId);
    
   /**
    * 根据条件删除
    *
    * @param empContract
    * @return
    */
    int delete(EmpContract empContract);

   /**
    * 添加
    *
    * @param  empContract
    * @return
    */
    int insert(EmpContract empContract);
    
   /**
    * 根据ID修改
    *
    * @param empContract
    * @return
    */
    int updateById(EmpContract empContract);

   /**
    * 根据条件修改
    *
    * @param empContract
    * @return
    */
    int update(EmpContract empContract);
}