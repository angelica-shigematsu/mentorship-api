# <p align="center"> 👩‍🏫 MentorShip Tech</p>


## Subject 
- Create api to manage mentorship between mentor and mentee with date and time to register
- Validate hours that mentor has and if it is same hours available of mentee
- Connect, make networking and help each other with tips and doubt about career at IT
- Theme choice by me. Focus in deliever project using Spring Boot to platform DIO (course of java)

  ## Tecnologies:
- <b>JPA</b> : persistence database voluntario to make queries to find data and create registers about mentor, admin and mentee
- <b>Hibernate and JPQL</b> : create queries customized to find and return specif data
- <b>Spring boot</b> : deploy the project to website
- <b>Postgres</b>: make queries complex, easy to manipulation and mantain ACID

## Diagram 
```mermaid
erDiagram
    USERS {
        BIGINT user_id PK
        VARCHAR fullname
        VARCHAR email
        VARCHAR password
        ENUM role
        BOOLEAN active
        TIMESTAMP created_at
    }

    PROFILE {
        BIGINT profile_id PK
        BIGINT user_id FK
        TEXT bio
        VARCHAR expertise
    }
    TIME_POSSIBLE {
        BIGINT time_id PK
        BIGINT user_id FK
        VARCHAR day_of_week
        TIMESTAMP start_time
        TIMESTAMP end_time
        VARCHAR expertise
    }
    
    MENTORSHIP_REQUESTS {
        BIGINT request_id PK
        BIGINT mentee_id FK
        BIGINT mentor_id FK
        ENUM status
        TIMESTAMP created_at
    }
    
    SESSIONS {
        BIGINT session_id PK
        BIGINT request_id FK
        TIMESTAMP scheduled_time
        INTEGER duration
        ENUM status
        TIMESTAMP created_at
    }
    
    FEEDBACK {
        BIGINT feedback_id PK
        BIGINT session_id FK
        BIGINT mentee_id FK
        INTEGER rating
        TEXT comments
        TIMESTAMP created_at
    }

    USERS ||--o{ PROFILE: "user_id"
    USERS ||--o{ MENTORSHIP_REQUESTS: "mentee_id"
    USERS ||--o{ MENTORSHIP_REQUESTS: "mentor_id"
    USERS ||--o{ TIME_POSSIBLE: "user_id"
    MENTORSHIP_REQUESTS ||--o{ SESSIONS: "request_id"
    SESSIONS ||--|{ FEEDBACK: "session_id"
    USERS ||--o{ FEEDBACK: "mentee_id"
```
## To do it: 
- [X] (Users)
- [X] Profile
- [X] Time possible
- [ ] Session
- [ ] Mentorship
- [ ] Feedback

## How use it:
- Execute file with name VoluntarioApplication
- Create database with name db_dio_voluntario
- O uri backend : ``` localhost:7080/ ``` + name of route
