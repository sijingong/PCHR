package com.bnt.pchr.commons.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * JSON数据结构
 */
@ApiModel(value = "响应JSON数据")
@Data
public class ResponseData implements Serializable {
    /**
     * 等于0:正常 大于0:业务性错误 小于0:程序运行异常
     */
    @ApiModelProperty(value = "等于0:正常 大于0:业务性错误 小于0:程序运行异常")
    private int status = 0;
    /**
     * 错误信息:status小于0 或大于0时存在
     */
    @ApiModelProperty(value = "错误信息:status小于0 或大于0时存在")
    private String message;
    /**
     * 请求成功时,返回请求相关的数据信息,仅当status=0时存在
     */
    @ApiModelProperty(value = "请求成功时,返回请求相关的数据信息,仅当status=0时存在")
    private Object data;

    public ResponseData() {
        super();
    }


    public ResponseData(Object data) {
        super();
        this.data = data;
    }

    public ResponseData(int status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public final static ResponseData SUCCESS(Object data) {
        return new ResponseData(data);
    }
    /**
     * 失败
     *
     * @param status
     * @param message
     * @return
     */
    public final static ResponseData FAIL(int status, String message) {
        return new ResponseData(status, message);
    }

    /**
     * 通用错误状态-缺少请求参数
     */
    public  final static ResponseData MISS_PARAM= ResponseData.FAIL(100400,"缺少请求参数");
}
