


export default function alertNotify(message){

    let notify = document.getElementsByClassName('notify')[0];
    let output = notify.getElementsByTagName('p')[0];
    output.innerHTML = message;
    notify.style.display = 'block';
    notify.classList.add('example')
    setTimeout(() =>{
        
        notify.style.display = 'none';
        notify.classList.remove('example')
    },3000)

  

}