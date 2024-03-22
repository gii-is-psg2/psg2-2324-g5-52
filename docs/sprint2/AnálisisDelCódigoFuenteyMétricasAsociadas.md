# Análisis del Código Fuente y Métricas Asociadas - Sprint 2

# Universidad de Sevilla   

## Escuela Técnica Superior de Ingeniería Informática

### **Grupo de Prácticas G5-52**
  
  ![Logo US](/docs/static/Logo_US.png)

### Grado en Ingeniería Informática – Ingeniería del Software 

### Proceso Software y Gestión II
### Product Owner: Carlos Guillermo Müller Cejas
### Curso 2023 – 2024

## Introducción

En este documento se realizará un análisis del código fuente del proyecto gracias a la herramienta SonarQube. Se tendrán en cuenta la release del sprint1 y la de este sprint2 y se estudiarán las diferentes métricas asociadas.

## Release del Sprint1
### Frontend

#### Dashboard

![SonarQube Frontend Dashboard](/docs/static/sprint1FrontendDashboard.png)

- Métricas:
  - Bugs: esta métrica indica la cantidad de bugs que ha detectado en el código. En nuestro caso hay 4.
  - Reliability: En nuestro caso, la nota es una C al haber ya que al menos uno cuenta como un _major bug_.
  - Vulnerabilities: esta métrica indica la cantidad de vulnerabilidades que ha detectado en el código. En nuestro caso no hay ninguna.
  - Security: En nuestro caso la nota es una A, porque no ha encontrado ninguna vulnerabilidad.
  - Security Hotspots: mide la cantidad de potenciales vulnerabilidades que necesitan ser revisadas manualmente para determinar si lo son o no. En nuestro caso, tenemos 1 Security Hotspot.
  - Reviewed: Porcentaje de security hostpost revisados. En nuestro caso es 0.
  - Security Review: Tenemos de nota una E porque el security hotspot que tenemos no lo hemos revisado aún.
  - Debt: la deuda técnica que tenemos en el proyecto con las code smells que ha detectado. En nuestro caso tenemos una deuda técnica de 3 días.
  - Code Smells: cantidad de code smells que ha detectado. En nuestro caso son 152.
  - Maintainability: indica la mantenibilidad de nuestro código teniendo en cuenta la deuda técnica. En nuestro caso es una A porque es menor al 5%.
  - Coverage: indica la cobertura de las pruebas unitarias en nuestro código. En nuestro caso es 0 porque no disponemos de pruebas unitarias.
  - Duplications: indica las duplicidades de códigos encontradas. En nuestro caso es del 15.9%.

#### Bugs potenciales

Nuestro frontend tiene 4 bugs:

1. _/src/auth/register/index.js_

    En este archivo se encuentra el siguiente extracto de código:
    ```js
    if (response.status === 200) {
        return response.json();
    } else {
        return response.json();
    }
    ```
    El if no tiene sentido ya que siempre va a realizar la misma acción. Por lo tanto deberíamos de quitar el bloque condicional o hacer algo diferente en el caso de que la respuesta del fetch sea 200.

2. _/src/global.css_

    El bug en este archivo es el siguiente:
    ```css
    * {
        font-family: 'american-typewriter';
    }
    ```

    Si ninguna de las fuentes definidas en la delcaración `font-family` está disponible en el navegador del usuario, el navegador mostrará el texto utilizando su fuente por defecto. Se recomienda definir siempre una fuente genérica para cada font-family para obtener una situación menos degradada que confiar en la fuente por defecto del navegador. 

    Ejemplo de arreglo:

    ```css
    * {
        font-family: 'american-typewriter', Helvetica, Arial, Verdana, Tahoma;
    }
    ```
