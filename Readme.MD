Spring Boot Example for REst and JPA
---
It requires a postgres. You may start one using docker and create the schema as well:  <br />
docker run --name postgres -itd -p 127.0.0.1:5432:5432 postgres
<br />
docker exec -it postgres bash -c "psql -U postgres -c 'create schema springjpasample;'"