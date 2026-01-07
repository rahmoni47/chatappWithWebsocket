# Spring Boot WebSocket Chat Application

A **simple real-time chat application** built with **Spring Boot** and **WebSocket/STOMP**.  
Designed as a **learning project** for developers familiar with REST who want to explore **WebSocket basics** and **event-driven communication**.

---

## Features

- Real-time chat with **WebSocket + STOMP**
- User join and leave notifications
- Simple, minimal Front-end (HTML, CSS, JS)
- Event-driven handling of disconnects
- Avatars with consistent colors for users
- Clear structure for learning purposes

---

## Tech Stack

- **Backend**: Spring Boot, Spring WebSocket, STOMP, Lombok
- **Frontend**: HTML, CSS, JavaScript, SockJS, Stomp.js
- **Messaging**: In-memory broker (`/topic/public`)

---

## Installation

1. Clone the repository and open it in your IDE  
2. Build the project  
3. Run the Spring Boot application  

- Server runs on: [http://localhost:8081](http://localhost:8081)  
- WebSocket endpoint: `/ws`

---

## How It Works

### 1. User Joins

- User enters a username in the Front-end form
- Client sends a message to `/app/chat.addUser`
- Server stores the username in session and broadcasts a **"Connected"** message to `/topic/public`

### 2. Sending Messages

- User types a message and sends it via `/app/chat.sendMessage`
- Server broadcasts the message to all connected clients on `/topic/public`

### 3. User Disconnects

- Closing the browser/tab triggers `SessionDisconnectEvent`
- Server broadcasts a **"Disconnected"** message to all clients

### 4. Front-end Display

- Messages are added dynamically to the chat area
- Avatars generated from first letter of username with consistent color
- Join/Leave messages are styled differently from chat messages

---

## Front-end Overview

- Plain HTML/CSS/JS (no frameworks required)
- Handles:
  - WebSocket connection
  - Sending and receiving messages
  - Displaying join/leave events
  - Auto-scrolling to the latest message

---

## Learning Goals

This project is ideal for developers who:

- Already know REST and Spring Boot
- Want to learn **WebSocket basics**
- Want to understand **real-time updates**
- Want to explore **event-driven programming in Spring**

> Focused on clarity and education rather than production-level features

---

## Optional Enhancements

- Add authentication (JWT)
- Persist chat messages in a database
- Create private rooms for users
- Improve UI/UX
- Replace simple broker with **RabbitMQ** or **Redis** for scalability

---

## Usage

1. Open [http://localhost:8081](http://localhost:8081)
2. Enter a username and click **Start Chatting**
3. Send messages in real-time
4. Open multiple browser windows to test chat
5. Close a tab to see **user disconnected** event

---

## License

This project is **open-source** and free to use for educational purposes.
