package learn.lhb.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import learn.lhb.my.shop.commons.persistence.BaseEntity;

import java.io.Serializable;
import java.util.Date;

// 完善阿里巴巴代码检查规范的笔记
/**
 * 用户表（只管理员一类，不是只会员和消费者）
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 22:56
 */
public class TbUserDomain extends BaseEntity {
    //用户名
    private String username;
    //注册手机号
    private String phone;
    //密码，加密存储
    private String password;
    //注册邮箱
    private String email;

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

    @JsonIgnore
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

}
