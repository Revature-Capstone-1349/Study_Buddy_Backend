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
  - Bootstrap: Version 4.6
  - IntelliJ IDEA Community Edition: Version 2022.1.3
  - MySQL: Version 8.0.29
  - Git: Version 2.36.1
  - Spring Boot: Version 2.7.1

### *Dependencies*
- Lombok Dev Tool /  Java annotation library, helps to reduce boiler plate code
- MySQL Driver /  MySQL JDBC and R2DBC driver
- Spring Data JPA /  Persist data in SQL stores with Java Persistance API Spring Date and Hibernate
- Spring Web /  Build web, RESTFUL, apps using Spring MVC, Apache Tomcat default embedded container
- PostgreSQL Driver / A JDBC and R2DBC driver that allows Java programs to connect to a PostgreSQL database using standard, database independent Java code.
- H2 Database / Provides a fast in-memory database that supports JDBC API and R2DBC access, with a small (2mb) footprint. Supports embedded and server modes as well as a browser based console application.

---
## *Back-End Annotations used for Java in IntelliJ IDEA*
---
## *The Annotations used for Java in IntelliJ*
### **@Autowired**
    Spring provides annotation-based auto-wiring by providing @Autowired annotation. It is used to autowire spring beans on setter methods, instance variables, and constructor. When we use @Autowired annotation, the spring container auto-wires the bean by matching data-type.
### *@AllArgsConstructor*
    Generates an all-args constructor. An all-args constructor requires one argument for every field in the class.
### *@RestController*
     It can be considered as a combination of @Controllerand @ResponseBody annotations. The @RestController annotation is itself annotated with the @ResponseBody annotation. It eliminates the need for annotating each method with @ResponseBody.
### *@Data*
     It is a convenient shortcut annotation that bundles the features of @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
### *@NoArgsConstructor*
     The @NoArgsConstructor annotation is used to generate the no-argument constructor for a class. In this case, the class consists of final fields. Using this annotation makes the compiler throw a compile-time error. To overcome this, the annotation takes a parameter called force which, when set to be true, initializes the final fields 0 or false or null.
### *@Entity*      
      @Entity annotation defines that a class can be mapped to a table. And that is it, it is just a marker, like for example Serializable interface.
### *@RequestBody*
This annotation is applicable to handle methods of Spring controllers.This annotation indicates that Spring should deserialize a request body into an object.This object is passed as a handler method parameter.

@RequestMapping("/api/users")
@RequestMapping("/api/flashcards")
@RequestMapping("/api/Notes")
@RequestMapping("/api/Sets")

### *@GetMapping*
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
    
### *@PostMapping*
The @PostMapping is a Specialized version of the @RequestMapping annotation that acts as a shortcut
for @RequestMapping(method=RequestMethod.POST). The @PostMapping annotated method in the @Controller annotated
classes handle the HTTP POST requests matched with the given URI expression.

#### Sample Code of @PostMapping ####
```java
@PostMapping
    public ResponseEntity<Notes> addNotes(@RequestBody Notes notes) {
        try{
            User user = userService.getUserById(notes.getUserId());
            Sets sets = setsService.getBySetId(notes.getSetId());
            if (user != null && (sets == null || sets.getUserId().equals(notes.getUserId()))) {
                return new ResponseEntity<>(notesService.addNotes(notes), HttpStatus.OK);
            }
```
  
### *@PutMapping*
The @PutMapping is a composed annotation that acts as a shortcut 
for @RequestMapping(method=RequestMethod.PUT). consumes-Narrow the primary mapping by media types 
that can be consumed by the mapped handler.

#### Sample Code of @PutMapping ####
```java
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
```    
    
### *@DeleteMapping*
The @DeleteMapping is a composed annotation that acts as a shortcut 
for @RequestMapping(method=RequestMethod.DELETE).

#### Sample Code of @DeleteMapping ####
```java
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
```    

### *@Bean*
It is a method-level annotation. It is an alternative of XML bean tag. It tells the method to produce a bean to be managed by Spring Container. 

### *@Repository*

DAO or Repository classes usually represent the database access layer in an application,
and should be annotated with @Repository.

### *@Service*

The business logic of an application usually resides within the service layer,
so use the @Service annotation to indicate that a class belongs to that layer.
___  


# *Front-End Components*

## *Login*
- The "Login Button" will allow the user to log in.
- If the user has registered, they can enter their Email and Password.
- If the user has not created an account, registration is required by clicking "New User" to create an account.
  
---
  
## *Register*
- The "Register Button" takes the new user to the Register page.
- The register page allows the new user to fill in their Name, Email, and Password to create an account.
- After the user enters their personal information and clicks on the "Registration Button," their information is saved, directing them back to the login screen. Suppose a previously registered user has an account. In that case, they can click the "Already a User" link, which will auto-direct back to the login screen.

