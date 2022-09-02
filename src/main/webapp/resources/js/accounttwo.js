let update = document.getElementById("updatebtn").addEventListener('click', getData)
let username = document.getElementById("username")
let password = document.getElementById("password")
let email = document.getElementById("email")
let labName = document.getElementById("labName")
let contactName = document.getElementById("contactName")
let shippingAddress = document.getElementById("shippingAddress")
let paymentInfo = document.getElementById("paymentInfo")

let userInformation;

document.onload = async function getUserInfo() {
localStorage.setItem('user_id',1)	
let req = await fetch("http://localhost:8080/Project2/api/user/getUserById/",localStorage.getItem("user_id"))
userInformation = await req.json()
username.value = userInformation.get('username')
password.value = userInformation.get('password')
email.value = userInformation.get('email')
labName.value = userInformation.get('labName')
contactName.value = userInformation.get('contactName')
shippingAddress.value = userInformation.get('shippingAddress')
paymentInfo.value = userInformation.get('paymentInfo')

	
}
async function getData(e){
    //Prevent the submitted info to influence the URL
    e.preventDefault();
    //When login is clicked, give us the password and username values


    let passwordRepeat = document.getElementById("psw-repeat").value

    if (password == passwordRepeat){

    updateReqObj = {
        id,
        username,
        password,
        email,
        labName,
        contactName,
        shippingAddress,
        paymentInfo

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