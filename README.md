 [![Build Status](https://travis-ci.com/michelaventurini96/Gomoku3.svg?branch=master)](https://travis-ci.com/michelaventurini96/Gomoku3)
# Gomoku

**Gomoku**, or Go-moku or Five in line, is a traditional oriental game, originally from China. In Japanese language *Go* means five, and *moku* pieces (or eyes or dots).

Black plays first, and players alternate in placing a stone of their color on an empty intersection. The winner is the first player to get an unbroken row of five stones horizontally, vertically, or diagonally.

Here the Java implementation of this game can be found. We provide the user 3 different implementations of Gomoku (Standard, Omok and Freestyle) and 3 different opening rules (Standard, Swap and Swap2). Each implementation has different rules and can be read in the file [GomokuRules](https://github.com/michelaventurini96/Gomoku3/blob/master/GomokuRules.pdf). 

The structure of the project follows the pattern Model View Controller. Both the Command Line version and the version with the Grapich Interface have been implemented. 

The structure of the project follows the pattern Model View Controller. Both the [Command Line version](https://github.com/michelaventurini96/Gomoku3/tree/master/src/main/java) and the version with the [Grapich Interface](https://github.com/michelaventurini96/Gomoku3/tree/master/srcGraphics/main/java) have been implemented. They share the same Model implementation while they obviously have different Controller and View. 

## How to run it

#### Open the project with IntelliJ 

Requirements: 
* [IntelliJ IDE](https://www.jetbrains.com/idea/)
* JavaFX Library (for the project the 11.0.2 has been used)
* JDK

Steps: 
* Open IntelliJ
* Create a new project from Version Control and clone this repository
* Load the JavaFX library 

Run the project: 
* to run the Command Line version of the game the run the class Main inside the Controller package (src package) 
* to run the version with the Grapich Interface run the class Main inside the ControllerJF package (srcGrapichs) 

