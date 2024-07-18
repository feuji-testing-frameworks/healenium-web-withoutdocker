# Selenium-Healenium-web-withoutdocker

This project demonstrates the integration of Selenium with Healenium for self-healing automation tests in Java without using Docker.

## Prerequisites

- Java 8 or higher
- Maven
- An IDE (e.g., IntelliJ IDEA, Eclipse)
- Web browser (e.g., Chrome, Firefox)
- WebDriver for the chosen browser
- PostgreSQL

## Project Setup

1. **Clone the repository**

   ```sh
   git clone <https://github.com/feuji-testing-frameworks/healenium-web-withoutdocker>
   cd <repository-directory>
   ```

2. **Install dependencies**

   Ensure you have Maven installed. If not, download and install it from [here](https://maven.apache.org/install.html).

   ```sh
   mvn clean install
   ```

## Configuration

1. **Add Healenium Dependencies**

   Add the following dependencies to your `pom.xml` file:

   ```xml
   <dependencies>
       <!-- Selenium dependencies -->
       <dependency>
           <groupId>org.seleniumhq.selenium</groupId>
           <artifactId>selenium-java</artifactId>
           <version>4.1.0</version>
       </dependency>

       <!-- Healenium dependencies -->
       <dependency>
           <groupId>com.epam.healenium</groupId>
           <artifactId>healenium-web</artifactId>
           <version>3.1.0</version>
       </dependency>

       <!-- Healenium client dependencies -->
       <dependency>
           <groupId>com.epam.healenium</groupId>
           <artifactId>healenium-client</artifactId>
           <version>3.1.0</version>
       </dependency>

       <!-- Test framework dependencies -->
       <dependency>
           <groupId>org.testng</groupId>
           <artifactId>testng</artifactId>
           <version>7.4.0</version>
           <scope>test</scope>
       </dependency>
   </dependencies>
   ```

2. **Healenium Configuration**

   Ensure the Healenium server is running. Refer to the Healenium documentation for more details.

   1. We need install first :
      Java 11+ , Python ( 3.12.0 )& PostgreSQL ( prefer to use latest 16 version )

   2. Once PostgersSQL installed ( make sure during installation whatever you put the password for the same you remember / noted down, need this is in 3rd step), open SQL Shell ( psql ) from the                    applications, as shown below:

   3. Once you open the Shell , hit ENTER till Username & provide same Password as in the step 2. 

   4. Now , feed one by one on the above terminal, this will create the DB ,  User & Schema for you:
   
           CREATE DATABASE healenium
           CREATE USER healenium_user WITH ENCRYPTED PASSWORD 'YDk2nmNs4s9aCP6K'
           GRANT ALL PRIVILEGES ON DATABASE healenium TO healenium_user
           ALTER USER healenium_user WITH SUPERUSER
           \c healenium healenium_user
           CREATE SCHEMA healenium AUTHORIZATION healenium_user
           GRANT USAGE ON SCHEMA healenium TO healenium_user


      and keep hit the ENTER after Each line you will get the O/p like below:

   5. Now install Heleanium-Web : 

   From the official document page by hitting download link 
   https://healenium.io/docs/download_and_install/hlm_web

   or use direct link :

   https://github.com/healenium/healenium/releases/download/1.4.0/healenium-1.4.0.zip


   6. Now Go to directory  /shell-installation/web, where the above Heleanium zip extracted.

      1. Download Healenium components. Run download_services.sh 
             If you are using Windows use cmd and use : run download_services.sh 
             or direct hit on the download_services.sh file.

             And on MacOX use new Terminal navigate to the respective directory & 
      type : chmod +x <and compete shell-installation/web PWD )
      on the next line type : sh download_services.sh

       2. Run start_healenium.sh
          use the above Windows suggestion for Win
          and on Mac use sh start_healenium.sh


   7. Now check are you able to see healenium report at localhost : 7878


3. **Run Tests**

   Execute the tests using your IDE or the following Maven command :

   ```sh
   mvn test
   ```

## Additional Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [Healenium Documentation](https://healenium.github.io/)
- [TestNG Documentation](https://testng.org/doc/)
