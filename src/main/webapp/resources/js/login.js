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

async function makeReq (ev) {
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

let response = await fetch("http://localhost:8080/Project2/api/authentication/register", requestOptions)
    let data = await response.json()
        const email = data.email
        const firstName = data.firstName;
        const lastName = data.lastName;
        const password = data.password;
        const paymentInfo = data.paymentinfo;
        const shippingAddress = data.shippingAddress;
        const username = data.username;
        const userID = data.userID

    document.getElementById('createAccount').reset();
}

// 
    // let testData = response.JSON
    // console.log("The result of the JSON ping: " + result);
// 
// http://localhost:8080/Project2/api/authentication/register
function convert2JSON(god) {
    let obj = {}
    for (let key of god.keys()) {
        obj[key] = god.get(key);
    }
    return JSON.stringify(obj);
}


document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.querySelector("#login");
    const createAccountForm = document.querySelector("#createAccount");

    document.querySelector("#linkCreateAccount").addEventListener("click", e => {
        e.preventDefault();
        loginForm.classList.add("form--hidden");
        createAccountForm.classList.remove("form--hidden");
    });

    document.querySelector("#linkLogin").addEventListener("click", e => {
        e.preventDefault();
        loginForm.classList.remove("form--hidden");
        createAccountForm.classList.add("form--hidden");
    });

    loginForm.addEventListener("submit", e => {
        e.preventDefault();

        // Perform your AJAX/Fetch login

        setFormMessage(loginForm, "error", "Invalid username/password combination");
    });

    createAccountForm.addEventListener("submit", makeReq);

    document.querySelectorAll(".form__input").forEach(inputElement => {
        inputElement.addEventListener("blur", e => {
            if (e.target.id === "signupUsername" && e.target.value.length > 0 && e.target.value.length < 8) {
                setInputError(inputElement, "Username must be at least 8 characters in length");
            }
        });

        inputElement.addEventListener("input", e => {
            clearInputError(inputElement);
        });
    });
});