# Event-Management-System
---  

Design Document  

Ali Ibrahim, Benjamin Gomori, Kevin Zhu

## Introduction  

When using the Event Management System, managers can access events and details about the event. The system simply acts as a central repository for businesses to store events and related information. An Event Management System reduces the number of processes required to handle your events, making the administrative process considerably more efficient. They have the ability to change or remove events as well as the information associated with them. They can add a new event to the system. Aside from searching for a specific event.
Managers can use a set of RESTful service endpoints, a simple UI, or both to communicate with Event-Management-System.  

## Storyboard  
[StoryBoard-ED.pptx](https://github.com/ayibrahim1/Event-Management-System/files/7924388/StoryBoard-ED.pptx)

## Requirments  

## Scenario  1

As a manager I want to be able to edit an event's information, so that I have the updated information on my events stored in my database.  

#### Examples  

##### 1.1

**Given**: An event's information is available.    

Example\  id(4),Name("Birthday"),Address("567 Main St., Cincinnati, Ohio, USA"), Date(01/28/2022), Time(5:00 pm), Description("It is Sam's 31st Birthday!!").  

**When**: The manager selects edit next to the event they would like to edit, and edits the Description to "It is Sam's (CEO) 32st Birthday!!". 

**Then**: Then edited information of the event is updated in the database.     

Example \  id(4),Name("Birthday"),Address("567 Main St., Cincinnati, Ohio, USA"), Date(01/28/2022), Time(5:00 pm), Description("It is Sam's (CEO) 32st  Birthday!!").  

##### 1.2

**Given**: An event's information is available.

Example\  Id(4),Name("Birthday"),Address("567 Main St., Cincinnati, Ohio, USA"), Date(01/28/2022), Time(5:00 pm), Description("It is Sam's (CEO) 31st Birthday!!").

**When**: The manager selects edit next to the event they would like to edit, and edits the Name to an empty string "".

**Then**: Then data is not updated in the database and manager receives an error message .

Example \  Id(4),Name("Birthday"),Address("567 Main St., Cincinnati, Ohio, USA"), Date(01/28/2022), Time(5:00 pm), Description("It is Sam's (CEO) 31st Birthday!!").

## Scenario 2 

As a manager I want to be able to delete an event, so that the event's information is deleted from my database.  

#### Examples 

##### 2.1

**Given**: An event's information is available.

**When**: The manager selects delete next to the event they would like to delete.    

Example \  Id(4), Name("Birthday"),Address("567 Main St., Cincinnati, Ohio, USA"), Date(01/28/2022), Time(5:00 pm), Description("It is Sam's (CEO) 32st Birthday!!").

**Then**: Then manager can delete the event, and it is deleted from the database.   

##### 2.2

**Given**: An event's information is available.

**When**: The manager selects delete next to the event they would like to delete, and internet connection is lost.

Example \  Id(4), Name("Birthday"),Address("567 Main St., Cincinnati, Ohio, USA"), Date(01/28/2022), Time(5:00 pm), Description("It is Sam's (CEO) 32st Birthday!!").

**Then**: Then manager the event is not deleted from the database.

## Scenario 3 

As a manager I want to be able to add a new event, so that I can store the event information in my database.  

#### Examples

##### 3.1

**Given**: A new event tab is available.

**When**: The manager selects the new event tab, fills the form that shows up, and submits the form.  

Example \  Name("Prom"),Address("456 Salt Rd., Sydney, Ohio, USA"), Date(04/25/2022), Time(4:00 pm), Description("Need to get balloons").

**Then**: The event information is saved as a new record in the database.    

Example \  Id(5),Name("Monthly Office Event"),Address("456 Salt Rd., Sydney, Ohio, USA"), Date(04/25/2022), Time(4:00 pm), Description("Office monthly happy hour - Bowling").  

##### 3.2

**Given**: A new event tab is available.

**When**: The manager selects the new event tab, fills the form that shows up, and submits the form without providing a date.

Example \  Name("Prom"),Address("456 Salt Rd., Sydney, Ohio, USA"), Date(), Time(4:00 pm), Description("Office monthly happy hour - Bowling").

**Then**: The event information is not sent to the server, and the event is not stored in the database.



## Scenario  4

As a manager I want to be able to specifically search for an event, so that I can preview that events information that is in my database.  

#### Examples  

##### 4.1

**Given**: A search bar is available.

**When**: The manager enters the event name.    

Example \  Name("Birthday"). 

**Then**: Then manager can preview the information of the event that is in the database.    

Example \  Name("Birthday"),Address("567 Main St., Cincinnati, Ohio, USA"), Date(01/28/2022), Time(5:00 pm), Description("It is Sam's (CEO) 32st Birthday!!")    

##### 4.2

**Given**: A search bar is available.

**When**: The manager searches for a Name that does not exist in the databse.

Example \  Name("Event 234").

**Then**: No event data is retrieved from the database.

### Class Diagram  

![Class Diagram-ED](https://user-images.githubusercontent.com/54749949/150756926-f6b9a42a-8746-4615-a095-3fb8d5e7a68d.png)  


### JSON Schema  
#### Event
> {
>   "type": "object",
>   "properties" : {
>      "name" : {
>          "type" : "string" 
>       },
>       "address" : {
>          "type" : "string" 
>       },
>      "city" : {
>          "type" : "string" 
>       }, 
>       "state" : {
>          "type" : "string" 
>       }, 
>       "country" : {
>          "type" : "string" 
>       },
>       "date" : {
>          "type" : "date" 
>       },
>       "time" : {
>          "type" : "time" 
>       },
>       "description" : {
>          "type" : "string" 
>       },
>       "groupid" : {
>          "type" : "int" 
>       },
>       "room" : {
>          "type" : "int" 
>       },
>    }
>   }


#### Group
> {
>   "type": "object",
>   "properties" : {
>       "id" : {
>          "type" : "int"
>    }
>   "name" : {
>          "type" : "string"
>       },
>    }
> }  


### Team Memebers and Roles  

- DevOps/Product Owner/Scrum Master: Ali Ibrahim  

-	Frontend Developer: Kevin Zhu

-	Integration Developer: Benjamin Gomori


## Milestones
[Milestone #1](https://github.com/ayibrahim1/Event-Management-System/milestone/1)  
[Milestone #2](https://github.com/ayibrahim1/Event-Management-System/milestone/2)  
[Milestone #3](https://github.com/ayibrahim1/Event-Management-System/milestone/3)
  
 
### github.com project link:  
https://github.com/ayibrahim1/Event-Management-System  

### Weekly Meeting  

Meeting are at 3:00pm on Monday using Microsoft Teams.
