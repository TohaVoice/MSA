#
# Set a variable that can be used in all stages.
#
ARG BUILD_HOME=/hw01-docker

#
# Gradle image for the build stage.
#
FROM gradle:jdk17 as build-image

#
# Set the working directory.
#
ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
WORKDIR $APP_HOME

#
# Copy the Gradle source code into the build container.
#
COPY --chown=gradle:gradle build.gradle settings.gradle $APP_HOME/
COPY --chown=gradle:gradle src $APP_HOME/src

#
# Build the application.
#
RUN gradle --no-daemon build

#
# Java image for the application to run in.
#
FROM openjdk:17-alpine
ENV JAR_NAME=hw01-docker.jar

#
# Copy the jar file in and name it app.jar.
#
ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
COPY --from=build-image $APP_HOME/build/libs/$JAR_NAME app.jar

#
# The command to run when the container starts.
#
EXPOSE 8000
ENTRYPOINT java -jar app.jar
ENV HTTP_PORT=8000 APP_LOG_LEVEL=ERROR