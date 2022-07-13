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
@Alias("sysDictItem")
@ApiModel(value = "系统字典数据表")
@TableName(value = "sys_dict_item")
public class SysDictItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典ID")
    @TableField(value = "dict_id")
    @TableId(type = IdType.AUTO)
    private Integer dictId;

    @ApiModelProperty(value = "字典名称")
    @TableField(value = "dict_name")
    private String dictName;

    @ApiModelProperty(value = "字典代码")
    @TableField(value = "dict_code")
    private String dictCode;

    @ApiModelProperty(value = "父字典ID")
    @TableField(value = "p_dict_id")
    private Integer pDictId;

    @ApiModelProperty(value = "添加人ID")
    @TableField(value = "create_emp_id")
    private Integer createEmpId;

    @ApiModelProperty(value = "添加时间")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "modify_time")
    private Date modifyTime;

    @ApiModelProperty(value = "修改人ID")
    @TableField(value = "modify_emp_id")
    private Integer modifyEmpId;

    @ApiModelProperty(value = "使用状态(1:使用;2:停用)")
    @TableField(value = "use_state")
    private Integer useState;

}