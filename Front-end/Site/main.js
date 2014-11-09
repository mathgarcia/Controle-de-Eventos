$(document).ready(function() {
    //toggle `popup` / `inline` mode
    $.fn.editable.defaults.mode = 'inline';     
    
    //make username editable
    $('#titulo-atividade').editable();
    $('#descr-atividade').editable();
    $('#conteudo-atividade').editable();
    $('#palestrante-atividade').editable();
    $('#local-atividade').editable();
    $('#tipo-atividade').editable();
    
  $('#data-atividade').editable();

    $('#nome-sala').editable();
    $('#vagas-sala').editable();

    //make status editable
    $('#status').editable({
        type: 'select',
        title: 'Select status',
        placement: 'right',
        value: 2,
        source: [
            {value: 1, text: 'status 1'},
            {value: 2, text: 'status 2'},
            {value: 3, text: 'status 3'}
        ]
        /*
        //uncomment these lines to send data on server
        ,pk: 1
        ,url: '/post'
        */
    });
});