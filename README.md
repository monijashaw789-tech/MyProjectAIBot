# 🤖 AI File Chatbot (Spring Boot + OpenAI)

This is a simple AI-powered chatbot project built using **Spring Boot**, where users can upload files (TXT/PDF) and ask questions based on file content. The system processes the file and generates AI-like responses.

---

## 🚀 Features

- 📁 File Upload (TXT / PDF)
- 📄 File Content Extraction
- 🤖 AI-based Question Answering
- 🌐 REST APIs using Spring Boot
- 🎨 Modern Frontend UI (HTML + CSS + JS)
- ⚡ Fast and lightweight backend

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- REST API
- HTML, CSS, JavaScript
- Apache PDFBox (for PDF reading)

---

## 📂 Project Structure


src/main/java/com/aibot/AIBOT
├── controller
├── service
├── model


---

## ⚙️ How to Run Project

### 1. Clone Repository
```bash
git clone https://github.com/your-username/ai-file-chatbot.git
2. Import in Eclipse / IntelliJ
Import as Maven Project
3. Add Dependencies

Make sure pom.xml contains:

Spring Web
Lombok
JSON
PDFBox
4. Run Spring Boot Application
mvn spring-boot:run
5. Open in Browser
http://localhost:8080/index.html
🔑 API Endpoints
Upload File
POST /api/upload
Ask Question
POST /api/chat
🧠 How It Works
User uploads a file
Backend stores file in /uploads folder
File content is extracted (TXT/PDF)
User asks a question
Backend processes file content + question
AI-like response is returned
📸 UI Preview

Screenshot and video added in github

⚠️ Notes
OpenAI API key can be integrated for real AI responses
Current version uses rule-based AI logic
Supports only text-based understanding
👨‍💻 Author

Developed for assignment.

⭐ Future Improvements
OpenAI real API integration
Audio/Video transcription
Database storage
Chat history feature
Authentication system
