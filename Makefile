# Makefile para compilar el proyecto NoJavaSky

# Variables
JAVAC = javac
JFLAGS = -source 23 -target 23
SRC = NoJavaSky.java Planeta.java Helado.java Oceanico.java Radiactivo.java \
      Volcanico.java CentroGalactico.java MapaGalactico.java \
      tieneAsentamientos.java Nave.java Jugador.java
CLASSES = $(SRC:.java=.class)

# Compilar todo el proyecto
all: $(CLASSES)

%.class: %.java
	$(JAVAC) $(JFLAGS) $<

# Limpiar los archivos .class
clean:
	rm -f *.class
