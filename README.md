# PairingStories
An application for pairing stories management. It ensures that pairing stories are digitized and saves paper.

## Technology Stack
Below is the list of technologies or frameworks used :

Technology | Version
-----------|---------
 Gradle    | 4.7
 Java      | 1.8.0_111
 Spring    | 4.3.17
 Groovy    | 2.4.12
 npm       | 6.1.0
 node      | 10.3.0

## Running the application
To run the application on Ubuntu machine please ensure all the above mentioned softwares are installed. Go to the project home directory and run command
```
gradle tomcatRun
```
This will start the embedded tomcat on the port 8091. If the port is already in use then you can change the port in the build.gradle file in the gretty configuration.(i.e. httpPort = 8091)

The UI will be distorted since we have not downloaded the npm dependencies. To fix the UI follow below steps

```
cd src/main/webapp
npm install
```

## Additional Details
To know further about the application visit [wiki page](https://github.com/AnandMuley/PairingStories/wiki)

## Copyright
Please get in touch with me if any improvements are needed in the project. I am a passionate software developer.

###### &copy; Anand Muley
