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

    @Override
    public List<Department> selectList(Integer depState){
        QueryWrapper<Department> qw = new QueryWrapper<>();
        if(depState!=null&&depState!=0){
            qw.eq("dep_state",depState);
        }
        return departmentMapper.selectList(qw);
    }

    @Override
    public Department selectOne(Integer depId) {
        QueryWrapper<Department> qw = new QueryWrapper<>();
        qw.eq("dep_id",depId);
        return departmentMapper.selectOne(qw);
    }

    @Override
    public int deleteById(Integer depId) {
        return departmentMapper.deleteById(depId);
    }

    @Override
    public int insert(Department department) {
        department.setCreateTime(new Date());
        return departmentMapper.insert(department);
    }

    @Override
    public int updateById(Department department) {
        department.setModifyTime(new Date());
        return departmentMapper.updateById(department);
    }

    @Override
    public int check(String depNo,Integer depId) {
        QueryWrapper<Department> qw = new QueryWrapper<>();
        qw.eq("dep_no",depNo);
        qw.ne("dep_id",depId);
        return departmentMapper.selectCount(qw).intValue();
    }
}