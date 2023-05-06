# Progetto-m152-Java

Questa repository fa parte del progetto finale per il modulo125 in particolare si tratta del back-end necessario per il corretto funzionamento del front-end ([Progetto-m152-Angular](https://github.com/joekueng/Progetto-m152-Angular)).

## Requisiti
* Java JDK 17 o superiore
* Apache Maven 3.8 o superiore
* Un IDE Java come Eclipse o IntelliJ IDEA
* Un database MySQL

## Installazione
1. Clonare il repository
2. Eseguire il file ```database.sql``` per creare il database e le tabelle necessarie
3. Inserire i dati di accesso al database nel file ```application.properties```
3. Compilare il progetto utilizzando Maven
```mvn install```
4. Eseguire il progetto utilizzando Maven
```mvn spring-boot:run``` oppure configurando run configuration nel vostro IDE 

L'applicazione sarà quindi disponibile all'indirizzo http://localhost:8080.

## Utilizzo
L'applicazione é stata progettata per essere utilizzare come back-end del progetto finale del modulo 152. In particolare é usata per la gestione dei dati e la comunicazione con il database.
