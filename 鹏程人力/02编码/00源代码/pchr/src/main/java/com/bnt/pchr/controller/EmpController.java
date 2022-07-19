package com.bnt.pchr.controller;

import com.bnt.pchr.commons.util.MD5;
import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.Department;
import com.bnt.pchr.entity.Emp;
import com.bnt.pchr.entity.Job;
import com.bnt.pchr.service.IDepartmentService;
import com.bnt.pchr.service.IJobService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.bnt.pchr.service.IEmpService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Slf4j
@RequestMapping("emp")
@Controller
@Api(value = "员工控制器")
public class EmpController {

    @Autowired
    @Qualifier("empService")
    private IEmpService empService;

    @Autowired
    @Qualifier("jobService")
    private IJobService jobService;

    @Autowired
    @Qualifier("departmentService")
    private IDepartmentService departmentService;

    /**
     * 分页查询，根据关键字、工资、部门id、职位id
     * @param kd
     * @param floor
     * @param ceil
     * @param emp
     * @param pageData
     * @param jobState
     * @param depState
     * @param model
     * @return
     */
    @PostMapping("select_page")
    public String selectPage(String kd, Integer floor, Integer ceil, Emp emp, PageData<Emp> pageData, Integer jobState, Integer depState, Model model) {
        HashMap map = new HashMap<String, Object>();
        map.put("kd", kd);
        map.put("floor", floor);
        map.put("ceil", ceil);
        map.put("depId", emp.getDepId());
        map.put("jobId", emp.getJobId());
        map.put("empState", emp.getEmpState());
        map.put("sex", emp.getSex());
        pageData.setCriteriaMap(map);
        pageData = empService.selectPage(pageData);
        List<Emp> empList = pageData.getRecords();
        for (Emp el : empList) {
            if (jobState != null && jobState == 1) {
                if (el.getJobId() != null) {
                    Job job = jobService.selectOne(el.getJobId());
                    el.setJob(job);
                }
            }
            if (depState != null && depState == 1) {
                if (el.getDepId() != null) {
                    Department dep = departmentService.selectOne(el.getDepId());
                    el.setDep(dep);
                }
            }
        }
        model.addAttribute("pageData", pageData);
        return "emp/emp_list";
    }

    /**
     * 根据id查一个员工
     * @param empId
     * @return
     */
    @GetMapping("to_select")
    public String toSelect(Integer empId,Model model) {
        Emp emp = empService.selectOne(empId);
        Job job = jobService.selectOne(emp.getJobId());
        emp.setJob(job);
        Department dep = departmentService.selectOne(emp.getDepId());
        emp.setDep(dep);
        model.addAttribute("emp",emp);
        return "emp/emp_info";
    }

    /**
     * 根据id查一个员工
     * @param empId
     * @return
     */
    @PostMapping("select_one")
    @ResponseBody
    public ResponseData selectOne(Integer empId) {
        Emp emp = empService.selectOne(empId);
        Job job = jobService.selectOne(emp.getJobId());
        emp.setJob(job);
        Department dep = departmentService.selectOne(emp.getDepId());
        emp.setDep(dep);
        return ResponseData.SUCCESS(emp);
    }

    /**
     * 更新员工状态
     * @param empId
     * @param empState
     * @param userId
     * @return
     */
    @GetMapping("update_state")
    @ResponseBody
    public ResponseData updateState(@RequestParam Integer empId, @RequestParam Integer empState, Integer userId) {
        Emp emp = new Emp();
        emp.setModifyEmpId(userId);
        emp.setEmpId(empId);
        emp.setEmpState(empState);
        int rows = empService.updateById(emp);
        return ResponseData.SUCCESS(rows);
    }

    /**
     * 重置密码
     * @param empId
     * @return
     */
    @GetMapping("reset_password")
    @ResponseBody
    public ResponseData resetPassword(@RequestParam Integer empId) {
        Emp emp = new Emp();
        emp.setEmpId(empId);
        String md5Str = MD5.getMD5("sb" + "123456");
        emp.setPassword(md5Str);
        int rows = empService.updateById(emp);
        return ResponseData.SUCCESS(rows);
    }

