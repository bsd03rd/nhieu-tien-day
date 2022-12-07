function rating() {
    let star = document.querySelectorAll('.star-rating-element');
    let rate_star = document.querySelector('#rate-star'); 
    star.forEach(function(current, i) {
        current.addEventListener('click', function() {
            let currentIndex = i + 1;
            rate_star.value =  currentIndex;
            star.forEach(function(current_star, j) {
                if(currentIndex >= j + 1) {
                    current_star.classList.remove('fa-regular');
                    current_star.classList.add('fa-solid');
                } else {
                    current_star.classList.remove('fa-solid');
                    current_star.classList.add('fa-regular');
                }
            }) 
        })
    })
}