FROM openjdk:11
ENV APP_HOME=/Apps/MoneyChange
WORKDIR $APP_HOME
COPY moneychange-0.0.1.jar $APP_HOME/moneychange-0.0.1.jar
ENTRYPOINT ["java","-jar","moneychange-0.0.1.jar"]
EXPOSE 9082