---
___

## *Timer*
- Setting a Study-Buddy timer can be set by hours, minutes, and seconds.
- "Snack Breaks" is an additional feature designed within the timer. 
- After setting your timer, click on the "Save Button" to begin the timer.

### How Does the Timer Work For the User?
It is a very intuitive tool with three buttons (play, stop, edit). Users can begin using the timer by clicking the "edit button." After selecting this button, a form will populate, allowing the user to set the time by hours and minutes for each category; "study-time" and "snack-time." After the user selects their custom time, the timer begins as they click on the "Create Button."  
___
---

## *Sets*
- Each user can make a set of flash cards.
- The user can decide to share their sets with other users by selecting the public feature, or they can keep it private.  
- All other users can view their sets if the set is 'set' to the public setting. The owner of the "set" is the only person allowed to change their set.

---
 
## *Flashcards*
- A user can create, edit, and filter a set of virtual flashcards for a particular technology stack.
- A user can go through a flashcard set, viewing the front half of the card, then flipping the card to see the second half.
- An owner and a user can view all flashcard sets.

---

## *Notes*
- A user can create, edit, and filter a set of virtual flashcards for a particular technology stack.
- A user can go through a flashcard set, viewing the front half of the card, then flipping the card to see the second half.
- An owner and a user can view all flashcard sets.

___

## *IDE Used*
 - Microsoft Visual Code
 - IntelliJ IDEA by JetBrains

---

## *Material Used*
Our material for the website came from material.angular.io.

___
 
## *Authors*
### *Author & Scrum Master*

#### [Jeffrey Saelee](https://github.com/Servation/)

___

## *Author & Team Leads*

#### [Connor Bullock](https://github.com/cbullock1/)

#### [Thomas Lin](https://github.com/ttlin030735/)

#### [Danny Vais](https://github.com/DannyVais/)

#### [Nicholas Torres](https://github.com/nicktor19/)		

___

## *Lead for the Presentation Documentation*

#### [Danny Vais](https://github.com/DannyVais/)
___

## *Lead for Read Me* 

#### [Lisa Lenhart](https://github.com/CodeFlareLisa/)

#### [Manisha Goyal](https://github.com/GoyalMani/)

#### [Khine Zaw](http://github.com/kzaw7/)

#### [Dovletgeldi Kossekov](https://github.com/dovletg/) 

#### [Daniel Moura](https://github.com/DMM2WEB/)

#### [Joshua Alfaro](https://github.com/Jalfaro1010?tab=repositories)

___

## *Authors & Team Members*

#### [Yeison Bello](https://github.com/yeisonBello/)

#### [Jordan Casavecchia](https://github.com/HappyHysteria/)
		
#### [Ibrahima Diallo](https://github.com/IbrahimaDIALLOBowe/)

#### [Nacer Djabour](https://github.com/Nacerdj/)
				
#### [Shane Smith](https://github.com/WorldKaizen/)
		
#### [Alejandro Zubillaga](https://github.com/alezubi)

#### [Jaquan Pitchford](https://github.com/whoswho94)

#### [Daniel Moura](https://github.com/DMM2WEB)
 
___

<details><summary><strong>Jeffrey Saelee</strong></summary>
<p>
<li>Scrum Master for Agile App Development Software project for Study-Budy Study-Helper flashcard system by facilitating scrum meetings and decision-making processes.</li>
 <li>Led the team leaders in connecting the backend with the front end and securing the components in Angular for the successful project.</li>  
 <li>Monitored the progress and performance of each team by improving, planning, testing product, and organizing the demo showcase.</li>
 <li>Set up the Github repositories with the teams.</li>
</p>
</details>
<details><summary><strong>Connor Bullock</strong></summary>
<p>
 <li>Team leader of the Notes and Flash Card teams while successfully delegating the assigned tasks to complete the project. </li>  
<li>Assisted and created the initial setup of Github repositories with the team leaders. </li>

