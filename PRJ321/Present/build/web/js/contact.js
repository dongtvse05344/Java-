$('body').on('click','.contact-detail',function(e){
    e.preventDefault();
    var href = $(this).attr('href');
    $.ajax({
        url : href,
        type: 'GET',
        dataType: 'html',
    }).done(function (ketqua) {
        swal(ketqua);
        //console.log(ketqua);
    });
    
});

$('body').on('click','.contact-delete',function(e){
    e.preventDefault();
    var parent = $(this).parent().parent();
    var href = $(this).attr('href');
    $.ajax({
        url : href,
        type: 'GET',
        dataType: 'html',
    }).done(function (ketqua) {
        swal("Done !!!");
        parent.remove();
    });
    
});