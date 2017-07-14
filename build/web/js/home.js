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

function addCustomQs() {
    console.log('test');
}


