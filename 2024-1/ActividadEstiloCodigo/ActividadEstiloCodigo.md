# Estilos de código , analisis estático 
## Tarea
Selecciona tres elementos de la guía de estilo con los que estés de acuerdo y, para cada uno, explica por
qué. Si no hay suficientes elementos con los que estés de acuerdo, da tu mejor estimación sobre la
razón detrás de la selección (con tus propias palabras) y los beneficios que proporciona. Nota: "No hay
razón" y "No hay beneficios" no son respuestas aceptables aquí.

Utiliza **Java Style Guide (Google)**, **Python Style Guide (Google)**, **PEP 8 (Python Enhancement Proposal)**.

Muestra código donde aplicas lo que estas de acuerdo de la guia que elegistes.
Selecciona ahora tres elementos de la guía de estilo con los que no esté de acuerdo y, para cada uno,
explique por qué. Si no hay suficientes elementos con los que no está de acuerdo, proporciona tu mejor
estimación de por qué alguien podría no estar de acuerdo y qué posibles desventajas tiene usarlo.

## Desarrollo
Para esta actividad se eligió la guía de estilo de Java style Guide, y se seleccionaron tres elementos con los que se está de acuerdo y 1 con lo que no se estoy de acuerdo.

### Estilos de código con los que estoy de acuerdo
1. Uso de 2 espacios para la indentación:

    - **Razón:** Facilita la lectura del código sin ocupar demasiado espacio horizontal, lo que es útil especialmente en pantallas con resoluciones más bajas o cuando se visualizan múltiples archivos uno al lado del otro.
    - **Beneficios:** Mejora la legibilidad y evita la necesidad de desplazamiento horizontal, lo que puede ser molesto y disruptivo.

         ```java
        public class Example {
          public void method(boolean condition){
              if(condition) {
                  System.out.println("Condition is true");
              } else {
                  System.out.println("Condition is false");
              }
          }
      }
      ``` 
2. Lineas de longitud máxima de 100 caracteres:
   - **Razón:**  Mantener las líneas de código cortas mejora la legibilidad y facilita la revisión del código, al tiempo que aprovecha adecuadamente el espacio disponible en pantallas modernas. 
    - **Beneficios:**  Reduce la necesidad de desplazamiento horizontal y hace que el código sea más fácil de leer y mantener.

        ```java
         public String getMessage() {
           return "This is a message that is kept within 100 characters for better readability.";
       }
      ```
3. Uso de nombres de variables significativos:
    - **Razón:** Los nombres de variables descriptivos mejoran la comprensión del código, facilitando el mantenimiento y la colaboración entre distintos desarrolladores.
   - **Beneficios:** Aumenta la claridad y reduce la posibilidad de errores al comprender rápidamente el propósito de cada variable.

    ```java
      public class Calculator {
        private int result;

        public void add(int number) {
          result += number;
        }

        public int getResult() {
          return result;
        }
      }
      ```
### Estilos de código con los que no estoy de acuerdo

