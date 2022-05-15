protocol = $(location).attr('protocol') + '//';
hostUrl = $(location).attr('host');
localServerUrl = protocol+hostUrl+'/';


Event.preventDefault();
let radio1 = document.getElementsByName("contact");
let radio2 = document.getElementsByName("contact2");
let radio3 = document.getElementsByName("contact3");
let value = 0;

if (radio1 == "Yes" ) { value++ }

if (radio2 == "8break45") { value++}

if (radio3 == "smallheels") {value++}

let proc = value/3 * 100
send = "Ваш результат равен " + proc + " процентов";


let a = table.getElementsByTagName('body');
a.append(send);
