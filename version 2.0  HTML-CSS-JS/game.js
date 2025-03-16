"use strict"

//variables del juego
let count = 0;
let turn = 1;
let number_player1=[];
let number_player2=[];
let list_numbers_player1=[];
let list_numbers_player2=[];
let list_checks_player1=[];
let list_checks_player2=[];

//botones
let btn_reset = document.getElementById("btn_reset");
let btn_start = document.getElementById("btn_start");
let form_number = document.getElementById("form_number");

//input
let input_number = document.getElementById("input_number");

//tablas de resultados
let table_player1=document.getElementById("player1");
let table_player2=document.getElementById("player2");

//estados iniciales botones y tipo de input
btn_reset.classList.add("hide");
form_number.classList.add("hide");
table_player1.classList.add("hide");
table_player2.classList.add("hide");
input_number.type = "password";

//eventos
btn_reset.addEventListener('click',reset);
btn_start.addEventListener('click',start);

//ingreso controlado solo de numeros sin repetir del 0 al 9
form_number.addEventListener("submit", function(event){
    event.preventDefault();
    let number = input_number.value;
    input_number.value="";
    if(checkNumber(number)){
        count++;
        if(count==1){
            asignNumberPlayer(number,number_player1);
        }else if(count==2){
            asignNumberPlayer(number,number_player2);
        }
        if(input_number.type==="password" && count == 2){
            input_number.type = "number";
        }   
    }else{
        return;
    }
    //ya se ingresaron ambos numeros de jugadores, empiezan los turnos
    if(count > 2){
        //hacer los intercambios de numeros
        if(turn==1){
            verifyNumber(number,number_player2,table_player1);
            turn++;
        }else{
            verifyNumber(number,number_player1,table_player2);
            turn--;
        }
    }

});

//verifica coincidencias
function verifyNumber(number,numberPlayer,tablePlayer){

    let digits = number.split("");
    let correctPosition = 0;
    let correctNumber=0;

    if(digits === numberPlayer){
        return true;
    }

    for(let i=0;i<digits.length;i++){
        if(digits[i]===numberPlayer[i]){
            correctPosition++;
        }else if(numberPlayer.includes(digits[i])){
            correctNumber++;
        }
    }
    
    let row=document.createElement("tr");
    
    let cellNumber = document.createElement("td");
    cellNumber.textContent=number;
    row.appendChild(cellNumber);

    let cellResult = document.createElement("td");
    cellResult.textContent= `${correctPosition} bien / ${correctNumber} regular`;
    row.appendChild(cellResult);

    tablePlayer.appendChild(row);

}

//asigna el numero de cada jugador que debe ser descubierto
function asignNumberPlayer(number,numberPlayer){
    let digits = number.split("");
    numberPlayer.length=0;
    numberPlayer.push(...digits);
}

//mensajes tipo toast informativos
function log(messaje, type = "info"){
    let log = document.getElementById("log");
    //agrega mensaje y clase correspondiente
    log.textContent=messaje;
    log.className = `log ${type} show`

    setTimeout(()=>{
        log.classList.remove("show");
    },3000);

}


//controla que el numero se encuentre en rango valido
function checkNumber(number){
    let digits = number.split("");
    let unique_digits = new Set(digits);
    let regex = /^[1-9]+$/;//expresion regular para controlar solo digitos
    
    if(number.length !== 4){
        log("solo puedes ingresar un numero de 4 digitos","error");
        return false;
    }
    
    if(!regex.test(number)){
        log("solo puedes ingresar numeros del 1 al 9","error");
        return false;
    }

    if(digits.length !== unique_digits.size){
        log("no se pueden ingresar numeros repetidos","error");
        return false;
    }
    return true;
}

//resetea juego
function reset(){
    let confirmState = confirm("¿desea reiniciar el juego?");
    if(confirmState){
        console.log("reset");
        btn_start.classList.remove("hide");
        btn_reset.classList.add("hide");
        form_number.classList.add("hide");
        table_player1.classList.add("hide");
        table_player2.classList.add("hide");
        input_number.type="password";
        count = 0;
    }
    return;
}

//inicia juego
function start(){
    console.log("start");
    btn_start.classList.add("hide");
    btn_reset.classList.remove("hide");
    form_number.classList.remove("hide");
    table_player1.classList.remove("hide");
    table_player2.classList.remove("hide");
    return;
}


function insert(){
    let number_input = document.getElementById("number");        
    console.log(number_input);
    return;
}


//jugadores colocan sus nombres--jugador 1 , jugador 2
//jugadores colocan sus numeros
//piedra papel o tijera para quien comienza
//jugador elije numero y muestra resultado de asiertos
//si gana, marcador se actualiza
//opcion de volver a jugar
//si no , jugador 2 elije
























/*
let btn = document.getElementById("btn");
let btn_restart = document.getElementById("btn_restart");
let result = document.getElementById("parrafo");
let arrayNumbers = [];
btn.addEventListener('click',funcion);
btn_restart.addEventListener('click',funcion_restart);


function funcion (){
    
    let value = document.getElementById("input").value; 
    let item = document.createElement("li");
    item.textContent=value;
    arrayNumbers.push(item);
    for(let i=0;i<arrayNumbers.length;i++){
        result.appendChild(item);
    }
    console.log(arrayNumbers.length);
}


function funcion_restart(){
    arrayNumbers=[];
    result.innerHTML="";
    console.log(arrayNumbers.length)
}
*/

