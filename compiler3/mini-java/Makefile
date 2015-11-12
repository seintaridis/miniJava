all: compile

compile:
	java -jar jtb132di.jar minijava.jj
	/Users/dimitris/Documents/javacc-5.0/bin/javacc minijava-jtb.jj
	javac Main.java
	javac SymbolTable.java
	
run:
	java Main examples/BinaryTree.java

clean:
	rm -f *.class *~

