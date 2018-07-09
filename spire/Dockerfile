FROM ubuntu:xenial

ARG SPIRE_VERSION=0.6.0
ARG SPIRE_RELEASE=https://github.com/spiffe/spire/releases/download/${SPIRE_VERSION}/spire-${SPIRE_VERSION}-linux-x86_64-glibc.tar.gz
ARG SPIRE_DIR=/opt/spire
ARG SPIFFE_HELPER_DIR=/opt/spiffe-helper

ARG NGINX_VERSION=1.13.9spiffe5
ARG NGINX_RELEASE="https://github.com/spiffe/spiffe-nginx/releases/download/${NGINX_VERSION}/nginx-${NGINX_VERSION}.tgz"
ARG NGINX_DIR=/opt/nginx

ARG TOMCAT_VERSION=8.5.32
ARG TOMCAT_RELEASE="http://apache.dattatec.com/tomcat/tomcat-8/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz"
ARG TOMCAT_DIR=/opt/tomcat


RUN apt-get update \
  && apt-get install -y --no-install-recommends ca-certificates curl tar vim default-jre netcat iputils-ping

RUN curl --silent --location $SPIRE_RELEASE | tar -xzf -
RUN mv spire-${SPIRE_VERSION} ${SPIRE_DIR}

RUN curl --silent --location ${NGINX_RELEASE} | tar -xzf -
RUN mv nginx-${NGINX_VERSION} ${NGINX_DIR}

RUN curl --silent --location ${TOMCAT_RELEASE} | tar -xzf -
RUN mv apache-tomcat-${TOMCAT_VERSION} ${TOMCAT_DIR}

WORKDIR ${SPIRE_DIR}
COPY conf/agent.conf conf/agent/agent.conf
COPY conf/server.conf conf/server/server.conf
COPY create-user.sh .
COPY create-entries.sh .

RUN chmod +x create-entries.sh

