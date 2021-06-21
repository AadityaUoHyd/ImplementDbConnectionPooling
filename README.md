# Implement Your Own Connection Pool (Java, PostgreSQL) 

- As we all know, a pool is a collection of stateless objects. Connection pool in jdbc, is a factory that contains set of readily available jdbc connection objects, before actually it being used.

- Connection Pool is generally used where we have logical connection. It is widely used with databases. Connection pool is a data access pattern which maintains cache of collections. It will include all the available connection, as well as connections which are unused. The major goal of pooling is to reuse the connections. Since creation of connections are time consuming resources, hence reusing it reduces the overhead time consumption. Also developer has to write less code as it reduces repeat boiler plate code of database connection.

- Here, we will maintain a pool of available connection while developing demo connection pool. This pool of connection will store ‘n’ number of connections where ‘n’ means it has n number of initial capacity. For sake of testing I'm hard-coding initial-capacity as 10 here. Capacity can be increased based upon our need, with addMoreConnection(). As a request is raised to the pool, a connection will be allocated to the given request. This will keep on happening till there are connection in the pool. Once the available connection will become blank, the caller has to wait till a connection is made available. If waiting is not allowed then a null object can be returned back. The solution revolved around, maintain pool of available useful connection as well as maintaining connection, which are under use. Thus, promoting reuse.

- Add PostgreSQL connector dependency in your pom.xml
(I’m using PostgreSQL, one can use any SQL database).

![](https://github.com/AadityaUoHyd/implementConnectionPooling/blob/master/cp.jpg?raw=true)

- In real time, we never create our own connection pool unless one have some sort of custom requirement. We use 3rd party connection pool such as - Apache DPCP, C3, HikariCP, etc.
