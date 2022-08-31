function setFormMessage(formElement, type, message) {
    const messageElement = formElement.querySelector(".form__message");

    messageElement.textContent = message;
    messageElement.classList.remove("form__message--success", "form__message--error");
    messageElement.classList.add(`form__message--${type}`);
}

function setInputError(inputElement, message) {
    inputElement.classList.add("form__input--error");
    inputElement.parentElement.querySelector(".form__input-error-message").textContent = message;
}

function clearInputError(inputElement) {
    inputElement.classList.remove("form__input--error");
    inputElement.parentElement.querySelector(".form__input-error-message").textContent = "";
}
async function handleForm(ev) {
    ev.preventDefault();
    let rForm = ev.target;
    let regis_data = new FormData(rForm);
    let raw = await convert2JSON(regis_data);

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
    };

fetch("http://localhost:8080/Project2/api/update/updateUser", requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
    .catch(error => console.log('error', error));
}

function convert2JSON(god) {
    let obj = {} 
    for (let key of god.keys()) {
        obj[key] = god.get(key);
    }
    return JSON.stringify(obj);
}

document.addEventListener("DOMContentLoaded", () => {
    const updateForm = document.querySelector("#UpdateUser");

    document.querySelector("#linkUpdateUser").addEventListener("click", e => {
        e.preventDefault();
        updateForm.classList.add("form--hidden");
        createAccountForm.classList.remove("form--hidden");
    });

    updateForm.addEventListener("submit", e => {
        e.preventDefault();

        // Perform your AJAX/Fetch login

        setFormMessage(updateForm, "error", "Invalid username/password combination");
    });

    document.querySelectorAll(".form__input").forEach(inputElement => {
        inputElement.addEventListener("blur", e => {
            if (e.target.id === "updateUsername" && e.target.value.length > 0 && e.target.value.length < 8) {
                setInputError(inputElement, "Username must be at least 8 characters in length");
            }
        });

        inputElement.addEventListener("input", e => {
            clearInputError(inputElement);
        });
    });
});