# Metodología de Gestión de la Configuración

En este informe se describe la metodología de gestión de la configuración seguida por el grupo de trabajo G5-52, siendo aplicable al proyecto actual y a proyectos futuros que se puedan desarrollar.

## Estandares de Codificación

Los estándares de codificación se basan en PEP 8, Google Java Style Guide y se aplican de manera consistente en todo el proyecto. Esto incluye convenciones de nomenclatura, estilo de código y prácticas recomendadas como las siguientes:
- **Formato del código**: 
  - Los imports deben de realizarse al principio y cada uno en una línea.
    - Ejemplo:
      - ✅
      ```java
      package org.springframework.samples.petclinic.owner;

      import java.net.URISyntaxException;
      import java.util.List;
      import java.util.Map;
        ```
        - ⛔
        ```java
        package org.springframework.samples.petclinic.owner;
      import java.net.URISyntaxException;      import java.util.List;      import java.util.Map;
        ```
  - La indentación debe de tener un tamaño de 4 espacios
    - Ejemplo:
    - ✅
    ```java
    @Autowired
    public OwnerPlanController(OwnerService ownerService, UserService userService) {
        this.ownerService = ownerService;
        this.userService = userService;
    }
    ```
    - ⛔
    ```java
    @Autowired
    public OwnerPlanController(OwnerService ownerService, UserService userService) {
      this.ownerService = ownerService;
      this.userService = userService;
    }
    ```
  - El máximo tamaño de una línea es de 90 caracteres:
    - Ejemplo:
      - ✅
    ```java
    @Autowired
    public ResponseEntity<Owner> create(@RequestBody @Valid Owner owner) 
    throws URISyntaxException {
      ...
    }
    ```
    - ⛔
    ```java
    public ResponseEntity<Owner> create(@RequestBody @Valid Owner owner) throws URISyntaxException {
      ...
    }
    ```
- **Operadores**: 
  - Escribir espacio antes y despues
  - Ejemplos:
    - ✅
    ```java
    if (userId == null)
    ```
    - ⛔
    ```java
    if(userId==null)
    ```
- **Casting**: 
  - Escribir un espacio despues del casting
  - Ejemplos:
    - ✅
    ```java
    return (List<PetHotelRoom>) petHotelRooms;
    ```
    - ⛔
    ```java
    return (List<PetHotelRoom>)petHotelRooms;
    ```
- **Estructuras de control**:  (drupal)
  - Siempre colocar las llaves `{}` en la misma línea que la declaración de la estructura de control.
  - Incluir un espacio antes de la llave de apertura.
  - El bloque de código dentro de la estructura de control debe estar indentado.
  - Ejemplos:
    - ✅
    ```java
    if (visit.getPet() == null) {
        errors.rejectValue("pet", REQUIRED, REQUIRED);
    }
    ```
    - ⛔
    ```java
    if (visit.getPet() == null) 
    {
    errors.rejectValue("pet", REQUIRED, REQUIRED);
    }
    ```
- **Constantes**: (drupal)
- **Comentarios en el codigo**: (drupal) https://www.drupal.org/node/1354
- **Espacios en blanco en expresiones y declaraciones**: (pet peeves, PEP8)
- **Nombres de variables y métodos**: (java style guide)
- **Manejo de excepciones**: (java style guide)



## Política de Mensajes de Commit (benji)

presentacion de ev

## Estructura del Repositorio y Ramas Base

El repositorio sigue una estructura organizada que incluye las siguientes ramas:

- **main**: Contiene la última versión estable del proyecto.
- **release**: Rama de preparación de versiones estables del proyecto, se usará para realizar las pruebas y correcciones de errores previas al lanzamiento.
- **hotfix**: Rama que servirá para arreglar bugs críticos que se encuentren en producción.
- **develop**: Rama de desarrollo principal donde se fusionan las funcionalidades completadas.
- **feature branches**: Ramas para el desarrollo de nuevas funcionalidades.

## Estrategia de Ramas

La estrategia de ramas se basa en Git Flow y revisiones por parejas para asegurar la calidad del código. Se sigue el siguiente proceso:

### i. Desarrollo de Ramas que Añadan Funcionalidad

1. Crear una rama de función desde `develop`.
2. Desarrollar y probar la funcionalidad en la rama de la función.
3. Solicitar una revisión por pareja antes de fusionar con `develop`.

### ii. Preparación de Releases

1. Crear una rama de lanzamiento desde `develop`.
2. Realizar pruebas finales y correcciones necesarias.
3. Fusionar la rama de lanzamiento con `main` y `develop`.
4. Etiquetar la versión.

### iii. Arreglar Bugs en Producción

1. Crear una rama de hotfix desde `main`.
2. Corregir el error.
3. Fusionar la rama de hotfix con `main` y `develop`.
4. Etiquetar la versión corregida.

## Semántica de Versionado (david)

presentacion de ev

## Definición de "Hecho"

Una tarea se considera "hecha" cuando se han completado las siguientes acciones:

- Toda la funcionalidad de la tarea está satisfecha.
- El código ha sido revisado y aprobado por al menos un compañero de equipo.
- La funcionalidad ha sido integrada con éxito en la rama principal (`develop` o `main` según corresponda).

## Gestión de Documentos

Los documentos generados durante el proyecto se gestionan en el repositorio según las estrategias descritas anteriormente. Se utilizará la carpeta `docs` para organizar la documentación relacionada con el desarrollo, las pruebas y la gestión del proyecto.

