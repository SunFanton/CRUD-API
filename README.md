# CRUD-API
Proyecto en SpringBoot de API Rest

El proyecto se compone de dos partes. Una es la API Rest en si (hecha en SpringBoot) y la otra es el proyecto que funciona como cliente tambien en SpringBoot.
Se han incorporado los Dockerfile correspondientes para la creacion de las imagenes y para el despliegue de los contenedores que hacen funcionar al proyecto en 
cualquier entorno. Los contenedores, especificados dentro del Docker-compose.yml, son: mysqldb (base de datos), phpmyadmin, backend (API Rest), y frontend (cliente de la API Rest)
