/* Notification Show*/
var bell = document.querySelector(".header-notification");
var notification = document.querySelector(".notification-cotainer");

bell.addEventListener('click', function() {
    console.log('click');
    notification.classList.toggle('show-noti');
})

/* Menu Account Show */
var avatar = document.querySelector('.avatar img');
var account_menu = document.querySelector('.account-menu');

avatar.addEventListener('click', function() {
    console.log('click avatar');
    console.log(account_menu);
    account_menu.classList.toggle('show-accmenu');
})

/* Click on bar button */
var bar_button = document.querySelectorAll('#side-bar .bar-button');

function reset() {
    for(var i = 0; i < bar_button.length; i++) {
        bar_button[i].classList.remove('button-hover');
        console.log('hello');
    }
}

bar_button.forEach((item, index) => {
    item.addEventListener('click', function() {
        reset();
        item.classList.add('button-hover');
    })
})

/* Click home */
var main = document.querySelector('#main');
main.addEventListener('click', function() {
    if(account_menu.classList.contains('show-accmenu')) {
        account_menu.classList.remove('show-accmenu');
    }
    if(notification.classList.contains('show-noti')) {
        notification.classList.remove('show-noti');
    }
})