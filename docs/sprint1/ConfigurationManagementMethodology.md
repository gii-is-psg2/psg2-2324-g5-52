# Metodología de Gestión de la Configuración

# Universidad de Sevilla   

## Escuela Técnica Superior de Ingeniería Informática

### **Grupo de Prácticas G5-52**
  
  ![Logo US](/docs/static/Logo_US.png)

### Grado en Ingeniería Informática – Ingeniería del Software 

### Proceso Software y Gestión II
### Product Owner: Carlos Guillermo Müller Cejas
### Curso 2023 – 2024

### Miembros del equipo
- Benjamín Ignacio Maureira Flores
- David Godoy Fernández
- Miguel Hernández Sánchez
- Rafael David Caro Medina
- Ramón José Guerrero Romero


# Indice
- [Introducción](#introducción)
- [Estándares de codificación](#estándares-de-codificación)
  * [Formato del código](#formato-del-código)
  * [Operadores binarios](#operadores-binarios)
  * [Casting](#casting)
  * [Estructuras de control](#estructuras-de-control)
  * [Constantes](#constantes)
  * [Comentarios en el código](#comentarios-en-el-código)
  * [Espacios en blanco en expresiones y declaraciones](#espacios-en-blanco-en-expresiones-y-declaraciones)
  * [Nombres de variables y métodos](#nombres-de-variables-y-métodos)
  * [Manejo de excepciones](#manejo-de-excepciones)
- [Política de mensajes de commit](#política-de-mensajes-de-commit)
- [Estructura del repositorio y ramas base](#estructura-del-repositorio-y-ramas-base)
- [Estrategia de ramas](#estrategia-de-ramas)
  * [Desarrollo de ramas que añadan funcionalidad](#desarrollo-de-ramas-que-añadan-funcionalidad)
  * [Preparación de releases](#preparación-de-releases)
  * [Arreglar bugs en producción](#arreglar-bugs-en-producción)
  * [Revisión por pares](#revisión-por-pares)
- [Semántica de versionado](#semántica-de-versionado)
- [Definición de Hecho](#definición-de-hecho)
- [Gestión de documentos](#gestión-de-documentos)
- [Resumen del trabajo con la CMDB iTop](#resumen-del-trabajo-con-la-cmdb-itop)
  * [Objetivos y alcance de la CMDB](#objetivos-y-alcance-de-la-cmdb)
  * [Estructura de la CMDB](#estructura-de-la-cmdb)

___
  


## Introducción

En este informe se describe la metodología de gestión de la configuración seguida por el grupo de trabajo G5-52, siendo aplicable al proyecto actual y a proyectos futuros que se puedan desarrollar.

## Estándares de codificación

Los estándares de codificación se basan en PEP 8, Google Java Style Guide y se aplican de manera consistente en todo el proyecto. Esto incluye convenciones de nomenclatura, estilo de código y prácticas recomendadas como las siguientes:


### **Formato del código**: 
  - Los imports deben de realizarse al principio y cada uno en una línea.
    - Ejemplo:
      - Bien
      ```java
      package org.springframework.samples.petclinic.owner;

      import java.net.URISyntaxException;
      import java.util.List;
      import java.util.Map;
      ```
      - Mal
      ```java
      package org.springframework.samples.petclinic.owner;
      import java.net.URISyntaxException; import java.util.List; import java.util.Map;
      ```
  - La indentación debe de tener un tamaño de 4 espacios.
    - Ejemplo:
      - Bien
      ```java
      @Autowired
      public OwnerPlanController(OwnerService ownerService, UserService userService) {
          this.ownerService = ownerService;
          this.userService = userService;
      }
      ```
      - Mal
      ```java
      @Autowired
      public OwnerPlanController(OwnerService ownerService, UserService userService) {
        this.ownerService = ownerService;
        this.userService = userService;
      }
      ```
  - El máximo tamaño de una línea es de 90 caracteres:
    - Ejemplo:
      - Bien
      ```java
      @Autowired
      public ResponseEntity<Owner> create(@RequestBody @Valid Owner owner) 
      throws URISyntaxException {
        ...
      }
      ```
      - Mal
      ```java
      public ResponseEntity<Owner> create(@RequestBody @Valid Owner owner) throws URISyntaxException {
      ...
      }
      ```

### **Operadores binarios**: 
  - Escribir espacio antes y después.
  - Ejemplos:
    - Bien
    ```java
    if(userId == null)
    ```
    - Mal
    ```java
    if(userId==null)
    ```
  

### **Casting**: 
  - Escribir un espacio después del casting.
  - Ejemplos:
    - Bien
    ```java
    return (List<PetHotelRoom>) petHotelRooms;
    ```
    - Mal
    ```java
    return (List<PetHotelRoom>)petHotelRooms;
    ```


### **Estructuras de control**:
  - Siempre colocar las llaves `{}` en la misma línea que la declaración de la estructura de control.
  - Incluir un espacio antes de la llave de apertura.
  - El bloque de código dentro de la estructura de control debe estar indentado.
  - Ejemplos:
    - Bien
    ```java
    if (visit.getPet() == null) {
        errors.rejectValue("pet", REQUIRED, REQUIRED);
    }
    ```
    - Mal
    ```java
    if (visit.getPet() == null) 
    {
    errors.rejectValue("pet", REQUIRED, REQUIRED);
    }
    ```


### **Constantes**:
  - Para el nombramiento de las constantes, haremos uso del estilo SREAMING_SNAKE_CASE(HELLO_WORLD).
    - Bien
    ```java
    public static final int MAX_ATTEMPTS = 5;
    public static final String ERROR_MESSAGE = "Ha ocurrido un error.";
    ```
    - Mal
    ```java
    public static final int maximo = 5;
    public static final String mensaje_error = "Ha ocurrido un error.";
    ```


### **Comentarios en el código**:
  - Se pondrán mediante: /** (esto abre el comentario); * (para las líneas con el comentario); */ (para cerrar el comentario).
  - En caso de que sea solo una linea, se podrá poner con //
    - Bien
    ```java
    /**
     * Esto es un ejemplo
     * de como poner un comentario
     * que tenga más de una linea
    */

    //Esto es un comentario de una sola linea
    ```
    - Mal
    ```java
    #No comentario
    ```


### **Espacios en blanco en expresiones y declaraciones**:
  - Dejaremos espacios en blanco tanto por delante como por detrás en las expresiones y declaraciones.
    - Bien
    ```java
    public static void main(String[] args) {
        // Declaración con espacios en blanco
        int x = 5;

        // Expresión con espacios en blanco
        int resultado = suma(x, 3);
        System.out.println("El resultado es: " + resultado);
    }
    ```
    - Mal
    ```java
    public static void main(String[] args) {
        int x=5;
    }
    ```

### **Nombres de variables y métodos**:
  - Estos nombres tienen que ser lo más explicativos o descriptivos posibles, comenzando por minúscula y usando camelCase.
  - Ejemplos:
    - Bien
    ```java
    public void createUser(@Valid SignupRequest request) {
		  User user = new User();
      ...
    }
    ```
    - Mal
    ```java
    public void create_user(@Valid SignupRequest request) {
		  User user = new User();
      ...
    }
    ```


### **Manejo de excepciones**:
  - Se realizarán mediante `Try` y `Catch`, indicando en el `Catch` qué tipo de excepción es.
  - El mensaje de dicha excepción tiene que ser lo más significativo posible.
  - Ejemplos:
    - Bien
    ```java
    public static void main(String[] args) {
        int dividendo = 10;
        int divisor = 0;

        try {
            double resultado = dividir(dividendo, divisor);
            System.out.println("El resultado de la división es: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error al intentar dividir: " + e.getMessage());
        }
    }

    public static double dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return (double) dividendo / divisor;
    }
    ```
    - Mal
    ```java
    public static void main(String[] args) {
        int dividendo = 10;
        int divisor = 0;

        try {
            double resultado = dividir(dividendo, divisor);
            System.out.println("Sale: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static double dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Error");
        }
        return (double) dividendo / divisor;
    }
    ```


## Política de mensajes de commit
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


## Estructura del repositorio y ramas base

El repositorio sigue una estructura organizada que incluye las siguientes ramas:

- **main**: Contiene la última versión estable del proyecto.
- **release**: Rama de preparación de versiones estables del proyecto, se usará para realizar las pruebas y correcciones de errores previas al lanzamiento.
- **hotfix**: Rama que servirá para arreglar bugs críticos que se encuentren en producción.
- **develop**: Rama de desarrollo principal donde se fusionan las funcionalidades completadas.
- **feature branches**: Ramas para el desarrollo de nuevas funcionalidades.

A la hora de crear una rama **hotfix**, se usará la siguiente nomenclatura: `hotfix/bugXX`, donde las XX se referirán al numero de la issue correspondiente.

A la hora de crear una rama **feature**, se usará la siguiente nomenclatura: `feature/XX`, donde las XX se referirán al número de la issue correspondiente.

A la hora de crear una rama **release**, se usará la siguiente nomenclatura: `release/X.y.z-ETIQUETA`, donde se seguirá la regla de versionado definida en este mismo documento.


## Estrategia de ramas

La estrategia de ramas se basa en Git Flow con **dos adaptaciones** para el curso :

- Realización de `Pull Request` para implementar las revisiones por parejas (Peer reviews) y así asegurar la calidad del código, contemplación de los standares de codificación, aprendizaje y comprensión compartidos por el equipo, etc. 

- Subida de ramas de trabajo locales a repositorio remoto, sin borrarlas posteriormente, para que los profesores puedan ver y comprobar el trabajo realizado por cada miembro del equipo. 

Se sigue el siguiente proceso: 


### Desarrollo de ramas que añadan funcionalidad:
  1. Crear una rama de función desde `develop`.
  2. Desarrollar y probar la funcionalidad en la rama de la función.
  3. Solicitar una revisión por pareja antes de fusionar con `develop`.

### Preparación de releases
  1. Crear una rama de lanzamiento desde `develop`.
  2. Realizar pruebas finales y correcciones necesarias.
  3. Fusionar la rama de lanzamiento con `main` y `develop`.
  4. Etiquetar la versión.

### Arreglar bugs en producción
  1. Crear una rama de hotfix desde `main`.
  2. Corregir el error.
  3. Fusionar la rama de hotfix con `main` y `develop`.
  4. Etiquetar la versión corregida.


### Revisión por pares
Para la revisión de tareas, se ha decido, que una vez acabada esta se creará un Pull Request y tendrá que poner como supervisores al resto de miembros del equipo. A su vez, este integrante, deberá avisa por otro medio (discord) que ha creado esta.

Cada miembro del equipo tendrá que revisar estas tareas y poner un comentario, ya sea este positivo si lo ve todo correcto, como de indicación de haber encontrado algún problema.

Esta tarea se podrá pasar a la siguiente rama una vez todos los miembros hayan comprobado la definición de Hecho y esté la tarea con todos los "tics verdes" (comprobación que te pone en GitHub cuando revisas una tarea).

 
## Semántica de versionado

La semántica de versionado definida es la siguiente:

**X.y.z-ETIQUETA**

- **X-Versión mayor**: Cambios mayores, rompe la compatibiladad de la API, la versión inicial será 0.y.z, la versión 1.0.0 definirá la primera API pública.

- **y-Versión menor**: Cambios menores, no rompen la compatibilidad de la API, incluyen nuevas funcionalidades y mejoras, puede incluir parches.

- **z-Parche**: Eliminación de bugs, no rompen la compatibilidad de la API, sólo cambios internos para arreglar comportamientos incorrectos.

- **ETIQUETA**: Indican versiones preliminares, utilizado también para metadata, cuidado al comparar la procedencia de las versiones.

- **Reglas de versionado**: Cuando la versión mayor sea incrementada se resetean las demás, cuando se incremente la versión menor, se resetea el parche.


## Definición de Hecho

Una tarea se considera "Hecha" cuando se han completado las siguientes acciones.

Si esta se trata de código:
- Toda la funcionalidad de la tarea está satisfecha.
- El código ha sido revisado y aprobado por el equipo.
- La funcionalidad ha sido integrada con éxito en la rama principal (`develop` o `main` según corresponda).
- La tarea ha sido resuelta en iTop.

Si esta se trata de documentación:
- El documento recoja toda la información referente a este.
- El documento ha sido revisado y aprobado por el equipo.


## Gestión de documentos

Los documentos generados durante el proyecto se gestionan en el repositorio según las estrategias descritas anteriormente. Se utilizará la carpeta `docs` para organizar la documentación relacionada con el desarrollo, las pruebas y la gestión del proyecto, de manera que dentro de ella, se usarán carpetas para cada sprint.


## Resumen del trabajo con la CMDB iTop

Para el desarrollo del presente proyecto utilizaremos la CMDB iTop (IT Operational Portal), una aplicación web de código abierto para administrar hardware, software y servicios IT, además de otras características como un lenguaje de consulta propio.


### **Objetivos y alcance de la CMDB**

- **Gestión de la configuración**: Proporcionar una visión completa y precisa de los elementos de configuración (CI) dentro del entorno de tecnología de la organización, incluyendo su estado, relaciones y versiones.

- **Control de cambios**: Facilitar la gestión de cambios al proporcionar información detallada sobre los elementos de configuración y sus relaciones, lo que permite evaluar el impacto de los cambios planificados y controlar la propagación de cambios no autorizados.

- **Soporte de procesos de TI**: Servir como una fuente de datos centralizada para varios procesos de gestión de servicios de TI, como gestión de incidentes, gestión de problemas, gestión de cambios y gestión de activos.

- **Mejora de la eficiencia y reducción de riesgos**: Al mantener información precisa y actualizada sobre la configuración de la infraestructura de TI, la CMDB puede ayudar a mejorar la eficiencia operativa al facilitar la resolución de problemas, reducir los tiempos de inactividad y minimizar los riesgos asociados con cambios no planificados.

El alcance de una CMDB puede variar según las necesidades y la complejidad de la organización, pero generalmente abarca todos los componentes de TI que son relevantes para la prestación de servicios de TI, incluyendo servidores, dispositivos de red, aplicaciones, bases de datos, configuraciones de software, licencias, configuraciones de red, documentación y   relaciones entre estos elementos.


### **Estructura de la CMDB**

- La estructura de información en iTop está diseñada para proporcionar a las organizaciones una plataforma integral para administrar servicios, activos y operaciones de TI de una manera estructurada y eficiente.

- Los elementos de configuración (CI) son uno de los componentes clave dentro de la estructura de información de iTop.

- La información de los CI siempre está asociada con una organización.

- Los product owner han creado una organización para cada equipo (PSG2-2324-G5-52 en nuestro caso)

**Lista de los elementos de configuración agregados por cada miembro del grupo**

![Tabla de iTop (1)](/docs/static/Functional%20CI-1.png)
![Tabla de iTop (2)](/docs/static/Functional%20CI-2.png)


**Diagrama UML con las relaciones entre los diferentes configuration items**

![Diagrama UML](/docs/static/UML%20Relaciones.jpeg)
