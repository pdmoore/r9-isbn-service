# r9-isbn-service
R9 CI exercise, generate the jar file for r9-isbn-ci-starter

gradle clean
./gradlew build

jar tf build/libs/isbn-service-1.0.0.jar

resulting jar file is used in the r9-isbn-ci-starter project
