$('a.lock').click(function (e) {
    e.preventDefault();
    var url = $(this).attr('href');
    var box = $(this).parent().parent().parent();
    swal({
        title: "Are you sure ?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
            .then((willDelete) => {
                if (willDelete) {
                    $.ajax({
                        url: url,
                        type: 'GET',
                        dataType: 'html',

                    }).done(function () {
                        swal("Your action is success!", {
                            icon: "success",
                        });
                        box.remove();
                    });

                } else {
                }
            });
});