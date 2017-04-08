Spring Boot Example for REst and JPA
---
It requires a postgres. You may start one using docker and create the schema as well:__
docker run --name postgres -itd -p 127.0.0.1:5432:5432 postgres
__
docker exec -it postgres bash -c "psql -U postgres -c 'create schema springjpasample;'"