3. _/src/static/css/owner/consultations.css_

    Bug:
    ```css
    .checkbox-wrapper-10 .tgl-flip + .tgl-btn:after,
    .checkbox-wrapper-10 .tgl-flip + .tgl-btn:before {
    display: inline-block;
    transition: all 0.4s ease;
    width: 100%;
    text-align: center;
    position: absolute;
    line-height: 2em;
    font-weight: bold;
    color: #fff;
    position: absolute;
    top: 0;
    left: 0;
    -webkit-backface-visibility: hidden;
    backface-visibility: hidden;
    border-radius: 4px;
    }
    ```

    En este extracto de css, el único problema es que la propiedad position está repetida. En este caso no es un problema grave ya que valen lo mismo. Pero en el caso de que no valiesen lo mismo sólo la última instancia de una propiedad duplicada determina el valor real que se utilizará para él. Por ello, lo marca como un bug.

4. _/src/static/css/owner/editPet.css_

    Bug:
    ```css
    .edit-pet-form-container{
        max-width: 600px;
        height: 800px;
        width: 90%;
        height: 90%;
        margin-top: 10%;
    }
    ```
    
    En este caso se repite la propiedad height pero en este caso cambiando su valor, por lo tanto sólo la última instancia sería la que resultaría válida. Para solucionar esto deberíamos de quitar la que no se utilice.

#### Tipos de Code Smells

1. _'variable' is already declared in the upper scope_:
   1. Description: La variable que se está declarando ya está siendo declarada en otro lugar del código anteriormente.
   2. Por qué es un Code Smell: Sobreescribir o hacer shadowing a una variable declarada en un ámbito externo puede tener un fuerte impacto en la legibilidad, y por tanto en la mantenibilidad, de un trozo de código. Además, podría llevar a los mantenedores a introducir errores porque piensan que están usando una variable pero en realidad están usando otra.
   3. Gravedad: Es de gravedad _major_ ya que dificulta la legibilidad y el mantenimiento del código haciéndolo propenso a tener bugs.
   4. Solución: Eliminar todas las declaraciones posteriores a la primera y pasarlas a asignaciones.
2.  _Remove this useless assignment to variable "variable name"_:
   1. Description: Una variable asignada no se usa.
   2. Por qué es un Code Smell: Calcular o recuperar un valor sólo para luego sobrescribirlo o tirarlo, podría indicar un error grave en el código. Incluso si no es un error, es en el mejor de los casos un desperdicio de recursos. Por lo tanto, todos los valores calculados deben ser utilizados.
   3. Gravedad: Es de gravedad _major_ ya que hace el código propenso a errores graves y desperdicia recursos.
   4. Solución: Eliminar la asignaciones de variables que no se utilicen.
3. _Remove the declaration of a unused variable_:
   1. Description: Una variable declarada no se usa.
   2. Por qué es un Code Smell: Si se declara una variable local o una función local pero no se utiliza, es código muerto y debe eliminarse. De este modo, mejorará la capacidad de mantenimiento, ya que los desarrolladores no se preguntarán para qué se utiliza la variable o la función.
   3. Gravedad: Es de gravedad _minor_ ya que es código muerto que entorpece el mantenimiento.
   4. Solución: Eliminar la declaraciones de variables que no se utilicen.
4. _Refactor this function to reduce its Cognitive Complexity from 29 to the 15 allowed_:
   1. Description: Una función es demasiado compleja.
   2. Por qué es un Code Smell: La Cognitive Complexity es una medida de lo difícil que es entender el flujo de control de una función. Las funciones con una Cognitive Complexity alta serán difíciles de mantener.
   3. Gravedad: Es de gravedad _critical_ ya que puede hacer que el código sea realmente difícil de mantener.
   4. Solución: Extraer código a otras funciones para reducir su complejidad.
