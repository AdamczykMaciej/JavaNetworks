var req
// 1st approach, but it isn't AJAX, doesn't have interaction with a server (everything done in js), does not create XMLHttpResponse
function add1() {
	var p1 = document.getElementById("p1").value;
	var p2 = document.getElementById("p2").value;
	var sum = parseFloat(p1) + parseFloat(p2);
	document.getElementById("result").innerHTML = sum;
}
// 2nd approach, the AJAX approach
function add2(){
	var p1 = document.getElementById("p1").value;
	var p2 = document.getElementById("p2").value;
	var data1 = "p1=" + encodeURIComponent(p1); // encodeURIComponent encodes , / ? : @ & = + $ # to escape characters
	// e.g. user input = &sdas#, it changes encodes the "special" characters
	var data2 = "p2=" + encodeURIComponent(p2);
	var data = data1 + "\n" + data2;
	document.getElementById("result").innerHTML = typeof XMLHttpRequest;
	if (typeof XMLHttpRequest != "undefined"){
		req = new XMLHttpRequest(); // used by all modern browsers
		document.getElementById("result").innerHTML = "abcde";
	} else if(window.ActiveXObject){
		req = new ActiveXObject("Microsoft.XMLHTTP"); // used by old IE browsers
		document.getElementById("result").innerHTML = "abcde";
	} else {
		document.getElementById("result").innerHTML = "abcde";
	}

	var url = "Validator?p1=" + p1 + "&p2=" + p2; // the server (file) location and parameters (that will be sent)
	req.open("POST", url, true); // async true, sync false; we want to have it asynchronous - so it does not have to wait (recommended)
	req.onreadystatechange = function(){
		if (req.readyState == 4 && req.status == 200) {
		    document.getElementById("result").innerHTML = req.responseText;
		  }
	};
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.send();
}