# Alpine Linux with OpenJDK JRE
FROM adoptopenjdk/openjdk11:alpine-slim

#port
EXPOSE 8080

# Build Arguments
ARG ARTIFACT_ID=pmed_svc
ARG ARTIFACT_PATH=pmed_svc-boot/target

# copy JAR into image
RUN mkdir /opt/app
COPY ${ARTIFACT_PATH}/${ARTIFACT_ID}.war /opt/app/app.war

# run application with this projection line
CMD java -jar $JAVA_OPTIONS /opt/app/app.war