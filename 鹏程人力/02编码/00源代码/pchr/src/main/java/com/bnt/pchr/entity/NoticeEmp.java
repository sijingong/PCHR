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
/**
* Author bnt
* Date  2022-07-13 16:05:23
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Alias("noticeEmp")
@ApiModel(value = "公告员工表")
@TableName(value = "notice_emp")
public class NoticeEmp implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告员工表ID")
    @TableField(value = "notice_emp_id")
    @TableId(type = IdType.AUTO)
    private Integer noticeEmpId;

    @ApiModelProperty(value = "公告ID")
    @TableField(value = "notice_id")
    private Integer noticeId;

    @ApiModelProperty(value = "员工ID")
    @TableField(value = "emp_id")
    private Integer empId;

    @ApiModelProperty(value = "read_state(1:未读;2:已读)")
    @TableField(value = "read_state")
    private Integer readState;

}