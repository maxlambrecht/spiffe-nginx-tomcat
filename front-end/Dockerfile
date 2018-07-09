FROM spire

ARG SPIFFE_HELPER_DIR=/opt/spiffe-helper

RUN mkdir /opt/front-end
COPY run-frontend.sh /opt/front-end
RUN chmod +x /opt/front-end/run-frontend.sh

RUN rm -Rf /opt/tomcat/webapps/ROOT*
COPY build/libs/front-end-0.1-SNAPSHOT.war /opt/tomcat/webapps/ROOT.war
COPY server.xml /opt/tomcat/conf/server.xml

RUN chmod +x create-user.sh

#Create linux users for the workload (front-end app)
RUN ./create-user.sh frontend 1000
RUN ./create-user.sh frontend2 1001

RUN mkdir -p /usr/local/nginx/logs
RUN mkdir -p /usr/local/nginx/conf
COPY nginx/nginx-frontend.conf /usr/local/nginx/conf/nginx.conf
