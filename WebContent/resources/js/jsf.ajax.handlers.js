var statusUpdate = function statusUpdate(data) {
	
	console.log("In 'statusUpdate()'. Data='" + JSON.stringify(data) + "'");
	
	var statusArea = document.getElementById("statusArea");
	var text = statusArea.value;
	text = text + "Name: " + data.source.id;
	if (data.type === "event") {
		text = text + " Event: " + data.type + "\n";
		text = text + " Status: " + data.status + "\n";
		if (data.status !== 'begin') {
			text = text + " Response Code: " + data.responseCode + "\n";
		}
	} else { // otherwise, it's an error
		text = text + " Error: " + data.name + "\n";
	}
	statusArea.value = text;
};

function handleAjax(data) {
	console.log("In 'handleAjax()'. data = " + JSON.stringify(data));
	
	var status = data.status;
	
	console.log("In 'handleAjax()'. Status='" + status + "'");
	
	switch (status) {
	case "begin":
		// This is the start of the AJAX request.
		document.getElementById("statusArea").value = '';
		document.getElementsByTagName('body')[0].className = 'loading';
		break;

	case "complete":
		// This is invoked right after ajax response is returned.
		break;

	case "success":
		// This is invoked right after successful processing of ajax response
		// and update of HTML DOM.
		document.getElementsByTagName('body')[0].className = '';
		break;
	}
}

function handleAjaxWithBlockUI(data) {
	console.log("In 'handleAjaxWithBlockUI()'. data = " + JSON.stringify(data));
	
	var status = data.status;
	
	console.log("In 'handleAjaxWithBlockUI()'. Status='" + status + "'");
	
	switch (status) {
	case "begin":
		$(document).ready(function() {
			$('#container').block({ message: '<h4>Waiting for response. Just a moment...</h4>' });
		});
		break;
	case "complete":
		break;
	case "success":
		$(document).ready(function() {
			$('#container').unblock();
		});
		break;
	}
}

// Setup the statusUpdate function to hear all events on the page
if (typeof jsf !== 'undefined') {
//	jsf.ajax.addOnEvent(handleAjax);
	
	jsf.ajax.addOnEvent(handleAjaxWithBlockUI);
	
//	jsf.ajax.addOnEvent(statusUpdate);
//	jsf.ajax.addOnError(statusUpdate);
}
