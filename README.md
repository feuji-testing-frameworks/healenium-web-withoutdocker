# Selenium-Healenium-web-withoutdocker

This project demonstrates the integration of Selenium with Healenium for self-healing automation tests in Java without using Docker.

## Prerequisites

- Java 8 or higher
- Maven
- An IDE (e.g., IntelliJ IDEA, Eclipse)
- Web browser (e.g., Chrome, Firefox)
- WebDriver for the chosen browser

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

   Create a `healenium.properties` file in the `src/main/resources` directory with the following content:

   ```properties
   hlm.server.url=http://localhost:7878
   hlm.save.elements=true
   ```

   Ensure the Healenium server is running. Refer to the Healenium documentation for more details.

3. **Run Tests**

   Execute the tests using your IDE or the following Maven command:

   ```sh
   mvn test
   ```

## Additional Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [Healenium Documentation](https://healenium.github.io/)
- [TestNG Documentation](https://testng.org/doc/)
