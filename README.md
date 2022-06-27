# Project 3
## *Study Helper App*

## *Project 3 Description*

The Revature Study-Buddy is a helper to study using flashcard sets. It functions as a virtual ambient where the student goes through the chosen content, creating and editing while filtering related flashcards and notes to improve their knowledge in a fun experience. Its importance resides in making it easier for students to achieve their best results along with helpful technology.
___

### *Technologies*
  - Oracle Java 18
  - Visual Studio Code: Version 1.68.1
  - Node.js: Version 16.13.0
  - Material Angular: Version 14.0.2
  - IntelliJ IDEA Community Edition: Version 2022.1.3
  - MySQL: Version 8.0.29
  - Git: Version 2.36.1
  - Spring Boot: Version 2.7.1

### *Dependecies*
- Lombok Dev Tool /  Java annotation library, helps to reduce boiler plate code
- MySQL Driver /  MySQL JDBC and R2DBC driver
- Spring Data JPA /  Persist data in SQL stores with Java Persistance API Spring Date and Hibernate
- Spring Web /  Build web, RESTFUL, apps using Spring MVC, Apache Tomcat default embedded container
- PostgreSQL Driver / A JDBC and R2DBC driver that allows Java programs to connect to a PostgreSQL database using standard, database independent Java code.
- H2 Database / Provides a fast in-memory database that supports JDBC API and R2DBC access, with a small (2mb) footprint. Supports embedded and server modes as well as a browser based console application.

---

## *The Annotations used for Java in IntelliJ*
### **@Autowired**
    Spring provides annotation-based auto-wiring by providing @Autowired annotation. It is used to autowire spring beans on setter methods, instance variables, and constructor. When we use @Autowired annotation, the spring container auto-wires the bean by matching data-type.
### **@AllArgsConstructor**
    Generates an all-args constructor. An all-args constructor requires one argument for every field in the class.
### **@RestController**
     It can be considered as a combination of @Controllerand @ResponseBody annotations. The @RestController annotation is itself annotated with the @ResponseBody annotation. It eliminates the need for annotating each method with @ResponseBody.
### **@Data**
     It is a convenient shortcut annotation that bundles the features of @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
### **@NoArgsConstructor** 
     The @NoArgsConstructor annotation is used to generate the no-argument constructor for a class. In this case, the class consists of final fields. Using this annotation makes the compiler throw a compile-time error. To overcome this, the annotation takes a parameter called force which, when set to be true, initializes the final fields 0 or false or null.
### **@Entity**      
      @Entity annotation defines that a class can be mapped to a table. And that is it, it is just a marker, like for example Serializable interface.

### **@RequestBody**
This annotation is applicable to handle methods of Spring controllers.This annotation indicates that Spring should deserialize a request body into an object.This object is passed as a handler method parameter.

@RequestMapping("/api/users")
@RequestMapping("/api/flashcards")
@RequestMapping("/api/Notes")
@RequestMapping("/api/Sets")

### **@GetMapping**
The @GetMapping annotation is a specialized version of the @RequestMapping annotation that acts as 
a shortcut for @RequestMapping(method=RequestMethod.GET).The @GetMapping annotated methods in the
@Controller annotated classes handle the HTTP GET requests matched with the given URI expression.

#### Sample Code of @GetMapping ####

```java
@GetMapping("/{id}")
    public ResponseEntity<Notes> getNotesById(@PathVariable("id")Long id){
        try{
            Notes notes = notesService.getNotesById(id);
            if(notes != null) {
                return new ResponseEntity<>(notes, HttpStatus.OK);
            }
        }catch(Exception ignored){}
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
```    
    
### **@PostMapping
The @PostMapping is a Specialized version of the @RequestMapping annotation that acts as a shortcut
for @RequestMapping(method=RequestMethod.POST). The @PostMapping annotated method in the @Controller annotated
classes handle the HTTP POST requests matched with the given URI expression.

