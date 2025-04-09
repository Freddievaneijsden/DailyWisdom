# 🌟 Daily Wisdom 2025 (Demo)

A simple Spring Boot web application where users can:

- 📜 Add and read **inspirational messages** (Daily Wisdoms)
- 🖼️ **Upload and view images** that serve as visual inspiration (like a lightweight Pinterest)

---

## 🛠️ Features

- ✍️ Leave a message to inspire the next visitor
- 📖 View the latest or all wisdom messages
- 🖼 Upload images and browse them in a clean, simple gallery
- 🔐 GitHub OAuth login for authentication
- 🐳 Runs in a Docker container with persistent storage for messages
- ⚡ GraphQL API for data interaction

---

## 🧪 Tech Stack

- Java 23
- Spring Boot
- Thymeleaf for views
- Security with Oauth2
- Spring GraphQL
- Docker 
- Flyway

---

This app uses GitHub OAuth for login. You’ll need to register your app on GitHub and provide a **Client ID** and **Client Secret**. 
Create a `.env` file in the **root directory** of your project and add:

   ```env
   GITHUB_CLIENT_ID=your_client_id_here
   GITHUB_CLIENT_SECRET=your_client_secret_here

