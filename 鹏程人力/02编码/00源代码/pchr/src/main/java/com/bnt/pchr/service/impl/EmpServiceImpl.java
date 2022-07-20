package com.bnt.pchr.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bnt.pchr.commons.vo.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.Emp;
import com.bnt.pchr.mapper.EmpMapper;
import com.bnt.pchr.service.IEmpService;

import java.util.Date;
import java.util.List;

@Service("empService")
public class EmpServiceImpl implements IEmpService {

    @Autowired
    @Qualifier("empMapper")
    private EmpMapper empMapper;

    /**
     * 分页查询
     * 以员工名、员工编号、手机号、备注、家庭住址、邮箱、qq、微信、座位号、身份证号为关键字
     * 根据部门、职位、用户状态、性别、工资上下限查询用户
     * @param pageData
     * @return
     */
    @Override
    public PageData<Emp> selectPage(PageData<Emp> pageData){
        String tag = (String) pageData.getCriteriaMap().get("tag");
        if (tag != null && "resume".equals(tag)) {
            //分页查询员工简历
            return empMapper.selectEmpResume(pageData);
        } else {
            return empMapper.selectPage(pageData);
        }
    }

    /**
     * 查询员工列表
     * @return
     */
    @Override
    public List<Emp> selectList(){
        return empMapper.selectList(new QueryWrapper<Emp>());
    }

    /**
     * 根据编号查询员工
     * @param empNo
     * @return
     */
    @Override
    public Emp selectByEmpNo(String empNo) {
        QueryWrapper<Emp> qw = new QueryWrapper<>();
        qw.eq("emp_no",empNo);
        return empMapper.selectOne(qw);
    }

    /**
     * 根据id查询员工
     * @param empId
     * @return
     */
    @Override
    public Emp selectOne(Integer empId) {
        QueryWrapper<Emp> qw = new QueryWrapper<>();
        qw.eq("emp_id",empId);
        return empMapper.selectOne(qw);
    }

    /**
     * 根据id删除员工
     * @param empId
     * @return
     */
    @Override
    public int deleteById(Integer empId) {
    return empMapper.deleteById(empId);
    }

    /**
     * 创建员工
     * @param  emp
     * @return
     */
    @Override
    public int insert(Emp emp) {
        emp.setCreateTime(new Date());
        return empMapper.insert(emp);
    }

    /**
     * 修改员工
     * @param emp
     * @return
     */
    @Override
    public int updateById(Emp emp) {
        emp.setModifyTime(new Date());
        return empMapper.updateById(emp);
    }

    /**
     * 查重
     * @param empNo
     * @param idCard
     * @param empId
     * @return
     */
    @Override
    public int check(String empNo, String idCard,Integer empId) {
        QueryWrapper<Emp> qw = new QueryWrapper<>();
        qw.ne("emp_id",empId);
        qw.eq("emp_no",empNo);
        qw.or();
        qw.eq("id_card",idCard);
        return empMapper.selectCount(qw).intValue();
    }
}