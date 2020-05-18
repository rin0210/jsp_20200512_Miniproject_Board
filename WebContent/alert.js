/**
 * 
 */

function loginCheck() {
	if (document.loginForm.iid.value == "") {
		alert("아이디를 입력하세요.");
		loginForm.iid.focus();
		return false;
	}
	if (document.loginForm.ipwd.value == "") {
		alert("비밀번호를 입력하세요.");
		loginForm.ipwd.focus();
		return false;
	}
	return true;
}

function joinCheck() {
	if (document.joinForm.iid.value == "") {
		alert("아이디를 입력하세요.");
		joinForm.iid.focus();
		return false;
	}
	if (document.joinForm.ipwd.value == "") {
		alert("비밀번호를 입력하세요.");
		joinForm.ipwd.focus();
		return false;
	}
	if (document.joinForm.iname.value == "") {
		alert("이름을 입력하세요.");
		joinForm.iname.focus();
		return false;
	}
	if (document.joinForm.idChk.value == "") {
		alert("아이디 중복체크를 해주세요.")
		return false;
	}
	return true;
}

function idCheck() {
	if (document.joinForm.iid.value == "") {
		alert("아이디를 입력하세요.");
		joinForm.iid.focus();
		return;
	}
	var url = "id_chk?id=" + document.joinForm.iid.value;
	window
			.open(url, "_blank_1",
					"toolbar=no,menubar=no,scrollbars=yes,resizable=no,width=300,height=200");
}

function idOk() {
	opener.joinForm.iid.value = document.idChkForm.id.value;
	opener.joinForm.idChk.value = document.idChkForm.id.value;
	self.close();
}

function writeCheck() {
	if (document.writeForm.ibody.value == "") {
		alert("내용을 입력하세요.");
		writeForm.ibody.focus();
		return false;
	}

	if (document.writeForm.ipwd.value == "") {
		alert("비밀번호를 입력하세요.");
		writeForm.ipwd.focus();
		return false;
	}
	return true;
}

function modCheck() {
	if (document.modForm.ibody.value == "") {
		alert("내용을 입력하세요.");
		modForm.ibody.focus();
		return;
	}
	var msg = confirm("정말로 수정하시겠습니까?");
	if (msg) {
		alert("수정이 완료되었습니다.")
		return true;
	} else {
		return false;
	}
}

function delCheck(type){
	if (document.ContentForm.ipwd.value == "") {
		alert("비밀번호를 입력하세요.");
		ContentForm.ipwd.focus();
		return;
	}
	
	if (type==2){
		var msg = confirm("정말로 삭제하시겠습니까?");
		if(msg){
			return true;
		} else{
			return false;
		}
	}
}




