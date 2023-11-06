/*NUEVO PRODUCTO*/
$(document).on("click","#btnnuevo",function(){
    //alert("Hola :D");
    $("#modalproducto").modal("show");

    $("#txtidproducto").val("");
    $("#txtidtipoproducto").val("");
    $("#txtidproveedor").val("");
    $("#txtnombre").val("");
    $("#txtcantidad").val("");
    $("#txtprecio").val("");
    $("#txtstockmin").val("");
    $("#txtstockmax").val("");
    $("#txtidlote").val("");
    $("#txtestado").val("");
});

/*ELIMINAR*/
$(document).on("click",".btneliminar",function(){
    $("#modalproducto").modal("show");
});

/*ACTUALIZAR - TRAER LOS DATOS AL MODAL*/
$(document).on("click",".btnactualizar",function(){
    $("#modalproducto").modal("show");
        $("#txtidproducto").val($(this).attr("data-idproducto"));
        $("#txtidtipoproducto").val($(this).attr("data-idtipopro"));
        $("#txtidproveedor").val($(this).attr("data-idproveedor"));
        $("#txtnombre").val($(this).attr("data-nombre"));
        $("#txtcantidad").val($(this).attr("data-cantidad"));
        $("#txtprecio").val($(this).attr("data-precio"));
        $("#txtstockmin").val($(this).attr("data-cantmin"));
        $("#txtstockmax").val($(this).attr("data-cantmax"));
        $("#txtidlote").val($(this).attr("data-idlote"));
        $("#txtestado").val($(this).attr("data-estado"));
});
