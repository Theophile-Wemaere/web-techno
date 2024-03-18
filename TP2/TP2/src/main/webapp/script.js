function validateForm() {
    const firstName = document.getElementById("firstName").value;
    const lastName = document.getElementById("lastName").value;
    const birthDate = document.getElementById("birthDate").value;
    const male = document.getElementById("male").checked;
    const female = document.getElementById("female").checked;

    var sex;
    if(male)
        sex = "male";
    else if(female)
        sex = "female";

    if(firstName != ""
        && lastName != ""
        && birthDate != ""
        && (male != false || female != false)){
        alert("Your data :\n\n" +
            `firstName : ${firstName}\n` +
            `lastName : ${lastName}\n` +
            `birthDay : ${birthDate}\n` +
            `Sex : ${sex}\n`)
    } else {
        message = "Please fill all theses values : \n\n";
        if(firstName == "")
            message += "first name\n";
        if(lastName == "")
            message += "last name\n";
        if(birthDate == "")
            message += "birth date\n";
        if(male == "" && female == "")
            message += "your sex\n"
        alert(message);
    }
}

function changeFM(sex) {
    const header = document.getElementById("header");

    if(sex == "female") {
        header.textContent = "Hello Madam"
    }
    else if(sex == "male") {
        header.textContent = "Hello Sir"
    }

    let inputs = document.getElementsByTagName('input');
    let legends = document.getElementsByTagName('legend');
    let fieldsets = document.getElementsByTagName('fieldset');

    var color;

    if(sex == "female")
        color = "blue";
    else if (sex == "male")
        color = "red";

    for (let i = 0; i < inputs.length; i++) {
        inputs[i].style.color = color;
        inputs[i].style.borderColor = color;
    }
    for (let i = 0; i < fieldsets.length; i++) {
        fieldsets[i].style.color = color;
        fieldsets[i].style.borderColor = color;
    }
    for (let i = 0; i < legends.length; i++) {
        legends[i].style.color = color;
    }
}