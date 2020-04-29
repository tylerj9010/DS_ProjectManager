function validateProject() {
	/*name, desc, target date, project manager*/
	let inName = document.querySelector("#project-name").value;
	let inDate = document.querySelector("#project-date").value;
	let inDesc = document.querySelector("#project-desc").value;
	let inManager = document.querySelector("#project-manager").value;
	
	if (!isNaN(inName) || inName.length > 200) {
		alert("Name is invalid make sure it is not longer than 200 Characters or a number");
		return false;
	}
	
	if (inName == null || inName == undefined || inName == "" ||
			inName == "null" || inName == "undefined" ) {
		return false;
	}
	
	if (!isNaN(inDesc)) {
		alert("Description is invalid make sure it is not longer than 400 Characters or a number");
		return false;
	}
	
	if (inDesc == null || inDesc == undefined || inDesc == "" ||
			inDesc == "null" || inDesc == "undefined" ) {
		return false;
	}
	
	if (inDate == null || inDate == undefined || inDate == "" ||
			inDate == "null" || inDate == "undefined" ) {
		return false;
	}
	
	if (inManager == null || inManager == undefined || inManager == "" ||
			inManager == "null" || inManager == "undefined" ) {
		return false;
	}
	
	return true;
}


function validateTask() {
	/*name, desc, date, priority, manager*/
	let inName = document.querySelector("#task-name").value;
	let inDesc = document.querySelector("#task-desc").value;
	let inDate = document.querySelector("#task-date").value;
	let inPri = document.querySelector("#task-priority").value;
	let inMan = document.querySelector("#task-manager").value;
	
	if (!validNotNull(inName) || !validLength(inName, 200) || !validNaN(inName)) {
		return false;
	}
	
	if (!validNotNull(inDesc) || !validLength(inDesc, 400) || !validNaN(inDesc)) {
		return false;
	}
	
	if (!validNotNull(inDate) || !validLength(inDate, 100) || !validNaN(inDate)) {
		return false;
	}
	
	if (!validNotNull(inPri) || !validLength(inPri, 100) || !validNaN(inPri)) {
		return false;
	}
	
	
	if (!validNotNull(inDate) || !validLength(inDate, 100) || !validNaN(inDate)) {
		return false;
	}
	
	return true;
}

function validLength(inVal, inLength) {
	console.log("inside valid length");
	if (inVal.length <=  inLength) {
		return true;
	}
	alert(inVal + "is invalid make sure it is not longer than " + inLength + " Characters or a number");
	return false;
}

function validNaN(inVal) {
	console.log("inside valid NaN");
	if (isNaN(inVal)) {
		return true;
	}
	alert(inVal + " cannot be a number");
	return false;
}

function validNotNull(inVal) {
	console.log("inside valid null");
	if (inVal != null && inVal != "null" && inVal != undefined && inVal != "") {
		return true;
	}
	alert("cannot have empty or null values");
	return false;
}
















