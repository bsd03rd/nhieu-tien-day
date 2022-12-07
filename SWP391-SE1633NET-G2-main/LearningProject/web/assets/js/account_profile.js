addEventListener("load", () => {
    var profile = document.querySelector('.link-profile');
    var course = document.querySelector('.link-course');
    var menu = document.querySelectorAll('.menu');

    var avatar_preview = document.querySelector('.avatar-preview img');
    var formFile = document.querySelector('.modal-body #formFile');

    /* Disable input form */
    

    formFile.addEventListener('change', (e) => {
        if (e.target.files.length) {
            const src = URL.createObjectURL(e.target.files[0]);
            avatar_preview.src = src;
        }
    });
});
    
function resetMenu() {
    menu.forEach((item) => {
        item.classList.remove('menu-active');
    });
}

function reset() {
    profile.classList.remove('active');
    course.classList.remove('active');
}

function profile_link(menu) {
    reset();
    resetMenu();
    profile.classList.add('active');
    menu.classList.add('menu-active');
}

function course_link(menu) {
    reset();
    resetMenu();
    course.classList.add('active');
    menu.classList.add('menu-active');
}

function disableOff(button) {
    var input = document.querySelectorAll('.account-information-section input');
    input.forEach((item) => {
        item.disabled = false;
    })
    button.classList.add('d-none');
    document.querySelector('#save').classList.remove('d-none');
}


function UploadAvatar(target) {
    var reader = new FileReader();
    var avatar = document.getElementById("AvatarProfile");
    
    reader.onloadend = function () {
        const img = new Image();
        img.src = reader.result;

        img.onload = function () {
            const MAX_WIDTH = 128;
            const MAX_HEIGHT = 128;

            let width = img.width;
            let height = img.height;

            if (width > height) {
                if (width > MAX_WIDTH) {
                    height *= MAX_WIDTH / width;
                    width = MAX_WIDTH;
                }
            } else {
                if (height > MAX_HEIGHT) {
                    width *= MAX_HEIGHT / height;
                    height = MAX_HEIGHT;
                }
            }

            const canvas = document.createElement('canvas');
            canvas.width = width;
            canvas.height = height;
            const ctx = canvas.getContext("2d");
            ctx.drawImage(this, 0, 0, width, height);
            const b64 = canvas.toDataURL("image/jpeg");

            avatar.innerText = b64;
        };
    };

    reader.readAsDataURL(target.files[0]);
}