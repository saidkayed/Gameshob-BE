# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM openjdk:11


COPY Gameshop-BE/target/gameshop-be-api.jar /usr/app/
WORKDIR /usr/app 

EXPOSE 8080

ENTRYPOINT ["java","-jar","gameshop-be-api.jar"]
