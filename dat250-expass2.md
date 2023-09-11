
[Link to Experiment2](https://github.com/beateskog/dat250-jpa-tutorial)

[Screens of tables](https://github.com/beateskog/dat250-jpa-tutorial/blob/master/Tables.pdf)


### Can you find out which database is used and where the database stores it files?

- Using a h2 database 

```xml 
<property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
<property name="hibernate.connection.driver_class" value="org.h2.Driver"/>
<property name="hibernate.connection.url" value="jdbc:h2:file:./DB;DB_CLOSE_DELAY=-1"/>
```
- the connection url is the path to the database file. and i can use that to shoe the database in the h2 console.
- the files are stored in the project folder, with the name DB.mv.db

### Where do the getters/setters used in the setUp() method come from?

- these getters and setters come from person and family class. Where `@Getter` and `@Setter` is used to automatically generate getters and setters for the fields in the class.

### Questions 
### Where is the database? Explain the used database and how/when it runs.

- it is stored in the project folder in the file named DB.mv.db, and it is a h2 database. It runs when the program is run, and it is used to store the data from the program. 
- DB_CLOSE_DELAY=-1 is used to not delete the database when the connection is closed.

### Can you provide the SQl used to create the table Customer (Hint: Hibernate is used for the object-relational-mapping)?

- hibernate creates the tables automatically, so you do not have to write any sql code to create the tables.

### Find a way to inspect the database tables being created and attach a screenshot of the database schema to your report. Do the created tables correspond to your initial thoughts regarding the exercise?

- More tables than i initial thought, because of the mapping between the classes need tables to know the relations between the objects.


### Problems 

- `Exception in thread "main" java.lang.NullPointerException: Cannot invoke "org.hibernate.mapping.ToOne.getReferencedEntityName()" because "toOne" is null`
    - this was caused by my missng `@JoinTable` annotations, and `@JoinColumn` annotations, on my ManyToOne/OneToMany relations.


-   assertThat(address.getOwners(), is(Set.of(customer)));
    gives me this error:
    Expected: is <[no.hvl.dat250.jpa.tutorial.creditcards.Customer@7772d266]>
        but: was <[no.hvl.dat250.jpa.tutorial.creditcards.Customer@7772d266]>

    - this happened because i used Collection instead of Set. So the test worked fine when i changed it to Set.
