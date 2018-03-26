var LABEL_CREATE = "Create";
var LABEL_UPDATE = "Update";

//var defineKey = (m) =>  m.title+m.releasedDate;
var defineKey = (m) =>  m.numeroTag;
var formatKey = (m) =>  m.title+" ("+m.releasedDate.split("-")[0]+")";

var showInfo = (m) =>  messageArea.innerHTML = m;
var showError = (m) =>  messageArea.innerHTML = "<strong>Error</strong>: <output>"+m+"<output>";

//<!-- Pet(String nome, int numeroTag, String raca, char sexo, LocalDate dataNascimento, String especie, String pelagem, String porte) -->

var getPetFromForm = () => {
	 var pet = {};
	 pet.nome = fieldNome.value;
	 pet.numeroTag = fieldNumeroTag.value;
	 pet.raca = fieldRaca.value;
	 pet.sexo = fieldSexo.value;
	 pet.dataNascimento = fieldDataNascimento.value;
	 pet.especie = fieldEspecie.value;
	 pet.pelagem =fieldPelagem.value;
	 pet.porte = fieldPorte.value;
	 
	 return pet;
};

var setPetToForm = (pet) => {
	fieldNome.value = pet.nome;
	fieldNumeroTag.value = pet.numeroTag;
	fieldRaca.value = pet.raca;
	fieldSexo.value = pet.sexo;
	fieldDataNascimento.value = pet.dataNascimento;
	fieldEspecie.value = pet.especie;
	fieldPelagem.value = pet.pelagem;
	fieldPorte.value = pet.porte;

	 
};

var clearForm = () => {
	fieldNome.value = "";
	fieldNumeroTag.value = "";
	fieldRaca.value = "";
	fieldSexo.value = "";
	fieldDataNascimento.value = "";
	fieldEspecie.value = "";
	fieldPelagem.value = "";
	fieldPorte.value = "";

	 btnSave.value = LABEL_CREATE;
};

var encodeParams = function (params) {
    return Object.keys(params).map(function(key) {
        return [key, params[key]].join("=");
    }).join("&");
};

var addToTable = (pet) => {
	var key = defineKey(pet);
	tblBody.innerHTML +=
		"<tr>"+
		"<td>"+pet.nome+"</td>"+
		"<td>"+pet.numeroTag+"</td>"+
		"<td>"+pet.raca+"</td>"+
		"<td>"+pet.sexo+"</td>"+
		"<td>"+pet.dataNascimento+"</td>"+
		"<td>"+pet.especie+"</td>"+
		"<td>"+pet.pelagem+"</td>"+
		"<td>"+pet.porte+"</td>"+
		"<td>"+
		"<button onclick=\"deletePet('"+key+"')\"> delete </button>"+
		"<button onclick=\"editPet('"+key+"')\"> edit </button>"+
		"</td>"+
		"</tr>";
}

var editPet = (key) => {
	btnSave.value = LABEL_UPDATE;
	console.log(key);
	getPet(key);
	//fieldTitle.disabled = "disabled";
	//fieldReleasedDate.disabled = "disabled";
};

var createPet = () => {
	if (	btnSave.value == LABEL_CREATE){
		var pet = getPetFromForm();
		pet = encodeParams(pet);
		xhrPost(petsUri,pet,
				(e) => {
					 if (isSuccess(e)) {
					  showInfo("Pet created!");
					  loadPets();
					  clearForm();
					 }
				},
			e => console.log(e));
	}
};

var updatePet = () => {
	if (btnSave.value == LABEL_UPDATE){
		var pet = getPetFromForm();
		var key = defineKey(pet.numeroTag);
		pet = encodeParams(pet);
		console.log(pet);
		
		xhrPut(petUpdate+"/"+key,pet,
				(e) => {
					  showInfo("Pet updated!");
					  loadPets();
					  clearForm();
				},
				e => console.log(e));
	}
};

var savePet = () => {
	if (btnSave.value == LABEL_CREATE){
		createPet();
	}
	if (btnSave.value == LABEL_UPDATE){
		updatePet();
	}
};

var deletePet = (key) => {
	xhrDelete(petDeleteUri+"/"+key,"",
			(e) => {
				    showInfo("Pet removed!");
					loadPets();
					clearForm();
			},
			e => console.log(e));
}

var loadPets = () => {
	 var onLoad = (e) => {
		var response = e.target.responseText;
		tblBody.innerHTML = "";
		if (response){
			var pets = JSON.parse(response);
			pets.forEach((m) => addToTable(m));
		}
	};
	var onError = e => console.log(e);
	xhrGet(petsUri, "", onLoad, onError);
};

var getPet = (key) => {
	console.log(key);
	 var onLoad = e => {
		var response = e.target.responseText;
		var isSuccess = e.target.status >= 200 && e.target.status < 400;
		if (isSuccess){
			var pet = JSON.parse(response);
			setPetToForm(pet);
			btnSave.value=LABEL_UPDATE;
		} else {
			if (e.target.status == 404){
				showError("Pet "+key+" not found");

			} else {
				showError("unknown error ("+e.target.statusText+").");
			}
		}
	};
	xhrGet(petFind+"/"+key, "", onLoad, onErrorDefault);
};

var loadBestPicture = () => {
	xhrGet(petsBestPictureUri, "", (e) => {
		loadPets();
	},
	(e) => console.log(e));
};

var init = () => {
	loadPets();
	btnSave.addEventListener("click", savePet);
	btnClear.addEventListener("click", clearForm);
	btnBestPicture.addEventListener("click", loadBestPicture);
	btnSave.value=LABEL_CREATE;
};

addEventListener("load", init());