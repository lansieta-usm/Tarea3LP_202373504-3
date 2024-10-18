# Tarea3LP_202373504-3
Nombre: Lucas Ansieta M.
Rol: 202373504-3

Entorno de desarrollo: Visual Studio Code (Windows/Debian Linux/macOS). Principalmente en Debian.

Compilación:
En los 3 sistemas de desarrollo, mediante javac 23 [java 23 2024-09-17]. Compilador y paquetes actualizados a fecha 07-10-2024.

Instrucciones de ejecución:
Desde la consola, usando los siguientes comandos:
  make
  java NoJavaSky.java

Consideraciones para la ejecucion:
No hay consideraciones adicionales para la ejecución... El programa es capaz de detectar inputs erroneos en todos los casos.

Consideraciones adicionales:
Cambié la generación de la profundidad en la clase Oceanico de modo que la máxima profundidad que se pueda generar sea de 100 mts. Esto debido a la existencia de valores negativos en la protección del exotraje del jugador tras visitar un planeta oceánico con una profundidad muy grande (>223).
Programé la recarga de combustible de la Nave y energía del exotraje de modo que estas se puedan hacer siempre y cuando el jugador esté orbitando un planeta. Las instrucciones respecto a cómo debían ser estos atributos no eran claras, por ende lo dejé en el apartado "3. Mas opciones" al momento de orbitar un planeta.
Importante destacar que el jugador puede descubrir nuevos planetas si, al hacer un salto, la posición final es igual al tamaño de la lista (Ej: Para descubrir el planeta 11, desde la posición 0, se debe hacer un salto de tamaño 10 hacia la derecha).