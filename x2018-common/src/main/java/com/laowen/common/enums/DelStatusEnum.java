package com.laowen.common.enums;

/**
 * 删除标记枚举
 */
public enum DelStatusEnum {

    ENABLE(0, "启用")
    , DISABLE(1, "禁用")

    ;

    private Integer val;
    private String desc;

    private DelStatusEnum(Integer val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public static DelStatusEnum getEnum(Integer val) {
        if (null == val) {
            return null;
        }
        for (DelStatusEnum delStatusEnum : DelStatusEnum.values()) {
            if (val == delStatusEnum.getVal()) {
                return delStatusEnum;
            }
        }
        return null;
    }

    //region getter/setter

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    //endregion

}
