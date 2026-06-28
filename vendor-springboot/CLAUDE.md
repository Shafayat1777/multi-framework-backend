# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Build
./mvnw clean package -DskipTests

# Run
./mvnw spring-boot:run

# Test (all)
./mvnw test

# Test (single class)
./mvnw test -Dtest=SomeServiceTest

# Compile only
./mvnw compile
```

On Windows use `mvnw.cmd` instead of `./mvnw`.

## Stack

- Spring Boot 4.0.7, Java 17
- Spring Data JPA + Hibernate (`ddl-auto: update`)
- PostgreSQL
- Lombok (annotation processor wired in `pom.xml`)
- SpringDoc OpenAPI — Swagger UI at `/swagger-ui.html`
- `dotenv-java` — loads `.env` at startup via `VendorApplication.main`

## Environment

DB config comes from `.env` (gitignored). Required keys:

```
DATABASE_URL=jdbc:postgresql://localhost:5432/vendor
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=root
```

`application.yaml` reads these via `${DATABASE_URL}` etc. The `datasource`/`jpa` blocks are **not** under a `spring:` key — keep that structure or Hibernate won't bind correctly.

## Architecture

Project is at scaffold stage — no domain code yet. Standard layered layout expected under `com.shafayat.vendor`:

```
entity/       → @Entity classes
repository/   → JpaRepository interfaces
service/      → business logic
controller/   → @RestController
dto/          → request/response records
```

Lombok `@Data`/`@Builder`/`@NoArgsConstructor` etc. are available; annotation processor is configured for both compile and test phases.
