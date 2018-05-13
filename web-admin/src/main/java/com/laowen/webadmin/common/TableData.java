package com.laowen.webadmin.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 表格数据
 */
@Data
public class TableData implements Serializable {

    /**
     * 总记录数
     */
    private Integer total;

    /**
     * 数据行
     */
    private List rows;

}
