$(document).ready(function () {
    $('.tab-section').hide();
    $('#Home').show();
    $('a[href^="#"]').click(function (e) {
      e.preventDefault();
      var target = $(this).attr('href');
      $('.tab-section').hide();
      $(target).show();
    });
    $('input[type=button][[href^="#"]').click(function (e) {
        e.preventDefault();
        var target = $(this).attr('href');
        $('.tab-section').hide();
        $(target).show();
      });
  });