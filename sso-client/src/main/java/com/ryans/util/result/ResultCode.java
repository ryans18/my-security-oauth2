package com.ryans.util.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author : Ryans
 * Date : 2023/6/25
 * Introduction :
 */
@Getter
@AllArgsConstructor
public enum ResultCode implements IResultCode {

    SUCCESS(200, "操作成功"),
    FAILURE(400, "业务异常"),
    ERROR(500, "服务异常"),
    PARAM_ERROR(540, "参数异常");

    final int code;
    final String msg;
}
