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
@Alias("leave")
@ApiModel(value = "员工请假表")
@TableName(value = "emp_leave")
public class Leave implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "请假表ID")
    @TableField(value = "leave_id")
    @TableId(type = IdType.AUTO)
    private Integer leaveId;

    @ApiModelProperty(value = "开始时间")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "截止时间")
    @TableField(value = "end_time")
    private Date endTime;

    @ApiModelProperty(value = "请假原因")
    @TableField(value = "remark")
    private String remark;

    @ApiModelProperty(value = "员工ID")
    @TableField(value = "emp_id")
    private Integer empId;

    @ApiModelProperty(value = "申请状态(1:未处理;2:已通过3:未通过;4:已取消)")
    @TableField(value = "apply_state")
    private Integer applyState;

    @ApiModelProperty(value = "申请时间")
    @TableField(value = "apply_time")
    private Date applyTime;

    @ApiModelProperty(value = "请假类型(1:事假;2:病假:3:年假;4:丧家;5:调休;6:其他)")
    @TableField(value = "leave_type")
    private Integer leaveType;

    @ApiModelProperty(value = "销假状态(1:未销假;2:已销假)")
    @TableField(value = "destory_state")
    private Integer destoryState;

    @ApiModelProperty(value = "销假时间")
    @TableField(value = "destory_time")
    private Date destoryTime;

    @ApiModelProperty(value = "审核人ID")
    @TableField(value = "approve_emp_id")
    private Integer approveEmpId;
}