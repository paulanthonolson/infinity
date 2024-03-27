all :
	cd Code/Module1; make
	cd Code/Module2; make
	cd Code/Module3; make
	cd Code/Module4; make
	cd Code/Module5; make
	cd Code/Module6; make

clean :
	-cd Code/Module1; make clean
	-cd Code/Module2; make clean
	-cd Code/Module3; make clean
	-cd Code/Module4; make clean
	-cd Code/Module5; make clean
	-cd Code/Module6; make clean

tar :
	make clean
	-rm ../csc240.tar
	cd ..; tar -cf csc240.tar CSC240/Code CSC240/Labs CSC240/Projects CSC240/makefile

