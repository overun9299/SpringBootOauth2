package overun.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName: UserCust
 * @Description:
 * @author: 壹米滴答-西安-ZhangPY
 * @version: V1.0
 * @date: 2019/8/21 16:36
 * @Copyright: 2019 www.yimidida.com Inc. All rights reserved.
 */
@Data
@ToString
public class UserCust {

    private String id;
    private String username;
    private String password;
    private String salt;
    private String name;
    private String utype;
    private String birthday;
    private String userpic;
    private String sex;
    private String email;
    private String phone;
    private String status;
    private String companyId;
}
