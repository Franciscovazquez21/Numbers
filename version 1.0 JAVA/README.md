# Numbers
Numbers is a play game based on guessing the opponent´s 4-digit number

## Instructions

El juego consta de 2 o mas jugadores, gana el jugador que adivina el número que el otro jugador eligio. 
El número esta formado por 4 digitos, no se puede repetir y el rango valido es del 1 al 9.
Se juega por turnos
Comienza el primer jugador (se puede decirdir quien comienza al azar) eligiendo un número. El jugador contrario 
debe determinar si es el número correcto, en el caso en que no sea, se debe informar cuales son los digitos del número
elegido por el primer jugador que se encuentran en la solución, para que el primer jugador pueda ir formando en su próximo
turno la siguiente combinación de digitos que representarián el número completo y correcto.

## Ejemplo(siguiendo un orden de turnos inicial jugador 1 - jugador 2):

* El jugador 1 elige el número 5432 / El jugador 2 elige el número 9581

* * Primer turno (comienza por adivinar el jugador 1):
Jugador 1 elige el número 1429

Para este caso el número a adivinar es el 9581, y se ha elegido 1429, el número no es el correcto pero tiene ocurrecias
de digitos que lo forman, el jugador 1 debe saber que ocurrencias o no existen para formar el número correcto si no lo 
adivinó y volver a elegirlo en su próximo turno.

* MANEJO DE OCURRENCIAS (bien - regular - ninguno)
Las ocurrencias corresponden a los aciertos o no de digitos nombrados por el jugador que se encuentran en el número a adivinar, estas deben estar acompañadas por el tipo de ocurrencia y la cantidad de cada una.

Ocurrencias para el primer turno en el ejemplo dado:
* 1 BIEN --> el número 4 se encuentra en la solución y en la posición correcta.
* 1 REGULAR --> el número 2 se encuentra  se encuentra en la solución y en una posición incorrecta.

Como jugador 1 no encontro el numero correcto (9581), es el turno del jugador 2.

Se juegan tantos turnos intercambiados y se muestran las ocurrencias como intentos sean necesarios hasta llegar al fin
del juego (un jugador adivina el numero del contrario).



