package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.Emp;
import com.bnt.pchr.mapper.EmpMapper;
import com.bnt.pchr.service.IEmpService;
import java.util.List;

@Service("empService")
public class EmpServiceImpl implements IEmpService {

    @Autowired
    @Qualifier("empMapper")
    private EmpMapper empMapper;

    @Override
    public List<Emp> selectList(Emp emp){
        return null;
    }

    @Override
    public IPage<Emp> selectPage(IPage<Emp> page){
        return null;
    }

    @Override
    public Emp selectOne(Integer empId) {
        return null;
    }

    @Override
    public int deleteById(Integer empId) {
    return 0;
    }

    @Override
    public int delete(Emp emp){
        return 0;
    }

    @Override
    public int insert(Emp emp) {
        return 0;
    }

    @Override
    public int updateById(Emp emp) {
        return 0;
    }

    @Override
    public int update(Emp emp) {
        return 0;
    }
}