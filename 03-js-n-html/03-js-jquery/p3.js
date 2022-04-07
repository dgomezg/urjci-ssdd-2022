$(document).ready(function () {

    $("#add-button").click(function (event) {
        event.preventDefault();
        
        var value1 = $('#campo1').val();
        var value2 = $('#campo2').val();
        $('#info-concatenada').append('<p>' + value1 + ' ' + value2 + '</p>')
    })
 })