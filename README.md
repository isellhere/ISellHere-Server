[![Java: version](https://img.shields.io/badge/JAVA%20-7-blue.svg)](https://www.oracle.com/technetwork/java/javase/jdk7-relnotes-429209.html)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

# ISellHere Server

ISellHere objective is to facilitate the digital integration of local business.

This is the default API application for the ISellHere platform. It is a RESTfull API written in Spring Boot framework.

> Course project for the discipline *Software Engineering*, U.F.C.G. Computer Science program.



## Prerequisites

* `Java 7`
* Maven

## Building from source

1. Ensure you have 

   ```java``` installed - goto http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html to download installer for your OS.    
   ```maven``` installed - goto https://maven.apache.org/download.cgi to download latest version of maven.

1. Clone this repository to your local filesystem (default branch is 'master')

1. To download the dependencies
   ```
    mvn install
   ```

1. To run the application, run the following command on the project root folder

   ```
    mvn spring-boot:run
   ```

   Note: If you see a warning similar to the one shown below on running `Disabling contextual LOB creation as createClob() method threw error`, see this question https://stackoverflow.com/questions/4588755/disabling-contextual-lob-creation-as-createclob-method-threw-error

   ```
    java.lang.reflect.InvocationTargetException: null
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:564) ~[na:na]
        at org.hibernate.engine.jdbc.env.internal.LobCreatorBuilderImpl.useContextualLobCreation(LobCreatorBuilderImpl.java:113) [hibernate-core-5.2.17.Final.jar:5.2.17.Final]
        at org.hibernate.engine.jdbc.env.internal.LobCreatorBuilderImpl.makeLobCreatorBuilder(LobCreatorBuilderImpl.java:54) [hibernate-core-5.2.17.Final.jar:5.2.17.Final]
        at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentImpl.<init>(JdbcEnvironmentImpl.java:271) [hibernate-core-5.2.17.Final.jar:5.2.17.Final]
   ```
## Running maven tasks

### Running the tests

You just need to run the following command:

`mvn test`

## Authors

* **Benardi Nunes** - *Testing and Back-end* - [Benardi](https://github.com/Benardi)
* **Iaron da Costa Araújo** - *Back-end* - [iaronaraujo](https://github.com/iaronaraujo)
* **Hadrizia Santos** - *Back-end* - [iaronaraujo](https://github.com/iaronaraujo)
* **Wesley Silva** - *Back-end* - [SILVAWesley](https://github.com/SILVAWesley)

See also the list of [contributors](https://github.com/isellhere/ISellHere-Server/contributors) who participated in this project.

## License

This project is licensed under the GPL v3 License - see the [LICENSE.md](LICENSE.md) file for details
