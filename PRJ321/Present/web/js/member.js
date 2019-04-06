$('body').on('input', '#search-mem-name', function (e) {
    var nameSearch = $(this).val();
    e.preventDefault();
    $.ajax({
        url: "searchMemByName",
        type: 'GET',
        dataType: 'html',
        data: {
            nameSearch: nameSearch
        }
    }).done(function (ketqua) {
        $('#partial-view').html(ketqua);
        //console.log(ketqua);
    });
});

function revertAttr(e)
{
    if(e.val()== 'false')
    {
        e.removeClass('btn-outline-danger').addClass('btn-outline-success');
        e.val('true');
    }
    else
    {
        e.removeClass('btn-outline-success').addClass('btn-outline-danger');
        e.val('false');
    }
}

function revertAttrManager(e)
{
    e.removeClass('btn-outline-warning').addClass('btn-outline-success');
    e.val('Done !');
    e.attr('id','');
}

$('body').on('click', '#btnActive', function (e) {
    var _this = $(this);
    var username = _this.next().val();
    swal({
        title: "Are you sure change active of " + username + " ?",
        text: "Make sure this account you want to change",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
            .then((willDelete) => {
                if (willDelete) {

                    $.ajax({
                        url: "changeActiveAccount",
                        type: 'GET',
                        dataType: 'html',
                        data: {
                            Username: username,
                        }
                    }).done(function () {
                        swal("Change is Active is success", {
                            icon: "success",
                        });
                        revertAttr(_this);
                    });

                } else {
                    swal("Nothing changed");
                }
            });
});

$('body').on('click', '#addManager', function (e) {
    var _this = $(this);
    var username = _this.next().val();
    swal({
        title: "Are you sure add " + username + " to MANAGER ?",
        text: "Make sure this account you want to add",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
            .then((willDelete) => {
                if (willDelete) {

                    $.ajax({
                        url: "addManager",
                        type: 'GET',
                        dataType: 'html',
                        data: {
                            Username: username,
                        }
                    }).done(function () {
                        swal("Change is Active is success", {
                            icon: "success",
                        });
                        revertAttrManager(_this);
                    });

                } else {
                    swal("Nothing changed");
                }
            });
});