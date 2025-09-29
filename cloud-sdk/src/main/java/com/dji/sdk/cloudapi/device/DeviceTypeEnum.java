package com.dji.sdk.cloudapi.device;

import com.dji.sdk.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Arrays;

/**
 * @author sean
 * @version 1.7
 * @date 2023/5/26
 */
@Schema(description = "device type", enumAsRef = true)
public enum DeviceTypeEnum {

    // UAV devices (domain 0)
    M350(89),
    M300(60),
    M30(67),
    M30T(67), // Note: same type as M30, differentiated by sub_type
    M3E(77),
    M3T(77), // Note: same type as M3E, differentiated by sub_type
    M3M(77), // Note: same type as M3E, differentiated by sub_type
    M3D(91),
    M3TD(91), // Note: same type as M3D, differentiated by sub_type
    M4D(100),
    M4TD(100), // Note: same type as M4D, differentiated by sub_type
    M4E(99),
    M4T(99), // Note: same type as M4E, differentiated by sub_type

    // Camera devices (domain 1)
    Z30(20),
    XT2(26),
    PAYLOAD(31),
    FPV(39),
    XTS(41),
    H20(42),
    H20T(43),
    L1(50),
    H30(82),
    H30T(83),
    L2(84),
    M30_CAMERA(52),
    M30T_CAMERA(53),
    DJI_MINI_3_PRO(60),
    H20N(61),
    DOCK_CAMERA(165),
    M3E_CAMERA(66),
    M3T_CAMERA(67),
    M3M_CAMERA(68),
    DJI_MINI_3(76),
    M3D_CAMERA(80),
    M4E_CAMERA(88),
    M4T_CAMERA(89),
    NOT_SUPPORTED_CAMERA(65535),
    P1(100000),
    M3TD_CAMERA(81),

    // RC devices (domain 2)
    RC(56),
    RC_PLUS(119),
    RC_PRO(144),

    // Dock devices (domain 3)
    DOCK(1),
    DOCK2(2),
    S22M300(88097),
    S2201(88098),
    S2301(88099),
    S24M350(88100),
    S24M350S(88101),
    S24M3(88102),
    S24M4(88103),
    ;

    private final int type;

    DeviceTypeEnum(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static DeviceTypeEnum find(int type) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.type == type).findAny()
                .orElseThrow(() -> new CloudSDKException(DeviceTypeEnum.class, type));
    }
}
