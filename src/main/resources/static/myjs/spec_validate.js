$(document).ready(function() {
	//1.hide error section
	$("#specCodeError").hide();
	$("#specNameError").hide();
	$("#specNoteError").hide();

	//2.Define Error Variable
	var specCodeError = false;
	var specNameError = false;
	var specNoteError = false;

	//3.define validate funtion
	function validate_specCode() {
		var val = $("#specCode").val();
		var exp = /^[A-Z]{4,10}$/;
		//check empty or not
		if (val == '') {
			$("#specCodeError").show();
			$("#specCodeError").html("*<b>Code</b> can't be empty");
			$("#specCodeError").css("color", "red");
			specCodeError = false;
		} else if (!exp.test(val)) {
			$("#specCodeError").show();
			$("#specCodeError").html("*<b>Code</b> must be 4-12 character");
			$("#specCodeError").css("color", "red");
			specCodeError = false;
		} else {
			$("#specCodeError").hide();
			specCodeError = true;
		}
		return specCodeError;
	}

	function validate_specName() {
		var val = $("#specName").val();
		var exp = /^[A-Za-z0-9\s\.]{4,60}$/;
		//check empty or not
		if (val == '') {
			$("#specNameError").show();
			$("#specNameError").html("*<b>Name</b> can't be empty");
			$("#specNameError").css("color", "red");
			specNameError = false;
		} else if (!exp.test(val)) {
			$("#specNameError").show();
			$("#specNameError").html("*<b>Name</b> must be 4-25 character");
			$("#specNameError").css("color", "red");
			specNameError = false;
		} else {
			$("#specNameError").hide();
			specNameError = true;
		}
		return specNameError;
	}

	function validate_specNote() {
		var val = $("#specNote").val();
		var exp = /^[A-Za-z0-9\s\.\-\,\']{10,250}$/;
		//check empty or not
		if (val == '') {
			$("#specNoteError").show();
			$("#specNoteError").html("*<b>Note</b> can't be empty");
			$("#specNoteError").css("color", "red");
			specNoteError = false;
		} else if (!exp.test(val)) {
			$("#specNoteError").show();
			$("#specNoteError").html("*<b>Note</b> must be 10-150 character");
			$("#specNoteError").css("color", "red");
			specNoteError = false;
		} else {
			$("#specNoteError").hide();
			specNoteError = true;
		}
		return specNoteError;
	}


	//4.link with action event
	$("#specCode").keyup(function() {
		$(this).val($(this).val().toUpperCase());
		validate_specCode();
	});
	$("#specName").keyup(function() {
		validate_specName();
	});
	$("#specNote").keyup(function() {
		validate_specNote();
	});

	//5. on submit
	$("#specForm").submit(function() {
		//call validate function
		validate_specCode();
		validate_specName();
		validate_specNote();

		//return boolean
		if (specCodeError && specNameError && specNoteError) return true;
		else return false;
	});
});
