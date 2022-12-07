let course_section = document.querySelectorAll(".course-lesson-container");
course_section.forEach(function (current) {
  let course_lesson = current.children[1];
  current.children[0].onclick = function () {
    if (course_lesson.style.display === "none") {
      course_lesson.style.display = "block";
    } else {
      course_lesson.style.display = "none";
    }
  };
  // current.onclick = function() {
  //     console.log(this);
  // let course_lesson = this.children[1];
  // console.log(course_lesson);
  // if(course_lesson.style.display === 'none') {
  //     course_lesson.style.display = 'block';
  // } else {
  //     course_lesson.style.display = 'none';
  // }
  // }
});

function auto_height(elem) {
  /* javascript */
  elem.style.height = "28px";
  elem.style.height = elem.scrollHeight + "px";
}

function active_comment_button(current) {
  let submit_comment = $(current).parent().next().children(".submit-comment");
  if (current.value !== "") {
    $(submit_comment).addClass("submit-comment-active");
  } else {
    $(submit_comment).removeClass("submit-comment-active");
  }
}

function show_reply_post_comment(input) {
  //    $(elem).parent().next().toggleClass('d-none');
  document.querySelector('#ShowReply' + input.getAttribute("data-cmt-reply")).classList.remove('d-none');
}

$("#course-comment-close").click(function () {
  $('.course-comment-container').hide();
});

$('.lesson-comment').click(function () {
  $('.course-comment-container').show();
})


function disableOn(input) {
  document.querySelector("#cmt" + input.getAttribute("data-cmt-id")).disabled = false;
  //    var put = document.querySelector('.content-comment');
  //    
  //    put.disabled = false;
  //    
  //    


  input.classList.add('d-none');

  document.querySelector('#NumberLikes' + input.getAttribute("data-cmt-id")).classList.add('d-none');
  document.querySelector('#Like' + input.getAttribute("data-cmt-id")).classList.add('d-none');
  document.querySelector('#Report' + input.getAttribute("data-cmt-id")).classList.add('d-none');
  document.querySelector('#dotReport' + input.getAttribute("data-cmt-id")).classList.add('d-none');
  document.querySelector('#Reply' + input.getAttribute("data-cmt-id")).classList.add('d-none');
  document.querySelector('#dotReply' + input.getAttribute("data-cmt-id")).classList.add('d-none');

  document.querySelector('#Cancel' + input.getAttribute("data-cmt-id")).classList.remove('d-none');
  document.querySelector('#Save' + input.getAttribute("data-cmt-id")).classList.remove('d-none');
}

function disableOff(input) {
  document.querySelector("#cmt" + input.getAttribute("data-cmt-cancel-id")).disabled = true;


  input.classList.add('d-none');

  document.querySelector('#NumberLikes' + input.getAttribute("data-cmt-cancel-id")).classList.remove('d-none');
  document.querySelector('#Like' + input.getAttribute("data-cmt-cancel-id")).classList.remove('d-none');
  document.querySelector('#Edit' + input.getAttribute("data-cmt-cancel-id")).classList.remove('d-none');
  document.querySelector('#Report' + input.getAttribute("data-cmt-cancel-id")).classList.remove('d-none');
  document.querySelector('#dotReport' + input.getAttribute("data-cmt-cancel-id")).classList.remove('d-none');
  document.querySelector('#Reply' + input.getAttribute("data-cmt-cancel-id")).classList.remove('d-none');
  document.querySelector('#dotReply' + input.getAttribute("data-cmt-cancel-id")).classList.remove('d-none');

  document.querySelector('#Cancel' + input.getAttribute("data-cmt-cancel-id")).classList.add('d-none');
  document.querySelector('#Save' + input.getAttribute("data-cmt-cancel-id")).classList.add('d-none');


}

function CancelReply(input) {

  document.querySelector('#ShowReply' + input.getAttribute("data-cmt-cancel-id")).classList.add('d-none');

}
 

function submit() {
  let question = document.querySelectorAll('.question')
  let output = []

  question.forEach((ques) => {
    let questionID = ques.querySelector('input[name="questionID"]').value
    let questions = {};
    questions.ques = []
    questions.ques.push({
      questionID
    });

    questions.ans = []
    let answersID = ques.querySelectorAll('input[name="answerID"]')
    answersID.forEach((ans) => {
      let ansID = ans.value
      let isCorrect = ans.nextElementSibling.checked
      questions.ans.push({ ansID, isCorrect })
    });
    output.push(questions);
  });
  let valueSubmit = document.querySelector("#valueSubmit");
  valueSubmit.value = JSON.stringify(output) 
  console.log(JSON.stringify(output))
  let formSubmit = document.querySelector("#submitForm");
   formSubmit.submit();
}