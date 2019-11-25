/** reload **/
function reloadRoleTabel(){
    $("#tabelrole").DataTable().ajax.reload();
}

/** reset form **/
function resetFormRole(){
    $("#formrole")[0].reset();
}

/** getCancelRole **/
$(document).ready(function(){
    $(".getCancelRole").click(function(){
        $("#formrole")[0].reset();
        $(".getSaveRole").show();
        $(".getUpdateRole").hide();
    });
    $(".getUpdateRole").hide();
});

/** getUpdateRole **/
$(document).ready(function(){
    $(".getUpdateRole").click(function(){
        var roleId = $("#idrole").val();
        var roleName = $("#namerole").val();
        $.ajax({
            url: 'http://localhost:7676/api/role/'+roleId,
            type: 'PUT',
            data: JSON.stringify({
                roleId: roleId,
                roleName: roleName
            }),
            contentType: 'application/json;charset=UTF-8',
            dataType: 'JSON',
            complete: function(){
                resetFormRole();
                reloadRoleTabel();
            },
            error: function(xhr, status, error){
                console.log(xhr.responseText);
                swal({
                    icon: "warning",
                    title: "Failed Update",
                    text: "Opps..something wrong !"
                })
            }
        })
    })
});

/** getSaveRole **/
$(document).ready(function(){
    $(".getSaveRole").click(function(){
            var roleId = $("#idrole").val();
            var namerole = $("#namerole").val();
            $.ajax({
                url: 'http://localhost:7676/api/role',
                type: 'POST',
                data: JSON.stringify({
                    roleId: roleId,
                    roleName: namerole
                }),
                contentType: 'application/json;charset=UTF-8',
                dataType: 'JSON',
                complete: function() {
                    resetFormRole();
                    reloadRoleTabel();
                },
                error: function(xhr, status, error){
                    console.log(xhr.responseText);
                    swal({
                        icon: "warning",
                        title: "Failed Save",
                        text: "Opps..something wrong !"
                    });
                }
            });
        });
});

/** showRole **/
$(document).on('click', '.showRole', function(){
    var roleId = $(this).attr("data-id");
    console.log("TEST ID ROLE ==> "+roleId);
    $.ajax({
        url: 'http://localhost:7676/api/role/'+roleId,
        type: 'GET',
        contentType: 'application/json;charset=UTF-8',
        dataType: 'JSON',
        success: function(data){
            console.log("data : "+data.id+" \n"+"name : "+data.name);
            $("#idrole").val(data.id);
            $("#namerole").val(data.name);
            $(".getUpdateRole").show();
            $(".getSaveRole").hide();
        }
    });
});

/** list role **/
$(document).ready(function(){
    var tabelRole = $("#tabelrole");
    if(tabelRole.length){
        tabelRole.DataTable({
            lengthMenu:[[5, 10, -1], ['Show 5', 'Show 10', 'Show All']],
            pageLength: 5,
            ajax: {
                url : 'http://localhost:7676/api/role',
                dataSrc: ''
            },
            columns: [
                {data: 'id'},
                {data: 'name'},
                {
                    data: 'id',
                    bSortable: false,
                    mRender:function(data, type, row){
                        var htmlStr = '';
                        htmlStr +='<button class="btn btn-primary showRole" data-id="'+data+'">';
                        htmlStr +='<span class="fa fa-edit"></button>&nbsp;';
                        htmlStr +='<button class="btn btn-danger removeRole" data-id="'+data+'">';
                        htmlStr +='<span class="fa fa-trash"></button>';
                        return htmlStr;
                    }
                }
            ]
        })
    }
});

