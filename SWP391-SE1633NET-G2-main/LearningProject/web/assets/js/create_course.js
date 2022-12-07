let thumbnail = document.querySelector('#thumbnail');
let avatar_preview = document.querySelector('.image-thumbnail');
let imageBase64 = document.querySelector('#imageBase64');
thumbnail.addEventListener('change', (e) => {
    if(e.target.files[0].size > 2 * 1024 * 1024) {
        alert("File is large than 2mb");
        thumbnail.value = '';
        return;
    }
    if (e.target.files.length) {
        const src = URL.createObjectURL(e.target.files[0]);
        avatar_preview.src = src;
        avatar_preview.style.display = 'block';
        $('.icon').css('display', 'none');
        $('.course-thumbnail-img').css('border', 'none');
    }
});


function createObjective() {
    let count = document.querySelectorAll('.section-create').length;
    let section_create = document.createElement('div');
    let section_list = document.querySelector('.section-list');
    let value = document.querySelector('#value').value;
    if(value === '') {
        window.alert("Objective is empty");
        return;
    }
    let number = `${count+1}.`;

    $(section_create).addClass('section-create mb-2');
    $(section_create).append(`<div class="section-title">${number} ${value}</div>`);

    section_list.appendChild(section_create);
    
    $(section_create).append(`
        <input class="d-none" type="text" name="Objectives" value="${value}"/>
    `);

    document.querySelector('#value').value = '';
    $('#staticBackdrop').modal('hide');
}

let addObjBtn = document.querySelector('.create-objectives .add-section')
let sectionContainer = document.querySelector('.section-list');
addObjBtn.addEventListener('click', function() {
    $(sectionContainer).append(`<div class="section">
    <input type="text" class="section-create mb-2 section-title" value="" style="width: 95%; height: 100%;" placeholder="Objective" name="Objectives">
    <i class="fa-solid fa-circle-xmark" onclick="$(this).parent().remove()"></i>
</div>`);
});
// function UploadThumbnail(target) {
//     var reader = new FileReader();
//     var avatar = document.getElementById("imageBase64");

//     reader.onloadend = function () {
//         const img = new Image();
//         img.src = reader.result;

//         img.onload = function () {
//             const MAX_WIDTH = 128;
//             const MAX_HEIGHT = 128;

//             let width = img.width;
//             let height = img.height;

//             if (width > height) {
//                 if (width > MAX_WIDTH) {
//                     height *= MAX_WIDTH / width;
//                     width = MAX_WIDTH;
//                 }
//             } else {
//                 if (height > MAX_HEIGHT) {
//                     width *= MAX_HEIGHT / height;
//                     height = MAX_HEIGHT;
//                 }
//             }

//             const canvas = document.createElement('canvas');
//             canvas.width = width;
//             canvas.height = height;
//             const ctx = canvas.getContext("2d");
//             ctx.drawImage(this, 0, 0, width, height);
//             const b64 = canvas.toDataURL("image/jpeg");

//             avatar.innerText = b64;
//         };
//     };

//     reader.readAsDataURL(target.files[0]);
// }

function upload(target) {
    var reader = new FileReader();
    var avatar = document.getElementById("imageBase64");
    reader.onloadend = function() {
        console.log(reader.result);
        avatar.innerText = reader.result;

    };
    reader.readAsDataURL(target.files[0]);
}

