package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.Department;
import com.bnt.pchr.mapper.DepartmentMapper;
import com.bnt.pchr.service.IDepartmentService;
import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    @Qualifier("departmentMapper")
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectList(Department department){
        return null;
    }

    @Override
    public IPage<Department> selectPage(IPage<Department> page){
        return null;
    }

    @Override
    public Department selectOne(Integer depId) {
        return null;
    }

    @Override
    public int deleteById(Integer depId) {
    return 0;
    }

    @Override
    public int delete(Department department){
        return 0;
    }

    @Override
    public int insert(Department department) {
        return 0;
    }

    @Override
    public int updateById(Department department) {
        return 0;
    }

    @Override
    public int update(Department department) {
        return 0;
    }
}