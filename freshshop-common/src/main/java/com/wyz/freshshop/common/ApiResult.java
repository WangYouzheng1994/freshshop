package com.wyz.freshshop.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/8/1 11:49
 * @Description:
 */
@Data
@AllArgsConstructor
public class ApiResult<T> {
    private String message;
    private String code;
    private T result;


}
