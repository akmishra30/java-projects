# camel-postgres-db
This project is camel and postgres db integration with basic operations. I have created two timer routes for select and insert respectively. I have externalize the DB configurations and sql queries for data reading and writing.

Next phase I will add more functionalities in this project along with unit test cases as well.

**Required Tech-spec :**
1. Java (1.8 or later)
2. Apache Camel (2.21.0)
3. Postgres DB (10)
4. Maven - (4.0.0)
5. Jboss Fuse 7
6. Karaf (4.2.0)
7. OSGi (5.6.10)

**DB Tables:**
- customer (id, name, city, address, contact)
- PK : id

**Building OSGi Bundle:**

Command to build this project

``` mvn clean install ```

**Jboss Fuse 7 Installation:**

Please follow Redhat Fuse 7 page to set up fuse 7 on your local machine.

**Deploying Bundle on Fuse:**
- Install camel-sql feature first from fuse karaf console

``` features:install camel-sql ```

- Install postgresql/9.4.1212 jar first from fuse karaf console

``` osgi:install wrap:mvn:org.postgresql/postgresql/9.4.1212 ```

- Install camel-postgres-db bundle from karaf console

``` osgi:install -s mvn:com.makhir.camel/camel-postgres-db/1.0.0 ```
