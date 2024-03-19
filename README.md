# API de Productos

Este proyecto es una API de productos desarrollada como parte de un examen para el 2º año de DAM. La API permite a los usuarios realizar operaciones CRUD en productos, así como buscar productos por nombre y filtrar productos por stock.

## Tecnologías utilizadas

- Java
- Spring Boot
- Maven

## Instalación

Para instalar y ejecutar este proyecto localmente, necesitarás tener instalado Java y Maven. Sigue estos pasos:

1. Clona el repositorio: `git clone https://github.com/Estivbi/ProductosAPI.git`
2. Navega al directorio del proyecto: `cd ProductosAPI`
3. Compila el proyecto: `mvn clean install`
4. Ejecuta la aplicación: `mvn spring-boot:run`

## Uso

Aquí hay algunos ejemplos de cómo puedes interactuar con la API:

- Obtener todos los productos: `GET /api/productos`
- Obtener un producto por ID: `GET /api/productos/{id}`
- Crear un nuevo producto: `POST /api/productos`
- Actualizar un producto existente: `PUT /api/productos/{id}`
- Eliminar un producto: `DELETE /api/productos/{id}`
- Buscar productos por nombre: `GET /api/productos?name={name}`
- Obtener productos con stock: `GET /api/productos/con-stock`

## Contribuir

Como este es un proyecto de examen, no se aceptan contribuciones. Sin embargo, si encuentras algún problema, no dudes en abrir un issue.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.
