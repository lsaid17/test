**Test Back**

Prerequisites

Java Development Kit (JDK) 21: Download and install Java JDK 21 from the official Oracle website: https://www.oracle.com/java/technologies/downloads/

Maven 3.9.6: Download and install Apache Maven from the official website: https://maven.apache.org/download.cgi

Docker 25.0.4: Download and install Docker Desktop from the official website: https://www.docker.com/products/docker-desktop/

Installation

Clone the Repository:


git clone https://github.com/lsaid17/test.git

Navigate to Project Directory:


cd test-api-back


Build the Project:


mvn clean install


Database Setup:

This project utilizes a PostgresSQL database. You can set up a PostgresSQL database container using docker-compose (assuming it's installed and configured).


Navigate to the docker folder within the project directory:

cd {Project_Home_Directory}/test-api-back/docker/

Run:

PWD=${PWD} docker-compose -p test-api up -d

If you need to use sudo for Docker, adjust the command accordingly.



Environment Variables:

export PATH=/home/{path}/jdk-21_linux-x64_bin/jdk-21.0.2/bin:$PATH
export PATH=/home/{path}/apache-maven-3.9.6-bin/apache-maven-3.9.6/bin:$PATH

Starting the Application:
Set below variable as VM arguments before starting up the project.

-Drest.api.dir={Project_Home_Directory}/test-api-back/config/test/

Run the Application:

The application might expose a actuator endpoint at http://localhost:8085/test/rest-api/actuator/health after successful deployment.


**Test Front**

Prerequisites

NodeJs 22.2.0: Download and install NodeJs from the official website: https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.0/install.shInstallation


Clone the Repository:

git clone https://github.com/lsaid17/test.git

Navigate to Project Directory:

cd test-api-front/test-api-app

Build the Project:

npm install

Starting the Application:
npm start

The application expose a endpoint at http://localhost:3000/ after successful deployment.
