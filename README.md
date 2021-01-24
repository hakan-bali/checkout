# Overview
We are working with a client who wants to launch an e-commerce site to promote their brand, below are some of the products that they will be listing:

| ID | Name | Price |
| --- | --- | --- |
| 0001 | Water Bottle | £24.95 |
| 0002 | Hoodie | £65.00 |
| 0003 | Sticker Set | £3.99 |

The marketing team would like to run the following promotions;  
* If you spend over £75 then you get a 10% discount.  
* If you buy two or more water bottles then the price drops to £22.99 each.  

Multiple promotions can be applied to the same checkout.  
The checkout system needs to be able to scan the items in any order then apply the promotion rules.  
These rules should be allowed to change over time.  
The pseudocode below outlines the interface for the checkout:
```
checkout = new checkout(promotionalRules)
checkout.scan(items) // List of item objects created from the products above
println(checkout.total()) //e.g. £68.99
```  
Implement a checkout that meets these requirements.  
Do not worry about the storage or retrieval of any items in a database, for the purpose of this test they only need to be processed.

Test Data

Items: 0001,0001,0002,0003  
Total Price: £103.47  

Items: 0001,0001,0001  
Total Price: £68.97  

Items: 0002,0002,0003  
Total Price: £120.59  

This project has been developed with Java 11 source code compatibility.  

---
## Pre-requisites for the project
[Install](https://www.oracle.com/uk/java/technologies/javase/javase8u211-later-archive-downloads.html) JDK version 1.8+

[Install](https://gradle.org/install/) Gradle version 6.6

[Install](https://git-scm.com/downloads) Git version 2.24.3

---
## A fresh startup for the project
Go to any directory you'd like to create the project.
```
$ cd <ANY_DIRECTORY>
```
Clone the project from GitHub repository. Project files will be placed under <ANY_DIRECTORY>/grocery-scraper
```
$ git clone https://github.com/hakan-bali/checkout.git
```
Proceed to the project directory.
```
$ cd checkout
```
Gradle will download all required dependencies, build the project, and run the project with the command below:
```
$ ./gradlew run
```

---
### Clean build whole project from command line
```
$ ./gradlew clean build
```

---
### Running unit tests from command line
```
$ ./gradlew test
```

---
### Check that it is running
```
$ ./gradlew run
```

---
### Command line options

#### Usage:
```
$ ./gradlew run --args='0001 0002 0003' 
```
