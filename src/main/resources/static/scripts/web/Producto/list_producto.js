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

/*BOTÓN GUARDAR - PARA REGISTRAR Y ACTUALIZAR PRODUCTOS*/

$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"POST",
        contentType:"application/json",
        url:"/producto/registrar",
        data: JSON.stringify({
            idproducto:$("#txtidproducto").val(),
            idtipopro:$("#txtidtipoproducto").val(),
            idproveedor:$("#txtidproveedor").val(),
            nombre:$("#txtnombre").val(),
            cantidad:$("#txtcantidad").val(),
            precio:$("#txtprecio").val(),
            cantmin:$("#txtstockmin").val(),
            cantmax:$("#txtstockmax").val(),
            idlote:$("#txtidlote").val(),
            estado:$("#txtestado").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarProductos();
            }
            alert(resultado.mensaje);
            $("#modalproducto").modal("hide")
        }
    });
});

function listarProductos(){
    $.ajax({
        type:"GET",
        url:"/producto/list",
        datatype: "json",
        success: function(resultado){
            $("#tblproducto > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblproducto > tbody").append(
                "<tr>"+
                     "<td>"+value.idproducto+"</td>"+
                     "<td>"+value.idtipopro+"</td>"+
                     "<td>"+value.idproveedor+"</td>"+
                     "<td>"+ value.nombre+"</td>"+
                     "<td>"+ value.cantidad+"</td>"+
                     "<td>"+value.precio+"</td>"+
                     "<td>"+ value.cantmin+"</td>"+
                     "<td>"+ value.cantmax+"</td>"+
                     "<td>"+ value.idlote+"</td>"+
                     "<td>"+ value.estado+"</td>"+
                     "<td>"+
                         "<button type='button' class='btn btn-outline-info btnactualizar'"+
                            "data-idproducto='"+value.idproducto+"'"+
                            "data-idtipopro='"+value.idtipopro+"'"+
                            "data-idproveedor='"+value.idproveedor+"'"+
                            "data-nombre='"+ value.nombre+"'"+
                            "data-cantidad='"+value.cantidad+"'"+
                            "data-precio='"+value.precio+"'"+
                            "data-cantmin='"+value.cantmin+"'"+
                            "data-cantmax='"+value.cantmax+"'"+
                            "data-idlote='"+value.idlote+"'"+
                            "data-estado='"+value.estado+"'"+
                         ">"+
                            "<i class='bi bi-pencil-square'></i>"+
                         "</button>"+
                     "</td>"+
                     "<td>"+
                         "<button type='button' class='btn btn-outline-warning btneliminar'"+
                            "data-idproducto='"+value.idproducto+"'"+
                            "data-idtipopro='"+value.idtipopro+"'"+
                            "data-idproveedor='"+value.idproveedor+"'"+
                            "data-nombre='"+ value.nombre+"'"+
                            "data-cantidad='"+value.cantidad+"'"+
                            "data-precio='"+value.precio+"'"+
                            "data-cantmin='"+value.cantmin+"'"+
                            "data-cantmax='"+value.cantmax+"'"+
                            "data-idlote='"+value.idlote+"'"+
                            "data-estado='"+value.estado+"'"+
                         ">"+
                            "<i class='bi bi-trash'></i>"+
                         "</button>"+
                     "</td>"+
                "</tr>"
                )
            });
        }
    });
}