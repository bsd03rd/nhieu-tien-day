/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

async function doSubmit() {
    // get video id from video-link
    try {
        const videoLink = document.querySelector('input[name="url"]').value;
        const videoId = videoLink.split('watch?v=')[1];

        const API_KEY = "AIzaSyBBcUOX-BytFmB96iWqMBIsRLzTgP0hhWQ";

        // use google api for get video detail
        const duration = await fetch(`https://www.googleapis.com/youtube/v3/videos?id=${videoId}&part=contentDetails&key=${API_KEY}`).then(res => res.json()).then(res => res.items[0].contentDetails.duration);
        console.log(duration);
        const parseDuration = (d) => {
            const match = d.match(/PT(\d+H)?(\d+M)?(\d+S)?/);
            const hours = (parseInt(match[1]) || 0);
            const minutes = (parseInt(match[2]) || 0);
            const seconds = (parseInt(match[3]) || 0);
            return hours * 3600 + minutes * 60 + seconds;
        };

        // parse duration to seconds
        const durationInSeconds = parseDuration(duration);

        // set video-length value
        document.querySelector('input[name="duration"]').value = durationInSeconds * 1000;
        document.querySelector('form[data-type="video"]').submit();
        //document.querySelector('form').submit();
    } catch (error) {
        alert('Invalid video link');
    }
}

function Forward(target) {
    if (target.getAttribute("data-lesson-type") == "Video") {
        document.getElementById("LessonVideoName").value = target.getAttribute("data-lesson-name");
        document.getElementById("VideoLink").value = target.getAttribute("data-video-url");
        document.getElementById("LessonVideoId").value = target.getAttribute("data-lesson-id");
    } else if (target.getAttribute("data-lesson-type") == "Docs") {
        tinyMCE.activeEditor.setContent('');
        document.getElementById("LessonDocsName").value = target.getAttribute("data-lesson-name");
        document.getElementById("Time").value = target.getAttribute("data-lesson-time");        
        document.getElementById("LessonDocsId").value = target.getAttribute("data-lesson-id");
        tinymce.activeEditor.selection.setContent(document.getElementById("docs-content-" + document.getElementById("LessonDocsId").value).value);
    } else {
        document.getElementById("LessonQuizTitle").value = target.getAttribute("data-lesson-name");
        document.getElementById("LessonQuizTime").value = target.getAttribute("data-lesson-time");
        document.getElementById("LessonQuizId").value = target.getAttribute("data-lesson-id");
    }
}

//function doSubmit2() {
//    // get video id from video-link
//
//    const videoLink = document.querySelector('input[name="VideoLink"]').value;
//    const videoId = videoLink.split('watch?v=')[1];
//
//    const API_KEY = "AIzaSyBBcUOX-BytFmB96iWqMBIsRLzTgP0hhWQ"
//
//    // use google api for get video detail
//    fetch(`https://www.googleapis.com/youtube/v3/videos?id=${"${videoId}"}&part=contentDetails&key=${"${API_KEY}"}`)
//            .then(res => res.json())
//            .then(res => res.items[0].contentDetails.duration).then(duration => {
//        console.log(duration);
//        const parseDuration = (d) => {
//            const match = d.match(/PT(\d+H)?(\d+M)?(\d+S)?/);
//            const hours = (parseInt(match[1]) || 0);
//            const minutes = (parseInt(match[2]) || 0);
//            const seconds = (parseInt(match[3]) || 0);
//            return hours * 3600 + minutes * 60 + seconds;
//        };
//
//        // parse duration to seconds
//        const durationInSeconds = parseDuration(duration);
//
//        // set video-length value
//        document.querySelector('input[name="time_duration"]').value = durationInSeconds * 1000;
//        document.querySelector('form[data-type="Video"]').submit();
//    }).catch(error => alert('Invalid video link'));
//
//}

async function doSubmit2() {
    // get video id from video-link
    try {
        const videoLink = document.querySelector('input[name="VideoLink"]').value;
        const videoId = videoLink.split('watch?v=')[1];

        const API_KEY = "AIzaSyBBcUOX-BytFmB96iWqMBIsRLzTgP0hhWQ";

        // use google api for get video detail
        const duration = await fetch(`https://www.googleapis.com/youtube/v3/videos?id=${videoId}&part=contentDetails&key=${API_KEY}`).then(res => res.json()).then(res => res.items[0].contentDetails.duration);
        console.log(duration);
        const parseDuration = (d) => {
            const match = d.match(/PT(\d+H)?(\d+M)?(\d+S)?/);
            const hours = (parseInt(match[1]) || 0);
            const minutes = (parseInt(match[2]) || 0);
            const seconds = (parseInt(match[3]) || 0);
            return hours * 3600 + minutes * 60 + seconds;
        };

        // parse duration to seconds
        const durationInSeconds = parseDuration(duration);

        // set video-length value
        document.querySelector('input[name="time_duration"]').value = durationInSeconds * 1000;
        document.querySelector('form[data-type="Video"]').submit();
        //document.querySelector('form').submit();
    } catch (error) {
        alert('Invalid video link');
    }
}