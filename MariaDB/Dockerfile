FROM mariadb:latest

LABEL mantainer "black-root ronald_reir21@hotmail.com"

#RUN apt-get update
#RUN apt-get install -y wget nano

ENV MYSQL_ROOT_PASSWORD=1234
ENV MYSQL_DATABASE=bdmedica

ADD bdmedica.sql /docker-entrypoint-initdb.d/bdmedica.sql 
CMD ["mysqld"]
EXPOSE 3306

