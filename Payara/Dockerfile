FROM payara/server-full:5.182

# Setup configuration
COPY mysql-connector-java-5.0.8-bin.jar /opt/payara5/glassfish/domains/domain1/lib/
COPY domain.xml /opt/payara5/glassfish/domains/domain1/config/
ADD SiemaApp-ear-1.0-SNAPSHOT.ear  /opt/payara5/glassfish/domains/domain1/autodeploy/
CMD ["asadmin", "start-domain", "-v"]
