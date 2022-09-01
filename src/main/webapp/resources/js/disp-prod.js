//Dynamic Display Products List

let uri = 'http://localhost:8080/Project2/api/items/getAllItems';
let req = new Request(uri, {method: 'GET'});
let container;


document.addEventListener('DOMContentLoaded', init);

function init(){
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
            // container.getElementsByClassName('buy-btn')[i].addEventListener('click'),addToCartClicked) 
            cartRow.getElementsByClassName('btn-danger')[0].addEventListener('click', removeCartItem)

        }
    })
    .catch((err)=>{
        console.log( err.message );
    })
}

