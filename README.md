Description:
=====================

This project automates the automation assignment using Selenium with Cucumber framework and Maven as build management tool.


Prerequisites/Configuration setup required for the project:
=====================
  IntelliJ dea 2016.3.2
  
  JRE/JDK 1.8
  
  Maven 3.1.1
  
  
Download and setup project on local machine:
=====================

  Download and open the project as an existing maven project in IntelliJ IDE.
  
  Select correct maven directory under ‘Maven home directory' in File->Settings->Build,execution, deployment->Maven
  
  Select correct JDK for the project
  
  Re-build the project and all the maven dependencies will be automatically resolved.
  
Run from IDE:
============

  Right click on Test.java and select ‘Run Test.java’ file under Java folder to run the scenarios.
 
Run from Maven:
==============

  Go to terminal or open command prompt
  
  Navigate to Project path
  
  Run the command ‘mvn clean install’
  

Viewing reports:
=====================

 When executing from IDE, reports are generated at ‘target/html report/Report/index.html’
 
 When executing through command prompt, additionally cucumber report is generated at ‘target/Cucumber-HTML-reports’
 
