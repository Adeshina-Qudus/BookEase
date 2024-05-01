# BookEase

# Table of Contents
- [Introduction](#introduction)
- [Requirements](#requirements)
- [Installation](#installation)
- [Features](#features)
- [UserApi](#userApi)


## Introduction   
BookEase is a streamlined booking system designed to simplify the process of scheduling appointments, reservations, and services. Whether you're booking for a concert,  or reserving a spot at a confrence, BookEase makes it easy for you .

## requirements

- JDK 21
- SpringBoot


## Features



- createAccount
- login
- createEvent
- cancelEvent
- reserveTicket
- viewBookedEvent
- cancelReservation
- viewBookedEvent


## Installation

1. Create an account with git
2. From your terminal/ command prompt clone the repository using this git command
      -  git clone https://github.com/Adeshina-Qudus/BookEase.git
3. Ensure all dependencies in the project are well injected in your pom.xml.
      -  To download and build the project you can run this command on the terminal: mvn clean install
4. setup mysql database to configure database connection.
5. To start the application from your IDE run the application main class.Alternatively you can run this command on the terminal
      -  mvn spring-boot:run
6. install postman to test the application end-points by providing the necessary url and body requests if necessary.


## UserApi


  CreateAccountRequest

   Description

   This end point create a new user, it takes in the user name , email and password. The email and password are expected to meet the following criteria.
   
## Email Validation:

                valid Email : user@gmail.com
   
  1.  Domain: gmail
  2.  Top-level domain: com

## Password Validation:

                 valid Password : HolyChild12@
  
1. Starts with an uppercase letter.
2. Followed by more than four letters.
3. Ends with at least one digit or special character.
               
 ## Request
 -  Url: localhost:2020/api/v1/customer/register
 -  Method: Post
 -  Header: content-type:application/json
 -  Body:

             {
                   "name" : "boyDirector",
                   "email" :"qudusa55@gmail.com",
                   "password" : "Director12%"
             }

  - Response body
        
              {
                      "successful": true,
                     "data": {
                     "message": "Account Created"
                             }
              }
    ## Trying To CreateAccount With This Again ?
     status: 404 Bad Request
  
              {
                   "name" : "boyDirector",
                   "email" :"qudusa55@gmail.com",
                   "password" : "Director12%"
              }

    - Response body
        
        
              {
                      "successful": true,
                     "data": {
                     "message": "user with qudusa55@gmail,com already exist"
                             }
              }
      
      ## Trying To CreateAccount With Invalid Password Format ?
      
         status: 404 Bad Request
  
              {
                   "name" : "boyDirector",
                   "email" :"qudusa55@gmail.com",
                   "password" : "director12"
              }

      - Response body
        
        
              {
                      "successful": true,
                     "data": {
                     "message": "invalid password format"
                             }
              }

        ## Trying To CreateAccount With Invalid Email Format ?
      
         status: 404 Bad Request
  
              {
                   "name" : "boyDirector",
                   "email" :"qudusa55@gmail.com",
                   "password" : "director12"
              }

      - Response body
        
        
              {
                      "successful": true,
                     "data": {
                     "message": "invalid Email format"
                             }
              }

        
    

           

         


