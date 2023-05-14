Sell My Car backend API


- start the database with docker by running `docker build -t sell-my-car-db _docker/database` and `docker run -d -p 5432:5432 sell-my-car-db`
- build the application with `mvn clean install`
- run the application with `mvn spring-boot:run -Dspring-boot.run.profiles=dev`
- Now you can reach the application with `curl http://localhost:5050/sellmycar/api/car-auction | json_pp`

** you can also use run configurations in your IDE to run the application. In the file .run you can find the run configurations for IntelliJ IDEA.