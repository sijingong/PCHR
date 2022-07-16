package com.bnt.pchr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.entity.DayAttend;
import org.apache.ibatis.annotations.Mapper;

/**
* Author bnt
* Date   2022-07-13 16:05:23
*/
@Mapper
public interface DayAttendMapper extends BaseMapper<DayAttend> {
    /**
     * 可以根据关键字、状态、时间间隔进行查询
     * @param page
     * @return
     */
    PageData<DayAttend> selectTimeBetWeen(PageData<DayAttend> page);

    /**
     * 判断是否已打卡
     * @param page
     * @return
     */
    PageData<DayAttend> ListAttended(PageData<DayAttend> page);

}