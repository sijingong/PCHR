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
@Alias("resume")
@ApiModel(value = "员工简历表")
@TableName(value = "emp_resume")
public class Resume implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "简历ID")
    @TableField(value = "resume_id")
    @TableId(type = IdType.AUTO)
    private Integer resumeId;

    @ApiModelProperty(value = "所属员工ID")
    @TableField(value = "emp_id")
    private Integer empId;

    @ApiModelProperty(value = "简历文件路径")
    @TableField(value = "resume_file_path")
    private String resumeFilePath;

    @ApiModelProperty(value = "上传时间")
    @TableField(value = "upload_time")
    private Date uploadTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "modify_time")
    private Date modifyTime;

    @ApiModelProperty(value = "上传员工ID")
    @TableField(value = "upload_emp_id")
    private Integer uploadEmpId;

    @ApiModelProperty(value = "简历文件类型(1:docx;2:pdf)")
    @TableField(value = "file_type")
    private Integer fileType;

}