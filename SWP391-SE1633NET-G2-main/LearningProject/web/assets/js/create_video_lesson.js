function video_preview() {
    // let src = current.value;
    console.log($('#video-url').val());
    let video_url = $('#video-url').val();
    let video_id = youtube_parser(video_url);
    $('#url-preview').attr('src', 'https://www.youtube.com/embed/' + video_id);
    $('#url-preview').css('display', 'block');
    console.log($('#url-preview').attr('src'));
    $('.icon-youtube').css('display', 'none');
    $('#video-URL').val($('#url-preview').attr('src'));
}

function youtube_parser(url){
    var regExp = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#&?]*).*/;
    var match = url.match(regExp);
    return (match&&match[7].length==11)? match[7] : false;
}

function video_preview_update() {
    // let src = current.value;
    console.log($('#VideoLink').val());
    let video_url = $('#VideoLink').val();
    let video_id = youtube_parser(video_url);
    $('#Url-preview').attr('src', 'https://www.youtube.com/embed/' + video_id);
    $('#Url-preview').css('display', 'block');
    console.log($('#Url-preview').attr('src'));
    $('.icon-youtube').css('display', 'none');
    $('#videolink').val($('#Url-preview').attr('src'));
}