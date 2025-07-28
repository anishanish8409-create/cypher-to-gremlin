# 🔁 Cypher to Gremlin Translation API

A lightweight Spring Boot-based reactive API that translates **Cypher queries** into **Gremlin** using the `cypher-for-gremlin` library. Designed for modern graph-based applications that require interoperability between query languages like Neo4j (Cypher) and Apache TinkerPop (Gremlin).

---

## 📦 Tech Stack

- **Java 17+**
- **Spring Boot**
- **Project Reactor (Mono)**
- **Lombok**
- **cypher-for-gremlin** (OpenCypher Translation Library)
- **Maven**

---

## 🚀 Features

- 🔁 **Cypher → Gremlin** translation using `CypherAst`
- ⚡️ **Reactive API** using Project Reactor
- 🧼 Minimal and clean structure
- ✅ Simple endpoint with JSON input/output

---

## 🧠 How It Works

1. Client sends a `POST` request with a Cypher query to `/api/translate`
2. Controller extracts the `cypher` key from the JSON body
3. The service uses `CypherAst.parse(...)` and translates it into Gremlin syntax using a configured `Translator`
4. Response contains a JSON object with the translated `gremlin` query

---

## 📁 Project Structure

```
converter/
├── controller/
│   └── CypherController.java         # Handles HTTP requests
├── service/
│   └── CypherTranslationService.java # Translation logic using CypherAst + Translator
├── ConverterApplication.java         # Main Spring Boot app
└── resources/
    └── application.properties
```

---

## 🧪 API Usage

### Endpoint

```
POST /api/translate
Content-Type: application/json
```

### Request Body

```json
{
  "cypher": "MATCH (n) RETURN n"
}
```

### Response Body

```json
{
   "gremlin": "g.V().project('n').by(__.valueMap().with('~tinkerpop.valueMap.tokens'))"
}
```

---

## ▶️ Run Locally

1. **Clone the project**
   ```bash
   git clone https://github.com/your-username/converter.git
   cd converter
   ```

2. **Build the project**
   ```bash
   ./mvnw clean install
   ```

3. **Run the app**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Test the API**
   Use Postman, cURL, or any REST client:

   ```bash
   curl -X POST http://localhost:8080/api/translate \
     -H "Content-Type: application/json" \
     -d '{"cypher": "MATCH (n) RETURN n"}'
   ```

---

## 🔧 Requirements

- Java 17+
- Maven 3.6+
- Internet connection (to download dependencies)

---

## 🧩 Dependencies

- [`org.opencypher:cypher-for-gremlin`](https://github.com/opencypher/cypher-for-gremlin)
- Spring WebFlux
- Project Reactor
- Lombok

---

## 📜 License

This project is licensed under the MIT License.

---