<li>Led the merging branches, combining team members' code, and pushing the code to Github.</li>
<li>Completed all of the unassigned features of the Notes and Flashcards components. </li>
</p>
</details>
<details><summary><strong>Thomas Lin Bullock</strong></summary>
<p>
<li>Team leader for the backend development team.</li>
<li>Oversaw the production, error check, testing, and debugging.</li>
<li>Communicated with Scrum Master and other team members regarding implementations for the backend.</li>
</p>
</details>
<details><summary><strong>Danny Vais</strong></summary>
<p>
<li>Designed and coded Login, Registration, and Home page components along with session tracking and cookies with routing files to establish the pathways.</li>
<li>Assisted, designed, and coded the HTML webpage with CSS styling, including the color scheme with customized fonts.</li>
<li>Led the PowerPoint presentation team in creating the slides for all edits and styles.</li> 
<li>Directed the entire project team in creating and forming the speaking order of the slides.</li>
</p>
</details>
<details><summary><strong>Nicholas Torres</strong></summary>
<p>
<li>Team led for the Study-Buddy Timer feature while successfully delegating the assigned tasks to complete a functional timer.</li>
<li>Communicated with Scrum Master with all updated daily progress while meeting deadline goals.</li>
<li>Designed, coded, and assisted in implementing the Session Services, which keeps track of all logged-in and logged-out users.</li>
</p>
</details>
<details><summary><strong>Lisa Lenhart</strong></summary>
<p>
<li>Team leader for the README.md and STARTUP teams and files while delegating the tasks—edited documents with Mark Down Language.</li>
<li>Programmed the Sets of Sets by implementing Spring Boot in Java for the backend.</li> 
<li>Tested the API while using HTTP request methods on Postman.</li>       
<li>Drew the ERD Diagram</li>
</p>
</details>
<details><summary><strong>Manisha Goyal</strong></summary>
<p>
<li>Programmed the Sets of Users by implementing Spring Boot in Java for the backend.</li> 
<li>Tested the API while using HTTP request methods on Postman.</li> 
<li>Edited, committed, and assisted in writing README.md and STARTUP.md files.</li> 
</p>
</details>
<details><summary><strong>Khine Zaw</strong></summary>
<p>
<li>Programmed the Sets of Flashcards by implementing Spring Boot in Java for the backend.</li>  
<li>Tested the API while using HTTP request methods on Postman.</li> 
<li>Edited, committed, and assisted in writing README.md and STARTUP.md files.</li> 
</p>
</details>
<details><summary><strong>Dovletgeldi Kossekov</strong></summary>
<p>
<li>Programmed the Sets of Notes by implementing Spring Boot in Java for the backend.</li> 
<li>Tested the API while using HTTP request methods on Postman.</li> 
<li>Edited, committed, and assisted in writing README.md and STARTUP.md files.</li> 
</p>
</details>
<details><summary><strong>Daniel Moura</strong></summary>
<p>
- 
</p>
</details>
<details><summary><strong>Joshua Alfaro</strong></summary>
<p>
<li>Provided documentation and licensing information for various parts of the project for the README.md files.</li>
<li>Designed the Notes and assisted in the programming.</li>
<li>Created multiple bits of data to be incorporated into the testing.</li>
</p>
</details>
<details><summary><strong>Yeison Bello</strong></summary>
<p>
- 
</p>	
</details>
<details><summary><strong>Jordan Casavecchia</strong></summary>
<p>
- 
</p>	
</details> 
<details><summary><strong>Ibrahima Diallo</strong></summary>
<p>
- 
</p>	
</details> 
<details><summary><strong>Nacer Djabour</strong></summary>
<p>
- 
</p>	
</details> 
<details><summary><strong>Shane Smith Djabour</strong></summary>
<p>
- 
</p>	
</details> 
<details><summary><strong>Nacer Djabour</strong></summary>
<p>
- 
</p>	
</details> 
<details><summary><strong>Jaquan Pitchford</strong></summary>
<p>
<li>Assisted the front-end team in coding the project.</li>
<li>Designed the first phase of the navbar.</li>
<li>Styled the HTML footer for the home page by using CSS for the styling.</li>

</p>	
</details> 

---

## *Challenges*


___
## *Screenshots*
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
## *License*

### Oracle Java 18: Version 17.0.2 & Version 18
#### License Agreement: 
#### https://www.oracle.com/downloads/licenses/no-fee-license.html
---
### Visual Studio Code: Version 1.68.1
#### License Agreement:
#### https://code.visualstudio.com/License/
---
### Node.js: Version 16.13.0
#### License Agreement: 
#### https://raw.githubusercontent.com/nodejs/node/master/LICENSE
---
### Material Angular: Version 14.0.2
#### License Agreement: 
#### https://github.com/angular/components/blob/main/LICENSE
---
### Bootstrap: Version 4.6
#### License Agreement:
#### https://getbootstrap.com/docs/4.6/about/license/#it-requires-you-to
---
### IntelliJ IDEA Community Edition: Version 2022.1.3
#### License Agreement:
#### https://www.jetbrains.com/help/idea/installationguide.html#:~:text=Install%20IntelliJ%20IDEA%EF%BB%BF&text=IntelliJ%20IDEA%20is%20a%20cross,source%2C%20licensed%20under%20Apache%202.0
---
### MySQL: Version 8.0.29
#### License Agreement: 
#### https://dev.mysql.com/doc/refman/8.0/en/preface.html
---
### Git: Version 2.36.1
#### License Agreement: https://github.com/git-for-windows/git/
---
### Spring Boot: Version 2.7.1
#### License Agreement:
#### https://www.vmware.com/help/legal.html













     
     
 
