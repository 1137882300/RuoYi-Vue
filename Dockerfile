FROM openjdk:8-jre

COPY ./ruoyi-admin/target/ruoyi-admin.jar /app.jar

EXPOSE 8088

CMD ["java", "-jar", "/app.jar", "--server.port=8088"]