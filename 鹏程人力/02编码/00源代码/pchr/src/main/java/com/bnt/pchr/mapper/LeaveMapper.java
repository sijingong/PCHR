package com.bnt.pchr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bnt.pchr.commons.vo.PageData;
import org.apache.ibatis.annotations.Mapper;

import com.bnt.pchr.entity.Leave;
/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
@Mapper
public interface LeaveMapper extends BaseMapper<Leave> {
    /**
     * 根据条件查询请假申请表
     * @param pageData
     * @return
     */
    PageData<Leave> selectPage(PageData<Leave> pageData);
}