    /**
     * 登录
     * @param empNo
     * @param pwd
     * @param session
     * @return
     */
    @PostMapping("login")
    @ResponseBody
    public ResponseData login(@RequestParam String empNo, @RequestParam String pwd, HttpSession session) {
        Emp emp = empService.selectByEmpNo(empNo);
        System.out.println("emp:" + emp);
        if (emp == null) {
            return ResponseData.FAIL(-1, "无此编号员工");
        }
        String password = emp.getPassword();
        String md5Str = MD5.getMD5("sb" + pwd).toUpperCase(Locale.ROOT);
        session.setAttribute("emp", emp);
        if (md5Str.equals(MD5.getMD5("sb123456").toUpperCase(Locale.ROOT)) && password.equals(md5Str)) {
            return ResponseData.FAIL(990, "初始密码未修改，安全性不高");
        } else if (!password.equals(md5Str)) {
            return ResponseData.FAIL(-2, "用户名或密码错误");
        } else {
            return ResponseData.SUCCESS(1);
        }
    }

    /**
     * 登出
     * @param empId
     * @param model
     * @param session
     * @return
     */
    @PostMapping("logout")
    public String logout(@RequestParam String empId, Model model, HttpSession session) {
        session.removeAttribute("emp");
        return "login";
    }

    /**
     * 新建员工
     * @param emp
     * @param userId
     * @return
     */
    @PostMapping("create_emp")
    @ResponseBody
    public ResponseData createEmp(Emp emp, Integer userId) {
        int check = empService.check(emp.getEmpNo(), emp.getIdCard(),emp.getEmpId());
        if (check > 0) {
            return ResponseData.SUCCESS(2);
        }
        String md5Str = MD5.getMD5("sb" + "123456");
        emp.setPassword(md5Str);
        emp.setEmpState(1);
        int rows = empService.insert(emp);
        emp.setCreateEmpId(userId);
        return ResponseData.SUCCESS(rows);
    }

    /**
     * 更新员工
     * @param emp
     * @param userId
     * @return
     */
    @PostMapping("update_emp")
    @ResponseBody
    public ResponseData updateEmp(Emp emp, Integer userId) {
        int check = empService.check(emp.getEmpNo(), emp.getIdCard(),emp.getEmpId());
        if (check > 0) {
            return ResponseData.SUCCESS(2);
        }
        int rows = empService.updateById(emp);
        emp.setModifyEmpId(userId);
        return ResponseData.SUCCESS(rows);
    }

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @param empId
     * @return
     */
    @PostMapping("modify_pwd")
    @ResponseBody
    public ResponseData modifyPwd(@RequestParam String oldPassword, @RequestParam String newPassword, @RequestParam Integer empId) {
        Emp emp = empService.selectOne(empId);
        String checkPwd = emp.getPassword();
        if (checkPwd.equals(MD5.getMD5("sb" + oldPassword).toUpperCase(Locale.ROOT))) {
            if (checkPwd.equals(MD5.getMD5("sb" + newPassword).toUpperCase(Locale.ROOT))) {
                return ResponseData.FAIL(-1, "与原密码相同！");
            }
            emp.setPassword(MD5.getMD5("sb" + newPassword).toUpperCase(Locale.ROOT));
            empService.updateById(emp);
            return ResponseData.SUCCESS(1);
        }
        return ResponseData.SUCCESS("服务器发生未知错误！！");
    }


    /**
     * 删除员工
     * @param empId
     * @return
     */
    @PostMapping("delete_emp")
    @ResponseBody
    public ResponseData deleteEmp(Integer empId) {
        int rows = empService.deleteById(empId);
        return ResponseData.SUCCESS(rows);
    }

    /**
     * 查找员工并跳转到员工详情页面
     * @param empId
     * @param model
     * @return
     */
    @GetMapping("emp_info")
    public String empInfo(Integer empId, Model model) {
        Emp emp = empService.selectOne(empId);
        Job job = jobService.selectOne(emp.getJobId());
        emp.setJob(job);
        Department dep = departmentService.selectOne(emp.getDepId());
        emp.setDep(dep);
        model.addAttribute("emp", emp);
        return "emp/emp_info";
    }
}