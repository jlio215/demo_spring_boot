# Usar una imagen base de OpenJDK
FROM openjdk:11-jdk

# Instalar Git en el contenedor para clonar el repositorio
RUN apt-get update && apt-get install -y git

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Clonar el repositorio directamente desde GitHub
RUN git clone https://github.com/jlio215/demo_spring_boot.git .

# Ejecutar el comando para construir y correr la aplicación
CMD ["./gradlew", "bootRun"]
