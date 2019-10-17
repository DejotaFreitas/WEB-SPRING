function Ajax(){
	var ajax;
	try	{
		ajax = new XMLHttpRequest();
	}	catch(e) {
		try		{
			ajax = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			try			{
				ajax = new ActiveXObject("Microsoft.XMLHTTP");
			}	catch(e) {
				alert("Seu browser nao da suporte o AJAX!");
				return false;
			}
		}
	}
	return ajax;
}

// ============================================================================
// json('animes');
// json('anime', 1);

function RequestAjaxSync(url, dados){
	try {
		var ajax = Ajax();
		if (dados) {
			ajax.open("POST", url, false);
			ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			ajax.send("json="+JSON.stringify(dados));
		} else {
			ajax.open("GET", url, false);
			ajax.setRequestHeader("Content-Type", "text/html");
			ajax.send();
		}
		if(ajax.readyState == 4 && ajax.status == 200) {
			try {
				return ajax.responseText;
				// return JSON.parse(ajax.responseText);
			} catch (ex) {
				console.log("RESPOSTA: "+ ajax.responseText);
				console.log("ERRO: "+ ex.message);
				return false;
			}
		}
	} catch (ex) {
		console.log("ERRO: "+ ex.message);
    return false;
	}
}

// ============================================================================
// json('animes');
// json('anime', 1);

function RequestAjaxAsync(method_response, url, dados){
	try {
		var ajax = Ajax();

		ajax.onreadystatechange = function() {
			if(ajax.readyState == 4 && ajax.status == 200) {
				method_invoke = method_response;
				method_invoke.call(window, this.responseText);
			}
		}

		if (dados) {
			ajax.open("POST", url, true);
			ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			ajax.send("json="+JSON.stringify(dados));
		} else {
			ajax.open("GET", url, true);
			ajax.setRequestHeader("Content-Type", "text/html");
			ajax.send();
		}

	} catch (ex) {
		console.log("ERRO: "+ ex.message);
	}
}

// ============================================================================
// var resposta = sendFormAjax('animes', metodo_resposta, 'formulario');
//===========================
// document.getElementById('button_cadastrar_anime').onclick = function() {
  // function metodo_resposta(resposta) { code... }
//   var resposta = sendFormAjax('animes', metodo_resposta, 'formulario', 'progress_bar');
// }

function sendFormAjax(metodo_respota, url, id_form){
	try {
		var ajax = Ajax();

		ajax.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200) {
				try {
					console.log(this.responseText);
					var resposta = JSON.parse(this.responseText);
					var metodo_invocar = metodo_respota;
					metodo_invocar.call(window, resposta);
				} catch (ex) {
					console.log("RESPOSTA: "+ ajax.responseText);
					console.log("ERRO: "+ ex.message);
					return false;
				}
			}
		}

		ajax.open("POST", url, true);
		ajax.send(new FormData(document.getElementById(id_form)));
	} catch (ex) {
		console.log("ERRO: "+ ex.message);
    return false;
	}

}



// ============================================================================
// var resposta = sendFormAjax('animes', metodo_resposta, 'formulario');
//===========================
// document.getElementById('button_cadastrar_anime').onclick = function() {
  // function metodo_resposta(resposta) { code... }
//   var resposta = sendFormAjax('animes', metodo_resposta, 'formulario', 'progress_bar');
// }
function sendFormAjaxProgress(url, metodo_respota, id_form, id_progress_bar){
	try {

		var ajax = Ajax();

		// PROGRESS BAR
		if (id_progress_bar) {
			var progressBar = document.getElementById(id_progress_bar);
			// UPLOAD, SE OUVER SUPORTE
			if(ajax.upload) {
	      ajax.upload.onprogress = function(e) {
					if(e.lengthComputable) {
						progressBar.max = e.total
						progressBar.value = e.loaded
					}
	      }
			} else {
				// PROGRESSO DO ENVIO DO FORMULARIO POR SESSAO
				ajax.onprogress = function(e) {
					if(e.lengthComputable) {
						progressBar.max = e.total
						progressBar.value = e.loaded
					}
				}
			}
			// FOI ENVIADO COM SUCESSO
			ajax.onloadend = function(e) {

			}
			// ERROR AO ENVIAR
			ajax.error = function(e) {

			}
			// CANCELOU A TRANFERENCIA
			ajax.abort = function(e) {

			}
		}

		// RESPOTA
		ajax.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200) {
				try {
					var resposta = JSON.parse(this.responseText);
					var metodo_invocar = metodo_respota;
					metodo_invocar.call(window, resposta);
				} catch (ex) {
					console.log("RESPOSTA: "+ ajax.responseText);
					console.log("ERRO: "+ ex.message);
					return false;
				}
			}
		}

		// ENVIAR
		ajax.open("POST", url, true);
		ajax.send(new FormData(document.getElementById(id_form)));
	} catch (ex) {
		console.log("ERRO: "+ ex.message);
    return false;
	}

}
