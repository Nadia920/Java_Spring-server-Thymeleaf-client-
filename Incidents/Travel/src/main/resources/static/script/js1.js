/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

let radio1 = document.getElementsByName("test1");
let radio2 = document.getElementsByName("test2");
let radio3 = document.getElementsByName("test3");
let radio4 = document.getElementsByName("test4");
let radio5 = document.getElementsByName("test5");
let value2 = 0;

if (radio1 == "Yes" ) { value++ }
if (radio2 == "Yes" ) { value++ }
if (radio3 == "Yes" ) { value++ }
if (radio4 == "Yes" ) { value++ }
if (radio5 == "Yes" ) { value++ }



let proc = value2/5 * 100
send = "Ваш результат равен " + proc + " процентов";
let a = document.getElementsByTagName('body');
a.append(send);

         

