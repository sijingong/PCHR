package com.bnt.pchr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bnt.pchr.commons.vo.PageData;
import org.apache.ibatis.annotations.Mapper;

import com.bnt.pchr.entity.Memo;
/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
@Mapper
public interface MemoMapper extends BaseMapper<Memo> {
    /**
     * 根据分页条件查询备忘录
     * @param pageData
     * @return
     */
    PageData<Memo> selectPage(PageData<Memo> pageData);

}