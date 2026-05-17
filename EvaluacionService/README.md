# EvaluacionService

API REST desarrollada con Spring Boot para gestionar evaluaciones.

## Tecnologias

- Java 21
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- MySQL
- Maven

## Requisitos

- Java 21 instalado
- Maven o uso del wrapper `mvnw`
- MySQL en ejecucion

## Configuracion

El proyecto usa la siguiente configuracion en `src/main/resources/application.properties`:

- Puerto: `8088`
- Base de datos: `db_evaluacion`
- Usuario MySQL: `root`

URL configurada:

```properties
jdbc:mysql://localhost:3306/db_evaluacion?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
```

Antes de ejecutar el proyecto, crea la base de datos en MySQL:

```sql
CREATE DATABASE db_evaluacion;
```

## Ejecutar el proyecto

Con el wrapper de Maven en Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

O compilar y ejecutar:

```powershell
.\mvnw.cmd clean package
java -jar target/EvaluacionService-0.0.1-SNAPSHOT.jar
```

## Endpoints

Base URL:

```text
http://localhost:8088/api/v1/evaluaciones
```

### Listar evaluaciones

```http
GET /api/v1/evaluaciones
```

### Buscar evaluacion por id

```http
GET /api/v1/evaluaciones/{id}
```

### Crear evaluacion

```http
POST /api/v1/evaluaciones
Content-Type: application/json
```

Ejemplo de body:

```json
{
  "idEmpresa": 1,
  "idPostulante": 10,
  "puntaje": 95,
  "comentarios": "Buen desempeno en la entrevista"
}
```

### Eliminar evaluacion

```http
DELETE /api/v1/evaluaciones/{id}
```

## Estructura principal

- `Controller`: expone los endpoints REST
- `Service`: contiene la logica de negocio
- `Repository`: acceso a datos con JPA
- `Model`: entidad `Evaluacion`

## Autor

Agrega aqui tu nombre o tus datos si lo necesitas.
