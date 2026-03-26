# AlegeSmart - E-Commerce Backend API cu Coș Inteligent și Asistent AI

Acest proiect reprezintă componenta de Backend (RESTful API) pentru o platformă de e-commerce inovatoare.
Aplicația nu este doar un simplu magazin online, ci integrează un algoritm de optimizare a coșului de cumpărături ("Smart Cart") și un asistent virtual bazat pe Inteligență Artificială pentru a ghida utilizatorii în deciziile lor.

## Funcționalități Principale (Core Features)

* ** Coș de Cumpărături Inteligent (Smart Cart Algorithm):** * Analizează produsele selectate și oferă automat utilizatorului două opțiuni: 
    1. **Mixul Optim:** Cea mai ieftină combinație posibilă de produse, chiar dacă provin din magazine diferite (ex: eMAG, Altex, Flanco).
    2. **Single Store Convenience:** Cea mai ieftină variantă în care toate produsele sunt comandate de la un singur magazin (pentru a salva costurile de transport).
* ** Asistent Virtual AI (Gemini Integration):** * Un endpoint conectat la API-ul Google Gemini care oferă consultanță tehnică utilizatorilor în funcție de bugetul și nevoile lor (Prompt Engineering personalizat).
* ** Securitate și Management Utilizatori:** * Înregistrare cu validări stricte (format email, lungime parolă).
  * Parolele sunt criptate ireversibil folosind algoritmul **SHA-256** înainte de a fi salvate în baza de date.
* ** Bază de Date Pre-populată (Data Seeding):** * Aplicația rulează un `DataSeeder` la pornire care populează automat baza de date cu 15 produse complexe și oferte relaționate, perfecte pentru testare.

## Arhitectură și Tehnologii (Tech Stack)

Aplicația respectă o arhitectură stratificată clară (Layered Architecture): **Controller -> Service -> Repository**. 
Datele sunt transferate către client folosind **DTO-uri (Data Transfer Objects)** pentru a ascunde structura internă a bazei de date.

* **Limbaj:** Java 17+
* **Framework:** Spring Boot 3.x
* **Bază de Date:** PostgreSQL
* **ORM:** Spring Data JPA / Hibernate
* **Integrare Externă:** REST Template (Google Gemini API)
