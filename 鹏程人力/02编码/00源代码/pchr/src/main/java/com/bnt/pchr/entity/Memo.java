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
@Alias("memo")
@ApiModel(value = "员工备忘录")
@TableName(value = "emp_memo")
public class Memo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "备忘录id")
    @TableField(value = "memo_id")
    @TableId(type = IdType.AUTO)
    private Integer memoId;

    @ApiModelProperty(value = "备忘录编号")
    @TableField(value = "memo_no")
    private String memoNo;

    @ApiModelProperty(value = "备忘录名称")
    @TableField(value = "memo_name")
    private String memoName;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "modify_time")
    private Date modifyTime;

    @ApiModelProperty(value = "备忘录内容")
    @TableField(value = "content")
    private String content;

    @ApiModelProperty(value = "员工ID")
    @TableField(value = "emp_id")
    private Integer empId;

}