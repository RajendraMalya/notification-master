# notification-master

PROBLEM:
Generic Notification System 
 
Problem Statement 
Most applications have the need to implement notifications for a variety of use cases and
scenarios. Create a centralized generic service for notification that can be used by a variety
consuming application for their notification needs e.g. an incident workflow system may use
this system when each incident ticket moves from one state to another, similarly a order
management system may use this service to notify the customer of the status of the order
whenever it changes 
 
The system should allow for the following capabilities: 
 
1. Accept messages including from, to and subject 
2. Ability to notify on multiple channels (e.g email, slack, you can stub out/mock if
required) 
3. Deliver messages in correct order for each consumer of this  
 
Deliverables 
1. The code for the service in github with instructions on how to set it up and run it



SOLUTION:


To access Rest API doc: http://localhost:8082/api

API Reference
API 1: Notify to a Channel

URL: http://<HOST>/notifier/{channelType}/notify

This sends given message to a specified channel like slack or email. Where the channelType is slack or email.

e.g: http://localhost:8080/api/v1.0/notifier/{channelType}/notify
with body as:

{  
   "body": "Body of the message",  
   "from": "sender@gmail.com",  
   "subject": "Notification Service Test Subject",  
   "to": "receiver@gmail.com"  
 }
API 2: Notify All

URL: http://<HOST>/notifier/notifyAll

This sends given message to all configured channels like slack and email.

e.g: http://localhost:8080/api/v1.0/notifier/notifyAll with body as:

{  
   "body": "Body of the message",  
   "from": "sender@gmail.com",  
   "subject": "Notification Service Test Subject",  
   "to": "receiver@gmail.com"  
}

Make sure all email and slack properties are configured properly in application.properties.
If GMail ia configured as your mail service then set Allow less secure apps = ON in Sing-in & Security of your google account to send message properly .
