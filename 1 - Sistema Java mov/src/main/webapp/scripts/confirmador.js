 function confirmar(idcon){
	 let resposta = confirm("Confirma a exclusão deste registro ?")
	 if (resposta === true){
	 	//alerta(idcon)
	 	window.location.href = "delete?idcon=" +idcon
 	}
 }