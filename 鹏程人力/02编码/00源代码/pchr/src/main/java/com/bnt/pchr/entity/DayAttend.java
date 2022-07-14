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
import java.util.List;

/**
* Author bnt
* Date  2022-07-13 16:05:22
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Alias("dayAttend")
@ApiModel(value = "员工打卡表")
@TableName(value = "day_attend")
public class DayAttend implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "打卡id")
    @TableField(value = "attend_id")
    @TableId(type = IdType.AUTO)
    private Integer attendId;

    @ApiModelProperty(value = "员工id")
    @TableField(value = "emp_id")
    private Integer empId;

    @ApiModelProperty(value = "补卡人id")
    @TableField(value = "supp_emp_id")
    private Integer suppEmpId;

    @ApiModelProperty(value = "打卡状态（1:上班正常;2:迟到;3:早退;4:补卡;5:超时打卡,6:下班正常）")
    @TableField(value = "attend_state")
    private Integer attendState;

    @ApiModelProperty(value = "打卡时间")
    @TableField(value = "attend_time")
    private Date attendTime;

    @ApiModelProperty(value = "补卡时间")
    @TableField(value = "supp_time")
    private Date suppTime;

    @ApiModelProperty(value = "下班时间")
    @TableField(value = "end_time")
    private Date endTime;
}