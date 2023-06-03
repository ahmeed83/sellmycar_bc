Sell My Car backend API


- start the database with docker by running `docker build -t sell-my-car-db _docker/database` and `docker run -d -p 5432:5432 sell-my-car-db`
- build the application with `mvn clean install`
- run the application with `mvn spring-boot:run -Dspring-boot.run.profiles=dev`
- Now you can reach the application with `curl http://localhost:5050/sellmycar/api/car-auction | json_pp`

** you can also use run configurations in your IDE to run the application. In the file .run you can find the run configurations for IntelliJ IDEA.

Testing with Postman:

Go to doc/postman and import this file: SellMyCar.postman_collection.json in post man

Steps:

1- Signup customer, copy the jwt token

2- Go to -> get active auction DEALER!

3- paste the jwt token of the customer and send the request, you will get 403, because this endpoint is secured for the Dealer

4- Signup dealer, copy the jwt token, and repeat step 2 & 3, you will get 200, because it is a Dealer JWT token :) 