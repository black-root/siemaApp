FROM mariadb:10.3

ENV MYSQL_DATABASE=doctordb
ADD /doctor.sql /docker-entrypoint-initdb.d/doctor.sql
