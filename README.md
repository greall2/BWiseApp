# BWiseApp

## Introduction
BWise is a Spring Boot Application configured with a MySql Database we created for our Final Year Project. Bwise is a web application for you to track your spendings. 

With BWise you can save and manage all your transactions in one place. Along with the features of Delete and Update, you can also search your transaction history from specific dates. With BWise you also have the option of converting your transaction to a PDF file which then  can be printd if you require a hardcopy.

## The Name: “Bwise”
Once given go ahead for our app from our Supervisor Dr John Healy, we decided we needed to decide on a name for our budgeting application. We came up with several different names but decided to go with the name Bwise. 
Why we decided on Bwise :
* B stands for Budget ->  ”Budget Wise”
* The idea behind the application is to Be Wise with our money and spending.

## Aims
By the time we complete the project, we aim for our application to include some features such as:
* We aim to create an application for a user to be able to track all their spending’s in one place.  The User can enter the amount and description which would be saved to a database and then be displayed on a table along with the date and time stamp and ID number. 
* Secondly, we want the user of the application to be able to update or delete any of the transactions saved in the database.
*	Calculate all the transactions inputted by the User to give a total amount of their expenditure.
*	Allow the user to be able to search their spending’s by date and also, allow the user to create a PDF file of Results that they can print if they so wish.


## Technology Used & Why:
We decided to create our ‘BWise‘ Application using Spring Boot with Java along with MySql database. We chose these Technologies for our application for many different reasons.
### Spring Boot:
Spring Boot is among the new features of Spring Framework version 4.0. The main objective of Spring Boot is to provide quick and simple java applications using an embedded server, Tomcat.
Spring Boot is not a framework to write applications, it is a feature that helps you build, package and deploy your Spring application with minimal configurations. 
We chose to use Spring Boot as it is one of the most popular Java frameworks in the market. Before this semester, we hadn’t used the framework Spring before and decided it would be a good technology to expand on and gain some experience in. 



### MySql:
MySql is an open-source relational database management system based on Structured Query Language (SQL).  It is ranked as one of the most popular database engines along with Oracle. It is written in C and C++, and runs virtually on all platforms like Windows, Linux etc. 
We picked to work with MySql for our database for several different reasons, such as:
*	It is ranked very high in use in Industry
*	We have prior experience in working with MySql databases
*	Wide range of documentation available
*	It has several different tools we could use to work with our database, like MySql Workbench

## Running the Application

```sh
Open the Project in STS(Spring Tool Suite)
Open the Application.java class found in the package 'bwise' and Run as Sprint Boot Application
Open browser and run:
                      localhost:8080
                      
**NOTE: Ensure you have configured your database user and password correctly in the file 'application.properties' and that wamp is running

```

## Limitations:
In the process of the project, the main limitation we came across was that there are limited resources to Spring Boot resources and guidelines compared to other features. This is because Spring Boot is recent feature in the Spring framework. 
Also we felt limited as it was a new technology for us. This meant it took time to learn and understand most features. 
Known Bugs:
The main known bug in our application is the Log in. We got a registration form working where the users’ details are saved to the database, however we did not get the full login to work, meaning the application is a single user system. 
Also, another bug in the application is that the password in which the user can register is not encrypted, it is just hard-coded, which is not good security.

## Recommendations for Future Development:
Firstly, we would like to fix the known bugs in our application. This would be to have a working login so the application can be a multi user system and also to have the passwords encrypted in the database. 
The we would like to add features like graph. These graphs would be generated based on the users spending’s’ history and be a visualisation of all their transactions.

## Conclusion:
Overall, throughout the development of this project, we both feel we have learned a lot with working with Spring Boot and the MySql database. However, we do feel that there is a lot more about these technologies, especially Spring that we could learn and gain experience in. 

## Demo Video

link to BWise Demo : https://www.youtube.com/watch?v=8M5AX1tlLGg


## References:

*	https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
*	https://spring.io/guides/gs/spring-boot/
*	https://spring.io/guides/gs/accessing-data-mysql/
*	https://dev.mysql.com/doc/
*	http://stackoverflow.com/questions/43444279/css-not-being-applied-to-print




```
