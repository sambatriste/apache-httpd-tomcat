
## tomcat

### http.conf

```
LoadModule proxy_module modules/mod_proxy.so
LoadModule proxy_http_module modules/mod_proxy_http.so
```

```
ProxyRequests Off

<Proxy *>
Order deny,allow
Allow from all
</Proxy>

ProxyPass / http://app:8080/
```

### server.xml

## https

### 証明書を作成

``` sh
# 1.秘密鍵の作成 (パスワードは後で使うため覚えておく)
openssl genrsa -aes128 2048 > server.key

# 2. csrの作成 (1のパスワードが必要。それ以外は全部Enterキー押下でも構わない)
openssl req -new -key server.key > server.csr

# 3. sign (1のパスワードが必要)
openssl x509 -in server.csr -days 36500 -req -signkey server.key > server.crt


# 4. パスフレーズの消去
mv server.key server.key.orig
openssl rsa -in server.key.orig -out server.key
```


#### 動作確認

``` sh
openssl \
 s_server \
 -tls1_2 \
 -accept 443 \
 -www \
 -cert server.crt \
 -key server.key 
```

https://localhost

にアクセスする。

### http.conf

https://hub.docker.com/_/httpd

```diff
-#LoadModule socache_shmcb_module modules/mod_socache_shmcb.so
+LoadModule socache_shmcb_module modules/mod_socache_shmcb.so

-#LoadModule ssl_module modules/mod_ssl.so
+LoadModule ssl_module modules/mod_ssl.so

-#Include conf/extra/httpd-ssl.conf
+Include conf/extra/httpd-ssl.conf
```
