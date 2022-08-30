<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../resources/css/master.css">
    <title>Sequoia Scientific</title>
    <div class="nav">
        <th><a href="home.html">Home</a></th>
        <th><a href="products.html">Products</a></th>
        <th><a href="account.html">Account</a></th>
        <th><a href="login">Login</a></th>
    </div>
</head>


<body>
<header>
    <h1> Welcome to Sequoia Scientific</h1>
</header>
<main class="grid-container">
    <article class="featured">
        <img src="../resources/images/distillation.png" alt="featured img">
        <div class="container">
            <form class="form" id="login">
                <h1 class="form__title">Login</h1>
                <div class="form__message form__message--error"></div>
                <div class="form__input-group">
                    <input type="text" class="form__input" autofocus placeholder="Username">
                    <div class="form__input-error-message"></div>
                </div>
                <div class="form__input-group">
                    <input type="password" class="form__input" autofocus placeholder="Password">
                    <div class="form__input-error-message"></div>
                </div>
                <button class="form__button" type="submit">Continue</button>
                <p class="form__text">
                    <a href="#" class="form__link">Forgot your password?</a>
                </p>
                <p class="form__text">
                    <a class="form__link" href="../resources/html" id="linkCreateAccount">Don't have an account?
                        Register here.</a>
                </p>
            </form>
            <form class="form form--hidden" id="createAccount">
                <h1 class="form__title">Register Account</h1>
                <div class="form__message form__message--error"></div>
                <div class="form__input-group">
                    <input
                            type="text"
                            id="signupUsername"
                            name="username"
                            class="form__input"
                            autofocus
                            placeholder="username">
                    <div class="form__input-error-message"></div>
                </div>
                <div class="form__input-group">
                    <input
                            type="text"
                            id="signupFirstname"
                            name="firstName"
                            class="form__input"
                            autofocus
                            placeholder="first name">
                    <div class="form__input-error-message"></div>
                </div>
                <div class="form__input-group">
                    <input
                            type="text"
                            id="signupLastname"
                            name="lastName"
                            class="form__input"
                            autofocus
                            placeholder="last name">
                    <div class="form__input-error-message"></div>
                </div>
                <div class="form__input-group">
                    <input
                            type="text"
                            id="signupEmail"
                            name="email"
                            class="form__input"
                            autofocus
                            placeholder="email address">
                    <div class="form__input-error-message"></div>
                </div>
                <div class="form__input-group">
                    <input
                            type="password"
                            id="signupPassword"
                            name="password"
                            class="form__input"
                            autofocus
                            placeholder="password">
                    <div class="form__input-error-message"></div>
                </div>
                <div class="form__input-group">
                    <input
                            type="password"
                            id="signupPassword_confirm"
                            name="password_confirm"
                            class="form__input"
                            autofocus
                            placeholder="confirm password">
                    <div class="form__input-error-message"></div>
                </div>
                <button class="form__button" type="submit">Continue</button>
                <p class="form__text">
                    <a class="form__link" href="../resources/html" id="linkLogin">Already have an account? Sign in.</a>
                </p>
            </form>
        </div>
    </article>
    <article>
        <img src="../resources/images/test-tubes.jpg" alt="featured img">
        <div>
            <h3> We are special</h3>
            <p> Lorem ipsum dolor sit amet consectetur adipisicing elit. Perferendis, amet?</p>
        </div>
    </article>
    <article>
        <img src="../resources/images/lab_equip.png" alt="featured img">
        <div>
            <h3> We are special</h3>
            <p> Lorem ipsum dolor sit amet consectetur adipisicing elit. Perferendis, amet?</p>
        </div>
    </article>
    <article>
        <img src="../resources/images/Album%203.png" alt="featured img">
        <div>
            <h3> We are special</h3>
            <p> Lorem ipsum dolor sit amet consectetur adipisicing elit. Perferendis, amet?</p>
        </div>
    </article>
</main>
<script src="../resources/js/login.js"></script>
</body>
</html>