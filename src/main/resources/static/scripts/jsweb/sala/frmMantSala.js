$(document).on("click", "#btnagregar", function(){
    $("#txtdescsala").val("");
    $("#txtnroasientos").val("");
    $("#hddidsala").val("0");
    $("#cboestado").empty();
    $.ajax({
        type: "GET",
        url: "/Estado/listarEstados",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboestado").append(
                    `<option value="${value.idestado}">${value.descestado}</option>`
                )
            })
        }
    })
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtdescsala").val($(this).attr("data-descsala"));
    $("#txtnroasientos").val($(this).attr("data-asientos"));
    $("#hddidsala").val($(this).attr("data-idsala"));
    $("#cboestado").empty();
    var idestado = $(this).attr("data-idestado");
    $.ajax({
        type: "GET",
        url: "/Estado/listarEstados",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboestado").append(
                    `<option value="${value.idestado}">${value.descestado}</option>`
                )
            })
            $("#cboestado").val(idestado);
        }
    })
    $("#modalNuevo").modal("show");
});