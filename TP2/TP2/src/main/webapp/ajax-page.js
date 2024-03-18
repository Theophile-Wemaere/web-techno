$(document).ready(function(){
    $("#submit").click(function( event ){
        event.preventDefault();
        var login = $("#login").val();
        var password = $("#password").val();
        $.ajax({
            url: "login-controller",
            type: "POST",
            data: {login: login, password: password},
            success: function(result){
                var message;
                console.log(result);
                if(result=="1")
                    message = "Credentials are good";
                else if(result=="0")
                    message = "Invalid credentials !"
                alert(message)
            },
            error: function(xhr, status, error){
                alert("Error: " + error);
            }
        });
    });
});