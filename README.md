### 人才管理系统-后端
<p>Talent management system</p>

#### 概述：
##### 1. 登陆认证
前后端分离项目，采用spring security实现jwt（即只使用token的认证模式）<br/>
- 登陆时做登陆认证之后，生成jwt令牌 **「认证流程」**
- 前端在header中带上jwt令牌<br/>
- 每次前端访问后端接口时，后端检查header中是否含有令牌 **「鉴权流程」**<br/>

刷新令牌？

##### 2. 权限管理
使用RBAC权限管理模型