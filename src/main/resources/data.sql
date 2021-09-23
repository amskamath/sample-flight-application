/*DROP TABLE IF EXISTS Flight;

CREATE TABLE Flight (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  flight_Number VARCHAR(250) NOT NULL,
  departurePort VARCHAR(250) NOT NULL,
  arrivalPort VARCHAR(250) NOT NULL,
  departureTime smalldatetime NOT NULL,
  arrivalTime smalldatetime NOT NULL
);*/

/*INSERT INTO Flight (flight_Number, departurePort, arrivalPort,departureTime, arrivalTime ) VALUES
  ('QF400', 'MEL', 'SYD', '2020-09-23T09:00:23Z', '2020-09-23T09:00:23Z'),
  ('EK240', 'DOH', 'MEL', '2020-09-23T09:00:23Z','2020-09-24T09:00:23Z'),
  ('CX','CAN', 'PER', '2020-09-24T09:00:23Z','2020-09-24T14:00:23Z');
  
  SELECT * from Flight;*/