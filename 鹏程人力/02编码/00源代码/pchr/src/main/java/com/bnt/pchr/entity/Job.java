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
@Alias("job")
@ApiModel(value = "部门职务表")
@TableName(value = "job")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "职务id")
    @TableField(value = "job_id")
    @TableId(type = IdType.AUTO)
    private Integer jobId;

    @ApiModelProperty(value = "职务名称")
    @TableField(value = "job_name")
    private String jobName;

    @ApiModelProperty(value = "职务编号")
    @TableField(value = "job_no")
    private String jobNo;

    @ApiModelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;

    @ApiModelProperty(value = "创建人id")
    @TableField(value = "create_emp_id")
    private Integer createEmpId;

    @ApiModelProperty(value = "修改人id")
    @TableField(value = "modify_emp_id")
    private Integer modifyEmpId;

    @ApiModelProperty(value = "所属部门")
    @TableField(value = "dep_id")
    private Integer depId;

    @ApiModelProperty(value = "职务状态:1:正常;9:停用")
    @TableField(value = "job_state")
    private Integer jobState;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "modify_time")
    private Date modifyTime;

}