
layer.open({
    type: 1,
    title: false,
    shadeClose: true,
    area: ['400px', '350px'],
    content: $('#box'),
    success: function(layero){

        setTimeout(function() {
            $(layero).removeClass('layer-anim');
        }, 0);
    }
});