5. _Refactor this function to always return the same type_:
   1. Description: La función no devuelve siempre el mismo tipo de variable.
   2. Por qué es un Code Smell: A diferencia de los lenguajes fuertemente tipados, JavaScript no impone un tipo de retorno en una función. Esto significa que diferentes caminos a través de una función pueden devolver diferentes tipos de valores, lo que puede ser muy confuso para el usuario y significativamente más difícil de mantener.
   3. Gravedad: Es de gravedad _major_ ya que puede hacer que el código sea realmente difícil de mantener.
   4. Solución: Hacer que la función devuelva el mismo tipo de retorno de la función.
6.  _Extract this nested ternary operation into an independent statement_:
   1. Description: Hay una operación ternaria anidada a otra haciendo que el código sea poco entendible.
   2. Por qué es un Code Smell: Anidar operadores ternarios hace más complejo el código haciéndolo más díficil de mantener al no entender bien a los que se refiere.
   3. Gravedad: Es de gravedad _major_ ya que puede hacer que el código sea realmente difícil de mantener.
   4. Solución: Extraer la operación ternaria anidada.
7. _Remove this commented out code_:
   1. Description: Hay código que está comentado y no se usa.
   2. Por qué es un Code Smell: Comentar código sobrecarga los programas y reduce su legibilidad.
   3. Gravedad: Es de gravedad _major_ ya que puede hacer que el código sea realmente difícil de mantener.
   4. Solución: El código no utilizado debe eliminarse y puede recuperarse del historial de control de código fuente si es necesario.
8. _Unnecessary semicolon_:
   1. Description: Hay dos punto y coma juntos.
   2. Por qué es un Code Smell: No deberían de haber dos, porque con uno ya funciona.
   3. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   4. Solución: El código no utilizado debe eliminarse y puede recuperarse del historial de control de código fuente si es necesario.
9. _'library' import is duplicated_:
   1. Description: Se importa dos veces la misma librería.
   2. Por qué es un Code Smell: No deberían de haber dos, porque con uno ya funciona.
   3. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   4. Solución: Eliminar uno de los dos imports o si se están importando dos objetos por separado en dos imports unirlos en uno solo.
10. _Remove this unused import of 'library'_:
   1. Description: Se importa una librería que no se utiliza.
   2. Por qué es un Code Smell: No hay ninguna razón para importar librerías que no utilizas y hacerlo aumenta innecesariamente la carga.
   3. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   4. Solución: Eliminar la importación.

### Backend

#### Dashboard

![SonarQube Backend Dashboard](/docs/static/sprint1BackendDashboard.png)

- Métricas:
  - Bugs: esta métrica indica la cantidad de bugs que ha detectado en el código. En nuestro caso hay 2.
  - Reliability: En nuestro caso, la nota es una C ya que al menos un bug se considera _major bug_.
  - Vulnerabilities: esta métrica indica la cantidad de vulnerabilidades que ha detectado en el código. En nuesto caso no hay ninguna.
  - Security: En nuestro caso la nota es una A, porque no ha encontrado ninguna vulnerabilidad.
  - Security Hotspots: mide la cantidad de potenciales vulnerabilidades que necesitan ser revisadas manualmente para determinar si lo son o no. En nuestro caso, tenemos 1 Security Hotspot.
  - Reviewed: Porcentaje de security hostpost revisados. En nuestro caso es 0.
  - Security Review: Tenemos de nota una E porque el security hotspot que tenemos no lo hemos revisado aún.
  - Debt: la deuda técnica que tenemos en el proyecto con las code smells que ha detectado. En nuestro caso tenemos una deuda técnica de 5h y 27 min.
  - Code Smells: cantidad de code smells que ha detectado. En nuestro caso son 209.
  - Maintainability: indica la mantenibilidad de nuestro código teniendo en cuenta la deuda técnica. En nuestro caso es una A porque es menor al 5%.
  - Coverage: indica la cobertura de las pruebas unitarias en nuestro código. En nuestro caso es 0 porque no disponemos de pruebas unitarias.
  - Duplications: indica las duplicidades de códigos encontradas. En nuestro caso es del 0%.

#### Bugs potenciales

