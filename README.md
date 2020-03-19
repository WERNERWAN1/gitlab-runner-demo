# gitlab CI/CD

#### 通过 [gitlab-runner](https://docs.gitlab.com/runner/) 构建服务

1.[在目标服务器安装gitlab-runner](#1)<br>
2.[将gitlab-runner 注册到gitlab,用于标识单个项目](#2)<br>
3.[项目里添加配置文件 “.gitlab-ci.yml”](#3)<br>
4.[当有代码push 会自动触发。在目标服务器中执行[3]中配置的步骤](#4)<br>


##### <h6 id='1'>安装gitlab-runner
#### linux 安装
```
#下载包
curl -LJO https://gitlab-runner-downloads.s3.amazonaws.com/latest/rpm/gitlab-runner_<arch>.rpm
#安装
rpm -i gitlab-runner_<arch>.rpm
#赋权
sudo chmod +x /usr/local/bin/gitlab-runner
#创建用户（gitlab-runner 是以该用户的身份执行）
sudo useradd --comment 'GitLab Runner' --create-home gitlab-runner --shell /bin/bash
#安装并启动
sudo gitlab-runner install --user=gitlab-runner --working-directory=/home/gitlab-runner
sudo gitlab-runner start
```
#### <h6 id='2'>gitlab-runner 注册
通过命令，注册服务。并配置 “连接、token、描述、tag”
```
gitlab-runner register 
```


#### <h6 id='3'>.gitlab-ci.yml

```
stages:
  - .pre
  - run

job 0:
  stage: .pre
  script: echo 'start'

job 1:
  stage: run
  script:
    - mvn clean package -Dmaven.test.skip=true
    - /opt/application/startJar.sh target/demo.jar &
```

### stage---步骤, script---脚本 <br>

## 此配置项执行为：开始执行，maven 打包,并执行jar 包。（此处脚本可以是先清除端口占用的服务，<br>
## 然后再启动服务，但是实际测试中服务会处于pending状态。）

 
