

export function detectPressHourButton(){
    let hoursBtn = document.getElementsByClassName('btn-hour');

    for(let  i = 0; i < hoursBtn.length; i++){
        hoursBtn[i].addEventListener('click',()=>{
            let currentId = hoursBtn[i].id;
            sessionStorage.setItem('availabilityId',Number(currentId))
            window.location.replace('/get-ticket');
        
        })
    }
}
