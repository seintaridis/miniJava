all: compile

compile:
	java -jar jtb132di.jar minijava.jj
	javacc minijava-jtb.jj
	javac Main.java
	javac SymbolTable.java


clean:
	rm -f *.class *~
