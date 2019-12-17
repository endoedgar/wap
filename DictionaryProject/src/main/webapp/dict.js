$(document).ready(function(){
    $('#lookup').click(function() {
        $.ajax({
            dataType: "json",
            url: "dictServlet",
            data: {
              word: $('#term').val()  
            },
            success: function(data) {
                let words = "<ol>";
                
                for(let i in data) {
                    words += "<li>(" + data[i].wordType + ") :: " +data[i].definition+ "</li>";
                }
                words += "</ol>";

                $("#result").html(words);
            }
        });
    });
});