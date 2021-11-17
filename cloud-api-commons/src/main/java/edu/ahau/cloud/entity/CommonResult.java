package edu.ahau.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangxuna
 * @date 2021-11-09 9:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private T outData;
    private String message;

    public CommonResult(Integer code, String message) {
        this(code, null, message);
    }
}
