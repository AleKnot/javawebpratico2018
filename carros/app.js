
// CRIA OBJETOS PARA A LISTAGEM
var corvette = {
  brand: "Chevrolet",
  model: "Corvette",
  purchaseDate: "2008/05/15",
  price: 180000,
  picture:"http://universoretro.com.br/wp-content/uploads/2016/05/chevrolet-corvette.jpg"
};

var cadillac  = {
  brand: "Cadillac",
  model: "Cadillac",
  purchaseDate: "2008/05/15",
  price: 160000,
  picture:"http://universoretro.com.br/wp-content/uploads/2016/05/cadillac.jpg"
};

var impala = {
  brand: "Chevrolet",
  model: "Corvette",
  purchaseDate: "2008/05/15",
  price: 200000,
  picture:"http://universoretro.com.br/wp-content/uploads/2016/05/chevrolet-impala.jpg"
};

// BUSCA ELEMENTOS DA VIEW
var tbody = document.getElementById("tbodyCars");
var btnSave = document.getElementById("btnSave");
var btnReset = document.getElementById("btnReset");
var txfBrand = document.getElementById("txfBrand");
var txfModel = document.getElementById("txfModel");
var txfPurchaseDate = document.getElementById("txfPurchaseDate");
var txfPrice = document.getElementById("txfPrice");
var txfPrice = document.getElementById("txfPicture");


// CRIA UM ARRAY VAZIO
var cars = [];

// FUNÇÃO DE INICIALIZAÇÃO DA PÁGINA
function init() {

    localStorage.removeItem("cars");
    addEventListeners();

    loadCars();
    console.log(cars)
}

// LISTENER DE EVENTO PARA A AÇÃO CLICK DO BOTÃO SAVLAR
var addEventListeners = () => {
  btnSave.addEventListener("click", getAndSaveCar);

}

// FUNÇÃO PARA CARREGAR FILMES
var loadCars = () => {
  tbody.innerHTML = "";
  cars = localStorage.getItem("cars");

  // DEBUGGER DO BROWSER
  //debugger;
  cars = [corvette, cadillac, impala];
  //SE O LOCAL STORAGE ACHOU VAI MANTER O DO LOCAL, SE NÃO VAI PEGAR DO ARRAY MARVEL
  cars = cars? cars: t;
  cars.forEach((m, i) => addCarToTable(m,i));
}




// VARIÁVEL ADICIONAR FILME E FUNÇÃO QUE RECEBE UM FILME - UTILIZADO PARA EXIBIER UMA LINHA NA TABELA
var addCarToTable = function(car, index) {
  if (!car) return;
  var row =
          "<tr>" +
            "<td>"+car.brand+"</td>"+
            "<td>"+car.model+"</td>"+
            "<td>"+car.purchaseDate+"</td>"+
            "<td>"+car.price+"</td>"+
            "<td><img src=\""+car.picture+"\" width=\"30px\"></td>"+
            "<td>" +
            "  <input type=\"button\" value=\"apagar\" onclick=\"removeCar("+index+")\"/>" +
            "  <input type=\"button\" value=\"editar\" onclick=\"editCar("+index+")\"/>" +
            "</td>" +
          "</tr>";
  tbody.innerHTML += row;
}


// VARIAVEL BUSCA E SALVA O FILME - UTILIZADA PARA LER A VIEW E SALVAR O CONTEUDO
var getAndSaveCar = function(e) {
  //evita o evento padrão de recarregar a página
  if (e) e.preventDefault();

  var brand = txfBrand.value;
  var model = txfModel.value;
  var purchaseDate = txfPurchaseDate.value;
  var price = txfPrice.value;
  var picture = txfPicture.value;
  var id = txfId.value;



  //CHAMA A FUNÇÃO PARA SALVAR O OBJETO
  //saveCar(car);
  var isNew = id == "-1";
  id = isNew? cars.length: id;

  //CRIA UM OBJETO A PARTIR DA VIEW - JSON
  var car = {brand: brand, model : model, purchaseDate: purchaseDate, "price": price, "picture": picture};

  if (isNew){
  console.log(car)
  console.log(isNew)  
    cars.push(car);
  } else {
    cars[id] = car;
  }
  localStorage.setItem("cars", JSON.stringify(cars));
  loadCars();
}

//FUNÇÃO PARA SALVAR O OBJETO
var saveCar = function (car) {
    addCarToTable(car);
    cars.push(car);
    localStorage.setItem("cars", JSON.stringify(cars));
}

var removeCar = (index) => {
    console.log(cars)
    console.log(index)
    console.log("removendo carro "+cars[index].brand);
    delete cars[index];
    localStorage.setItem("cars", JSON.stringify(cars));
    loadCars();
};

var editCar = (index) => {

    //console.log("editando carro "+cars[index].brand);
    var car = cars[index];
    txfBrand.value = car.brand;
    txfModel.value = car.model;
    txfPurchaseDate.value = car.purchaseDate;
    txfPrice.value = car.price;
    txfPicture.value = car.picture;
    txfId.value = index;
};


//COMANDO QUE É EXECUTADO AO INICIAR A PÁGINA.
window.onload = init();
