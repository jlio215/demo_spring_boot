
# Franquicias API

Una aplicación RESTful desarrollada en **Spring Boot** para gestionar franquicias, sucursales y productos asociados. La aplicación sigue un enfoque modular y escalable, y utiliza **Gradle** como herramienta de construcción. Este repositorio incluye soporte para ejecución local y en contenedores mediante **Docker Compose**.

---

## **Descripción**

La API permite:

1. **Gestionar franquicias**:
   - Crear, listar, consultar, actualizar y eliminar franquicias.
   - Consultar productos con mayor stock en cada sucursal.

2. **Gestionar sucursales**:
   - Crear y actualizar sucursales asociadas a una franquicia.

3. **Gestionar productos**:
   - Crear, actualizar stock y eliminar productos asociados a una sucursal.

---

## **Tecnologías utilizadas**

- **Spring Boot**: Framework principal de la aplicación.
- **Gradle**: Herramienta de construcción.
- **Docker y Docker Compose**: Para contenerización y despliegue.
- **Git**: Control de versiones.

---

## **Requisitos previos**

1. **Java 11** o superior.
2. **Gradle**.
3. **Docker y Docker Compose** (para ejecución en contenedores).
4. Conexión a Internet (para clonar el repositorio desde GitHub).

---

## **Instalación y ejecución**

### **1. Ejecución con Docker Compose**
La forma recomendada de ejecutar la aplicación es mediante Docker Compose, que clona automáticamente el repositorio desde GitHub y configura el entorno.

#### **Pasos:**
1. Clona este repositorio (o crea una carpeta vacía):
   ```bash
   git clone https://github.com/jlio215/demo_spring_boot.git
   cd demo_spring_boot
   ```

2. Guarda los siguientes archivos en la raíz del proyecto:

   - **Dockerfile**:
     ```dockerfile
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
     ```

   - **docker-compose.yml**:
     ```yaml
     version: '3.8'
     services:
       franquicias-app:
         build:
           context: .
           dockerfile: Dockerfile
         container_name: franquicias-app
         ports:
           - "8080:8080"
         environment:
           - SPRING_PROFILES_ACTIVE=default
     ```

3. Construye y ejecuta los contenedores:
   ```bash
   docker-compose up --build
   ```

4. Una vez que los contenedores se hayan creado y la aplicación esté ejecutándose, accede a la API en:
   ```
   http://localhost:8080
   ```

#### **Para detener los servicios:**
```bash
docker-compose down
```

---

### **2. Ejecución local**
Si prefieres ejecutar la aplicación en tu máquina local:

1. Clona el repositorio:
   ```bash
   git clone https://github.com/jlio215/demo_spring_boot.git
   cd demo_spring_boot
   ```

2. Compila y ejecuta la aplicación:
   ```bash
   ./gradlew bootRun
   ```

3. La API estará disponible en:  
   `http://localhost:8080`

---

## **Endpoints principales**

### **Franquicias**
- **Crear franquicia**:  
  `POST /api/franquicias`  
  **Body:**
  ```json
  {
      "nombre": "Franquicia Test",
      "sucursales": []
  }
  ```

- **Listar franquicias**:  
  `GET /api/franquicias`

- **Consultar franquicia por ID**:  
  `GET /api/franquicias/{id}`

- **Eliminar franquicia**:  
  `DELETE /api/franquicias/{id}`

- **Consultar productos con mayor stock**:  
  `GET /api/franquicias/{id}/productos-mas-stock`

---

### **Sucursales**
- **Crear sucursal**:  
  `POST /api/franquicias/{franquiciaId}/sucursales`  
  **Body:**
  ```json
  {
      "nombre": "Sucursal Nueva",
      "productos": []
  }
  ```

- **Actualizar nombre de sucursal**:  
  `PUT /api/sucursales/{id}/nombre?nuevoNombre=NUEVO_NOMBRE`

---

### **Productos**
- **Crear producto**:  
  `POST /api/sucursales/{sucursalId}/productos`  
  **Body:**
  ```json
  {
      "nombre": "Producto Nuevo",
      "stock": 100
  }
  ```

- **Actualizar stock del producto**:  
  `PUT /api/productos/{id}/stock?stock=VALOR_NUEVO`

- **Eliminar producto**:  
  `DELETE /api/productos/{id}`

---

## **Flujo de trabajo con Git**

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/jlio215/demo_spring_boot.git
   cd demo_spring_boot
   ```

2. **Crear una rama nueva para cambios**:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```

3. **Realizar cambios y confirmar**:
   ```bash
   git add .
   git commit -m "Descripción del cambio"
   ```

4. **Fusionar la rama**:
   ```bash
   git checkout main
   git merge feature/nueva-funcionalidad
   ```

5. **Subir cambios al repositorio remoto**:
   ```bash
   git push origin main
   ```

---

## **Notas importantes**

1. La aplicación clona el repositorio desde GitHub en cada construcción del contenedor. Si necesitas hacer cambios, asegúrate de realizarlos en el repositorio principal y reconstruir los contenedores.

2. **Persistencia de datos**: Si necesitas persistencia de datos en bases de datos como MySQL o MongoDB, puedes añadir esos servicios a `docker-compose.yml` y configurarlos en `application.properties`.

---

## **Contribución**

1. Haz un fork de este repositorio.
2. Crea una nueva rama para tus cambios.
3. Envía un Pull Request con una descripción clara.

---

## **Licencia**

Este proyecto está bajo la licencia [MIT](https://opensource.org/licenses/MIT).
