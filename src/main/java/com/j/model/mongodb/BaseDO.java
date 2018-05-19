package com.j.model.mongodb;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 数据持久化模型基类
 *
 * @author wanglong
 * @version $Id: BaseDO.java, v 0.1 16/12/27 20:51 wanglong Exp $
 */
@Data
public class BaseDO<ID extends Serializable> implements Persistable {

    private static final long serialVersionUID = -7351749602787939571L;

    @Id
    private ID                id;

    /**
     * 数据创建时间
     */
    @CreatedDate
    private Date createdTime;

    /**
     * 数据最近修改时间
     */
    @LastModifiedDate
    private Date              lastModifiedTime;

    /**
     * Returns if the {@code Persistable} is new or was persisted already.
     *
     * @return if the object is new
     */
    @Override
    public boolean isNew() {
        return id == null || "".equals(id);
    }
}
