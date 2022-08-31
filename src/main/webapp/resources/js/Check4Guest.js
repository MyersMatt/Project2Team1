
document.addEventListener("DOMContentLoaded", () => {
    const hasAccount = document.querySelector("#hasAccount");

    // browser.cookies.onChanged.addListener(listener)


    document.querySelector("#linkCreateAccount").addEventListener("click", e => {
        e.preventDefault();
        loginForm.classList.add("form--hidden");
        createAccountForm.classList.remove("form--hidden");
    });
})