HoundMedia

Project Features

User Registration and Login:
Users can register with a username and password.
Login checks for valid credentials

Media Tracker:
Users can add media entries (movies, books, etc) to specific days.
The system uses a 3D calendar structure (12 months × 4 weeks × 7 days).

Help Form:
Users can fill out a help form with an email and a message.
No actual email is sent; data is accepted and cleared.

Session Management:
Users remain logged in during active sessions.
Can log out to clear session.

Input Validation:
Ensures all forms (login, register, add media, help) are validated for correct input length and presence.
Error Messaging
Invalid inputs show appropriate error messages on the frontend.


How to Run the Program

1. Requirements

Java 17+
Maven
An IDE (IntelliJ IDEA, Eclipse) or terminal

2. Steps

Option 1: Run in an IDE
Open the project folder in your IDE.
Make sure dependencies (Spring Boot, Web, Validation) are installed via Maven.
Locate the MediaTrackerApplication.java file.
Right-click and select Run.
Open a browser and go to:
http://localhost:8080/


Option 2: Run via Terminal
Navigate to the project folder.
Build and run using Maven:
mvn clean install
mvn spring-boot:run
Open:
http://localhost:8080/


How the Database is Stored: 
The project uses Java Serialization to save user data into a file called users.db.

File Location:
The users.db file is created in the root directory of the project (same location you run the app from).

What is Saved:
A HashMap<String, User> that includes: Username, Password, A 3D array of Day[][][], where each day contains a list of Media objects

How It Works:
When users register or modify their media, the application updates the in-memory map and immediately writes to users.db.
When the application restarts, it automatically loads all users from users.db.

