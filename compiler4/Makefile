all: compile

compile:
	java -jar jtb132di.jar spiglet.jj
	/Users/dimitris/Documents/javacc-5.0/bin/javacc spiglet-jtb.jj
	javac Main.java

run:
	java Main examples/BinaryTree.java

clean:
	rm -f *.class *~
