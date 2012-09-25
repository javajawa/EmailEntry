SRCS=$(wildcard src/**/*.java)
CLASSES:=$(subst src/,build/,$(SRCS))
CLASSES:=$(subst .java,.class,$(CLASSES))

JAVAC ?= javac

all: $(CLASSES)

clean:
	-rm -r build

build/%.class : src/%.java build
	$(JAVAC) -cp src/ -d build/ $<

build:
	mkdir -p build

