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
@Alias("roleMenu")
@ApiModel(value = "系统角色菜单表")
@TableName(value = "sys_role_menu")
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色权限id")
    @TableField(value = "role_menu_id")
    @TableId(type = IdType.AUTO)
    private Integer roleMenuId;

    @ApiModelProperty(value = "菜单id(外键)")
    @TableField(value = "menu_id")
    private Integer menuId;

    @ApiModelProperty(value = "角色id(外键)")
    @TableField(value = "role_id")
    private Integer roleId;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "创建用户id(外键)")
    @TableField(value = "create_emp_id")
    private Integer createEmpId;

}