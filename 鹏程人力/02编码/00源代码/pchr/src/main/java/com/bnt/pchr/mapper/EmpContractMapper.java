package com.bnt.pchr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import com.bnt.pchr.entity.EmpContract;

import java.util.List;

/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
@Mapper
public interface EmpContractMapper extends BaseMapper<EmpContract> {

   List<EmpContract> selectList();
}