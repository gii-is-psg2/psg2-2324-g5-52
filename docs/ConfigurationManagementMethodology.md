# Metodología de Gestión de la Configuración

En este informe se describe la metodología de gestión de la configuración seguida por el grupo de trabajo G5-52, siendo aplicable al proyecto actual y a proyectos futuros que se puedan desarrollar.

## Estandares de Codificación

Los estándares de codificación se basan en PEP 8, Google Java Style Guide y se aplican de manera consistente en todo el proyecto. Esto incluye convenciones de nomenclatura, estilo de código y prácticas recomendadas como las siguientes:
- **Formato del código**: 4 espacios, maxima longitud (?), indentación, line break antes de un operador, blank lines, imports (java style guide)
- **Operadores**: espacio antes y despues
- **Casting**: espacio despues del casting
- **Estructuras de control**: (drupal)
- **Constantes**: (drupal)
- **Comentarios en el codigo**: (drupal) https://www.drupal.org/node/1354
- **Espacios en blanco en expresiones y declaraciones**: (pet peeves, PEP8)
- **Nombres de variables y métodos**: (java style guide)
- **Manejo de excepciones**: (java style guide)



## Política de Mensajes de Commit

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

presentacion de ev

## Definición de "Hecho"

Una tarea se considera "hecha" cuando se han completado las siguientes acciones:

- El código ha sido revisado y aprobado por al menos un compañero de equipo.
- Se han pasado todas las pruebas automatizadas.
- La funcionalidad ha sido integrada con éxito en la rama principal (`develop` o `master` según corresponda).

## Gestión de Documentos

Los documentos generados durante el proyecto se gestionan en el repositorio según las estrategias descritas anteriormente. Se utilizará la carpeta `docs` para organizar la documentación relacionada con el desarrollo, las pruebas y la gestión del proyecto.

