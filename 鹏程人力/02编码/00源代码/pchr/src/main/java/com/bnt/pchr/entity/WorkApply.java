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
@Alias("workApply")
@ApiModel(value = "员工加班申请表")
@TableName(value = "work_apply")
public class WorkApply implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "申请id")
    @TableField(value = "apply_id")
    @TableId(type = IdType.AUTO)
    private Integer applyId;

    @ApiModelProperty(value = "申请人id(外键)")
    @TableField(value = "emp_id")
    private Integer empId;

    @ApiModelProperty(value = "申请时间")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "申请状态(1:未处理;2:已通过3:未通过;4:已取消)")
    @TableField(value = "apply_state")
    private Integer applyState;

    @ApiModelProperty(value = "开始时间")
    @TableField(value = "start_time")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField(value = "end_time")
    private Date endTime;

    @ApiModelProperty(value = "加班类型(1:节假日加班;2:周末加班)")
    @TableField(value = "overtime_type")
    private Integer overtimeType;

    @ApiModelProperty(value = "加班费计算方式")
    @TableField(value = "cost_type")
    private Integer costType;

    @ApiModelProperty(value = "申请备注")
    @TableField(value = "remark")
    private String remark;

    @ApiModelProperty(value = "审批人ID")
    @TableField(value = "appr_emp_id")
    private Integer apprEmpId;

}