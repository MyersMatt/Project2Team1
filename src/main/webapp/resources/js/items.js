const API = "http://localhost:8080/Project2_war/api/items"

let addButton = document.getElementById("add-item-button");
let deleteButton = document.getElementById("delete-item-button");
let updateButton = document.getElementById("update-item-button");
let body = document.getElementById("item-manipulation-field")

async function addForm(arg){
    let response;
    switch (arg){
        case "add":
            response = await  fetch("components/addItem.html");
            break;
        case "delete":
            response = await  fetch("components/deleteItem.html");
            break;
        case "update":
            response = await  fetch("components/updateItem.html");
            break;
    }
    body.innerHTML = await response.text();
}

addButton.addEventListener("click", async (e) =>{
    const addAPI = "/add";
    console.log("Add API: " +  `${API +addAPI}`);
    body.innerHTML = "";
    await addForm("add");
    }
);



deleteButton.addEventListener("click", async (e) =>{
    const deleteAPI = "/delete"
    console.log("Delete API: " + `${API + deleteAPI}`);
    body.innerHTML = "";
    await addForm("delete");
})

updateButton.addEventListener("click", async (e) =>{
    const updateAPI = "/update"
    console.log("Update API: " + `${API + updateAPI}`);
    body.innerHTML = "";
    await addForm("update")
})