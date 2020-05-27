# Challenge Fullstack interview

Este articulo ha sido escrito con la intencion de brindar instrucciones para iniciar la aplicacion.  

## Prerequisitos
1. Java(TM) SE Runtime Environment 18.9 (build 11.0.6+8-LTS)
2. Server: Docker Engine - Community 19.03.5

## Package, Test and Build
1. Empaquetar y testear
`mvn clean install`
2. Empaquetar para dockerizar
`mvn package spring-boot:repackage`
3. Dockerizar
`sudo docker build -t drugstores .`
4. Iniciar Docker
`sudo docker run -p 8080:8080 drugstores`

## Run
1. Swagger UI
`http://localhost:8080/swagger-ui.html#/`
2. Postman Collection provided.  

## Notes
La aplicacion por defecto entrega los resultados en formato json, para obtener los resultados en formato xml utilizar el siguiente header
`Accept application/xml`
