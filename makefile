#makefile for load shedding applications
#Calvin Nyoni
#2 March 2020

JFLAGS=-g
Compile=javac
Java=java

.SUFFIXES: .java .class
.java.class:
        $(Compile) $(JFLAGS) $*.java

CLASSES=LSArrayApp.java LSBSTApp.java\
	BinarySearchTree.java loadShedding.java

Main=hello
default: classes
classes: $(CLASSES:.java=.class)
run: hello.class
        $(Java) $(Main)
clean:
        $(RM) *.class

