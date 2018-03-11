var people1 = {
  name: "MacGayver",
  birthDate: "15-05-2008",
  Identification: 32161888,
  picture:"https://image.freepik.com/free-icon/business-person-silhouette-wearing-tie_318-49988.jpg"
};

var people2 = {
  name: "Rambo",
  birthDate: "11-04-2011",
  identification: 551188,
  picture:"https://image.freepik.com/free-icon/business-person-silhouette-wearing-tie_318-49988.jpg"
};

var people3 = {
  name: "Bruce Lee",
  birthDate: "11-07-2011",
  identification: 8974488,
  picture:"https://image.freepik.com/free-icon/business-person-silhouette-wearing-tie_318-49988.jpg"
};

// Itens da view
var tbody = document.getElementById("tbodyPeoples");
var btnSave = document.getElementById("btnSave");
var btnReset = document.getElementById("btnReset");

// text fields
var txfName = document.getElementById("txfName");
var txfBirthDate = document.getElementById("txfBirthDate");
var txfIdentification = document.getElementById("txfIdentification");
var txfPicture = document.getElementById("txfPicture");
var txfId = document.getElementById("txfId");


// lista de carros
var peoples = [];

// função executada ao abrir a pagina
function init() {
  localStorage.removeItem("peoples");
  addEventListeners();
  loadPeoples();
}

// carrega carros
var loadPeoples = () => {
  tbody.innerHTML = "";
  // recupera os itens armazenado no local storage
  peoples = localStorage.getItem("peoples");
  // traduz o json
  peoples = JSON.parse(peoples);
  var peoplesList1 = [people1, people2, people3];
  peoples = peoples? peoples: peoplesList1;
  peoples.forEach((m, i) => addPeopleToTable(m, i));
}

// pega eventos do botao
var addEventListeners = () => {
  btnSave.addEventListener("click", getAndSavePeople);

}


var addPeopleToTable = function(people, index) {
  if (!people) return;
  var row =
          "<tr>" +
            "<td>"+people.name+"</td>"+
            "<td>"+people.birthDate+"</td>"+
            "<td>"+people.identification+"</td>"+
            "<td><img src=\""+people.picture+"\" width=\"30px\"></td>" +
            "<td>" +
            "  <input type=\"button\" value=\"apagar\" onclick=\"removePeople("+index+")\"/>" +
            "  <input type=\"button\" value=\"editar\" onclick=\"editPeople("+index+")\"/>" +
            "</td>" +
          "</tr>";
  tbody.innerHTML += row;
}

var removePeople = (index) => {
    console.log("removendo a pessoa "+peoples[index].name);
    delete peoples[index];
    localStorage.setItem("peoples", JSON.stringify(peoples));
    loadPeoples();
};

var editPeople = (index) => {
    console.log("editando a pessoa "+peoples[index].name);
    var people = peoples[index];
    txfName.value = people.name;
    txfPicture.value = people.picture;
    txfBirthDate.value = people.birthDate
    txfIdentification.value = people.identification
    txfId.value = index;
};

var getAndSavePeople = function(e) {
  if (e) e.preventDefault();
  
  var name = txfName.value;
  var picture = txfPicture.value;
  var birthDate = txfBirthDate.value;
  var identification = txfIdentification.value;
  var id = txfId.value;
  var isNew = id == "-1";
  id = isNew? peoples.length: id;
  var people = {id: id, name: name, "picture": picture, birthDate: birthDate, "identification": identification};
  if (isNew){
    peoples.push(people);
  } else {
    peoples[id] = people;
  }
  localStorage.setItem("peoples", JSON.stringify(peoples));
  loadPeoples();
  cleanTable()
}

var cleanTable = function(){

  txfName.value = ""
  txfPicture.value = ""
  txfBirthDate.value = ""
  txfIdentification.value = ""
  txfId.value = "-1"


}


window.onload = init();
