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

async function doTheFetch (form_info, _api) {

    let raw = convert2JSON(form_info);
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    let response = await fetch("http://localhost:8080/Project2/api/authentication/"+_api, requestOptions)
    let data = await response.json()
	 console.log(response.status)
    if (response.status == 200) {
        //setFormMessage(loginForm, "error", "Invalid username/password combination");
      //setFormMessage(loginForm, "sucess", "Login was Sucessful");
      localStorage.setItem('user_id', data.id)
      window.location.replace('products.html')
      window.location.reload() 
      

    }
}

function convert2JSON(payload) {
    let obj = {} 
    for (let key of payload.keys()) {
        obj[key] = payload.get(key);}
    return JSON.stringify(obj);
}


document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.querySelector("#login");
    const createAccountForm = document.querySelector("#createAccount");
    // const eRGEX = [A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4};

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

    createAccountForm.addEventListener("submit", ev => {
        ev.preventDefault();
        let form_info = new FormData(ev.target);
        doTheFetch(form_info, 'register');
        // window.location.href="products.html";

        createAccountForm.reset();

    });

    loginForm.addEventListener("submit", ev => {
        ev.preventDefault();
        let form_info = new FormData(ev.target);
        doTheFetch(form_info, 'login');
        window.location.href="products.html";

//      setFormMessage(loginForm, "error", "Invalid username/password combination");
        // console.log(`Yep... back where we started with ${firstName}`);
        loginForm.reset();
        
    });

    document.querySelectorAll(".form__input").forEach(inputElement => {
        inputElement.addEventListener("blur", e => {
            if (e.target.id === "signupPassword" && e.target.value.length > 0 && e.target.value.length < 8) {
                setInputError(inputElement, "Password must be at least 8 characters in length");
            }
            if (e.target.id === "signupUsername" && e.target.value.length > 0 && e.target.value.length < 8) {
                setInputError(inputElement, "Username must be at least 8 characters in length");
            }
            if (e.target.id === "signupEmail" && e.target.value.length > 0 && e.target.value.length < 1) {
                setInputError(inputElement, "Email must be filled out.");
            }
            // if (e.target.id === "signupEmail" && e.target.value.length > 0 && eRGEX.test(e.target.value)) {   //Regex:   [A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}
            //     setInputError(inputElement, "Invalid email address");
            // }
            // if (e.target.id === "signupFirstname" && e.target.value.length > 0 && e.target.value.length < 1) {
            //     setInputError(inputElement, "First name must be filled out.");
            // }
            // if (e.target.id === "signupLastname" && e.target.value.length > 0 && e.target.value.length < 1) {
            //     setInputError(inputElement, "Last name must be filled out.");
            // }
            
        });

        inputElement.addEventListener("input", e => {
            clearInputError(inputElement);
        });
    });
})