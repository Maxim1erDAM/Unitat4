
CC=gcc
CFLAGS=-Wall -g

calc.o: calc.c calc.h
	$(CC) $(CFLAGS) -c calc.c -o calc.o

calcula: calcula.c calc.o
	$(CC) $(CFLAGS) calcula.c calc.o -o calcula

install: dist
	cp -r ../dist/* /

.PHONY: distclean
distclean: 
	rm -rf ../dist;

.PHONY: targz
targz: clean
	mkdir -p source
	cp *.c *.h Makefile source
	tar -cvf calcula.tar source
	gzip calcula.tar
	rm -rf calcula.tar
	rm -rf source

.PHONY: clean
clean:
	rm -rf *.o
	rm -rf calcula

.PHONY: dist
dist: 
	rm -rf ../dist;
	mkdir -p ../dist/usr/bin/calcula
	cp calcula ../dist/usr/bin/calcula
