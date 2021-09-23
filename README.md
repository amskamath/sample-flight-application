# sample-flight-application
Developed RESTful web services like POST,GET with request params
This Spring boot application is using h2-memory database to store records
To start the application we can either run main class or using command mvn spring-boot:run in terminal
We can create entries in Flight table using POST url http://localhost:8081/api/register
with Sample JSON object as follows:
{
    "flightNumber":"QF400",
    "departurePort":"MEL",
    "arrivalPort":"SYD",
    "departureTime":"2020-06-10T09:00:23Z",
    "arrivalTime":"2020-06-10T10:25:23Z"
}

We have GET api to list all flights in the database URL: http://localhost:8081/api/allflights
Response body: 
[
    {
        "id": 1,
        "departurePort": "MEL",
        "arrivalPort": "SYD",
        "departureTime": "2020-06-10T20:25:23+10:00:00",
        "arrivalTime": "2020-06-10T20:25:23+10:00:00",
        "flightNumber": "QF400"
    }
]

There is GET api along with request params as departuredate and code to get list of flights based on dates which is a required field and optional field code to filter results by airline code.
URL : http://localhost:8081/api/flightsbydate?departuredate=2020-06-10&code=QF
Sample Response :
[
    {
        "id": 1,
        "departurePort": "MEL",
        "arrivalPort": "SYD",
        "departureTime": "2020-06-10T20:25:23+10:00:00",
        "arrivalTime": "2020-06-10T20:25:23+10:00:00",
        "flightNumber": "QF400"
    }
]
-Basic Unit test cases added to check for get api.