@PostMapping
    public ResponseEntity<Notes> addNotes(@RequestBody Notes notes) {
        try{
            User user = userService.getUserById(notes.getUserId());
            Sets sets = setsService.getBySetId(notes.getSetId());
            if (user != null && (sets == null || sets.getUserId().equals(notes.getUserId()))) {
                return new ResponseEntity<>(notesService.addNotes(notes), HttpStatus.OK);
            }

  
###**@PutMapping

The @PutMapping is a composed annotation that acts as a shortcut 
for @RequestMapping(method=RequestMethod.PUT). consumes-Narrow the primary mapping by media types 
that can be consumed by the mapped handler.


@PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        try {
            User findUser = userService.getUserById(user.getUserId());
            if(findUser != null){
                return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
            }
        } catch (Exception ignore) {}
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
###** @DeleteMapping

The @DeleteMapping is a composed annotation that acts as a shortcut 
for @RequestMapping(method=RequestMethod.DELETE).

@DeleteMapping("/{fCardId}")
    public ResponseEntity<?> deleteByFCardId(@PathVariable("fCardId") Long fCardId) {
        try {
            FlashCards flashCards = flashCardsService.getByfCardId(fCardId);
            if(flashCards != null){
                flashCardsService.deleteByfCardId(fCardId);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception ignore) {}
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

### *@Bean*

It is a method-level annotation. It is an alternative of XML bean tag. It tells the method to produce a bean to be managed by Spring Container. 

### *@Repository*

DAO or Repository classes usually represent the database access layer in an application,
and should be annotated with @Repository.

### *@Service*

The business logic of an application usually resides within the service layer,
so use the @Service annotation to indicate that a class belongs to that layer.
___    

## *Login*
The local host for login was 4200.
     
## *Register* 
The local host for register was 4200.
 
## *Timer*

## *Sets*
 
## *Flashcards*
The local host for Flash Cards was 4200.

## *Notes*
The local host for notes was 4200.

## *Environment*


## *IDE Used*
Microsoft Visual Code
IntelliJ IDEA by JetBrains

## *Material Used
Our material for the website came from material.angular.io.

 
### *Authors*
#### *Author & Scrum Master*

##### [Jeffrey Saelee](https://github.com/Servation/)



#### *Author & Team Leads*

##### [Connor Bullock](https://github.com/cbullock1/)

##### [Thomas Lin](https://github.com/ttlin030735/)

##### [Danny Vais](https://github.com/DannyVais/)

##### [Nicholas Torres](https://github.com/nicktor19/)		



### *Lead for the Presentation Documentation*

##### [Danny Vais](https://github.com/DannyVais/)


### *Lead for Read Me* 

##### [Lisa Lenhart](https://github.com/CodeFlareLisa/)

##### [Yeison Bello](https://github.com/yeisonBello/)

##### [Jordan Casavecchia](https://github.com/HappyHysteria/)
		
##### [Ibrahima Diallo](https://github.com/IbrahimaDIALLOBowe/)

##### [Nacer Djabour](https://github.com/Nacerdj/)
		
##### [Manisha Goyal](https://github.com/GoyalMani/)

##### [Dovletgeldi Kossekov](https://github.com/dovletg/) 	

##### [Daniel Moura](https://github.com/DMM2WEB/)
				
##### [Shane Smith](https://github.com/WorldKaizen/)
		
##### [Danny Vais](https://github.com/DannyVais/)
		
##### [Khine Zaw](http://github.com/kzaw7/)

##### [Alejandro zubillaga](https://github.com/)
 
___


<details><summary>Roles & Responsibilities</summary>
<p>

</p>
</details>


### *Challenges*


___
### *Screenshots*
![angular-material](https://user-images.githubusercontent.com/74020237/176029818-e8e4c250-65fd-4f20-a456-08da19d6ec2d.png)
![Trello](https://user-images.githubusercontent.com/74020237/176029825-723cbf66-1a8b-487f-a35b-fbe1b8f5520f.png)
[ERDproj3.pdf](https://github.com/Revature-Capstone-1349/Study_Buddy_Backend/files/8995368/ERDproj3.pdf)
![google-fonts](https://user-images.githubusercontent.com/74020237/176029880-679bfccd-9734-4ad8-9c31-c145813ee4d9.png)
![ERD-UML notation](https://user-images.githubusercontent.com/74020237/176029879-25c96195-30c5-464d-ad55-bd833820240f.png)![noteComponent](https://user-images.githubusercontent.com/74020237/176029878-bded1bf4-5f01-4f1a-bdf4-c053163661d2.png)

![flash-cards](https://user-images.githubusercontent.com/74020237/176029887-6e996ff0-52ad-4e1e-b0e2-4b948dc31f31.png)

![module-timer](https://user-images.githubusercontent.com/74020237/176029888-0d44fb70-3daf-4f9b-a06b-bb8a796d5c38.png)

![users](https://user-images.githubusercontent.com/74020237/176029889-17e837fd-b247-4450-92d5-b16a218cc864.png)
Tables in MySQL Database
<img width="591" alt="Screen Shot 2022-06-27 at 3 05 02 PM" src="https://user-images.githubusercontent.com/74020237/176016961-b22adda0-6693-4625-927c-bb9ca23be39a.png">
___
### *License*
     
     
 
