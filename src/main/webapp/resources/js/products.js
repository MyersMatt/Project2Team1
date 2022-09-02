//Dynamic Display Products List

let uri = 'http://localhost:8080/Project2/api/items/getAllItems';
let req = new Request(uri, {method: 'GET'});
let container;


if (document.readyState == 'loading') {
    document.addEventListener('DOMContentLoaded', ready)
} else {
    ready()
}

function ready() {  

    container = document.getElementById('prod-list');

    fetch(req)
    .then((response)=>{
        if(response.ok){
            return response.json();
        }else{
            throw new Error('BAD HTTP');
        }
    })
    .then((json)=>{
        const length = Object.keys(json).length;
            for (var i = 0; i < length; i++) {
            let art = document.createElement('article');
            art.classList.add('prod-row')
            art.setAttribute('id', json[i].itemId);
            let prod_row_contents =`            
            <img class="prod-image" src="${json[i].imageUrl}" alt="image">
            <div class="prod-text">
                <h2 class="prod-title">${json[i].itemName}</h2>
                <p class="prod-desc">${json[i].description}</p>
            </div>
            <div class="prod-numb">
                <p class="prod-price">${json[i].itemPrice}</p>
                <p class="prod-quantity"><strong>${json[i].itemQuantity}</strong><br><em>in stock</em></p>
                <button class="buy-btn">Purchase</button>
            </div>`
            art.innerHTML = prod_row_contents;
            container.append(art);
        }
        const addToCartButtons = document.getElementsByClassName('buy-btn');
        for (var i = 0; i < addToCartButtons.length; i++) {
            var button = addToCartButtons[i]
            button.addEventListener('click', addToCartClicked)
        }
    })
    .catch((err)=>{
        console.log( err.message );
    })

    let removeCartItemButtons = document.getElementsByClassName('btn-danger');
    for (var i = 0; i < removeCartItemButtons.length; i++) {
        button = removeCartItemButtons[i];
        button.addEventListener('click', removeCartItem)
    }

    var quantityInputs = document.getElementsByClassName('cart-quantity-input')
    for (var i = 0; i < quantityInputs.length; i++) {
        var input = quantityInputs[i]
        input.addEventListener('change', quantityChanged)
    }

}


function removeCartItem(event) {
    let buttonClicked = event.target
    buttonClicked.parentElement.parentElement.remove()
    updateCartTotal()
}


function quantityChanged(event) {
    var input = event.target
    if (isNaN(input.value) || input.value <= 0) {
        input.value = 1
    }
    updateCartTotal()
}


function addToCartClicked(event) {
    console.log('button clicked')
    var button = event.target       //target button is buy-btn
    var shopItem = button.parentElement.parentElement       //parent's parent = article with class prod-row
    var title = shopItem.getElementsByClassName('prod-title')[0].innerText
    var price = shopItem.getElementsByClassName('prod-price')[0].innerText
    var imageSrc = shopItem.getElementsByClassName('prod-image')[0].src
    addItemToCart(title, price, imageSrc)
    updateCartTotal()
}


function addItemToCart(title, price, imageSrc) {
    var cartRow = document.createElement('div')
    cartRow.classList.add('cart-row')
    var cartItems = document.getElementsByClassName('cart-items')[0]
    var cartItemNames = cartItems.getElementsByClassName('cart-item-title')
    for (var i = 0; i < cartItemNames.length; i++) {
        if (cartItemNames[i].innerText == title) {
            alert(`The ${title} has already been added to your lab cart`)
            return
        }
    }
    var cartRowContents = `
    <div class="cart-item cart-column">
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
    var cartItemContainer = document.getElementsByClassName('cart-items')[0]
    var cartRows = cartItemContainer.getElementsByClassName('cart-row')
    var total = 0
    for (var i = 0; i < cartRows.length; i++) {
        var cartRow = cartRows[i]
        var priceElement = cartRow.getElementsByClassName('cart-price')[0]
        var quantityElement = cartRow.getElementsByClassName('cart-quantity-input')[0]
        var price = parseFloat(priceElement.innerText.replace('$', ''))
        var quantity = quantityElement.value
        total = total + (price * quantity)
    }
    total = Math.round(total * 100) / 100
    document.getElementsByClassName('cart-total-price')[0].innerText = '$' + total
}


function purchaseClicked() {

    //is user registered or a guest:  check

        //if registered, create order history


        //if not, do something else (or not)


    //need to update item quantity in item


    //alerting about the purchase
    alert("Thank you for your purchase")

    var cartItems = document.getElementsByClassName('cart-items')[0]

    //removing the items 
    while (cartItems.hasChildNodes()) {
        cartItems.removeChild(cartItems.firstChild)
    }
    updateCartTotal()   //makes total zero
}
