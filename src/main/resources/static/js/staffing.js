
$(function() {
			
		response.done(function(e) {
			var codigoTitulo = botaoReceber.data('codigo');
			$('[data-role=' + codigoTitulo + ']').html('<span class="badge badge-success">' + e + '</span>');
			botaoReceber.hide();		
	});
});
		