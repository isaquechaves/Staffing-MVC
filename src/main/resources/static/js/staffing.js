$('#confirmarExclusaoModal').on('show.bs.modal', function (event){
	
	var button = $(event.relatedTarget);
	
	var idFuncionario = button.data('id');
	var nomeFuncionario = button.data('nome');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if(!action.endsWith('/')){
		action += '/';
	}	
	
	form.attr('action', action + idFuncionario);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o(a) funcionário(a) <strong>' +nomeFuncionario + '</strong>?');
});

$('#confirmarExclusaoVagasModal').on('show.bs.modal', function (event){
	
	var button = $(event.relatedTarget);
	
	var idVaga = button.data('id');
	var descricaoVaga = button.data('descricao');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if(!action.endsWith('/')){
		action += '/';
	}	
	
	form.attr('action', action + idVaga);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir esta vaga <strong>' +descricaoVaga + '</strong>?');
});
