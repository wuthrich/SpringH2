Proyecto de ejemplo de funciones CRUD
con Spring Boot, H2 y JPA

Puede encontrar una explicacion de como desplegar y probar los servicios en:
https://youtu.be/u2qEW3d5NRg

HEADERS
Content-Type: application/json

Create
---------
POST http://localhost:8080/usuario/

Body (ejemplo)

{
"nombres":"nombre uno",
"apellidos":"apellido dos",
"edad":20,
"documento":"doc 1"
}

READ
-------
GET http://localhost:8080/usuario/
GET http://localhost:8080/usuario/{id}

UPDATE
--------
PUT http://localhost:8080/usuario/{id}
Body (ejemplo)

{
"nombres":"nombre uno",
"apellidos":"apellido dos",
"edad":20,
"documento":"Cambio doc"
}

DELETE
--------
DELETE http://localhost:8080/usuario/{id}