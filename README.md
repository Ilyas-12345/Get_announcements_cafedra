# Get_announcements_cafedra
Getting Started
Prerequisites
Make sure you have the following installed:

Java (version 17 or higher)
Gradle
Installation
Clone the repository:

git clone https://github.com/ilyas-12345/Get_announcements_cafedra

Build the project:

mvn clean install
Run the application:

java -jar target/laba1_-api-1.0.0.jar
The application will start on http://localhost:8080.

Usage
Endpoints
Get announcements by departmentId:

GET /announcements/?departmentId={departmentId}

Example:

GET /announcements/?departmentId=20027

