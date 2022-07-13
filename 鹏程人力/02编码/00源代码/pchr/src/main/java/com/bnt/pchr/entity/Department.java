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
@Alias("department")
@ApiModel(value = "部门表")
@TableName(value = "department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门ID")
    @TableField(value = "dep_id")
    @TableId(type = IdType.AUTO)
    private Integer depId;

    @ApiModelProperty(value = "部门名称")
    @TableField(value = "dep_name")
    private String depName;

    @ApiModelProperty(value = "部门编号")
    @TableField(value = "dep_no")
    private String depNo;

    @ApiModelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;

    @ApiModelProperty(value = "部门状态:1:正常;9:停用")
    @TableField(value = "dep_state")
    private Integer depState;

    @ApiModelProperty(value = "创建人id")
    @TableField(value = "create_user_id")
    private Integer createUserId;

    @ApiModelProperty(value = "修改人id")
    @TableField(value = "modify_user_id")
    private Integer modifyUserId;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "modify_time")
    private Date modifyTime;

}