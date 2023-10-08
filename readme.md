SpringSecurity 6 + Spring Authorization Server 搭建oauth2 
授权码模式
- SpringBoot 3.13
- SpringSecurity 6
- jdk 17

### 获取授权码code：
http://:9000/oauth2/authorize?response_type=code&client_id=my_client&scope=read%20write&redirect_uri=http://127.0.0.1:8000
### 授权码模式-获取token 
http://os.com:9000/oauth2/token  
#### body
grant_type=authorization_code&code=i22m3n--IT_frec0dmBg3EhmZx4x2D8uhp2ptqC783Lh-9ABZUSNXV_fmrEKBrkGPiaSWcgAc-bRTU4bzW9uKrB3a3xnlNecQap9Nf0rpJY3zra6mfVfCV40w9o1oBPQ&redirect_uri=http://127.0.0.1:8000
#### header
- Authorization:Basic bXlfY2xpZW50OjEyMzQ1Ng==(授权码返回的code)
- Content-Type:application/x-www-form-urlencoded(postman body 选择x-www-form-urlencoded)

### SSO单点登录-授权码模式
server复用oauth2-server，客户端为sso-client
首页：http://localhost:8080/index.html，点击进行单点登录