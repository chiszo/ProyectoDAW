/*NUEVO PRODUCTO*/
$(document).on("click","#btnnuevo",function(){
    $("#modalproducto").modal("show");

    $("#txtidproducto").val("");
    $("#txtnombre").val("");
    $("#txtcantidad").val("");
    $("#txtprecio").val("");
    $("#txtstockmin").val("");
    $("#txtstockmax").val("");
    $("#txtestado").val("");
    $.ajax({
        type:"GET",
        url:"/producto/list_tipopro",
        datatype: "json",
        success: function(resultado){
            $.each(resultado, function(index,value){
                $("#txtidtipoproducto").append(
                    `<option value="${value.idtipopro}">
                        ${value.descripcion}
                    </option>`
                )
            });
        }
    });
    $.ajax({
        type:"GET",
        url:"/producto/list_lote",
        datatype: "json",
        success: function(resultado){
            $.each(resultado, function(index,value){
                $("#txtidlote").append(
                    `<option value="${value.idlote}">
                        ${value.descripcion}
                    </option>`
                )
            });
        }
    });
    $.ajax({
        type:"GET",
        url:"/proveedor/list",
        datatype: "json",
        success: function(resultado){
            $.each(resultado, function(index,value){
                $("#txtidproveedor").append(
                    `<option value="${value.idproveedor}">
                        ${value.empresa}
                    </option>`
                )
            });
        }
    });
});

/*ELIMINAR*/
$(document).on("click",".btneliminar",function(){
    $("#lblmensajeeliminar").text("Está seguro de eliminar el producto " +
    $(this).attr("data-nombre") + "?");
    $("#hddideliminar").val($(this).attr("data-idproducto"));
    $("#modaleliminar").modal("show");
});

/*ACTUALIZAR - TRAER LOS DATOS AL MODAL*/
$(document).on("click",".btnactualizar",function(){
    $("#modalproducto").modal("show");
        $("#txtidproducto").val($(this).attr("data-idproducto"));
        $("#txtnombre").val($(this).attr("data-nombre"));
        $("#txtcantidad").val($(this).attr("data-cantidad"));
        $("#txtprecio").val($(this).attr("data-precio"));
        $("#txtstockmin").val($(this).attr("data-cantmin"));
        $("#txtstockmax").val($(this).attr("data-cantmax"));
        $("#txtestado").val($(this).attr("data-estado"));
        $("#txtidproveedor").empty();
        $("#txtidlote").empty();
        $("#txtidtipoproducto").empty();
        var idlote =$(this).attr("data-idlote");
        var idtipopro=$(this).attr("data-idtipopro");
        var idproveedor=$(this).attr("data-idproveedor");
        $.ajax({
            type:"GET",
            url:"/producto/list_tipopro",
            datatype: "json",
            success: function(resultado){
                $.each(resultado, function(index,value){
                    $("#txtidtipoproducto").append(
                        `<option value="${value.idtipopro}">
                            ${value.descripcion}
                        </option>`
                    )
                });
                $("#txtidtipoproducto").val(idtipopro);
            }
        });
        $.ajax({
            type:"GET",
            url:"/producto/list_lote",
            datatype: "json",
            success: function(resultado){
                $.each(resultado, function(index,value){
                    $("#txtidlote").append(
                        `<option value="${value.idlote}">
                            ${value.descripcion}
                        </option>`
                    )
                });
                $("#txtidlote").val(idlote);
            }
        });
        $.ajax({
            type:"GET",
            url:"/proveedor/list",
            datatype: "json",
            success: function(resultado){
                $.each(resultado, function(index,value){
                    $("#txtidproveedor").append(
                        `<option value="${value.idproveedor}">
                            ${value.empresa}
                        </option>`
                    )
                });
                $("#txtidproveedor").val(idproveedor);
            }
        });
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

/*Listado de productos - actualizado*/
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
                     "<td>"+value.tipoproducto.descripcion+"</td>"+
                     "<td>"+value.proveedor.empresa+"</td>"+
                     "<td>"+ value.nombre+"</td>"+
                     "<td>"+ value.cantidad+"</td>"+
                     "<td>"+value.precio+"</td>"+
                     "<td>"+ value.cantmin+"</td>"+
                     "<td>"+ value.cantmax+"</td>"+
                     "<td>"+ value.lote.descripcion+"</td>"+
                     "<td>"+ value.estado+"</td>"+
                     "<td>"+
                         "<button type='button' class='btn btn-outline-info btnactualizar'"+
                            "data-idproducto='"+value.idproducto+"'"+
                            "data-idtipopro='"+value.tipoproducto.idtipopro+"'"+
                            "data-idproveedor='"+value.proveedor.idproveedor+"'"+
                            "data-nombre='"+ value.nombre+"'"+
                            "data-cantidad='"+value.cantidad+"'"+
                            "data-precio='"+value.precio+"'"+
                            "data-cantmin='"+value.cantmin+"'"+
                            "data-cantmax='"+value.cantmax+"'"+
                            "data-idlote='"+value.lote.idlote+"'"+
                            "data-estado='"+value.estado+"'"+
                         ">"+
                            "<i class='bi bi-pencil-square'></i>"+
                         "</button>"+
                     "</td>"+
                     "<td>"+
                         "<button type='button' class='btn btn-outline-warning btneliminar'"+
                            "data-idproducto='"+value.idproducto+"'"+
                            "data-idtipopro='"+value.tipoproducto.idtipopro+"'"+
                            "data-idproveedor='"+value.proveedor.idproveedor+"'"+
                            "data-nombre='"+ value.nombre+"'"+
                            "data-cantidad='"+value.cantidad+"'"+
                            "data-precio='"+value.precio+"'"+
                            "data-cantmin='"+value.cantmin+"'"+
                            "data-cantmax='"+value.cantmax+"'"+
                            "data-idlote='"+value.lote.idlote+"'"+
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

$(document).on("click","#btneliminar",function(){
    $.ajax({
        type:"DELETE",
        contentType:"application/json",
        url:"/producto/eliminar",
        data: JSON.stringify({
            idestado:$("#hddideliminar").val(),
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarProductos();
            }
            alert(resultado.mensaje);
            $("#modaleliminar").modal("hide")
        }
    });
});