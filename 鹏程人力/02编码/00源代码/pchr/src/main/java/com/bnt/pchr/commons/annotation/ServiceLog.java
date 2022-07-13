package com.bnt.pchr.commons.annotation;

import java.lang.annotation.*;

/**
 * 业务日志注解,用在Controller方法上
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLog {
    /**
     * 模块名称
     *
     * @return
     */
    String modName() default "";

    /**
     * 业务类型
     *
     * @return
     */
    String serviceName() default "";

    /**
     * 业务说明
     *
     * @return
     */
    String serviceDesc() default "";

    /**
     * 业务类型
     *  删除、修改、查询、添加、文件处理、接口调用、支付、其它
     *  (可以扩展)
      * @return
     */
    ServiceType type() default ServiceType.OTHER;
}
