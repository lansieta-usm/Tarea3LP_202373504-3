# Variables
JAVAC = javac
JFLAGS = -source 23 -target 23 -d Clases
SRC = NoJavaSky.java Planeta.java Helado.java Oceanico.java Radiactivo.java \
      Volcanico.java CentroGalactico.java MapaGalactico.java \
      tieneAsentamientos.java Nave.java Jugador.java
CLASSES = $(SRC:.java=.class)

# Compilación
all: $(CLASSES)

%.class: %.java
	$(JAVAC) $(JFLAGS) $<

# Limpiar archivos .class
clean:
	rm -f Clases/*.class
