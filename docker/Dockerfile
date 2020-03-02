FROM openjdk:15-jdk-alpine3.11
ENV TZ='Asia/Tokyo'

ENV SBT_VERSION=1.3.8
ENV SBT_HOME=/usr/local/sbt

ENV SCALA_VERSION=2.12.10
ENV SCALA_HOME=/usr/share/scala

ENV PATH ${PATH}:${SCALA_HOME}/bin:${SBT_HOME}/bin

# Install base packages
RUN  apk upgrade --update && \
    apk add curl wget bash tree tar && \
    echo -ne "Alpine Linux 3.11 image. (`uname -rsv`)\n" >> /root/.built

# Install Scala
RUN mkdir -p ${SBT_HOME} && \
    mkdir -p ${SCALA_HOME} && \
    cd /root
RUN apk --update add bash wget curl tar git && \
    wget https://downloads.typesafe.com/scala/$SCALA_VERSION/scala-$SCALA_VERSION.tgz -O scala-$SCALA_VERSION.tgz && \
    tar -xf scala-$SCALA_VERSION.tgz && \
    mv "scala-${SCALA_VERSION}/bin" "scala-${SCALA_VERSION}/lib" "${SCALA_HOME}" && \
    echo -ne "- with scala $SCALA_VERSION\n" >> /root/.built && \
    scala -version && \
    rm scala-$SCALA_VERSION.tgz

# Install sbt
RUN \
    mkdir -p "$SBT_HOME" && \
    wget "https://github.com/sbt/sbt/releases/download/v$SBT_VERSION/sbt-$SBT_VERSION.tgz" && \
    tar -xf sbt-$SBT_VERSION.tgz -C /usr/local && \
    echo -ne "- with sbt sbt-$SBT_VERSION\n" >> /root/.built && \
    rm sbt-$SBT_VERSION.tgz && \
    apk del wget tar && \
    rm -rf /var/cache/apk/

WORKDIR /home/workspace
CMD ["/bin/sh"]
