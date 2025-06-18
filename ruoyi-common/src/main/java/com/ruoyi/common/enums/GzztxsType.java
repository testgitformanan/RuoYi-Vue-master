package com.ruoyi.common.enums;


public enum GzztxsType {
    TYPE1(1, "无人机"),
    TYPE2(2, "温度传感器"),
    TYPE3(3, "信号强度"),
    TYPE4(4, "摄像头"),
    TYPE5(5, "湿度传感器"),
    TYPE6(6, "数据传输"),
    TYPE7(7, "雷达"),
    TYPE8(8, "压力传感器"),
    TYPE9(9, "系统自检"),
    ;
    private int type;
    private String name;

    GzztxsType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static int getTypeByName(String name) {
        for (GzztxsType value : GzztxsType.values()) {
            if (value.getName().equals(name)) {
                return value.type;
            }
        }
        return 0;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
