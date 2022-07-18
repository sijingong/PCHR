package com.bnt.pchr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bnt.pchr.commons.vo.PageData;
import org.apache.ibatis.annotations.Mapper;

import com.bnt.pchr.entity.WorkApply;

import java.util.List;

/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
@Mapper
public interface WorkApplyMapper extends BaseMapper<WorkApply> {
    /**
     * 查询员工加班申请列表
     * @param page
     * @return
     */
    PageData<WorkApply> selectApplyList(PageData<WorkApply> page);
    List<WorkApply> selectByCondition(WorkApply workApply);
}