/*NUEVO PROVEEDOR*/
$(document).on("click","#btnnuevo",function(){
    $("#modalproveedor").modal("show");

    $("#txtidproveedor").val("");
    $("#txttelefono").val("");
    $("#txtdireccion").val("");
    $("#txtempresa").val("");
    $("#txtruc").val("");
    $("#txtcorreo").val("");
    $("#txtrepresentante").val("");
});

/*ELIMINAR*/
$(document).on("click",".btneliminar",function(){
    $("#modalproveedor").modal("show");
});

/*ACTUALIZAR - TRAER LOS DATOS AL MODAL*/
$(document).on("click",".btnactualizar",function(){
    $("#modalproveedor").modal("show");
        $("#txtidproveedor").val($(this).attr("data-idproveedor"));
        $("#txttelefono").val($(this).attr("data-telefono"));
        $("#txtdireccion").val($(this).attr("data-direccion"));
        $("#txtempresa").val($(this).attr("data-empresa"));
        $("#txtruc").val($(this).attr("data-ruc"));
        $("#txtcorreo").val($(this).attr("data-correo"));
        $("#txtrepresentante").val($(this).attr("representante"));
});

/*BOTÓN GUARDAR - PARA REGISTRAR Y ACTUALIZAR PROVEEDORS*/
$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"POST",
        contentType:"application/json",
        url:"/proveedor/registrar",
        data: JSON.stringify({
           idproveedor:$("#txtidproveedor").val(),
           telefono:$("#txttelefono").val(),
           direccion:$("#txtdireccion").val(),
           empresa:$("#txtempresa").val(),
           ruc:$("#txtruc").val(),
           correo:$("#txtcorreo").val(),
           representante:$("#txtrepresentante").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarProveedor();
            }
            alert(resultado.mensaje);
            $("#modalproveedor").modal("hide")
        }
    });
});

/*Listado de proveedor - actualizado*/
function listarProveedor(){
    $.ajax({
        type:"GET",
        url:"/proveedor/list",
        datatype: "json",
        success: function(resultado){
            $("#tblproveedor > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblproveedor > tbody").append(
                 "<tr>"+
                    "<td>"+value.idproveedor+"</td>"+
                    "<td>"+value.telefono+"</td>"+
                    "<td>"+value.direccion+"</td>"+
                    "<td>"+value.empresa+"</td>"+
                    "<td>"+value.ruc+"</td>"+
                    "<td>"+value.correo+"</td>"+
                    "<td>"+value.representante+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-outline-info btnactualizar'"+
                                "data-idproveedor='"+value.idproveedor+"'"+
                                "data-telefono='"+value.telefono+"'"+
                                "data-direccion='"+value.direccion+"'"+
                                "data-empresa='"+value.empresa+"'"+
                                "data-ruc='"+value.ruc+"'"+
                                "data-correo='"+value.correo+"'"+
                                "data-representante='"+value.representante+"'"+
                        ">"+
                            "<i class='bi bi-pencil-square'></i>"+
                        "</button>"+
                    "</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-outline-warning btneliminar'"+
                                  "data-idproveedor='"+value.idproveedor+"'"+
                                 "data-telefono='"+value.telefono+"'"+
                                 "data-direccion='"+value.direccion+"'"+
                                 "data-empresa='"+value.empresa+"'"+
                                 "data-ruc='"+value.ruc+"'"+
                                 "data-correo='"+value.correo+"'"+
                                 "data-representante='"+value.representante+"'"+
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