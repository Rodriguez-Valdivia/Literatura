# Proyecto de Aplicación de Consola para Gestión de Libros

Este proyecto es una aplicación de consola desarrollada con Spring Boot, que permite conectar con la API de Gutenberg (https://gutendex.com/) para buscar libros por título. Los datos de los libros y autores encontrados se almacenan en una base de datos PostgreSQL utilizando JPA y Hibernate.

## Funcionalidades Disponibles

1. **Buscar libro por título**: Permite buscar un libro específico por su título utilizando la API de Gutenberg.
2. **Listar libros registrados**: Muestra todos los libros guardados en la base de datos local.
3. **Listar autores registrados**: Muestra todos los autores registrados en la base de datos local.
4. **Listar autores vivos en un determinado año**: Permite buscar y mostrar los autores que están vivos en un año específico.
5. **Listar libros por idioma**: Permite seleccionar un idioma y listar los libros registrados en ese idioma.
6. **Salir**: Termina la ejecución de la aplicación.

### Opciones de Idioma para Listar Libros

- `es`: Español
- `en`: Inglés
- `fr`: Francés
- `pt`: Portugués

## Configuración y Ejecución

1. **Configuración de la Base de Datos**:
    - Asegúrate de tener PostgreSQL instalado y configurado.
    - Crea una base de datos con el nombre especificado en la variable de entorno `DB_NAME` en PostgreSQL.

2. **Configuración de las Variables de Entorno**:
    - Define las siguientes variables de entorno antes de ejecutar la aplicación:
      ```bash
      export DB_HOST=nombre_del_host_de_la_base_de_datos
      export DB_NAME=nombre_de_la_base_de_datos
      export DB_USER=nombre_de_usuario_de_la_base_de_datos
      export DB_PASSWORD=contraseña_de_usuario_de_la_base_de_datos
      ```

3. **Ejecución de la Aplicación**:
    - Clona este repositorio.
    - Abre el proyecto en tu IDE preferido que soporte Spring Boot.
    - Ejecuta la aplicación desde el IDE o utilizando Maven: `mvn spring-boot:run`.

4. **Uso de la Aplicación**:
    - Sigue las instrucciones en la consola para seleccionar una opción y utilizar las funcionalidades disponibles.
    - Para buscar libros por idioma, introduce el código de idioma según las opciones proporcionadas.

## Tecnologías Utilizadas

- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven

