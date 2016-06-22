$(function() {
	$('.field, textarea').focus(function() {
        if(this.title==this.value) {
            this.value = '';
        }
    }).blur(function(){
        if(this.value=='') {
            this.value = this.title;
        }
    });

    $('.product-holder').hover( function(){
    	$(this).find('.product').addClass('active');
    	$(this).find('.product-bottom').addClass('active');
    } , function() {
    	$(this).find('.product').removeClass('active');
    	$(this).find('.product-bottom').removeClass('active');    		
    });

    $(".product").click(function(){
        window.location=$(this).find("a").attr("href");
     return false;
    });

    $("#slider").jcarousel({
        scroll: 1,
        auto: 3,
        wrap: 'both',
        initCallback: mycarousel_initCallback,        
        buttonNextHTML: null,
        buttonPrevHTML: null,
         itemVisibleInCallback: {
            onAfterAnimation: function(c, o, i, s) {
                $('.jcarousel-control a').removeClass('active');
                $('.jcarousel-control a:eq('+ (i-1) +')').addClass('active');
            }
        }
    });

    if ($.browser.msie && $.browser.version == 6) {
        DD_belatedPNG.fix('#wrapper-top, #wrapper-bottom, .bottom, .product img, a.order-button, #slider img, #prev, #next, .cart');
    }

    var width =  20 * $('.jcarousel-control a').length;    
    $('.jcarousel-control').width(width+24);
    var left_pos = (921 - width) / 2;
    $('.jcarousel-control').css('left' , left_pos );    
});

function mycarousel_initCallback(carousel) {
    $('.jcarousel-control a').bind('click', function() {
        $('.jcarousel-control a').removeClass('active');
        $(this).addClass('active');
        carousel.scroll(jQuery.jcarousel.intval(jQuery(this).text()));
        return false;
    });

    $('#next').bind('click', function() {
        carousel.next();
        return false;
    });

    $('#prev').bind('click', function() {
        carousel.prev();
        return false;
    });
};    