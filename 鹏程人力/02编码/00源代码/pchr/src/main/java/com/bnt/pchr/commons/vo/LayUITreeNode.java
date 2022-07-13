package com.bnt.pchr.commons.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/***
 *xiaoxia
 */
@Data
public class LayUITreeNode implements Serializable   {
    /**
     * 节点标题或名称111111
     */
    private String title;
    /***
     * 节点ID,可以是整型或String
     */
    private String id;
    /**
     * 节点单选或多选框name属性值
     */
    private String field;
    /**
     * 节点链接URL
     */
    private String href;
    /**
     * 是否选中
     */
    private Boolean checked = false;
    /**
     * 是否展开
     */
    private Boolean spread = false;
    /**
     * 子节点
     */
    private List<LayUITreeNode> children;
    /**
     * 是否禁用
     */
    private Boolean disabled = false;

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                ", field='" + field + '\'' +
                ", href='" + href + '\'' +
                ", checked=" + checked +
                ", spread=" + spread +
                ", children=" + children +
                ", disabled=" + disabled +
                '}';
    }
}
