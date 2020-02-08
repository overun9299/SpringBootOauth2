package soap.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName: BCryptUtil
 * @Description: BCrypt加密解密
 * @author: 壹米滴答-西安-ZhangPY
 * @version: V1.0
 * @date: 2019/8/22 10:32
 * @Copyright: 2019 www.yimidida.com Inc. All rights reserved.
 */
public class BCryptUtil {


    /**
     * client表加密
     * @param password
     * @return
     */
    public String encryption(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * client表验证密码是否正确
     * @param original 原始密码
     * @param encryption 加密后密码
     * @return
     */
    public Boolean checkPw(String original, String encryption) {
        return BCrypt.checkpw(original, encryption);
    }

    /**
     * ac_user表密码加密
     * @param OriginalPassWord
     * @return
     */
    public static String userEncode(String OriginalPassWord) {
        return new BCryptPasswordEncoder().encode(OriginalPassWord);
    }

    /**
     * 校验密码
     * @param original 原始密码
     * @param encryption 加密后密码
     * @return
     */
    public static Boolean userCheckPw(String original, String encryption) {
        return new BCryptPasswordEncoder().matches(original, encryption);
    }

    public static void main(String[] args) {

        System.out.println(BCryptUtil.userEncode("263385"));

        /** $2a$10$2edS2ByARmZlCJ7s1aWPPekQMBMnSgseE/a7GjIrCGdYGP4OwahxO */
        String password = "overun";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed);

        boolean overun = BCrypt.checkpw("overun", "$2a$10$2edS2ByARmZlCJ7s1aWPPekQMBMnSgseE/a7GjIrCGdYGP4OwahxO");
        System.out.println(overun);
        boolean overun2 = BCrypt.checkpw("XcWebApp", "$2a$10$9bEpZ/hWRQxyr5hn5wHUj.jxFpIrnOmBcWlE/g/0Zp3uNxt9QTh/S");
        System.out.println(overun2);
        boolean overun3 = BCrypt.checkpw("123", "$2a$10$TJ4TmCdK.X4wv/tCqHW14.w70U3CC33CeVncD3SLmyMXMknstqKRe");
        System.out.println(overun3);

        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}
