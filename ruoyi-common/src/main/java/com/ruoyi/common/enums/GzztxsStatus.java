package com.ruoyi.common.enums;


public enum GzztxsStatus {
    TYPE1("01", "正常"),
    TYPE2("02", "异常"),
    ;
    private String type;
    private String name;

    GzztxsStatus(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public static String getNameByStatus(String status) {
        for (GzztxsStatus value : GzztxsStatus.values()) {
            if (value.getType().equals(status)) {
                return value.getName();
            }
        }
        return status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
