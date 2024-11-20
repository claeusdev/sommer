
.PHONY: build run

build:
	mvn clean compile assembly:single

run:
	java -jar target/sommer-1.0-SNAPSHOT-jar-with-dependencies.jar
