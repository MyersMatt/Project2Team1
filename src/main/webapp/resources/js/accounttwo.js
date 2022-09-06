let update = document.getElementById("updatebtn").addEventListener('click', getData)
let username = document.getElementById("username")
let password = document.getElementById("password")
let email = document.getElementById("email")
let labName = document.getElementById("labName")
let contactName = document.getElementById("contactName")
let shippingAddress = document.getElementById("shippingAddress")
let paymentInfo = document.getElementById("paymentInfo")

let userInformation;

window.onload = async function getUserInfo() {
    localStorage.setItem('user_id',1)
    let myHeaders = new Headers()
    myHeaders.append("Content-Type", "application/json")
    let raw = JSON.stringify(localStorage.getItem('user_id'))
    let requestOptions = {

        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    }
    let req = await fetch("http://localhost:8080/Project2/api/user/getUserById/", requestOptions)
    userInformation = await req.json()
    console.log(userInformation)
    username.value = userInformation.username
    password.value = userInformation.password
    email.value = userInformation.email
    labName.value = userInformation.labName
    contactName.value = userInformation.contactName
    if(userInformation.shippingAddress == null){
        shippingAddress.value = "123 Example Street"
    }else{
        shippingAddress.value = userInformation.shippingAddress
    }

    if(userInformation.paymentInfo == null){
        paymentInfo.value = "1111-1111-1111"
    }else{
        paymentInfo.value = userInformation.paymentInfo
    }

}
async function getData(e){
    //Prevent the submitted info to influence the URL
    e.preventDefault();
    //When login is clicked, give us the password and username values


    let passwordRepeat = document.getElementById("psw-repeat").value

    if (password.value == passwordRepeat){

        updateReqObj = {
            id : localStorage.getItem('user_id'),
            username: username.value,
            password: password.value,
            email: email.value,
            labName: labName.value,
            contactName: contactName.value,
            shippingAddress: shippingAddress.value,
            paymentInfo: paymentInfo.value

        }

        console.log(updateReqObj)

        try{
            //If the request is successful, send the data to the dispatcher
            let req = await fetch("http://localhost:8080/Project2/api/user/updateUser/", {
                method: 'PATCH',
                headers: {'Content-type': 'application/json'},
                body: JSON.stringify(updateReqObj)
            });

            let res = await req.json();

            console.log("Patch was successful");
            console.log(res);
            //window.location.href = "./login.html";

        } catch(e){
            //errorMessage.innerText = "invalid information was received, please try again";
            console.log("A user has failed to update to the system");
        }
    }
    else {
        console.log("Password did not match.")
    }
}