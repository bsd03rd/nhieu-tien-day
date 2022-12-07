// function addAnswer() {
//   let answerContent = $("#addAnswer").val();
//   let isAnswer = $("#isAnswer").prop("checked");
//   if (answerContent !== "") {
//     if (isAnswer) {
//       $("#AnswerList").append(`
//             <div class="mb-3">
//                 <input type="hidden" name="answer" value="${answerContent}-true">
//                 <div class="card card-body w-50 bg-success text-white d-inline-block">
//                     ${answerContent}
//                 </div>
//                 <div class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editAnswerModal" onclick="editAnswer($(this).prev())">Edit</div>
//                 <div class="btn btn-danger d-inline-block" onclick="remove(this.parentNode)">Remove</div>
//             </div>
//             `);
//     } else {
//       $("#AnswerList").append(`
//             <div class="mb-3">
//                 <input type="hidden" name="answer" value="${answerContent}-false">
//                 <div class="card card-body w-50 bg-danger text-white d-inline-block">
//                     ${answerContent}
//                 </div>
//                 <div class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editAnswerModal" onclick="editAnswer($(this).prev())">Edit</div>
//                 <div class="btn btn-danger d-inline-block" onclick="remove(this.parentNode)">Remove</div>
//             </div>
//             `);
//     }
//     $("#addAnswer").val("");
//     $("#isAnswer").prop("checked", false);
//     $("#addAnswerModal").modal("toggle");
//   } else {
//     window.alert("Answer content is empty");
//   }
// }

// function remove(current) {
//   current.remove();
// }
// let editAnswerObj = null;
// function editAnswer(current) {
//   editAnswerObj = current;
//   let answerContent = $(current).html().trim();
//   // console.log(answerContent);
//   let isAnswer = false;

//   if ($(current).hasClass("bg-success")) {
//     isAnswer = true;
//   }

//   $("#editAnswer").val(answerContent);

//   if (isAnswer) {
//     $("#editIsAnswer").prop("checked", true);
//   } else {
//     $("#editIsAnswer").prop("checked", false);
//   }
//   // console.log($(editAnswerObj).text());
// }

// function saveEditAnswer() {
//   let editAnswerContent = document.getElementById("editAnswer");
//   let isAnswer = document.getElementById("editIsAnswer");

//   $(editAnswerObj).html(editAnswerContent.value);

//   let valueHidden = $(editAnswerObj).prev();
//   if (isAnswer.checked) {
//     $(valueHidden).val(editAnswerContent.value + "-true");
//     console.log($(valueHidden).val());
//   } else {
//     $(valueHidden).val(editAnswerContent.value + "-false");
//     console.log($(valueHidden).val());
//   }

//   //Nếu như tích answer và obj là btn-danger → đổi màu
//   if (isAnswer.checked && $(editAnswerObj).hasClass("bg-danger")) {
//     $(editAnswerObj).removeClass("bg-danger");
//     $(editAnswerObj).addClass("bg-success");
//   }

//   //Nếu như bỏ tích answer mà obj là btn-success → đổi
//   if (!isAnswer.checked && $(editAnswerObj).hasClass("bg-success")) {
//     $(editAnswerObj).removeClass("bg-success");
//     $(editAnswerObj).addClass("bg-danger");
//   }

//   editAnswerObj = null;
//   $("#editAnswerModal").modal("toggle");
// }

function addAnswerPrev(current) {
  console.log($(current).prev());
  $(current).before(`
  <div class="mt-3">
  <div class="d-flex align-items-center">
      <input name="answerID" type="hidden" value="null">

      <div class="form-check">
          <input class="form-check-input" type="checkbox">
      </div>
      
      <input type="text" class="card card-body mb-2" name="answer">
      
      <button type="button" class="btn-close ms-3" aria-label="Close" onclick="$(this).parent().parent().remove()"></button>
  </div>
  
</div>
  `);
}

function updateRowCount() {
  $("table tbody tr").each(function () {
    $(this)
      .find(".index")
      .html($(this).index() + 1);
  });
}

function addQuestion() {
  $("#questionTable").append(`
  <!--Begin Question -->
  <tr>
      <td class="index"></td>
      <td style="width: 80%;">
          <div class="card mb-2" style="border-radius: 8px;">
              <div class="card-body" >
                  <input name="questionID" type="hidden" value="null">
                  <textarea name="questionContent" class="fw-bold form-control" style="overflow-y: hidden;" oninput='this.style.height = "";this.style.height = this.scrollHeight + "px"'></textarea>
                  <div class="mt-3">
                      <div class="d-flex align-items-center">
                          <input name="answerID" type="hidden" value="null">

                          <div class="form-check">
                              <input class="form-check-input" type="checkbox">
                          </div>
                          
                          <input type="text" class="card card-body mb-2" name="answer">
                          
                          <button type="button" class="btn-close ms-3" aria-label="Close" onclick="$(this).parent().parent().remove()"></button>
                      </div>
                      
                  </div>
                  <div class="btn btn-primary mt-2" onclick="addAnswerPrev(this)">Add answer</div>
              </div>
          </div>
      </td>
      <td>
          <div class="btn btn-outline-danger mb-2" onclick="deleteQuestion(this)">Delete</div>
      </td>
  </tr>
  <!-- End Question -->
    `);
  updateRowCount();
}

function deleteQuestion(current) {
  $(current).parent().parent().remove();
  updateRowCount();
}

function submit() {
  const outputData = [];
  document.querySelectorAll("#questionTable > tr").forEach((question) => {
    let newQuestion = {};
    newQuestion.ques = [];
    let questionID = question.querySelector('input[name="questionID"]').value;
    let questionContent = question.querySelector(
      'textarea[name="questionContent"]'
    ).value;
    newQuestion.ques.push({
      questionID,
      questionContent
    });

    newQuestion.ans = [];

    const anws = question.querySelectorAll('input[name="answer"]');
    anws.forEach((ans) => {
      const val = ans.value;
      const isCorrect =
        ans.previousElementSibling.querySelector("input").checked;
      const answerID = ans.previousElementSibling.previousElementSibling.value;
      newQuestion.ans.push({
        answerID,
        val,
        isCorrect,
      });
    });
    
    outputData.push(newQuestion);
  });
  let valueSubmit = document.querySelector("#valueSubmit");
  valueSubmit.value = JSON.stringify(outputData);
  console.log(valueSubmit.value);
  let formSubmit = document.querySelector("#submitForm");
  formSubmit.submit();
}

function submit1() {
  window.alert("Update successful");
  const outputData = [];
  document.querySelectorAll("#questionTable > tr").forEach((question) => {
    let newQuestion = {};
    newQuestion.ques = [];
    let questionID = question.querySelector('input[name="questionID"]').value;
    let questionContent = question.querySelector(
      'textarea[name="questionContent"]'
    ).value;
    newQuestion.ques.push({
      questionID,
      questionContent
    });

    newQuestion.ans = [];

    const anws = question.querySelectorAll('input[name="answer"]');
    anws.forEach((ans) => {
      const val = ans.value;
      const isCorrect =
        ans.previousElementSibling.querySelector("input").checked;
      const answerID = ans.previousElementSibling.previousElementSibling.value;
      newQuestion.ans.push({
        answerID,
        val,
        isCorrect,
      });
    });
    
    outputData.push(newQuestion);
  });
  let valueSubmit = document.querySelector("#valueSubmit");
  valueSubmit.value = JSON.stringify(outputData);
  console.log(valueSubmit.value);
  let formSubmit = document.querySelector("#submitForm");
  formSubmit.submit();
}
