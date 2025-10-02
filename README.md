# Educational-Initiatives-Project

## **Exercise 1**

### **Behavioral Patterns**

#### 1) Simple Text Editor (Command Pattern)
This project is a simple Java text editor demonstrating the *Command Design Pattern*.  
It allows users to insert, delete, replace text, undo/redo actions, and view command history.  
The design shows how commands can be encapsulated as objects, making it easy to track, undo, or redo operations.

**Implementation Details**
- **Command (Interface):** Defines `execute()` and `undo()` methods.  
- **Concrete Commands:** `InsertCommand`, `DeleteCommand`, `ReplaceCommand`, `DeleteAllCommand` perform actions on the text.  
- **Editor (Class):** Holds the text content and performs actual insert, delete, replace operations.  
- **CommandInvoker (Class):** Executes commands, keeps undo/redo stacks, and records history.  
- **Main (Class):** Handles user input and console UI.


![WhatsApp Image 2025-10-02 at 00 56 13_73d36d38](https://github.com/user-attachments/assets/62b23540-ac24-4057-962b-66b64a31bdf0)

---

#### 2) Social Media Platform (Observer Pattern)
This project is a simple Java implementation of the *Observer Design Pattern*.  
It shows how an object (Influencer) can notify its followers automatically when a new post is made, promoting loose coupling.

**Implementation Details**
- **Observer (Interface):** Defines the `update()` method that Followers implement.  
- **Follower (Class):** Implements `Observer`, stores messages in an inbox, and displays notifications.  
- **Influencer (Class):** Maintains a set of followers and notifies them whenever a new post is made.  
- **SocialPlatform (Class):** Manages influencers, followers, follow relationships, and posting.  
- **Main (Class):** Entry point to demonstrate the notification flow.  


![WhatsApp Image 2025-10-02 at 01 01 17_76fe1f7b](https://github.com/user-attachments/assets/74b1bef5-f966-418e-8d24-542c548a9dd6)

---

### **Creational Patterns**

#### 1) Leaderboard System (Singleton Pattern)
This project is a simple Java implementation of the *Singleton Design Pattern*.  
It ensures that only one instance of the Leaderboard exists, centralizing player management and scores.

**Use Case:**  
Add, update, remove players and display the leaderboard while guaranteeing a single source of truth.

**Implementation Details**
- **Leaderboard (Singleton Class):** Manages a list of `Player` objects. Only one instance exists via `getInstance()`.  
- **Player (Class):** Represents a player with ID, name, and score.  
- **Main (Class):** Provides CLI for add, update, remove, show operations.  


![WhatsApp Image 2025-10-02 at 01 07 05_26fae85f](https://github.com/user-attachments/assets/95c0dcae-9cb7-45c1-98ef-d30031a64796)

---

#### 2) Pizza Builder System (Builder Pattern)
This project is a simple Java implementation of the *Builder Design Pattern*.  
It demonstrates how a `Pizza` object with multiple optional properties can be built step-by-step using a `PizzaBuilder`.

**Use Case:**  
Users can customize a pizza by selecting valid options for sauce, topping, cheese, crust, and size.

**Implementation Details**
- **Pizza (Class):** Immutable pizza object with final fields.  
- **PizzaBuilder (Class):** Provides a fluent interface for setting properties and building pizza. Includes validation for valid options.  
- **Main (Class):** Handles user input, validates numeric selections, and demonstrates pizza building.  


<img width="1054" height="481" alt="image" src="https://github.com/user-attachments/assets/c39b583c-993a-4c41-905c-05fc25f59061" />


---

### **Structural Patterns**

#### 1) Firewall Access System (Proxy Pattern)
This project is a simple Java implementation of the *Proxy Design Pattern*.  
A proxy object (`FirewallProxy`) controls access to a real object (`Server`) by allowing only authorized users.

**Implementation Details**
- **ServerAccess (Interface):** Defines `accessServer(String userName)`.  
- **Server (Class):** The real object providing server access functionality.  
- **FirewallProxy (Class):** Controls access to `Server`, manages allowed users.  
- **User (Class):** Represents a user attempting to access the server.  
- **Main (Class):** Menu-driven program for adding/removing users, accessing server, and listing authorized users.  


![WhatsApp Image 2025-10-02 at 01 15 59_9d5a9159](https://github.com/user-attachments/assets/f915beb5-67e5-42ed-a8dd-c977c663b746)

---

#### 2) PC Configurator (Decorator Pattern)
This project is a simple Java implementation of the *Decorator Design Pattern*.  
It shows how we can dynamically add features (GPU, SSD, RGB Lights, Cooling System) to a Base PC without modifying its class.

**Implementation Details**
- **PC (Interface):** Defines `getDescription()` and `getCost()`.  
- **BasePC (Class):** Basic PC with CPU and RAM.  
- **PCDecorator (Abstract Class):** Wraps a PC object, serving as a base for all decorators.  
- **Components (Classes):** Concrete decorators (`GPU`, `SSD`, `RGBLights`, `CoolingSystem`) that add features and update cost.  
- **Main (Class):** Menu-driven interface to build a PC configuration dynamically.  


<img width="713" height="803" alt="image" src="https://github.com/user-attachments/assets/12a9c339-ee46-48f8-84de-89f13b0ca2f9" />


---

## **Exercise 2**

### **ChatRoom Application (Observer + Singleton + Adapter)**

**Problem Statement:**  
Create a simple real-time chat application where users can create or join multiple chat rooms and send messages to all members or privately, with message history support.

**Overview:**  
This Java project demonstrates a real-time chat system using **Observer, Singleton, and Adapter Design Patterns**.  
- **Singleton Pattern:** Ensures a single instance of `ChatRoomManager` to manage all chat rooms.  
- **Observer Pattern:** Each `ChatRoom` notifies its users whenever a new message is broadcast.  
- **Adapter Pattern:** Supports multiple communication protocols (`HTTP` and `WebSocket`) via `ClientCommunicator`.  

**Implementation Details**
- **ChatRoom (Observer Subject):** Maintains users and broadcasts messages. Stores history.  
- **User (Observer):** Receives/broadcasts messages; supports private messages.  
- **ChatRoomManager (Singleton):** Centralized manager for creating and managing chat rooms.  
- **ClientCommunicator (Adapter Interface):** Abstracts message sending.  
- **HttpAdapter / WebSocketAdapter:** Concrete adapters for protocol-specific communication.  
- **HttpService / WebSocketService:** Simulated services for sending data.  
- **Main:** Console UI for creating/joining rooms, sending messages, and switching protocols.  

**Functionalities**
1. Create/join chat rooms with unique IDs.  
2. Send public messages within a room.  
3. Send private messages between users.  
4. View chat history when joining.  
5. List active rooms and their users.  
6. Choose between HTTP or WebSocket communication.

![WhatsApp Image 2025-10-02 at 02 05 34_79bb55c4](https://github.com/user-attachments/assets/b4162d32-04fe-488d-8ed0-7dae5b2c07fc)


![WhatsApp Image 2025-10-02 at 02 06 46_6c91edab](https://github.com/user-attachments/assets/86c36003-d691-4baa-a0b9-304632f48865)

---

## **How to Run**
Clone this repository:

git clone https://github.com/Aperna98/Educational-Initiatives-Project.git

For each project, navigate to the respective folder using cd command and compile the files by using the following commands to execute the project.

javac *.java

java Main



