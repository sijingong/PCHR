package com.bnt.pchr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bnt.pchr.commons.vo.PageData;
import org.apache.ibatis.annotations.Mapper;

import com.bnt.pchr.entity.Emp;
/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
    PageData<Emp> selectPage(PageData<Emp> pageData);
    /**
     * 查询员工简历
     * @param pageData
     * @return
     */
    PageData<Emp> selectEmpResume(PageData<Emp> pageData);
}