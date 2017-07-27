function generatePwd() {
    $.ajax({
        type: "POST",
        url: "GeneratePassword",
        success: function (msg) {
            document.getElementById("displayDiv").innerHTML = msg;
        }
    });
}

function addCustomQs() {
    var content = '<h3 style="color: #489FDF;">Add new Custom question</h3>\n\
<div style="margin-top: 30px; margin-bottom: 20px;"><div class="form-group">\n\
<input type="text" class="form-control" id="customQs" maxlength="150" placeholder="Enter custom question.." onchange="changeQs();" style="color: #489FDF;"/>\n\
<small id="questionHelp" class="form-text text-muted"></small></div><div class="form-group">\n\
<input type="text" class="form-control" id="customQsAns" maxlength="30" placeholder="Enter answer.." onchange="changeAns();" style="color: #489FDF;"/>\n\
<small id="answerHelp" class="form-text text-muted">Give single word answer.</small>\n\
</div><button class="btn btn-block" onclick="submitCustomQs();" style="background-color:#489FDF; color: white;">Submit</button></div>'
    document.getElementById("displayDiv").innerHTML = content;
}

function submitCustomQs() {
    var question = document.getElementById("customQs").value;
    var answer = document.getElementById("customQsAns").value;

    if (question.length == 0 || answer.length == 0 || answer.includes(' ')) {
        changeQs();
        changeAns();

    } else {
        $.ajax({
            type: "POST",
            data: {question: question,
                answer: answer
            },
            url: "AddCustomQs",
            success: function (msg) {
                document.getElementById("customQs").value = "";
                document.getElementById("customQsAns").value = "";
                //sweet alert
            }
        });
    }
}

function addHints() {
    //var hints = JSON.parse(jsonArray);
    //console.log(hint[0]);
    var jsonString = document.getElementById("jsonArray").value;
    console.log(jsonString);
    var hints = JSON.parse(jsonString);
    console.log(hints.hint+1);
}


