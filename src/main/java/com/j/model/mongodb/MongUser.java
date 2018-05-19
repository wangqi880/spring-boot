package com.j.model.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "MongUser")
public class MongUser extends BaseDO<String> {
    String username;
    String password;
}
