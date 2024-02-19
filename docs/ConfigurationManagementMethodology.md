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
      import java.net.URISyntaxException; import java.util.List; import java.util.Map;
      ```
  - La indentación debe de tener un tamaño de 4 espacios.
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
  - Escribir espacio antes y después.
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
  - Escribir un espacio después del casting.
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
- **Constantes**: para el nombramiento de las constantes, haremos uso del estilo SREAMING_SNAKE_CASE(HELLO_WORLD).
- **Comentarios en el código**: se pondrán mediante: /** (esto abre el comentario); * (para las líneas con el comentario); */ (para cerrar el comentario).
- **Espacios en blanco en expresiones y declaraciones**: dejaremos espaciones en blanco tanto por delante como por detrás en las expresiones y declaraciones.
- **Nombres de variables y métodos**: estos nombres tienen que ser lo más explicativos o descriptivos posibles, comenzando por minúscula y usando camelCase.
- **Manejo de excepciones**: se realizarán mediante `Try` y `Catch`, indicando en el `Catch` qué tipo de excepción es. El mensaje de dicha excepción tiene que ser lo más significativo posible.

## Política de Mensajes de Commit
Los commits se realizarán siguiendo el siguiente patrón:
`<type>[optional scope]: <description>`
`<blank line>`
`[optional body]`
`<blank line>`
`[optional footer(s)]`

Donde `type` puede ser:
- **fix**: si se arregla un bug de código.
- **feat**: si se añade alguna funcionalidad.
- **docs**: si sólo se modifica documentación.
- **refactor**: si se refactorizan partes del código.
- **test**: si se añaden test o se corrigen los existentes.
- **style**: si son cambios que no modifican la funcionalidad del código.
- **perf**: si los cambios mejoran el rendimiento.
- **chore**: otros cambios que no modifican el código o los tests, (organización de carpetas, por ejemplo).
- **type!**: se añade **!** después del tipo si el commit introduce un **Breaking Change**.

Un ejemplo de mensaje de commit sería:
`feat: #1 Añadido que el usuario pueda hacer pedidos desde la aplicación`

`Desde la página de pedidos, el usuario puede realizar un nuevo pedido,`
`cumpliendo así los requisitos de nuestro cliente.`

Además, seguiremos las 7 reglas siguientes:
1. Separar el título del cuerpo con una línea en blanco.
2. Limitar el título a 50 caracteres.
3. Capitalizar el título.
4. No acabar el título con un punto.
5. Usar el modo imperativo en el título.
6. Envolver el cuerpo en 72 caracteres.
7. Usar el cuerpo para explicar qué y porqué frente al cómo.

## Estructura del Repositorio y Ramas Base

El repositorio sigue una estructura organizada que incluye las siguientes ramas:

- **main**: Contiene la última versión estable del proyecto.
- **release**: Rama de preparación de versiones estables del proyecto, se usará para realizar las pruebas y correcciones de errores previas al lanzamiento.
- **hotfix**: Rama que servirá para arreglar bugs críticos que se encuentren en producción.
- **develop**: Rama de desarrollo principal donde se fusionan las funcionalidades completadas.
- **feature branches**: Ramas para el desarrollo de nuevas funcionalidades.

## Estrategia de Ramas

La estrategia de ramas se basa en Git Flow con DOS adaptaciones para el curso :

- realización de `Pull Request` para implementar las revisiones por parejas ( Peer Reviews ) 
para asegurar la calidad del código, contemplación de los standares de codificación, 
aprendizaje y comprensión compartidos por el equipo, etc ... 

- subida de ramas de trabajo locales a repositorio remoto, sin borrarlas posteriormente, para que los profesores puedan ver y comprobar el trabajo realizado por cada miembro del equipo. 

Se sigue el siguiente proceso: 

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

### Revisión por pares
A la hora de hacer `Pull Requests`, hemos definido la siguiente organización:
1. Benji
2. Ramón
3. Miguel
4. David
5. Rafa

De manera que se realizan las revisiones en cascada, es decir, el 1 revisa el 2, el 2 al 3 y así sucesivamente, hasta que el 5 revisa al 1. 

## Semántica de Versionado

La semántica de versionado definida es la siguiente:

**X.y.z-ETIQUETA**

- **X-Versión mayor**: Cambios mayores, rompe la compatibiladad de la API, la versión inicial será 0.y.z, la versión 1.0.0 definirá la primera API pública.

- **y-Versión menor**: Cambios menores, no rompen la compatibilidad de la API, incluyen nuevas funcionalidades y mejoras, puede incluir parches.

- **z-Parche**: Elimincación de bugs, no rompen la compatibilidad de la API, sólo cambios internos para arreglar comportamientos incorrectos.

- **ETIQUETA**: Indican versiones preliminares, utilizado también para metadata, cuidado al comparar la procedencia de las versiones.

- **Reglas de versionado**: Cuando la versión mayor sea incrementada se resetean las demás, cuando se incremente la versión menor, se resetea el parche.

## Definición de "Hecho"

Una tarea se considera "Hecha" cuando se han completado las siguientes acciones:

- Toda la funcionalidad de la tarea está satisfecha.
- El código ha sido revisado y aprobado por al menos un compañero de equipo.
- La funcionalidad ha sido integrada con éxito en la rama principal (`develop` o `main` según corresponda).

## Gestión de Documentos

Los documentos generados durante el proyecto se gestionan en el repositorio según las estrategias descritas anteriormente. Se utilizará la carpeta `docs` para organizar la documentación relacionada con el desarrollo, las pruebas y la gestión del proyecto.

