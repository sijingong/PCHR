package com.bnt.pchr.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResumeVO {
    /**
     * 简历名称
     */
    private String resumeName;
    /**
     * 简历文件路径
     */
    private String resumeFilePath;

    /**
     * 简历类型(1:docx;2:pdf)
     */
    private Integer fileType;
    /**
     * 简历URL,用于阅读简历
     */
    private String resumeURL;
}
