This is the code test of AS on 2018/02/24
## Basic Tasks
This is the basic function which meet the test requirement.

#### CSV Reader
CSV reader is build base on "opencsv" library

#### Mapping relationship between courses and preRequisite

By reading messages from two csv files, we can obtain relationshipas below:

"courses can be found by id and preReuisites use id to define preReuisites relationship"

That is a typical Hashmap format with "Key" equals to id and "Value" equals to course

So a Object named "CourseModel" is build which contains information as below:

 - String courseName
 
    - the name of course
 - List< CourseModel > preRequisite
 
    - Contain all preRequisite of the course
    
    - The reason why I didn't use parent and child class relation between Course and preRequisite is that they contains same information and methods
 
The HashMap is used to map the preRequisite to their courses, the pseudo code is shown below:

```pseudo
CSVReader(courses.csv)
    new hashmap(String, CourseModel)
    for each line:
        key = CSVReader.id
        value = Course(CSVReader.title, preRequisite = [])
        hashmap.add(key, value)
    return hashmap
    
CSVReader(preRequisite.csv, hashmap)
     for each line:
        coursekey = CSVReader.course
        preRequitekey = CSVReader.preRequisite
        course = hashmap.get(coursekey)
        preRequisite = hashmap.gey(preRequitekey)
        // add preRequisite to the list in CourseModel
        course.preRequisiteList.add(preRequisite)
        
```

#### Search possiable courses for students

From the previous section, we can obtain objects like below:
- List< CourseModel > totalCourses
    - this entity contains the preRequisite relationship.

This relation can be regared as a Topology graph

By providing input as below:

- List< CourseModel > CourseDone
    - this entity shows how many courses has been done
    - base on that we need to give student a study plan
    
    
The algorithm pseudo code is shown below:

```pseudo
List totalList
list DoneList

// Those are the nodes we need to search in the Topology graph
List targetList = totallist.removeAll(donelist)

// This is for the recording of learning orders
index = 0

// Searching the Topology until all courses have been learned
while(targetlist!=null):
    for(course:targetlist):
        // This is a list to record which course can be learn in this loop
        list temperoray = []
        if(canBeEnroll(course)){
			temperoray.add(course)
	}
    // Record courses that can be enrolled
    hashmap.add(index,temperoray)
    // Assume those courses is alread done and conitues search
    DoneList.addAll(temperoray)
    // Remove all done courses from  
    targetlist.removeAll(Donelist)

canBeEnrolled(course, Donelist):
    boolean judge = true
    list prerequisites = course.getPrerequisite
    for(prerequisite:prerequisites):
        if(!Donelist.contains(prerequisite)):
            judge = false
            break;
            
    return judge
    

```
#### Test

The unit test is passed in SearchControllerTest.java

![avatar](https://raw.githubusercontent.com/nazisangg/AS_CodeTest/master/src/main/resources/static/SearchUnitTestResult.jpg)

     
        
    



 
