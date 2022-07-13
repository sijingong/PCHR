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
@Alias("role")
@ApiModel(value = "系统角色表")
@TableName(value = "sys_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    @TableField(value = "role_id")
    @TableId(type = IdType.AUTO)
    private Integer roleId;

    @ApiModelProperty(value = "角色中文名称")
    @TableField(value = "role_name_zh")
    private String roleNameZh;

    @ApiModelProperty(value = "角色英文名称")
    @TableField(value = "role_name_en")
    private String roleNameEn;

    @ApiModelProperty(value = "系统id")
    @TableField(value = "sys_id")
    private Integer sysId;

    @ApiModelProperty(value = "模块名称")
    @TableField(value = "module_name")
    private String moduleName;

    @ApiModelProperty(value = "数量上限(0:没有上限)")
    @TableField(value = "max_count")
    private Integer maxCount;

    @ApiModelProperty(value = "使用状态(1:使用中;0:已停用)")
    @TableField(value = "use_state")
    private Integer useState;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "modify_time")
    private Date modifyTime;

    @ApiModelProperty(value = "创建用户id")
    @TableField(value = "create_emp_id")
    private Integer createEmpId;

    @ApiModelProperty(value = "修改用户id")
    @TableField(value = "modify_emp_id")
    private Integer modifyEmpId;

    @ApiModelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;

}