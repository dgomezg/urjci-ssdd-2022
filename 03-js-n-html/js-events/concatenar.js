console.log('Definiendo funcion concatenar');
var concatenar = function(event) {
    var result = 
         $('#campo1').get(0).value + " " 
        + $('#campo2').get(0).value;
    $('#resultado').get(0).innerHTML = result;
};


$(document).ready(function() {
    $('#button').get(0).onclick = concatenar;   
});


