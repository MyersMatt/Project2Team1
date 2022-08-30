const API = "http://localhost:8080/Project2/api/items"

let addButton = document.getElementById("add-item-button");
let deleteButton = document.getElementById("delete-item-button");
let updateButton = document.getElementById("update-item-button");
let body = document.getElementById("item-manipulation-field")
let newButton;

async function addForm(arg) {
    let response;
    switch (arg) {
        case "add":
            response = await fetch("components/addItem.html");
            break;
        case "delete":
            response = await fetch("components/deleteItem.html");
            break;
        case "update":
            response = await fetch("components/updateItem.html");
            break;
    }
    body.innerHTML = await response.text();
}

addButton.addEventListener("click", async () => {
        body.innerHTML = "";
        await addForm("add");
        newButton = document.getElementById("submit-add-item-button");
        newButton.addEventListener("click", async () => {
            const addAPI = "/add";
            console.log("Add API: " + `${API + addAPI}`);
        })
    }
);


deleteButton.addEventListener("click", async () => {
    body.innerHTML = "";
    await addForm("delete");
    newButton = document.getElementById("submit-delete-item-button");
    newButton.addEventListener("click", async() => {
        const deleteAPI = "/delete"
        console.log("Delete API: " + `${API + deleteAPI}`);
    })
})

updateButton.addEventListener("click", async () => {
    const updateAPI = "/update"
    console.log("Update API: " + `${API + updateAPI}`);
    body.innerHTML = "";
    await addForm("update")
})