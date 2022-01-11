# Event-Management-System
---  

Design Document  

Ali Ibrahim, Benjamin Gomori, Yehya Hamed

## Introduction  

When using the Event Management System, managers can access events and details about the event. The system simply acts as a central repository for businesses to store events and related information. An Event Management System reduces the number of processes required to handle your events, making the administrative process considerably more efficient. They have the ability to change or remove events as well as the information associated with them. They can add a new event to the system. Aside from searching for a specific event.
Managers can use a set of RESTful service endpoints, a simple UI, or both to communicate with Event-Management-System.  

## Storyboard  
[StoryBoard-ED.pptx](https://github.com/ayibrahim1/Event-Management-System/files/7845689/StoryBoard-ED.pptx)  


## Requirments  

## Scenario  

As a manager I want to be able to edit an events information, so that I have the updated information on my events stored in my database.  

#### Example  

**Given**: An events information is available.    

Example\  Name("Birthday"),Address("567 Main St., Cincinnati, Ohio, USA"), Date(01/28/2022), Time(5:00 pm), Description("It is Sam's 31st Birthday!!").  

**When**: The manager selects edit next to the event they would like to edit.  

**Then**: Then manager can edit the information of the event and it will be updated in the database.     

Example \  Name("Birthday"),Address("567 Main St., Cincinnati, Ohio, USA"), Date(01/28/2022), Time(5:00 pm), Description("It is Sam's 32st Birthday!!").  

## Scenario  

As a manager I want to be able to delete an event, so that the events information is deleted from my database.  

#### Example  

**Given**: An events information is available.

**When**: The manager selects delete next to the event they would like to delete.    

Example \  Id(4), Name("Birthday"),Address("567 Main St., Cincinnati, Ohio, USA"), Date(01/28/2022), Time(5:00 pm), Description("It is Sam's 32st Birthday!!").

**Then**: Then manager can delete that event and it will be delete from the database.   

## Scenario  

As a manager I want to be able to add a new event, so that I can store the event information in my database.  

#### Example  

**Given**: A new event tab is available.

**When**: The manager selects the tab and a form show up for infomation regarding the event.  

**Then**: Then manager can add the information of the event, which includes . This information will be stored in the database.    

Example \  Name("Prom"),Address("456 Salt Rd., Sydney, Ohio, USA"), Date(04/25/2022), Time(4:00 pm), Description("Need to get balloons").  

## Scenario  

As a manager I want to be able to specifically search for an event, so that I can preview that events information that is in my database.  

#### Example  

**Given**: A search bar is available.

**When**: The manager enters the event name.    

Example \  Name("Birthday"). 

**Then**: Then manager can preview the information of the event that is in the database.    

Example \  Name("Birthday"),Address("567 Main St., Cincinnati, Ohio, USA"), Date(01/28/2022), Time(5:00 pm), Description("It is Sam's 32st Birthday!!")    

### Class Diagram  

![Class Diagram-ED](https://user-images.githubusercontent.com/83904035/148925979-127898d8-ba22-4716-9dde-cce68a06e143.PNG)  


### JSON Schema  

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
>    }
>   }

### Team Memebers and Roles  

- DevOps/Product Owner/Scrum Master: Ali Ibrahim  

-	Frontend Developer: 

-	Integration Developer:  

## Milestones

  
 
### github.com project link:  
  


### Weekly Meeting  

Meeting at on  on Microsoft Teams.
