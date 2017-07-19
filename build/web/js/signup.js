function checkName() {
    var name = document.getElementById("name").value;

    if (name.length == 0) {
        document.getElementById("nameHelp").innerHTML = "Invalid password";
        document.getElementById("nameHelp").style.color = "red";
        document.getElementById("name").style.borderColor = "red";
        return false;
    } else {
        document.getElementById("nameHelp").innerHTML = "";
        document.getElementById("name").style.borderColor = "#489FDF";
        return true;
    }
}
function checkEmail() {
    var email = document.getElementById("email").value;
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if (!re.test(email)) {
        document.getElementById("emailHelp").innerHTML = "Invalid email address";
        document.getElementById("emailHelp").style.color = "red";
        document.getElementById("email").style.borderColor = "red";
        return false;
    } else {
        document.getElementById("emailHelp").innerHTML = "";
        document.getElementById("email").style.borderColor = "#489FDF";
        return true;
    }
}
function checkPassword() {
    var password = document.getElementById("password").value;
    var repassword = document.getElementById("repassword").value;

    if (password.length == 0 && repassword.length > 0) {
        document.getElementById("passwordHelp").innerHTML = "Invalid password";
        document.getElementById("passwordHelp").style.color = "red";
        document.getElementById("repasswordHelp").innerHTML = "Passwords are not matched";
        document.getElementById("repasswordHelp").style.color = "red";
        document.getElementById("password").style.borderColor = "red";
        document.getElementById("repassword").style.borderColor = "red";
        return false;
    } else if (password.length == 0) {
        document.getElementById("passwordHelp").innerHTML = "Invalid password";
        document.getElementById("passwordHelp").style.color = "red";
        document.getElementById("password").style.borderColor = "red";
    } else if (password.length > 0 && repassword.length > 0 && password != repassword) {
        document.getElementById("repasswordHelp").innerHTML = "Passwords are not matched";
        document.getElementById("repasswordHelp").style.color = "red";
        document.getElementById("password").style.borderColor = "red";
        document.getElementById("repassword").style.borderColor = "red";
        return false;
    } else {
        document.getElementById("passwordHelp").innerHTML = "";
        document.getElementById("password").style.borderColor = "#489FDF";
        return true;
    }
}

function recheckPassword() {
    var password = document.getElementById("password").value;
    var repassword = document.getElementById("repassword").value;

    if (repassword.length == 0) {
        document.getElementById("repasswordHelp").innerHTML = "Invalid password";
        document.getElementById("repasswordHelp").style.color = "red";
        document.getElementById("repassword").style.borderColor = "red";
        return false;
    } else if (password != repassword) {
        document.getElementById("repasswordHelp").innerHTML = "Passwords are not matched";
        document.getElementById("repasswordHelp").style.color = "red";
        document.getElementById("password").style.borderColor = "red";
        document.getElementById("repassword").style.borderColor = "red";
        return false;
    } else {
        document.getElementById("repasswordHelp").innerHTML = "";
        document.getElementById("password").style.borderColor = "#489FDF";
        document.getElementById("repassword").style.borderColor = "#489FDF";
        return true;
    }
}

function next1() {
    if (checkName() && checkEmail() && recheckPassword()) {
        var name = document.getElementById("name").value;
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;

        //get questions
        $.ajax({
            type: "POST",
            url: "GetGeneralQuestions",
            success: function (msg) {
                var questions = JSON.parse(msg);

                var content = '<div class="form-group" style="margin-top: 30px">\n\
<lable>' + questions[0] + '</lable>\n\
<input type="text" class="form-control" id="answer1" placeholder="Enter answer" maxlength="30" onchange=\'checkAnswer("answer1","answer1Help")\' style="color: #4e89FDF;"/>\n\
<small id="answer1Help" class="form-text text-muted"></small>\n\
</div><div class="form-group">\n\
<lable>' + questions[1] + '</lable>\n\
<input type="text" class="form-control" id="answer2" placeholder="Enter answer" maxlength="30" onchange=\'checkAnswer("answer2","answer2Help")\' style="color: #4e89FDF;"/>\n\
<small id="answer2Help" class="form-text text-muted"></small>\n\
</div><div class="form-group">\n\
<lable>' + questions[2] + '</lable>\n\
<input type="text" class="form-control" id="answer3" placeholder="Enter answer" maxlength="30" onchange=\'checkAnswer("answer3","answer3Help")\' style="color: #4e89FDF;"/>\n\
<small id="answer3Help" class="form-text text-muted"></small>\n\
</div><button class="btn btn-block" onclick=\'next2("' + name + '","' + email + '","' + password + '","' + questions[3] + '","' + questions[4] + '","' + questions[5] + '");\' style="background-color:#489FDF; color: white;">Next</button>';
                document.getElementById("signupContent").innerHTML = content;
            }
        });


    }
}

