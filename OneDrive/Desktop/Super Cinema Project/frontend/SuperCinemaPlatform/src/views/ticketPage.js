import { html, render } from "../../node_modules/lit-html/lit-html.js";
import { getAllTickets, getAvailabilityById } from "../api/data.js";
import alertNotify from "../functions/notifyAlert.js";



const ticketsTemplate = (availability,tickets) => html`
    <section class="tickets-section"> 




<div class="main-ticket-container">
    <div class="container-flex">
        <div class="steps grid--cols-3 grid">
            <div><p> <span>1</span> Select ticket</p></div>
            <div><p> <span>2</span> Choose a seat</p></div>
            <div><p> <span>3</span> Finish</p></div>
       
        </div>
        <div class="details grid">
            <div class="details-reservation">
                <div><h4>${availability.movie.title}</h4></div>
                <div><p>${availability.date} ${availability.time}</p></div>
                <div><p>${availability.cinemaBuilding.name}</p></div>
                 <div><p>hall: ${availability.hall}</p></div>
            </div>
            <div class="col-2">
                <div class="main-details">
                    <h5>Select a ticket</h5>
                    <p>For now you can choose just a ticket in the future we will make a big update for this plaform</p>
                </div>
                <div class="tickets-container ">

                    ${tickets.map(ticket => {return ticketTemplate(ticket)})}
                    <div class="next-step-btn"><button id="nextStepBtn" class="btn btn-fill btn-radius btn-small">Select a seat </button></div>

                </div>
            </div>
        </div>
    </div>
</div>

</section>

<div id = 'notify ' class="notify btn-radius example"><p></p></div>


`
export async function ticketPage(ctx){

    if(!sessionStorage.getItem('availabilityId')){
        ctx.page.redirect('/')
    }
    let availabilityId = sessionStorage.getItem('availabilityId');
    let availability =  await getAvailabilityById(availabilityId);
    let tickets = await getAllTickets();

    ctx.render(ticketsTemplate(availability,tickets,redirectSeats));


    selectTicket();
    clickNextStep(availabilityId,redirectSeats);

    function redirectSeats(){
        window.location.replace('/seats');
    }
}

// ------------------------------------- //
//                TEMPLATES              //
// ------------------------------------- //

const ticketTemplate = (ticket) => html`
                    <div   class="ticket ">
                         <div class="type-ticket"><h5>${ticket.category}</h5></div>
                         <div class="ticket-price"><p>price: ${ticket.price} 	&euro;</p></div>
                         <div><button id = "${ticket.id}" class="btn btn-fill btn-radius btn-small btn-ticket">Select</button></div>
                    </div>`;

// ------------------------------------- //
//                FUNCTIONS              //
// ------------------------------------- //

function selectTicket(){

    let ticketsButtons = document.getElementsByClassName('btn-ticket');
    for(let i = 0 ; i < ticketsButtons.length; i++){

        let currentButton = ticketsButtons[i];
        currentButton.addEventListener('click',() => {
            for(let j = 0 ; j < ticketsButtons.length; j++){

                if(i != j){

                    ticketsButtons[j].innerHTML = "Select";
                    ticketsButtons[j].style.backgroundColor = ' #FCA312';
                }
            }
           
            if(currentButton.innerHTML == "Select"){
                currentButton.innerHTML = "Selected"
                currentButton.style.backgroundColor = '#d88703';
            }else{
                currentButton.innerHTML = "Select";
                
                currentButton.style.backgroundColor = ' #FCA312';
               
                
            }
        })
    }

}

function clickNextStep(availabilityId,redirectSeats){

    let nextStepBtn = document.getElementById('nextStepBtn');

    nextStepBtn.addEventListener('click', () =>{

        let ticketsButtons = document.getElementsByClassName('btn-ticket');
        let nothingSelected = true;
        for(let i = 0 ;  i < ticketsButtons.length; i++){
            let currentButton = ticketsButtons[i];
    
            if(currentButton.innerHTML == "Selected"){
                sessionStorage.setItem('ticketId',currentButton.id);
                   nothingSelected = false;
                   break;
            }
    
        }
        
        if(nothingSelected){
            alertNotify('Please select a ticket!')
        }else {
            
            redirectSeats()
        }
    })

}

