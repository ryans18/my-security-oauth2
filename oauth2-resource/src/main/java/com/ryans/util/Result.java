package com.ryans.util;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 * Author：Ryans
 * Date：Created in 2023/9/27 22:22
 * Introduction：
 */
@Data
@Setter(AccessLevel.NONE)
public class Result {
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 数据
     */
    private Object data;
    /**
     * 时间
     */
    private LocalDateTime time;

    public Result(Integer code,Object data){
        this.code = code;
        this.data = data;
        this.time = LocalDateTime.now();
    }
}