function readURL(input) {
    for (var i = 0; i < input.files.length; i++) {
        if (input.files[i]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                //var img = $('<img id="dynamic">');
                //img.attr('src', e.target.result);
                //img.appendTo('#form1');  
                $('.img-preview').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[i]);
        }
    }
}

$("#imgUpload").change(function () {
    readURL(this);
});


$('body').on('change', '#search-event-time', function (e) {
    var choice = $(this).val();
    
    e.preventDefault();
    $.ajax({
        url: "getEventAdmin",
        type: 'GET',
        dataType: 'html',
        data: {
             option : choice
        }
    }).done(function (ketqua) {
        $('#table-detail').html(ketqua);
        // console.log(ketqua);
    });
});

$('body').on('input', '#search-event-name', function (e) {
    var nameSearch = $(this).val();
    e.preventDefault();
    $.ajax({
        url: "getEventAdmin",
        type: 'GET',
        dataType: 'html',
        data: {
             option : 5,
             nameSearch : nameSearch
        }
    }).done(function (ketqua) {
        $('#table-detail').html(ketqua);
        // console.log(ketqua);
    });
});

