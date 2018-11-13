FROM payara/server-full
ENV JDBC_URL=https://downloads.mariadb.com/Connectors/java/connector-java-2.3.0/mariadb-java-client-2.3.0.jar
RUN wget --quiet --no-check-certificate $JDBC_URL
RUN cp -r mariadb-java-client-2.3.0.jar /opt/payara5/glassfish/lib/mariadb-java-client-2.3.0.jar
ADD mysql-connector-java-5.1.47.jar /opt/payara5/glassfish/lib/mysql-connector-java-5.1.47.jar
ADD pass.txt /pass.txt
RUN /opt/payara5/bin/asadmin start-domain
#RUN /opt/payara5/bin/asadmin restart-domain &&\
#/opt/payara5/bin/asadmin create-jdbc-connection-pool --datasourceclassname=com.mysql.jdbc.jdbc2.optional.MysqlDataSource --restype=javax.sql.DataSource --Property 'user="root":password="prn335":databasename=flota:portnumber=3306:url="jdbc:mysql://mariadb_prn335:3306/flota":driverClass=com.mysql.jdbc.Driver:servername=mariadb_prn335' flota_pool_prn335 --user admin -- passwordfile /pass.txt
#RUN /opt/payara5/bin/asadmin pingconnection-pool flota_pool_prn335
#RUN /opt/payara5/bin/asadmin create-jdbc-resource --connectionpoolid flota_pool_prn335 jndi_flota --user admin --passwordfile /pass.txt
RUN /opt/payara5/bin/asadmin restart-domain && \
/opt/payara5/bin/asadmin create-jdbc-connection-pool --datasourceclassname=com.mysql.jdbc.jdbc2.optional.MysqlDataSource --restype=javax.sql.DataSource --property='user=root:password=prn335:url="jdbc:mysql://172.29.0.2:3306/flota":portNumber=3306:dataBaseName=flota:driverClass=com.mysql.jdbc.Driver:serverName=172.29.0.2' ues_pool_CasosAcad --user admin --passwordfile /pass.txt && \
/opt/payara5/bin/asadmin create-jdbc-resource --connectionpoolid ues_pool_CasosAcad ues_jndi_casosAcad --user admin --passwordfile /pass.txt
#RUN /opt/payara5/bin/asadmin ping-connection-pool ues_pool_CasosAcad