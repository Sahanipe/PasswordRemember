function changeAns() {
    var answer = document.getElementById("customQsAns").value;

    if (answer.length == 0) {

        document.getElementById("answerHelp").innerHTML = "Answer can not be empty.";
        document.getElementById("answerHelp").style.color = "red";
        document.getElementById("customQsAns").style.borderColor = "red";

    } else if (answer.includes(' ')) {

        document.getElementById("answerHelp").innerHTML = "Answer should be single word.";
        document.getElementById("answerHelp").style.color = "red";
        document.getElementById("customQsAns").style.borderColor = "red";

    } else {
        
        document.getElementById("answerHelp").innerHTML = "";
        document.getElementById("customQsAns").style.borderColor = "#489FDF";
    }
}

function changeQs(){
    var question = document.getElementById("customQs").value;
    
    if (question.length == 0) {

        document.getElementById("questionHelp").innerHTML = "Question can not be empty.";
        document.getElementById("questionHelp").style.color = "red";
        document.getElementById("customQs").style.borderColor = "red";

    }
    else{
        
        document.getElementById("questionHelp").innerHTML = "";
        document.getElementById("customQs").style.borderColor = "#489FDF";
        
    }
}