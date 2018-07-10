FROM spire

RUN mkdir /opt/back-end
COPY run-backend.sh /opt/back-end
RUN chmod +x /opt/back-end/run-backend.sh

RUN rm -Rf /opt/tomcat/webapps/ROOT*
COPY build/libs/back-end-0.1-SNAPSHOT.war /opt/tomcat/webapps/ROOT.war
COPY server.xml /opt/tomcat/conf/server.xml

RUN chmod +x create-user.sh
#Create linux user for the workload (back-end app)
RUN ./create-user.sh backend 1000

RUN mkdir -p /usr/local/nginx/logs
RUN mkdir -p /usr/local/nginx/conf
COPY nginx/nginx-backend.conf /usr/local/nginx/conf/nginx.conf

