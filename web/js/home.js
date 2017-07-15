function generatePwd(email) {
    console.log(email);
    $.ajax({
        type: "POST",
        data: {user_email: email
        },
        url: "GeneratePassword",
        success: function (msg) {
            console.log(msg);
        }
    });
}

function addCustomQs(email) {
    console.log('test');
}

function submitCustomQs(email) {
    var question = document.getElementById("customQs").value;
    var answer = document.getElementById("customQsAns").value;

    if (question.length == 0 || answer.length == 0 || answer.includes(' ')) {
        changeQs();
        changeAns();
        
    }else {
        $.ajax({
        type: "POST",
        data: {question: question,
            answer: answer
        },
        url: "AddCustomQs",
        success: function (msg) {
            console.log(msg);
        }
    });
    }

}


