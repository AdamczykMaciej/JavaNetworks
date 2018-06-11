function callback(response){
	$("#date").html(response.date); // date is the name of our html element
	// we take from response (json) "date" key
}

function ajax_post(){
	$.post(
		"/Project7/Date",
		null,
		callback,
		"json");
}

setInterval(ajax_post, 1000);