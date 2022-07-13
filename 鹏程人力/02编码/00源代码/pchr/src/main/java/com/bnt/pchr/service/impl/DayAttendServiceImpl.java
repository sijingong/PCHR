package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.DayAttend;
import com.bnt.pchr.mapper.DayAttendMapper;
import com.bnt.pchr.service.IDayAttendService;
import java.util.List;

@Service("dayAttendService")
public class DayAttendServiceImpl implements IDayAttendService {

    @Autowired
    @Qualifier("dayAttendMapper")
    private DayAttendMapper dayAttendMapper;

    @Override
    public List<DayAttend> selectList(DayAttend dayAttend){
        return null;
    }

    @Override
    public IPage<DayAttend> selectPage(IPage<DayAttend> page){
        return null;
    }

    @Override
    public DayAttend selectOne(Integer attendId) {
        return null;
    }

    @Override
    public int deleteById(Integer attendId) {
    return 0;
    }

    @Override
    public int delete(DayAttend dayAttend){
        return 0;
    }

    @Override
    public int insert(DayAttend dayAttend) {
        return 0;
    }

    @Override
    public int updateById(DayAttend dayAttend) {
        return 0;
    }

    @Override
    public int update(DayAttend dayAttend) {
        return 0;
    }
}