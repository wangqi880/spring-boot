package com.j.common;

import lombok.Data;

@Data
public class BaseResponse {

    String info;
    String code;
    Object Data;
}
