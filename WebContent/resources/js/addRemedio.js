$(document).ready(function(){

   $('#nomeRemedio').onclick(function(){
       adiciona();
   });
    
});


function adiciona(){
    
     
    var aRemedios;
   
    
    aRemedios = JSON.parse(window.localStorage['remedios'] || '[]') ;

        
    var oRemedio = {
        id:             new Date().getTime(),
        nome:           $('#nomeRemedio').val(),
        principioAtivo: $('#principioAtivoRemedio').val(),
        tipo:           $('#tipoRemedio').val(),
        validade:       $('#validadeRemedio').val(),
        qtdAtual:       $('#qtdAtualRemedio').val(),
        qtdMinima:      $('#qtdMinimaRemedio').val()
    };
    
        
    aRemedios.push(oRemedio);

    window.localStorage['remedios'] = JSON.stringify(aRemedios);

    window.location.href="index.html"; 
}
