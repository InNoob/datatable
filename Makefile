Target=com.jason.$(class)
Objs= ./bin/$(path)/*.class

all:$(Target)
	clear;
	java -classpath $(jar):bin $< $(args)

$(Target):
	javac -cp $(jar):. -d ./bin ./src/com/jason/*.java

clean:
	-rm -rf ./bin/*
