/** list users info **/
$(document).ready(function(){
    var tabel = $("#tabelUsersInfo");
    if(tabel.length){
        tabel.DataTable({
            lenthMenu: [[5, 10, -1], ['Show 5', 'Show 10', 'Show All']],
            pageLenth: 5,
            ajax:{
                url: 'http://localhost:7676/api/users',
                dataSrc: ''
            },
            columns : [
                {data:'id'},
                {data:'name'},
                {data:'username'},
                {data:'status'},
                {
                    data:'id',
                    bSortable:false,
                    mRender:function(data, type, row){
                        var htmlStr = '';
                        htmlStr += '<button class="btn btn-primary showUsers" data-id="'+data+'">';
                        htmlStr += '<span class="fa fa-edit"></span></button>&nbsp;';
                        htmlStr += '<button class="btn btn-danger disabledUsers" data-id="'+data+'">';
                        htmlStr += '<span class="fa fa-trash"></span></button>';
                        return htmlStr;
                    }
                 }
            ]
        })
    }
});