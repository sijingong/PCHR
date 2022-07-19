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
@Alias("leaveApprove")
@ApiModel(value = "员工请假审批表")
@TableName(value = "leave_approve")
public class LeaveApprove implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "请假审批表ID")
    @TableField(value = "leave_approve_id")
    @TableId(type = IdType.AUTO)
    private Integer leaveApproveId;

    @ApiModelProperty(value = "审批时间")
    @TableField(value = "approve_time")
    private Date approveTime;

    @ApiModelProperty(value = "审批状态:(1:同意;2:未同意;3:未处理;4:已取消)")
    @TableField(value = "approve_state")
    private Integer approveState;

    @ApiModelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;

    @ApiModelProperty(value = "审批人ID")
    @TableField(value = "approve_emp_id")
    private Integer approveEmpId;

    @ApiModelProperty(value = "审批流水(备用)")
    @TableField(value = "apply_trans_no")
    private String applyTransNo;

    @ApiModelProperty(value = "交易ID(备用)")
    @TableField(value = "trans_no_id")
    private Integer transNoId;

    @ApiModelProperty(value = "请假ID")
    @TableField(value = "leave_id")
    private String leaveId;

}