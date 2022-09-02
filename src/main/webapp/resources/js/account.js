let register = document.getElementById("registerbtn").addEventListener('click', getData)

async function getData(e){
    //Prevent the submitted info to influence the URL
    e.preventDefault();
    //When login is clicked, give us the password and username values
    let id = document.getElementById("id").value
    let username = document.getElementById("username").value
    let password = document.getElementById("password").value
    let email = document.getElementById("email").value
    let labName = document.getElementById("labName").value
    let contactName = document.getElementById("contactName").value

    let passwordRepeat = document.getElementById("psw-repeat").value

    if (password == passwordRepeat){

    registerReqObj = {
        id,
        username,
        password,
        email,
        labName,
        contactName

    }

    console.log(registerReqObj)
	
	try{
		//If the request is successful, send the data to the dispatcher
		let req = await fetch("http://localhost:8080/Project2/api/user/updateUser/", {
			method: 'PATCH',
			headers: {'Content-type': 'application/json'},
			body: JSON.stringify(registerReqObj)
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
    