/*NUEVO TRABAJADOR*/
$(document).on("click","#btnnuevo",function(){
    $("#modaltrabajador").modal("show");

    $("#txtidtrabajador").val("");
    $("#txtnombres").val("");
    $("#txtapellidos").val("");
    $("#txtdni").val("");
    $("#txttelefono").val("");
    $("#txtcorreo").val("");
    $("#txtdireccion").val("");
    $("#txtidcargo").val("");
    $("#txtidarea").val("");
    $("#txtclave").val("");
});

/*ELIMINAR*/
$(document).on("click",".btneliminar",function(){
    $("#modaltrabajador").modal("show");
});

/*ACTUALIZAR - TRAER LOS DATOS AL MODAL*/
$(document).on("click",".btnactualizar",function(){
    $("#modaltrabajador").modal("show");
        $("#txtidtrabajador").val($(this).attr("data-idtrabajador"));
        $("#txtnombres").val($(this).attr("data-nombres"));
        $("#txtapellidos").val($(this).attr("data-apellidos"));
        $("#txtdni").val($(this).attr("data-dni"));
        $("#txttelefono").val($(this).attr("data-telefono"));
        $("#txtcorreo").val($(this).attr("data-correo"));
        $("#txtdireccion").val($(this).attr("data-direccion"));
        $("#txtidcargo").val($(this).attr("data-idcargo"));
        $("#txtidarea").val($(this).attr("data-idarea"));
        $("#txtclave").val($(this).attr("data-clave"));
});

/*BOTÓN GUARDAR - PARA REGISTRAR Y ACTUALIZAR TRABAJADOR*/
$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"POST",
        contentType:"application/json",
        url:"/trabajador/registrar",
        data: JSON.stringify({
           idtrabajador:$("#txtidtrabajador").val(),
           nombres:$("#txtnombres").val(),
           apellidos:$("#txtapellidos").val(),
           dni:$("#txtdni").val(),
           telefono:$("#txttelefono").val(),
           correo:$("#txtcorreo").val(),
           direccion:$("#txtdireccion").val(),
           idcargo:$("#txtidcargo").val(),
           idarea:$("#txtidarea").val(),
           clave:$("#txtclave").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarTrabajador();
            }
            alert(resultado.mensaje);
            $("#modaltrabajador").modal("hide")
        }
    });
});

/*Listado de trabajador - actualizado*/
function listarTrabajador(){
    $.ajax({
        type:"GET",
        url:"/trabajador/list",
        datatype: "json",
        success: function(resultado){
            $("#tbltrabajador > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tbltrabajador > tbody").append(
                "<tr>"+
                    "<td>"+value.idtrabajador+"</td>"+
                    "<td>"+value.nombres+"</td>"+
                    "<td>"+value.apellidos+"</td>"+
                    "<td>"+value.dni+"</td>"+
                    "<td>"+value.telefono+"</td>"+
                    "<td>"+value.correo+"</td>"+
                    "<td>"+value.direccion+"</td>"+
                    "<td>"+value.idcargo+"</td>"+
                    "<td>"+value.idarea+"</td>"+
                    "<td>"+value.clave+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-outline-info btnactualizar'"+
                                "data-idtrabajador='"+value.idtrabajador+"'"+
                                "data-nombres='"+value.nombres+"'"+
                                "data-apellidos='"+value.apellidos+"'"+
                                "data-dni='"+value.dni+"'"+
                                "data-telefono='"+value.telefono+"'"+
                                "data-correo='"+value.correo+"'"+
                                "data-direccion='"+value.direccion+"'"+
                                "data-idcargo='"+value.idcargo+"'"+
                                "data-idarea='"+value.idarea+"'"+
                                "data-clave='"+value.clave+"'"+
                        ">"+
                            "<i class='bi bi-pencil-square'></i>"+
                        "</button>"+
                    "</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-outline-warning btneliminar'"+
                                "data-idtrabajador='"+value.idtrabajador+"'"+
                                "data-nombres='"+value.nombres+"'"+
                                "data-apellidos='"+value.apellidos+"'"+
                                "data-dni='"+value.dni+"'"+
                                "data-telefono='"+value.telefono+"'"+
                                "data-correo='"+value.correo+"'"+
                                "data-direccion='"+value.direccion+"'"+
                                "data-idcargo='"+value.idcargo+"'"+
                                "data-idarea='"+value.idarea+"'"+
                                "data-clave='"+value.clave+"'"+
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