package com.bnt.pchr.commons.util;

/**
 * 分页插件类型
 */
public enum PagingPlugins {
    NONE("none"), MM_GRID("mmGrid");
    //插件名称
    private String pluginName;

    PagingPlugins(String pluginName) {
        this.pluginName = pluginName;
    }
}
