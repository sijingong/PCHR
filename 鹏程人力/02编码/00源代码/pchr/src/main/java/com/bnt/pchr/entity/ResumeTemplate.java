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
@Alias("resumeTemplate")
@ApiModel(value = "合同模板表")
@TableName(value = "resume_template")
public class ResumeTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "模板ID")
    @TableField(value = "temp_id")
    @TableId(type = IdType.AUTO)
    private Integer tempId;

    @ApiModelProperty(value = "模板文件路径")
    @TableField(value = "temp_file_id")
    private String tempFileId;

    @ApiModelProperty(value = "模板类型(1:试用期;2:正式;3:终身;4:临时)")
    @TableField(value = "temp_type")
    private Integer tempType;

    @ApiModelProperty(value = "模板状态(1:未使用;2:使用中;3:已停用)")
    @TableField(value = "temp_state")
    private Integer tempState;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "modify_time")
    private Date modifyTime;

    @ApiModelProperty(value = "创建人ID")
    @TableField(value = "create_emp_id")
    private Integer createEmpId;

    @ApiModelProperty(value = "修改人ID")
    @TableField(value = "modify_emp_id")
    private Integer modifyEmpId;

}