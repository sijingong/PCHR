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
@Alias("notice")
@ApiModel(value = "公告表")
@TableName(value = "notice")
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告ID")
    @TableField(value = "notice_id")
    @TableId(type = IdType.AUTO)
    private Integer noticeId;

    @ApiModelProperty(value = "公告编号")
    @TableField(value = "notice_code")
    private String noticeCode;

    @ApiModelProperty(value = "标题")
    @TableField(value = "title")
    private String title;

    @ApiModelProperty(value = "类型:(1:消息;2:公告)")
    @TableField(value = "type")
    private Integer type;

    @ApiModelProperty(value = "内容")
    @TableField(value = "content")
    private String content;

    @ApiModelProperty(value = "发布时间")
    @TableField(value = "release_time")
    private Date releaseTime;

    @ApiModelProperty(value = "发布员工ID")
    @TableField(value = "release_emp_id")
    private Integer releaseEmpId;

    @ApiModelProperty(value = "状态(1:有效;2:过期:3:停用)")
    @TableField(value = "state")
    private Integer state;

    @ApiModelProperty(value = "生效时间")
    @TableField(value = "start_time")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField(value = "end_time")
    private Date endTime;

}