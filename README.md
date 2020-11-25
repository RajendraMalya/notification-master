# notification-master

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
