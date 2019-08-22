----
### SpringBootOauth2
#### SpringBoot整合Oauth2认证中心

**运行流程**
* postman请求http://localhost:9239/auth/oauth/token
  * 参数
    * grant_type：密码模式授权填写password
    * username：账号
    * password：密码
* 并且此链接需要使用 http Basic认证（此处的账号密码必须在oauth_client_details表中存在不然验证不通过）
  * Username：overun
  * Password：overun
  
----  
**代码解析**
请求上文路径会走到 UserDetailsServiceImpl 实现类中先检验 http Basic 中的用户名和密码是否正确，在后再根据用户名去数据库中查询是否存在该用户(本项目中使用假数据)，校验通过颁发令牌
  

