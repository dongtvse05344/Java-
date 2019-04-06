document.addEventListener('DOMContentLoaded', function() {
  new Typed('#typed3', {
    strings: ['Giao lưu', 'Học hỏi', 'Trau dồi kiến thức'],
    typeSpeed: 50,
    backSpeed: 0,
    smartBackspace: true,
    loop: true
  });
});


$('body').on('click','.page-item.disabled a',function(e){
    e.preventDefault();
});

$('body').on('click','.page-link.past',function(e){
    e.preventDefault();
    var index = $(this).text();
    $.ajax({
                url: 'getEventPast',
                type: 'GET',
                dataType: 'html',
                data: {
                    index : index
                }
            }).done(function(ketqua) {
                $('#eventPast').html(ketqua);
                //console.log(ketqua);
            });
});


$('body').on('click','.page-link.future',function(e){
    e.preventDefault();
    var index = $(this).text();
    $.ajax({
                url: 'getEvent',
                type: 'GET',
                dataType: 'html',
                data: {
                    index : index,
                    _case : 1
                }
            }).done(function(ketqua) {
                $('#future').html(ketqua);
                //console.log(ketqua);
            });
});

$('body').on('click','.page-link.now',function(e){
    e.preventDefault();
    var index = $(this).text();
    $.ajax({
                url: 'getEvent',
                type: 'GET',
                dataType: 'html',
                data: {
                    index : index,
                    _case : 2
                }
            }).done(function(ketqua) {
                $('#now').html(ketqua);
                //console.log(ketqua);
            });
});
$('body').on('click','.page-link.past',function(e){
    e.preventDefault();
    var index = $(this).text();
    $.ajax({
                url: 'getEvent',
                type: 'GET',
                dataType: 'html',
                data: {
                    index : index,
                    _case : 3
                }
            }).done(function(ketqua) {
                $('#past').html(ketqua);
                //console.log(ketqua);
            });
});
