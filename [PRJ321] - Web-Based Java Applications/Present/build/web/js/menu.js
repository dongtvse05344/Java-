$(window).scroll(function(event) {
		if ($('html,body').scrollTop() > 200)
	 	{
	 		$('.menu').addClass('show');
	 	}
 		else 
	 	{
	 		$('.menu').removeClass('show');
	 	}
 	});
$('#sub').click(function(e)
{
    if($(this).next().hasClass("active"))
    {
        $(this).next().removeClass("active");
    }
    else
    {
        $(this).next().addClass("active");
    }
    
});
