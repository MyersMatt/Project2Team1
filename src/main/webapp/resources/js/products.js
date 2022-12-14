//Dynamic Display Products List

let url = "http://localhost:8080/Project2/api/items";
let itemsPurchased = {}
let userId

window.onload = async function init(){

    userId = localStorage.getItem('user_id')

    if(userId != null){
        document.getElementById("account-inactive").id = "account-active";
        document.getElementById("sign-out-inactive").id="sign-out-active";
        document.getElementById("login-active").id = "login-inactive"
    }
    let req = new Request(url+"/getAllItems", {method: 'GET'});
    let container = document.getElementById("prod-list");
    await fetch(req).then((response) =>{
        if(response.ok) return response.json();
        else throw new Error();
    }).then((json)=>{
        const length = Object.keys(json).length;
        for(let i = 0; i < length; ++i){
            let art = document.createElement("article");
            art.classList.add("prod-row");
            art.setAttribute("id", json[i].itemId);
            art.innerHTML = `
                <img class="prod-image" src="${json[i].imageUrl}" alt="image">
                <div class="prod-text">
                    <h2 class="prod-title">${json[i].itemName}</h2>
                    <p class="prod-desc">${json[i].description}</p>
                </div>
                <div class="prod-numb">
                    <p class="prod-price">$${json[i].itemPrice}</p>
                    <p class="prod-quantity"><strong>${json[i].itemQuantity}</strong><br><em>in stock</em></p>
                    <button class="buy-btn">Purchase</button>
                </div>`;
            container.append(art)
            const addToCartButtons = document.getElementsByClassName('buy-btn');
            for (let i = 0; i < addToCartButtons.length; i++) {
            let button = addToCartButtons[i]
            button.addEventListener('click', addToCartClicked)
            }
        }
    }).catch((error)=>{
        console.log(error)
        }
    )
    let removeCartItemButtons = document.getElementsByClassName('btn-danger');
    for (let i = 0; i < removeCartItemButtons.length; i++) {
        let button = removeCartItemButtons[i];
        button.addEventListener('click', removeCartItem)
    }

    let quantityInputs = document.getElementsByClassName('cart-quantity-input')
    for (let i = 0; i < quantityInputs.length; i++) {
        let input = quantityInputs[i]
        input.addEventListener('change', quantityChanged)
    }
}

let signout = () =>{
    localStorage.clear()
    // location.reload()
}
function removeCartItem(event) {
    let buttonClicked = event.target
    buttonClicked.parentElement.parentElement.remove()
    updateCartTotal()
}


function quantityChanged(event) {
    let input = event.target
    // let pRow = input.parentElement.parentElement.
    if (isNaN(input.value) || input.value <= 0) {
        input.value = 1
    }
    updateCartTotal()
}


function addToCartClicked(event) {
    // console.log('button clicked')
    let button = event.target       //target button is buy-btn
    let shopItem = button.parentElement.parentElement       //parent's parent = article with class prod-row
    let pid = shopItem.getAttribute('id');
    let title = shopItem.getElementsByClassName('prod-title')[0].innerText
    let price = shopItem.getElementsByClassName('prod-price')[0].innerText
    let imageSrc = shopItem.getElementsByClassName('prod-image')[0].src
    addItemToCart(pid, title, price, imageSrc)       //take the prod-item, send to cart, make it a cart-item
    updateCartTotal()
}


function addItemToCart(pid, title, price, imageSrc) {        //receives prod-item and makes it a cart-item
    let cartRow = document.createElement('div')
    cartRow.classList.add('cart-row')
    let cartItems = document.getElementsByClassName('cart-items')[0]
    let cartItemNames = cartItems.getElementsByClassName('cart-item-title')
    for (let i = 0; i < cartItemNames.length; i++) {
        if (cartItemNames[i].innerText == title) {
            alert(`The ${title} has already been added to your lab cart`)
            return
        }
    }
    let cartRowContents = `
    <div class="cart-item cart-column bought-item" id="${pid}">
        <img class="cart-item-image" src="${imageSrc}" width="100" height="100">
        <span class="cart-item-title">${title}</span>
    </div>
    <span class="cart-price cart-column">${price}</span>
    <div class="cart-quantity cart-column">
        <input class="cart-quantity-input" type="number" value="1">
        <button class="btn btn-danger" type="button">REMOVE</button>
    </div>`
    cartRow.innerHTML = cartRowContents
    cartItems.append(cartRow)
    cartRow.getElementsByClassName('btn-danger')[0].addEventListener('click', removeCartItem)
    cartRow.getElementsByClassName('cart-quantity-input')[0].addEventListener('change', quantityChanged)

}



function updateCartTotal() {
    let cartItemContainer = document.getElementsByClassName('cart-items')[0]
    let cartRows = cartItemContainer.getElementsByClassName('cart-row')
    let total = 0
    for (let i = 0; i < cartRows.length; i++) {
        let cartRow = cartRows[i]
        let priceElement = cartRow.getElementsByClassName('cart-price')[0]
        let quantityElement = cartRow.getElementsByClassName('cart-quantity-input')[0]
        let price = parseFloat(priceElement.innerText.replace('$', ''))
        let quantity = quantityElement.value
        total = total + (price * quantity)
    }
    total = Math.round(total * 100) / 100
    document.getElementsByClassName('cart-total-price')[0].innerText = '$' + total
}

let purchase = async (e) =>{
    e.preventDefault();
    let ccname = document.getElementById("ccname").value;
    let ccnum = document.getElementById("ccnum").value;
    let expmonth = document.getElementById("expmonth").value;
    let expyear = document.getElementById("expyear").value;
    let shipaddr = document.getElementById("shipaddr").value;
    let message = document.getElementById("error-message")
    console.log(ccname)
    console.log(ccnum)
    console.log(expmonth)
    console.log(expyear)
    console.log(shipaddr)
    if(ccname.length === 0
        || ccnum.length === 0
        || expmonth.length === 0
        || expyear.length === 0
        || shipaddr.length === 0
    ){

        message.innerText = "Payment Info Error, Please fill out all appropriate fields"
        message.style.color = '#FF0000'
    }else{
        message.innerText = ""
    let boughtItem = document.getElementsByClassName("bought-item")
    let boughtItemQty = document.getElementsByClassName("cart-quantity-input")
    for (let i = 0; i<boughtItem.length; ++i) itemsPurchased[boughtItem[i].getAttribute('id')] = boughtItemQty[i].value
    let myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    if(userId!=null){
        itemsPurchased["userId"] = userId;
    }
    let raw = JSON.stringify(itemsPurchased);
    console.log(raw)
    let requestOptions = {
        method: "PATCH",
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    await fetch(url+"/updateBoughtItems", requestOptions)
        .then( () => console.log("Successfully purchased items"))
        .catch(error => console.log('error', error));


    //////// original content ///////////
    let cartItems = document.getElementsByClassName('cart-items')[0]
    //removing the items
    while (cartItems.hasChildNodes()) {
        cartItems.removeChild(cartItems.firstChild)
    }

    if(userId === null){
        document.getElementById("ccname").value = '';
        document.getElementById("ccnum").value = '';
        document.getElementById("expmonth").value = '';
        document.getElementById("expyear").value = '';
        document.getElementById("shipaddr").value = '';
    }
    alert(`Thank you for your purchase of items`)
    updateCartTotal()
    }
}
