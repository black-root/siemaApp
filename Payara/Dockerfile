FROM payara/micro:181
LABEL mantainer "ronald.ibanez1994@gmail.com>"
USER root
EXPOSE 4848 8009 8080 8181
ADD  SiemaApp-ear-1.0-SNAPSHOT.ear $PAYARA_PATH/deployments/
COPY domain.xml ./
RUN chmod 777 domain.xml
COPY dockerize /usr/local/bin
ADD mysql-connector-java-5.0.8-bin.jar $PAYARA_PATH/deployments
CMD dockerize -wait http://172.25.0.28:3300/mantenimientoPC -timeout 50s
ENTRYPOINT java -jar /opt/payara/payara-micro.jar --autoBindHttp --domainConfig domain.xml --addJars /opt/payara/deployments/mysql-connector-java-5.0.8-bin.jar --port 8181 --deploy /opt/payara/deployments/SiemaApp-ear-1.0-SNAPSHOT.ear
#CMD ["/bin/bash"]
