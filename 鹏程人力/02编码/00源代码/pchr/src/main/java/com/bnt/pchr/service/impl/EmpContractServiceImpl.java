package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.EmpContract;
import com.bnt.pchr.mapper.EmpContractMapper;
import com.bnt.pchr.service.IEmpContractService;
import java.util.List;

@Service("empContractService")
public class EmpContractServiceImpl implements IEmpContractService {

    @Autowired
    @Qualifier("empContractMapper")
    private EmpContractMapper empContractMapper;

    @Override
    public List<EmpContract> selectList(EmpContract empContract){
        return null;
    }

    @Override
    public List<EmpContract> selectList() {
        return empContractMapper.selectList();
    }

    @Override
    public IPage<EmpContract> selectPage(IPage<EmpContract> page){
        return null;
    }

    @Override
    public EmpContract selectOne(Integer contractId) {
        return null;
    }

    @Override
    public int deleteById(Integer contractId) {
    return 0;
    }

    @Override
    public int delete(EmpContract empContract){
        return 0;
    }

    @Override
    public int insert(EmpContract empContract) {
        return 0;
    }

    @Override
    public int updateById(EmpContract empContract) {
        return 0;
    }

    @Override
    public int update(EmpContract empContract) {
        return 0;
    }
}