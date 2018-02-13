# Spring Boot REST Banner Generator
Spring Boot REST which generates colored Spring Boot banners from images

- Run the application
```
mvn spring-boot:run
```

- Sample request
```
curl -i -X POST -F "image=@/home/user/banner.png" -F "dark=false" -F "ansi=false" localhost:8123/banner/generate
```