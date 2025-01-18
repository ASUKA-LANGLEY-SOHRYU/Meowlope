FROM gradle:jdk21-corretto-al2023 AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle.kts settings.gradle.kts gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
COPY ./src ./src
RUN chmod +x $APP_HOME/gradlew
RUN ./gradlew build
RUN ls $APP_HOME/build/libs

FROM gradle:jdk21-corretto-al2023
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/app.jar /usr/app/app.jar
RUN ls $APP_HOME
EXPOSE 8765
CMD ["java","-jar", "/usr/app/app.jar"]
