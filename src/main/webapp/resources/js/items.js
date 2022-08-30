const API = "http://localhost:8080/Project2_war/api/items"



let addButton = document.getElementById("add-item-button");
let deleteButton = document.getElementById("delete-item-button");
let updateButton = document.getElementById("update-item-button");
let body = document.getElementById("item-manipulation-field")
addButton.addEventListener("click", async (e) =>{
    const addAPI = "/add";
    console.log("Add API: " +  `${API +addAPI}`);
    await addForm();
    // await fetch(`${API + addAPI}`,
    //     {
    //         method: "POST",
    //         body: JSON.stringify(data)
    //     }).then(res =>{
    //         console.log("Request complete! response: ",res)
    // })
    }
);

async function addForm(){
    const response = await  fetch("components/addItem.html");
    const html = await response.text();
    body.innerHTML = html;
}

deleteButton.addEventListener("click", async (e) =>{
    const deleteAPI = "/delete"
    console.log("Delete API: " + `${API + deleteAPI}`);
})

updateButton.addEventListener("click", async (e) =>{
    const updateAPI = "/update"
    console.log("Update API: " + `${API + updateAPI}`);
})