Nuestro backend tiene 2 bugs:

1. _/src/main/petclinic/clinic/ClinicService.java_

    Bug:
    ```java
    @Transactional
	public Clinic update(Clinic clinic, int clinicId) throws DataAccessException {
		
		Clinic clinicToUpdate = clinicRepository.findById(clinicId).get();
		if (clinic.getClinicOwner() != null){
			BeanUtils.copyProperties(clinic, clinicToUpdate, "id", "owners");
		}else{
			BeanUtils.copyProperties(clinic, clinicToUpdate, "id", "clinicOwner", "owners");
		}
		return save(clinicToUpdate);
	}
    ```

    En la línea:
    ```java 
    Clinic clinicToUpdate = clinicRepository.findById(clinicId).get();
    ```
    Se accede directamente a un optional sin antes hacer una comprobación de si contiene a un objeto o no.
    Tendría que tener un condicional antes como por ejemplo:
    ```java
    Optional<Clinic> clinicToUpdateOpt = clinicRepository.findById(clinicId);
    if(!clinicToUpdateOpt.isPresent())
        return null;
    Clinic clinicToUpdate = clinicToUpdateOpt.get();
    ```

2. _/src/main/petclinic/clinicOwner/ClinicOwnerService.java_
   
   Bug:
   ```java
   @Transactional(readOnly = true)
	public ClinicOwner findById(int clinicOwnerId) throws DataAccessException {
		return clinicOwnerRepository.findById(clinicOwnerId).get();
	}
    ```
    En este caso ocurre lo mismo que anteriormente, debería de haber un condicional antes que verifique que se puede acceder al optional. Se solucionaría de la misma forma que el anterior.

#### Tipos de Code Smells

1. _Remove this commented out code_:
   1. Description: Hay código que está comentado y no se usa.
   2. Por qué es un Code Smell: Comentar código sobrecarga los programas y reduce su legibilidad.
   3. Gravedad: Es de gravedad _major_ ya que puede hacer que el código sea realmente difícil de mantener.
   4. Solución: El código no utilizado debe eliminarse y puede recuperarse del historial de control de código fuente si es necesario.
2. _Provide the parametrized type for this generic_
   1. Description: No hay un tipo parametrizado para un tipo genérica.
   2. Por qué es un Code Smell: Los tipos genéricos no deberían usarse sin procesar (sin parámetros de tipo) en declaraciones de variables o valores de retorno. Al hacerlo, se elude la comprobación de tipos genéricos y se aplaza la detección de código inseguro al tiempo de ejecución.
   3. Gravedad: Es de gravedad _major_ ya que resultar en futuros bugs.
   4. Solución: Especificar un tipo parametrizado.
3. _Declare this local variable with "var" instead_
   1. Description: Una variable local no se está declarando con "var".
   2. Por qué es un Code Smell: Aunque no siempre es posible o más limpio utilizar esta nueva forma de declarar una variable, cuando el tipo de la izquierda es el mismo que el de la derecha en una asignación, el uso de var dará como resultado un código más conciso.
   3. Gravedad: Es de gravedad _info_ ya que tal como está no supone un problema de ningún tipo.
   4. Solución: Cambiar la asignación para que sea con "var".
4. _Replace this lambda with a method reference_
   1. Description: Existe una lambda que puede ser reemplazado con un _method reference_
   2. Por qué es un Code Smell: Method/constructor son, en general, más compactas y legibles que el uso de lambdas, por lo que son preferibles.
   3. Gravedad: Es de gravedad _minor_ ya que solo empeora un poco la legibilidad del código.
   4. Solución: Cambiar la lambda por un _method reference_
5. _Replace the type spcefication in this constructor call with the diamond operator ("<>")_
   1. Description: Se debería de usar "<>".
   2. Por qué es un Code Smell: En lugar de tener que declarar el tipo de una Lista tanto en su declaración como en su constructor, ahora puedes simplificar la declaración del constructor con <>, y el compilador inferirá el tipo.
   3. Gravedad: Es de gravedad _minor_ ya que solo empeora un poco la legibilidad del código.
   4. Solución: Usar "<>".
