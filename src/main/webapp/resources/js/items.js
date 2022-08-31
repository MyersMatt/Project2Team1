const API = "http://localhost:8080/Project2/api/items"

let addButton = document.getElementById("add-item-button");
let deleteButton = document.getElementById("delete-item-button");
let updateButton = document.getElementById("update-item-button");
let body = document.getElementById("item-manipulation-field")
let newButton;

function convert2JSON(payload) {
    let obj = {} 
    for (let key of payload.keys()) {
        obj[key] = payload.get(key);}
    return JSON.stringify(obj);
    }

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
        const addItemForm = document.getElementById("add-item-form");
        addItemForm.addEventListener("submit", async (ev) => {
            ev.preventDefault();
            let form_info = new FormData(ev.target);
            let payload = convert2JSON(form_info);
            console.log(payload);
            const addAPI = "/add";
            var myHeaders = new Headers();
            myHeaders.append("Content-Type", "application/json");
        
            var requestOptions = {
                method: 'POST',
                headers: myHeaders,
                body: payload,
                redirect: 'follow'
            };
            console.log(requestOptions)
            let response = await fetch(`${API + addAPI}`, requestOptions)
            let data = await response.json()

        })

        // newButton = document.getElementById("submit-add-item-button");
        // newButton.addEventListener("click", async () => {
        // })
        // console.log("Add API: " + );

    }
);


deleteButton.addEventListener("click", async () => {
    body.innerHTML = "";
    await addForm("delete");
    newButton = document.getElementById("submit-delete-item-button");
    newButton.addEventListener("click", async () => {
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