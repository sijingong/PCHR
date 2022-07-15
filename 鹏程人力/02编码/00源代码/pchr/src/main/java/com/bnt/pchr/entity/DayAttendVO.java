package com.bnt.pchr.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Alias("dayAttendVO")
public class DayAttendVO {
    //员工id
    private Integer empId;
    //补卡人id
    private Integer suppEmpId;
    //打卡状态
    private Integer attendState;
    //打卡时间
    private Date attendTime;
    //补卡人打卡时间
    private Date suppTime;
    //下班时间
    private Date endTime;
    //员工姓名
    private String empName;
    //员工编号
    private String empNo;
    //手机号码
    private String mobile;
}
