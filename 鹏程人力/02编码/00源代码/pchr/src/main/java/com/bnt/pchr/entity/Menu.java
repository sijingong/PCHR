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
@Alias("menu")
@ApiModel(value = "系统菜单表")
@TableName(value = "sys_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单id")
    @TableField(value = "menu_id")
    @TableId(type = IdType.AUTO)
    private Integer menuId;

    @ApiModelProperty(value = "菜单名称")
    @TableField(value = "menu_name")
    private String menuName;

    @ApiModelProperty(value = "菜单url")
    @TableField(value = "url")
    private String url;

    @ApiModelProperty(value = "菜单logo url")
    @TableField(value = "logo_url")
    private String logoUrl;

    @ApiModelProperty(value = "菜单logo base64编码")
    @TableField(value = "logo_base64")
    private String logoBase64;

    @ApiModelProperty(value = "菜单级别")
    @TableField(value = "menu_level")
    private Integer menuLevel;

    @ApiModelProperty(value = "菜单索引")
    @TableField(value = "menu_index")
    private Integer menuIndex;

    @ApiModelProperty(value = "父菜单id")
    @TableField(value = "p_menu_id")
    private Integer pMenuId;

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

    @ApiModelProperty(value = "使用状态(1:使用;0:停用)")
    @TableField(value = "use_state")
    private Integer useState;

    @ApiModelProperty(value = "备注")
    @TableField(value = "remark")
    private String remark;

}