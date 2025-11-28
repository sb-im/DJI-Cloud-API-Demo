package com.dji.sdk.cloudapi.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author sean
 * @version 1.7
 * @date 2023/6/25
 */
public enum PayloadPositionEnum {

    LEFT_OR_MAIN(0),

    RIGHT(1),

    UP(2),

    INDEX_3(3),

    UP_TYPE_C(4),

    UP_TYPE_C_EXT_ONE(5),

    INDEX_6(6),

    FPV(7),

    INDEX_8(8),

    INDEX_9(9),

    INDEX_10(10),

    INDEX_11(11),

    INDEX_12(12),

    AGGREGATION(65534),

    VISION_ASSIST(10000),

    PORT_1(20001),

    PORT_2(20002),

    PORT_3(20003),

    PORT_4(20004),

    PORT_5(20005),

    PORT_6(20006),

    PORT_7(20007),

    PORT_8(20008),

    UNKNOWN(65535);

    private final int position;

    PayloadPositionEnum(int position) {
        this.position = position;
    }

    @JsonValue
    public int getPosition() {
        return position;
    }

    @JsonCreator
    public static PayloadPositionEnum find(int position) {
        return Arrays.stream(values()).filter(positionEnum -> positionEnum.position == position).findAny()
                .orElse(UNKNOWN);
    }
}
