package com.bnt.pchr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * Author bnt
 * Date  2022-07-13 16:05:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Alias("emp")
@ApiModel(value = "员工信息表")
@TableName(value = "emp")
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工id")
    @TableField(value = "emp_id")
    @TableId(type = IdType.AUTO)
    private Integer empId;

    @ApiModelProperty(value = "员工名")
    @TableField(value = "emp_name")
    private String empName;

    @ApiModelProperty(value = "密码")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty(value = "员工编号")
    @TableField(value = "emp_no")
    private String empNo;

    @ApiModelProperty(value = "性别")
    @TableField(value = "sex")
    private Integer sex;

    @ApiModelProperty(value = "手机号")
    @TableField(value = "mobile")
    private String mobile;

    @ApiModelProperty(value = "员工状态:1:正常;9:停用")
    @TableField(value = "emp_state")
    private Integer empState;

    @ApiModelProperty(value = "部门id")
    @TableField(value = "dep_id")
    private Integer depId;

    @ApiModelProperty(value = "职务id")
    @TableField(value = "job_id")
    private Integer jobId;

    @ApiModelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;

    @ApiModelProperty(value = "薪水")
    @TableField(value = "salary")
    private Integer salary;

    @ApiModelProperty(value = "籍贯")
    @TableField(value = "homeplace")
    private String homeplace;

    @ApiModelProperty(value = "创建人id")
    @TableField(value = "create_emp_id")
    private Integer createEmpId;

    @ApiModelProperty(value = "修改人id")
    @TableField(value = "modify_emp_id")
    private Integer modifyEmpId;

    @ApiModelProperty(value = "生日")
    @TableField(value = "birthday")
    private Date birthday;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "modify_time")
    private Date modifyTime;

    @ApiModelProperty(value = "员工头像")
    @TableField(value = "emp_head")
    private String empHead;

    @ApiModelProperty(value = "邮箱")
    @TableField(value = "email")
    private String email;

    @ApiModelProperty(value = "家庭住址")
    @TableField(value = "home_address")
    private String homeAddress;

    @ApiModelProperty(value = "紧急联系人")
    @TableField(value = "contact_man")
    private String contactMan;

    @ApiModelProperty(value = "紧急联系人电话")
    @TableField(value = "contact_phone")
    private String contactPhone;

    @ApiModelProperty(value = "紧急联系人关系")
    @TableField(value = "relation")
    private Integer relation;

    @ApiModelProperty(value = "QQ号码")
    @TableField(value = "qq")
    private String qq;

    @ApiModelProperty(value = "微信号码")
    @TableField(value = "wechart")
    private String wechart;

    @ApiModelProperty(value = "工位编号")
    @TableField(value = "seat_code")
    private String seatCode;

    @ApiModelProperty(value = "身份证号码")
    @TableField(value = "id_card")
    private String idCard;

    @TableField(exist = false)
    private Job job;

    @TableField(exist = false)
    private Department dep;

    @TableField(exist = false)
    private Resume resume;

    @TableField(exist = false)
    private EmpContract contract;
}