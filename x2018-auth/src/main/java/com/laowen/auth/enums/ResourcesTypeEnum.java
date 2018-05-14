package com.laowen.auth.enums;

public enum ResourcesTypeEnum {

    MENU(0, "菜单")
    , PERMISSIONS(1, "功能")
    , FOLDER(2, "文件夹")
    ;

    private Integer val;
    private String desc;

    private ResourcesTypeEnum(Integer val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public static ResourcesTypeEnum getEnum(Integer val) {
        if (null == val) {
            return null;
        }
        for (ResourcesTypeEnum delStatusEnum : ResourcesTypeEnum.values()) {
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
