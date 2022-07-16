package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.entity.Leave;


/**
 * Author bnt
 * Date   2022-07-13 16:05:23
 */
public interface ILeaveService {

    /**
     * 查询请假申请表列表
     * @param leave
     * @return
     */
    List<Leave> selectList(Leave leave);


    /**
     * 分页查询请假申请表
     *
     * @param pageData
     * @return
     */
    PageData<Leave> selectPage(PageData<Leave> pageData);

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    IPage<Leave> selectPage(IPage<Leave> page);

    /**
     * 根据ID查询返回一个对象
     *
     * @param leaveId
     * @return
     */
    Leave selectOne(Integer leaveId);

    /**
     * 根据ID删除
     *
     * @param leaveId
     * @return
     */
    int deleteById(Integer leaveId);

    /**
     * 根据条件删除
     *
     * @param leave
     * @return
     */
    int delete(Leave leave);

    /**
     * 添加
     *
     * @param  leave
     * @return
     */
    int insert(Leave leave);

    /**
     * 根据ID修改
     *
     * @param leave
     * @return
     */
    int updateById(Leave leave);

    /**
     * 根据条件修改
     *
     * @param leave
     * @return
     */
    int update(Leave leave);
}