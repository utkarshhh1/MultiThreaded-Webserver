# MultiThreaded Webserver

A lightweight Java-based web server built from scratch, designed to demonstrate the difference between **single-threaded** and **multi-threaded** request handling. This project provides insights into how concurrency impacts the performance and scalability of a web server.

---

## 📂 Project Structure
The project is divided into two main modules:

- **Single-Threaded Server**  
  - Handles incoming requests sequentially, one at a time.  
  - Simple to implement, but performance degrades significantly under high load.  

- **Multi-Threaded Server**  
  - Utilizes threads to handle multiple client requests concurrently.  
  - Improves throughput and reduces response time under heavy load.  

---

## ⚙️ Features
- Built purely with **Java sockets** and core Java libraries.  
- Demonstrates differences in performance between single-threaded and multi-threaded approaches.  
- Modular folder structure for easy understanding and experimentation.  
- Tested using **Apache JMeter** for simulating concurrent client requests.  

---

## 🚀 Getting Started

### Prerequisites
- **Java JDK 8+**
- **Apache JMeter** (optional, for performance testing)

### Running the Server
1. Clone the repository:
   ```bash
   git clone https://github.com/utkarshhh1/MultiThreaded-Webserver.git
