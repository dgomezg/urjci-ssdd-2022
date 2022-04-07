$(document).ready(function() {
    $.ajax({
        url: "https://www.googleapis.com/books/v1/volumes?q=intitle:java"
    }).done(function(data){
        console.log(data);
        for (var i = 0; i < data.items.length; i++) {
          $("#books").append(new Option(data.items[i].volumeInfo.title, data.items[i].id));
        }
    })
})