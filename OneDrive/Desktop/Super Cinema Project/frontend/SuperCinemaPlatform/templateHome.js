import runSlideShow from "./src/functions/slideShow.js";





function runApp(){
    runSlideShow();


    // editUrlFromWindow('https://www.youtube.com/watch?v=ktyJIj6i4Qw')
    let openTrailerBtn = document.getElementById('watch-trailer')

    openTrailerBtn.addEventListener('click',() =>{
        showWindow();
    })

    let closeTrailerBtn = document.getElementById('close-trailer');
    
    closeTrailerBtn.addEventListener('click',() =>{
        closeWindow();
    })



    runMobileNavBar();


}
runApp();




function showWindow (){
    let window = document.getElementsByClassName('window-container')[0];
   
    window.classList.add('open-window');
     
    setTimeout(() => {
        window.style.display = 'block';
    },1000)
}


function closeWindow (){
    let window = document.getElementsByClassName('window-container')[0];
    
    window.classList.remove('open-window');
    window.classList.add('close-window');
    setTimeout(()=>{
        window.style.display = 'none';
    },1000)
  
}


function editUrlFromWindow(url){
    url = url.replace('watch?v=','embed/');
    let embed = document.getElementsByClassName('open-trailer')[0].getElementsByTagName('embed')[0];
    embed.src = url;
}


function runMobileNavBar(){

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

