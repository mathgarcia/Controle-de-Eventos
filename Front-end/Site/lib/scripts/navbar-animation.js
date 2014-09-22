		$(function() {
			$('#header_nav').data('size', 'big');
		});

		$(window).scroll(function() {
			if ($(document).scrollTop() > 0) {
				if ($('#header_nav').data('size') == 'big') {
					$('#header_nav').addClass('pos-final');
					$('#header_nav').data('size', 'small');
					$('#header_nav').stop().animate({
						height: '60px'
					}, 600);
					$('#turu').stop().animate({
						width: '70px',
						height: '50px',
						marginTop: '5px'
					}, 600);
					$('.nav-middle').stop().animate({
						marginTop: '5px'
					}, 600);
				}
			} else {
				if ($('#header_nav').data('size') == 'small') {

					$('#header_nav').removeClass('pos-final');
					$('#header_nav').data('size', 'big');
					$('#header_nav').stop().animate({
						height: '100px'
					}, 600);
					$('#turu').stop().animate({
						width: '95px',
						height: '65px',
						marginTop: '15px'
					}, 600);
					$('.nav-middle').stop().animate({
						marginTop: '20px'
					}, 600);
				}
			}
		});