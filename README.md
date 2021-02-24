# Project Title - policyexperts
Web testing 
via Selenium, Cucumber and Java

## Getting Started
****************

* Clone the repo
* Tests were not complete. Test class can be found in **/src/test/java/com/policyexpert/automation/PolicyExpertHomeTest.java**
* Data driven via Cucumber and feature file  can be found in **/src/test/resources/features/policy.feature**

### Prerequisites
Docker and GIT

### Installing
* Clone the repo
* Navigate to the project directory for the cloned repo.
* Edit configuration in docker-compose.yml if needed
    > * Default port for chrome in compose is **4444:4444**, you can change if port is 
    already in use (e.g `<port4Chrome>`:4444)
    > * Default port for vnc viewer in compose is **5900:5900**, you can change if port is 
    already in use (e.g `<port4VNC>`:5900)
    > * Include remote uri in -Dbrowser.remote_uri. Get host machine IP address. 
    For example using ifconfig on your terminal and search for IPv4 address or 
    inet addr. **http://`<HostIPADD>`:`<port4Chrome>`/wd/hub** (e.g, **'http://194.133.4.53:4444/wd/hub'**)
   
````yaml
chrome:
    image: selenium/standalone-chrome-debug:3.141.59-neon
    ports:
      - "5900:5900"
      - "4444:4444"
maven:
    image: maven:3.6.1-jdk-12
    stop_signal: SIGKILL
    stdin_open: true
    tty: true
    working_dir: $PWD
    volumes:
      - $PWD:$PWD
      - /var/run/docker.sock:/var/run/docker.sock
      - ~/.m2:/root/.m2
    command: bash -c "mvn clean install &&
             mvn verify -pl functionaltest
             -Dbrowser.remote_uri='http://<HostIPADD>:4444/wd/hub'
             -Dskip.tests=‘false’" 
````

### Running the tests
* To run in foreground,  
> ***docker-compose up*** 

* To run via mvn once you set your chrome driver either via docker or locally,  
> ***mvn clean install && mvn verify -pl functionaltest -Dskip.tests=false*** 


* View test run by using the VNC server. In your browser type in vnc://localhost:5900 or vnc://`<HostIPADD>`:`<port4VNC>`
When you are prompted for the password it is **secret**




### Authors
Tunde Oduniyi


