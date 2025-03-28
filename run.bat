call mvn clean package -DskipTests=true
call cd target/
call java -jar send-request-0.0.1-SNAPSHOT.jar 12 1000