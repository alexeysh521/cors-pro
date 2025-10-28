# Используем официальный JDK 21
FROM eclipse-temurin:21-jdk-jammy AS build

# Создаём рабочую директорию
WORKDIR /app

EXPOSE 8080

# Копируем Maven файлы
COPY pom.xml mvnw* ./
COPY .mvn .mvn

# Даем право на выполнение скрипта mvnw
RUN chmod +x mvnw

# Кэшируем зависимости
RUN ./mvnw dependency:go-offline -B

# Копируем весь проект
COPY src ./src

# Сборка проекта
RUN ./mvnw package -DskipTests

# ---- Production image ----
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Копируем собранный JAR из build-стадии
COPY --from=build /app/target/*.jar app.jar

# Запуск приложения
ENTRYPOINT ["java","-jar","app.jar"]

