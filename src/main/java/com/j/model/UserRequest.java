package com.j.model;

import com.j.common.BaseRequest;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class UserRequest extends BaseRequest {
    @NotEmpty(message = "账户不能为空")
    String username;
}
