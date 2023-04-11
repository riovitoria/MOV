function validar(){	
	let nome = frmContato.nome.value
	let prio1 = frmContato.prio1.value
	if (nome === ""){
		alert('O preenchimento dos campos Nome e Prio 1 são obrigatórios')
		frmContato.nome.focus()
		return false
		} else if (prio1 === ""){
			alert('O preenchimento dos campos Nome e Prio 1 são obrigatórios')
			frmContato.prio1.focus()
			return false
		} else {
			document.forms["frmContato"].submit()
		}	
	}
		