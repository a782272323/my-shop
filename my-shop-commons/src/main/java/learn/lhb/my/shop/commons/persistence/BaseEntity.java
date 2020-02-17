package learn.lhb.my.shop.commons.persistence;

import java.util.Date;
import java.io.Serializable;

/**
 * 实体类的基础类
 *
 * @author 梁鸿斌
 * @date 2020/2/17.
 * @time 22:18
 */
public abstract class BaseEntity implements Serializable { // 其实等于 TbUserDomain
    private Long id; // 用户编号
    private Date created; // 创建时间
    private Date updated; // 更新时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
