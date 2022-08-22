export default function runSlideShow(){

    let items = document.getElementsByClassName("carousel-item");
    let forwardButton = document.getElementById("btn-forward");
    let backButon = document.getElementById("btn-back");

    let dots = document.getElementsByClassName("carousel-inidicator");

    forwardButton.addEventListener("click", () =>{
            for(let i = 0 ; i < items.length; i++){
                let item = items[i];

                if(item.classList.contains("active-carousel-item")){
                    item.classList.remove("active-carousel-item");
                    
                    disableAllDots();
                    if(i == items.length - 1){
                         i= 0;
                                              
                    }else{
                        i++;
                    }

                    items[i].classList.add("active-carousel-item")       
                    dots[i].classList.add("active-dot")

                }
            }
    });
    backButon.addEventListener("click", () =>{
        for(let i = 0 ; i < items.length; i++){
            let item = items[i];

            if(item.classList.contains("active-carousel-item")){
                item.classList.remove("active-carousel-item");
                disableAllDots();
                if(i == 0){
                   
                    i = items.length - 1;
                 
                }else{
                    i--;
                }
                items[i].classList.add("active-carousel-item");
                dots[i].classList.add("active-dot")
            }
        }
    })

    for(let i = 0 ; i < dots.length; i++){

        let dot = dots[i];

        dot.addEventListener("click", () =>{
            hideCarouselItems();
            disableAllDots();
            dot.classList.add("active-dot");
            items[i].classList.add("active-carousel-item");
        })

    }

    showSlides();

}

function hideCarouselItems(){

    let items = document.getElementsByClassName("carousel-item");
    for(let i = 0 ; i < items.length; i++){
        let item = items[i];
        if(item.classList.contains("active-carousel-item")){
            item.classList.remove("active-carousel-item");
            break;
        }
    }
}

function disableAllDots(){
    let dots = document.getElementsByClassName("carousel-inidicator");
    for(let i = 0; dots.length ; i++ ){
        
        if(dots[i].classList.contains("active-dot")){
            dots[i].classList.remove("active-dot");
            break;
        }
    }
}

function showSlides(){
    let dots = document.getElementsByClassName("carousel-inidicator");
    let items = document.getElementsByClassName("carousel-item");

    let index = 0;
    for(let i = 0 ; i < dots.length; i++){
        if(dots[i].classList.contains("active-dot")){
            dots[i].classList.remove("active-dot");
            index = i;
        }
    }
    hideCarouselItems()
    if(index == dots.length - 1){
      
        items[0].classList.add("active-carousel-item");
        dots[0].classList.add("active-dot");
    }else {
        
        index++;
        items[index].classList.add("active-carousel-item");
        dots[index].classList.add("active-dot");
    }

    setTimeout(showSlides,6000);
}