# Project Refactoring Documentation

This project has been refactored to follow modern Spring Boot and MyBatis-Plus best practices.

## Architecture & Package Reorganization

- `com.example.demo.common`: Contains unified API response (`Result<T>`) and global exception handling (`GlobalExceptionHandler`).
- `com.example.demo.config`: Centralized configuration, including `MybatisPlusConfig` with pagination support and mapper scanning.
- `com.example.demo.model.entity`: Houses the database entity `User`.
- `com.example.demo.model.vo`: Contains `UserVO`, a Java 21 `record` for data representation to the client.

## Layer Refactoring

### Controller Layer
- Base path updated to `/api/users`.
- Switched to **Constructor Injection** using Lombok's `@RequiredArgsConstructor`.
- Return values are now wrapped in `Result<UserVO>`.
- Uses `@PathVariable` for ID retrieval.

### Service Layer
- Service methods now return `UserVO` instead of the raw entity for client-facing operations.
- Implementation handles conversion from Entity to VO.

## Configuration

- Pagination support enabled for H2 database in `MybatisPlusConfig`.
- Mapper scanning moved from the main application class to `MybatisPlusConfig`.

## Technology Stack

- **Java**: 21
- **Spring Boot**: 3.3.5
- **MyBatis-Plus**: 3.5.9
- **Database**: H2 (In-memory)
- **Lombok**: For boilerplate reduction.