function checkAnswer(answerId, helpTextId) {
    if (document.getElementById(answerId).value.length == 0) {
        document.getElementById(answerId).style.borderColor = "red";
        document.getElementById(helpTextId).innerHTML = "Invalid answer.";
        document.getElementById(helpTextId).style.color = "red";
        return false;
    } else if (document.getElementById(answerId).value.includes(' ')) {
        document.getElementById(answerId).style.borderColor = "red";
        document.getElementById(helpTextId).innerHTML = "Answer should be single word.";
        document.getElementById(helpTextId).style.color = "red";
        return false;
    } else {
        document.getElementById(answerId).style.borderColor = "#489FDF";
        document.getElementById(helpTextId).innerHTML = "";
        return true;
    }
}

function next2(name, email, password, question4, question5, question6) {
    if (checkAnswer('answer1', 'answer1Help') && checkAnswer('answer2', 'answer2Help') && checkAnswer('answer3', 'answer3Help')) {
        var answer1 = document.getElementById("answer1").value;
        var answer2 = document.getElementById("answer2").value;
        var answer3 = document.getElementById("answer3").value;

        var content = '<div class="form-group" style="margin-top: 30px">\n\
<lable>' + question4 + '</lable>\n\
<input type="text" class="form-control" id="answer4" placeholder="Enter answer" maxlength="30" onchange=\'checkAnswer("answer4","answer4Help")\' style="color: #4e89FDF;"/>\n\
<small id="answer4Help" class="form-text text-muted"></small>\n\
</div><div class="form-group">\n\
<lable>' + question5 + '</lable>\n\
<input type="text" class="form-control" id="answer5" placeholder="Enter answer" maxlength="30" onchange=\'checkAnswer("answer5","answer5Help")\' style="color: #4e89FDF;"/>\n\
<small id="answer5Help" class="form-text text-muted"></small>\n\
</div><div class="form-group">\n\
<lable>' + question6 + '</lable>\n\
<input type="text" class="form-control" id="answer6" placeholder="Enter answer" maxlength="30" onchange=\'checkAnswer("answer6","answer6Help")\' style="color: #4e89FDF;"/>\n\
<small id="answer6Help" class="form-text text-muted"></small>\n\
</div><button class="btn btn-block" onclick=\'next3("' + name + '","' + email + '","' + password + '","' + answer1 + '","' + answer2 + '","' + answer3 + '");\' style="background-color:#489FDF; color: white;">Submit</button>';
        document.getElementById("signupContent").innerHTML = content;

    }
}

function next3(name, email, password, answer1, answer2, answer3) {
    if (checkAnswer('answer4', 'answer4Help') && checkAnswer('answer5', 'answer5Help') && checkAnswer('answer6', 'answer6Help')) {
        var answer4 = document.getElementById("answer4").value;
        var answer5 = document.getElementById("answer5").value;
        var answer6 = document.getElementById("answer6").value;

        $.ajax({
            type: "POST",
            data: {name: name,
                email: email,
                password: password,
                answer1: answer1,
                answer2: answer2,
                answer3: answer3,
                answer4: answer4,
                answer5: answer5,
                answer6: answer6
            },
            url: "Signup",
            success: function (msg) {
                console.log(msg);
                if (msg == "success") {
                    console.log("done");
                    window.location.href = 'index.jsp';
                }
            }
        });
    }
}


