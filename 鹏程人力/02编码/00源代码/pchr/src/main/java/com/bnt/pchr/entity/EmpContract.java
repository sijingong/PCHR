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
@Alias("empContract")
@ApiModel(value = "员工劳动合同表")
@TableName(value = "emp_contract")
public class EmpContract implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "合同ID")
    @TableField(value = "contract_id")
    @TableId(type = IdType.AUTO)
    private Integer contractId;

    @ApiModelProperty(value = "所属员工ID")
    @TableField(value = "emp_id")
    private Integer empId;

    @ApiModelProperty(value = "合同模板ID")
    @TableField(value = "temp_id")
    private Integer tempId;

    @ApiModelProperty(value = "contract_path")
    @TableField(value = "contract_path")
    private String contractPath;

    @ApiModelProperty(value = "start_date")
    @TableField(value = "start_date")
    private Date startDate;

    @ApiModelProperty(value = "end_date")
    @TableField(value = "end_date")
    private Date endDate;

}