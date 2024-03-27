all : Fibonacci.class deletes hello inout inout2 last memtest priqueue_test queue_test strings multiple_simple multiple2 DivZero exception exception2 callbyref read_strings

clean :
	-rm Fibonacci.class deletes hello inout inout2 last memtest priqueue_test queue_test strings multiple_simple multiple2 DivZero exception exception2 callbyref read_strings

Fibonacci.class : Fibonacci.java
	javac Fibonacci.java

deletes : deletes.cpp
	g++ deletes.cpp -o deletes

hello : hello.cpp
	g++ hello.cpp -o hello

inout : inout.cpp
	g++ inout.cpp -o inout

inout2 : inout2.cpp
	g++ inout2.cpp -o inout2

read_strings : read_strings.cpp
	g++ read_strings.cpp -o read_strings

last : last.cpp
	g++ last.cpp -o last

memtest : memtest.cpp
	g++ memtest.cpp -o memtest

priqueue_test : priority_queue.cpp priority_queue.h priqueue_test.cpp
	g++ priqueue_test.cpp queue.cpp priority_queue.cpp -o priqueue_test

queue_test : queue.cpp queue.h queue_test.cpp
	g++ queue_test.cpp queue.cpp -o queue_test

strings : strings.cpp
	g++ strings.cpp -o strings

multiple_simple : multiple_simple.cpp
	g++ multiple_simple.cpp -o multiple_simple

multiple2 : multiple2.cpp
	g++ multiple2.cpp -o multiple2

DivZero : DivZero.cpp
	g++ DivZero.cpp -o DivZero

exception : exception.cpp
	g++ exception.cpp -o exception

exception2 : exception2.cpp
	g++ exception2.cpp -o exception2

callbyref : callbyref.cpp
	g++ callbyref.cpp -o callbyref

