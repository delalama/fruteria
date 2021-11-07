class Product {
    constructor(name, price, quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    toJson() {
        return {
             name: this.name,
             price: this.price,
             quantity: this.quantity
        }
    }
}

var products = [];

// i would like to send across ajax to validate product, but no time
function addProduct() {
    var name = document.getElementById('pName').value;
    var price = document.getElementById('pPrice').value;
    var quantity = document.getElementById('pQuantity').value;

    var validNames = ['APPLE', 'ORANGE', 'PEAR'];

    var valid = true;
    var message = [];

    // validate product
    if(!validNames.includes(name)) {
        message.push("error, solo vendemos: " + validNames);
        valid = false;
    }
    if(isNaN(price) || price == ""){
        message.push("error, precio incorrecto ");
        valid = false;
    }
    if(isNaN(quantity) || quantity == ""){
        message.push("error, cantidad incorrecta");
        valid = false;
    }

    if(valid){
        var p = new Product(name, price, quantity);
        products.push(p);

        cleanProductFields();
        console.log(products);
    } else{
            $("#errorMessage").text(message);
    }
}

function cleanProductFields() {
    document.getElementById('pName').value =  "";
    document.getElementById('pPrice').value =  "";
    document.getElementById('pQuantity').value =  "";
}

function getFactura() {
    if(products.length == 0) {
         $("#totalBill").text("NO HA AÑADIDO PRODUCTOS" );
    }else{
    {
    $.ajax({
      url: '/factura/total',
      type: 'POST',
      contentType: 'application/json; charset=utf-8',
      cache: false,
      data: JSON.stringify(
            products.map(product => {
                return product.toJson();
            })),
      success: function (result) {
           $("#totalBill").text(result);
           products = [];
       },
       error: function (e) {
           console.log("Nombre incorrecto");
           $("#totalBill").text("error, nombre de algún producto incorrecto" );
       }
    });
    }
    }
}


