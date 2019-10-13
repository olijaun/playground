# idempotence-example

This is an example application related to my blog post at [https://idontbyte.jaun.org](https://idontbyte.jaun.org/blog/2019/09/Idempotence).

Spring boot application using jax-rs that shows how to implement a POST request that rejects subsequent requests with the same request id. It shows the use of local transactions in order to properly implement handling of the request id.

The application uses spring jdbc and programmatic transactions. The database is in-memory and all data is lost when you shut down the application. 

It is not meant as an example for a nicely designed applications. For demonstration purposes the main part of the application is in one single class ([AccountResource](src/main/java/org/jaun/idontbyte/idemotenceexample/AccountResource.java)).
