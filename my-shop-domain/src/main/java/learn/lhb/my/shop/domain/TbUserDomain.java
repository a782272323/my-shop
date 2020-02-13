package learn.lhb.my.shop.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表（只管理员一类，不是只会员和消费者）
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 22:56
 */
public class TbUserDomain implements Serializable {

    private Long id;//用户编号
    private String username;//用户名
    private String phone;//注册手机号
    private String password;//密码，加密存储
    private String email;//注册邮箱
    private Date created;//创建时间
    private Date updated;//更新时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
