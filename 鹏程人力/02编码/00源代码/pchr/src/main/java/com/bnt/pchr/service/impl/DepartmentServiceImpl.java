package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.Department;
import com.bnt.pchr.mapper.DepartmentMapper;
import com.bnt.pchr.service.IDepartmentService;

import java.util.Date;
import java.util.List;
@Service("departmentService")
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    @Qualifier("departmentMapper")
    private DepartmentMapper departmentMapper;

    /**
     * 查询部门列表
     * @param depState
     * @return
     */
    @Override
    public List<Department> selectList(Integer depState){
        QueryWrapper<Department> qw = new QueryWrapper<>();
        if(depState!=null&&depState!=0){
            qw.eq("dep_state",depState);
        }
        return departmentMapper.selectList(qw);
    }

    /**
     * 根据id查询
     * @param depId
     * @return
     */
    @Override
    public Department selectOne(Integer depId) {
        QueryWrapper<Department> qw = new QueryWrapper<>();
        qw.eq("dep_id",depId);
        return departmentMapper.selectOne(qw);
    }

    /**
     * 根据id删除
     * @param depId
     * @return
     */
    @Override
    public int deleteById(Integer depId) {
        return departmentMapper.deleteById(depId);
    }

    /**
     * 添加部门
     * @param  department
     * @return
     */
    @Override
    public int insert(Department department) {
        department.setCreateTime(new Date());
        return departmentMapper.insert(department);
    }

    /**
     * 修改部门
     * @param department
     * @return
     */
    @Override
    public int updateById(Department department) {
        department.setModifyTime(new Date());
        return departmentMapper.updateById(department);
    }

    /**
     * 查重
     * @param depNo
     * @param depId
     * @return
     */
    @Override
    public int check(String depNo,Integer depId) {
        QueryWrapper<Department> qw = new QueryWrapper<>();
        qw.eq("dep_no",depNo);
        qw.ne("dep_id",depId);
        return departmentMapper.selectCount(qw).intValue();
    }
}