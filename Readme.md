# Spring Boot WebSocket Chat Application

This is a **simple real-time chat application** built with **Spring Boot** and **WebSocket/STOMP**, designed as a **learning project** for developers who know REST and want to learn how WebSocket works in a full-stack scenario.

---

## Features

- Real-time messaging with **WebSocket + STOMP**
- Join/Leave notifications for users
- Minimalistic Front-end using plain HTML, CSS, and JavaScript
- Event-driven handling of user disconnects
- User avatars with consistent colors
- Clean and simple architecture for learning purposes

---

## Tech Stack

- **Backend**: Spring Boot, Spring WebSocket, STOMP, Lombok
- **Frontend**: HTML, CSS, JavaScript, SockJS, Stomp.js
- **Messaging**: Simple in-memory broker (`/topic/public`)

---

## Installation

1. **Clone the repository**

```bash
git clone https://github.com/rahmoni47/chatappWithWebsocket
cd <repository_folder>

2. **Build the Spring Boot application**

```bash

./mvnw clean install

Run the application

./mvnw spring-boot:run

    The server runs on http://localhost:8081

    WebSocket endpoint: /ws

How It Works
1. User Joins

    The user enters a username.

    The client sends a message to /app/chat.addUser.

    The server stores the username in the session and broadcasts a "Connected" message to /topic/public.

2. Sending Messages

    Users type messages and send them via /app/chat.sendMessage.

    The server receives the message and broadcasts it to all connected clients on /topic/public.

3. User Disconnects

    When a user closes the browser or tab, Spring triggers SessionDisconnectEvent.

    A "Disconnected" message is broadcast automatically to all clients.

4. Front-end Display

    Messages are dynamically added to the message list.

    Avatars are generated using the first letter of the username with a consistent color.

    Join/Leave events are highlighted differently from chat messages.

Front-end

    Plain HTML/CSS/JS

    Handles:

        Connecting to WebSocket

        Sending and receiving messages

        Showing user join/leave events

        Scrolling to latest messages automatically

Learning Goals

This project is perfect for developers who:

    Already know REST and Spring Boot

    Want to learn WebSocket basics

    Want to see how to push real-time updates from server to clients

    Want to understand event-driven programming in Spring

It focuses on clarity and educational value rather than production-level features.
Next Steps (Optional Enhancements)

    Add authentication (JWT)

    Persist messages in a database

    Add private rooms

    Enhance UI/UX

    Use a message broker like RabbitMQ or Redis for scalability

Usage

    Open http://localhost:8080 in your browser.

    Enter your username and click Start Chatting.

    Start sending messages.

    Open multiple browser windows to see real-time chat in action.

    Close a tab to see user disconnected event broadcast.

License

This project is open-source and free to use for educational purposes.


---