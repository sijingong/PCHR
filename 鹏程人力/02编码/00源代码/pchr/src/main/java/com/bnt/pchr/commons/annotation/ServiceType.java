package com.bnt.pchr.commons.annotation;

/**
 * 业务类型枚举
 */
public enum ServiceType {
    SELECT("select"), DELETE("delete"), UPDATE("update"), INSERT("insert"), FILE("file"), PAY("pay"), API("api"), OTHER("other");
    private String name;

    ServiceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }}
