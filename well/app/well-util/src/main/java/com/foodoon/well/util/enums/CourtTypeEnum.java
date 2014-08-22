package com.foodoon.well.util.enums;

/**
 * Created by well on 2014/8/22.
 */
public enum CourtTypeEnum {
    v3("3", "3V3"),
    v5("5", "5V5"),
    v7("7", "7V7"),
    v9("9", "9V9"),
    v11("11", "11V11");

    public String value;

    public String msg;

    private CourtTypeEnum(String value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public static CourtTypeEnum getByValue(String value) {
        CourtTypeEnum[] values = CourtTypeEnum.values();
        for (CourtTypeEnum courtTypeEnum : values) {
            if (courtTypeEnum.value.equals(value)) {
                return courtTypeEnum;
            }
        }
        return null;
    }
}
