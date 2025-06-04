$(document).ready(function () {
    $('.tab-section').hide();
    $('#Home').show();
    $('a[href^="#"]').click(function (e) {
      e.preventDefault();
      var target = $(this).attr('href');
      $('.tab-section').hide();
      $(target).show();
    });
    $('input.Quick-Action-Button').click(function () {
        var target=$(this).data('target');
    	if(target){
    		$('.tab-section').hide();
    		$(target).show();
      });
  });
