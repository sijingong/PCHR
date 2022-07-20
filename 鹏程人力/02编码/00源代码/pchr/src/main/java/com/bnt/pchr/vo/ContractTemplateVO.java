package com.bnt.pchr.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContractTemplateVO {
    /**
     * 合同模板名称
     */
    private String tempName;
    /**
     * 合同模板文件服务器本地相对路径
     */
    private String tempFilePath;

     /**
     * 合同模板文件URL
     */
    private String tempURL;
}