6. _Remove this unused import of 'library'_:
   1. Description: Se importa una librería que no se utiliza.
   2. Por qué es un Code Smell: No hay ninguna razón para importar librerías que no utilizas y hacerlo aumenta innecesariamente la carga.
   3. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   4. Solución: Eliminar la importación.
7. _Replace this use of System.out or System.err by a logger_:
   1. Description: Las salidas estándar no deben utilizarse directamente para registrar nada.
   2. Por qué es un Code Smell: Se tiene que cumplir que el usuario pueda recuperar los logs fácilmente, que sean uniformes, que se deben de registrar realmente y los logs sensibles se tienen que guardar de forma segura.
   3. Gravedad: Es de gravedad _major_ ya que si se solucionase se podrían arreglar bugs fácilmente mirando los logs.
   4. Solución: Cambiar _System.out_ por _System.err_
8. _Remove the declaration of thrown exception, as it cannot be thrown from method's body_:
   1. Description: Las declaraciones "throws" no deben ser superfluas.
   2. Por qué es un Code Smell: No puede ser listada múltiples veces, una subclase de otra excepción listada o completamente innecesaria porque el tipo de excepción no puede ser lanzado.
   3. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   4. Solución: Quitar la excepción.
9. _Inject this field value directly into "configure", the only method that uses it_:
   1. Description: La inyección de métodos debe utilizarse en las clases "@Configuration".
   2. Por qué es un Code Smell: Cuando se utiliza @Autowired, las dependencias deben resolverse cuando se instancia la clase, lo que puede provocar una inicialización temprana de los beans o hacer que el contexto busque el bean en lugares donde no debería. Para evitar este problema y optimizar la carga del contexto, las dependencias deben solicitarse lo más tarde posible. Esto significa utilizar inyección de parámetros en lugar de inyección de campos para las dependencias que sólo se utilizan en un único método @Bean.
   3. Gravedad: Es de gravedad _critical_ ya que puede ser un problema que puede originar bugs.
   4. Solución: Inyectar el valor a "configure".
10. _Remove the parentheses around the parameter_:
   1. Description: Los paréntesis deben eliminarse de un único parámetro de entrada lambda cuando se infiere su tipo.
   2. Por qué es un Code Smell: Hay dos sintaxis posibles para una lambda que sólo tiene un parámetro de entrada con un tipo inferido: con y sin paréntesis alrededor de ese único parámetro. La sintaxis más simple, sin paréntesis, es más compacta y legible que la que tiene paréntesis, por lo que es preferible.
   3. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   4. Solución: Eliminar los paréntesis alrededor del parámetro.
11. _Remove hits unnecesssary cast to a type_:
   1. Description: No deben utilizarse casts redundantes.
   2. Por qué es un Code Smell: Las expresiones de casts innecesarias dificultan la lectura y comprensión del código.
   3. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   4. Solución: Eliminar los casts innecesarios.
12. _Declare variable on a separate line_:
   1. Description: No deben declararse varias variables en la misma línea.
   2. Por qué es un Code Smell: Declarar múltiples variables en una línea es difícil de leer.
   3. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   4. Solución: Declarar la variable en otra línea.
13. _Make this field final_:
   1. Description: Las clases de excepción deben ser inmutables.
   2. Por qué es un Code Smell: Hacer que todos los campos de una clase Exception sean final asegura que su estado estará completamente definido al mismo tiempo que la Excepción es instanciada y que no será acutalizado o corrompido por un manejador de errores cuestionable.s
   3. Gravedad: Es de gravedad _minor_ ya que puede no es un gran problema de mantenimiento pero es algo a tener en cuenta.
   4. Solución: Hacer el campo final.
    