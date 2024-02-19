# Metodología de Gestión de la Configuración

En este informe se describe la metodología de gestión de la configuración seguida por el grupo de trabajo G5-52, siendo aplicable al proyecto actual y a proyectos futuros que se puedan desarrollar.

## Estandares de Codificación (ramon y miguel)

Los estándares de codificación se basan en PEP 8, Google Java Style Guide y se aplican de manera consistente en todo el proyecto. Esto incluye convenciones de nomenclatura, estilo de código y prácticas recomendadas como las siguientes:
- **Formato del código**: 4 espacios, maxima longitud 70 caracteres, indentación, line break antes de un operador, blank lines, imports (java style guide)
- **Operadores**: espacio antes y despues
- **Casting**: espacio despues del casting
- **Estructuras de control**: (drupal)
- **Constantes**: para el nombramiento de las constantes, haremos uso del estilo SREAMING_SNAKE_CASE(HELLO_WORLD).
- **Comentarios en el codigo**: se pondran mediante: /** (esto abre el comentario); * (para las lineas con el comentario); */ (para cerrar el comentario).
- **Espacios en blanco en expresiones y declaraciones**: dejaremos espaciones en blanco tanto por delante como por detras en las expresiones y declaraciones.
- **Nombres de variables y métodos**: estos nombres tienen que ser lo mas explicativos posibles, comenzando por minuscula y usando camelCase.
- **Manejo de excepciones**: se realizaran mediante "Try" y "Catch", indicnado en el Catch que tipo de excepción es. El mensaje de dicha excepcion tiene que ser lo mas significativo posible.



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

## Semántica de Versionado

La semántica de versionado definida es la siguiente:

**X.y.z-ETIQUETA**

- **X-Versión mayor**: Cambios mayores, rompe la compatibiladad de la API, la versión inicial será 0.y.z, la versión 1.0.0 definirá la primera API pública.

- **y-Versión menor**: Cambios menores, no rompen la compatibilidad de la API, incluyen nuevas funcionalidades y mejoras, puede incluir parches.

- **z-Parche**: Elimincación de bugs, no rompen la compatibilidad de la API, solo cambios internos para arreglar comportamientos incorrectos.

- **ETIQUETA**: Indican versiones preliminares, utilizado también para metadata, cuidado al comparar la procedencia de las versiones.

- **Reglas de versionado**: Cuando la versión mayor sea incrementada se resetean las demas, cuando se incremente la versión menor, se resetea el parche.

## Definición de "Hecho"

Una tarea se considera "hecha" cuando se han completado las siguientes acciones:

- Toda la funcionalidad de la tarea está satisfecha.
- El código ha sido revisado y aprobado por al menos un compañero de equipo.
- La funcionalidad ha sido integrada con éxito en la rama principal (`develop` o `main` según corresponda).

## Gestión de Documentos

Los documentos generados durante el proyecto se gestionan en el repositorio según las estrategias descritas anteriormente. Se utilizará la carpeta `docs` para organizar la documentación relacionada con el desarrollo, las pruebas y la gestión del proyecto.

