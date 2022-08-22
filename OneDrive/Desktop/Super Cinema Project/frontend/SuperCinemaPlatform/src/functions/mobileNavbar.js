


export function runMobileNavBar(){

    let button = document.getElementsByClassName('mobile-nav')[0]


    let mainNav = document.getElementsByClassName('main-nav')[0];

    button.addEventListener('click',() =>{

        if(mainNav.classList.contains('nav-open')){
            mainNav.classList.remove('nav-open');
        }else{
            mainNav.classList.add('nav-open');
        }
    });



}
