package learn.lhb.my.shop.domain;

/**
 * 用户表
 *
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 16:44
 */
public class UserDomain {

    private String email;
    private String username;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
