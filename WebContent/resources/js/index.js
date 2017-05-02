$(document).ready(function(){
  
    var oRemedio;
    var linha;
    var aRemedios = JSON.parse(window.localStorage['remedios'] || '[]');
    
    for( i=0; i < aRemedios.length; i++){
    
        var status="";
        var iconErrorValidade ="";
        var iconErrorQuantidade ="";
        var validade = new Date(aRemedios[i].validade);
        var now = new Date();
        var icoPlus ="<div id='"+ aRemedios[i].id +"' class='glyphicon lyphicon-chevron-up clicavel' ></div>";
        var icoMinus ="<div id='"+ aRemedios[i].id +"' class='glyphicon lyphicon-chevron-down clicavel' ></div>";
        
        if(Number(aRemedios[i].qtdAtual) <= Number(aRemedios[i].qtdMinima)) {
            status = "class='danger'";
            iconErrorQuantidade ="<span class='glyphicon glyphicon-exclamation-sign'></span>";
        }
        

        if(validade < now){
            status = "class='danger'";
            iconErrorValidade ="<span class='glyphicon glyphicon-exclamation-sign'></span>";
        }
        
        
 
        linha+=     
            "<tr "+status+" >"
                +"<td>"+ aRemedios[i].nome +"</td>"
                +"<td>"+ aRemedios[i].principioAtivo +"</td>"
                +"<td>"+ aRemedios[i].tipo +"</td>"
                +"<td>"+ iconErrorValidade+ aRemedios[i].validade +"</td>"
                +"<td>"+  icoPlus + aRemedios[i].qtdAtual + icoMinus +"</td>"
                +"<td>"+ iconErrorQuantidade + aRemedios[i].qtdMinima +"</td>"
                +"<td><div id='"+ aRemedios[i].id +"' class='glyphicon glyphicon-trash clicavel' ></div> </td>"
            +"</tr>";
    }
     
    $("#tabelaCorpo").append(linha);
    

    $(".glyphicon-trash").click(function(){
        
        for( i=0; i < aRemedios.length; i++){
             if(aRemedios[i].id == $(this).attr("id")){
                aRemedios.splice(i,1);
                window.localStorage["remedios"] = JSON.stringify(aRemedios);
                window.location.href="index.html";
             }
            
         }
    });
    

        $(".lyphicon-chevron-up").click(function(){
        
        for( i=0; i < aRemedios.length; i++){
             if(aRemedios[i].id == $(this).attr("id")){
                aRemedios[i].qtdAtual = Number(aRemedios[i].qtdAtual) +1;
                window.localStorage["remedios"] = JSON.stringify(aRemedios);
                window.location.href="index.html";
             }
            
         }
    });
    
        $(".lyphicon-chevron-down").click(function(){
        
        for( i=0; i < aRemedios.length; i++){
             if(aRemedios[i].id == $(this).attr("id")){
                aRemedios[i].qtdAtual = Number(aRemedios[i].qtdAtual) -1;
                window.localStorage["remedios"] = JSON.stringify(aRemedios);
                window.location.href="index.html";
             }
            
         }
    });
    
});
