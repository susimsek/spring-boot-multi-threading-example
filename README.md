# Spring Boot Multi-Threading Example using CompletableFuture
> Spring Boot Multi-Threading Example
>
<img src="https://github.com/susimsek/spring-boot-multi-threading-example/blob/main/images/spring-boot-multi-threading-example.png" alt="Spring Boot Multi-Threading using CompletableFuture" width="100%" height="100%"/> 

## Prerequisites

* Java 11
* Maven 3.3+
* Docker 19.03+
* Docker Compose 1.25+

## Installation


```sh
./mvnw compile jib:dockerBuild
```


```sh
docker-compose up -d 
```

## Installation Using Vagrant

<img src="https://github.com/susimsek/spring-boot-multi-threading-example/blob/main/images/vagrant-installation.png" alt="Spring Boot Vagrant Installation" width="100%" height="100%"/> 

### Prerequisites

* Vagrant 2.2+
* Virtualbox or Hyperv

```sh
vagrant up
```

```sh
vagrant ssh
```

```sh
cd vagrant/setup
```

```sh
sudo chmod u+x *.sh
```

```sh
./install-prereqs.sh
```

```sh
exit
```

```sh
vagrant ssh
```

```sh
./mvnw compile jib:dockerBuild
```

```sh
docker-compose up -d
```

You can access the SpringDoc Openapi from the following url.

http://localhost:9090/api


## Used Technologies

* Spring Boot 2.5.2
* Spring Boot Web
* Spring Boot Jpa
* Spring Boot Log4j2
* SpringDoc Openapi Web Ui
* Maven Jib Plugin
* Maven Clean Plugin
* Maven Enforcer Plugin
* Maven Compiler Plugin
* Lombok
* H2 (Dev Environment)
* Postgresql
* Dev Tools
* Spring Boot Test

## SpringDoc OpenApi

> You can access the SpringDoc Openapi from the following url.

http://localhost:9090/api

<img src="https://github.com/susimsek/spring-boot-multi-threading-example/blob/main/images/springdoc-openapi.png" alt="SpringDoc Openapi" width="100%" height="100%"/> 




