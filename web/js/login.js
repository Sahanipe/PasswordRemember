function checkEmail() {
    var email = document.getElementById("email").value;
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if (!re.test(email)) {
        document.getElementById("emailHelp").innerHTML = "Invalid email address";
        document.getElementById("emailHelp").style.color = "red";
        document.getElementById("email").style.borderColor = "red";
        console.log("1");
        return false;
    } else {
        document.getElementById("emailHelp").innerHTML = "";
        document.getElementById("email").style.borderColor = "#489FDF";
        console.log("2");
        return true;
    }
}
function checkPassword() {
    var password = document.getElementById("password").value;

    if (password.length == 0) {
        document.getElementById("passwordHelp").innerHTML = "Invalid password";
        document.getElementById("passwordHelp").style.color = "red";
        document.getElementById("password").style.borderColor = "red";
        console.log("3");
        return false;
    } else {
        document.getElementById("passwordHelp").innerHTML = "";
        document.getElementById("password").style.borderColor = "#489FDF";
        console.log("4");
        return true;
    }
}
function login() {
    if (checkEmail() && checkPassword()) {
        $.ajax({
            type: "POST",
            data: {email: document.getElementById("email").value,
                password: document.getElementById("password").value
            },
            url: "Login",
            success: function (msg) {
                if(msg=="success"){
                    window.location.href = 'index.jsp';
                }
                else{
                    document.getElementById("email").style.borderColor = "red";
                    document.getElementById("password").style.borderColor = "red";
                    document.getElementById("passwordHelp").innerHTML = "Incorrect username or password";
                    document.getElementById("passwordHelp").style.color = "red";
                    
                }
            }
        });
    }
}