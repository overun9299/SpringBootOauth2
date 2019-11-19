----
### SpringBootOauth2
#### SpringBoot整合Oauth2认证中心（弱依赖）

----
##### SpringBootAuth Oauth2认证中心(密码模式)
**运行流程-颁发token**
* postman请求http://localhost:9239/auth/oauth/token
  * 参数
    * grant_type：密码模式授权填写password
    * username：账号(admin)
    * password：密码(123)
* 并且此链接需要使用 http Basic认证（此处的账号密码必须在oauth_client_details表中存在不然验证不通过）
  * Username：overun
  * Password：overun
  
**运行流程-校验token**
* postman请求 http://localhost:9239/auth/oauth/check_token
  * 参数
    * token


**代码解析**
请求上文路径会走到 UserDetailsServiceImpl 实现类中先检验 http Basic 中的用户名和密码是否正确，在后再根据用户名去数据库中查询是否存在该用户(本项目中使用假数据)，校验通过颁发令牌
  
----

##### SpringBootApp 授权应用
**该服务配置了授权控制后如要访问该服务的接口，则必须提供令牌**
* 添加依赖
* 配置config

在后续请求中的头信息中加入
Authorization : Bearer token 便可进行校验访问


----
##### 公钥和密钥生成
* 生成密钥证书
cmd窗口下
```$xslt
keytool -genkeypair -alias ovkey -keyalg RSA -keypass overun -keystore overun.keystore -storepass overun
```

* Keytool 是一个java提供的证书管理工具 
* -alias：密钥的别名 
* -keyalg：使用的hash算法 
* -keypass：密钥的访问密码 
* -keystore：密钥库文件名，
* overun.keystore保存了生成的证书 
* -storepass：密钥库的访问密码

----

* 导出公钥（使用openssl）
```$xslt
keytool -list -rfc --keystore C:\Users\admin\Desktop\jwt\overun.keystore | openssl x509 -inform pem -pubkey
```
放入需要授权控制的服务下 例:publickey.txt


----
#### SpringBoot整合Oauth2认证中心（强依赖）
##### 强依赖模式就是资源服务的每一步操作，到要去请求授权服务再验证该用户是否有权限，可以做类似与中台系统

----
* SpringSecurityOauth2Server强依赖模式的认证授权服务器
* SpringSecurityOauth2Resources强依赖模式的资源服务器

----

**请求方式：**
* 获取code


**浏览器访问http://localhost:8848/auth2/oauth/authorize?client_id=overun&response_type=code**


**然后跳转登陆页面 参数 User:soap  Password:263385,授权后得到code。**
* 获取access_token

**postman请求获取access_token，http://client:secret@localhost:8848/auth2/oauth/token 参数 grant_type:authorization_code,code:上步操作获取的code**
并且此链接需要使用Basic Auth认证，username:overun password:overun。获取到access_token后在访问资源服务器时?access_token=27f78c35-3f28-429b-80c8-7a9e07ec1130要加上token









