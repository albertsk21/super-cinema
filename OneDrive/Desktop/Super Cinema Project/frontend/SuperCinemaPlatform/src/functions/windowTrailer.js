

export function showWindow (){
    let window = document.getElementsByClassName('window-container')[0];
   
    window.classList.add('open-window');
     
    setTimeout(() => {
        window.style.display = 'block';
    },1000)
}


export function closeWindow (){
    let window = document.getElementsByClassName('window-container')[0];
    window.classList.remove('open-window');
    window.classList.add('close-window');
    setTimeout(()=>{
        window.style.display = 'none';
    },1000)
  
}


export function editUrlFromWindow(url){
    url = url.replace('watch?v=','embed/');
    let embed = document.getElementsByClassName('open-trailer')[0].getElementsByTagName('embed')[0];
    embed.src = url;
}

export function editUrlForEmbed(url){
    url = url.replace('watch?v=','embed/');
    return url;
}
