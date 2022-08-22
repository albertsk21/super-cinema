
import { html} from "../../node_modules/lit-html/lit-html.js";
import { createReservation, getAvailabilityById, getTicketById } from "../api/data.js";
import alertNotify from "../functions/notifyAlert.js";

const formTemplate = (availability,ticket,seat , onSubmit) => html`

    <section class="form-section"> 
        <div class="main-form-container">
            <div class="container-flex container-from">
                <div class="steps grid--cols-3 grid">
                    <div><p> <span>1</span> Select ticket</p></div>
                    <div><p> <span>2</span> Choose a seat</p></div>
                    <div><p> <span>3</span> Finish</p></div>
            
                </div>
                <div class="details grid">
                    <div class="details-reservation details-form">
                        <div><h4>${availability.movie.title}</h4></div>
                        <div><p>${availability.date} ${availability.time}</p></div>
                        <div><p>${availability.cinemaBuilding.name}</p></div>

                        <div><p>hall: ${availability.hall}</p></div>
                        <div><p>seat: ${seat}</p></div>
                        <div><p>type ticket: ${ticket.category}</p></div>
                        <div><p>price ticket: ${ticket.price} 	&euro;</p></div>
                    </div>
                    <div class="col-2">
                        <div class="main-details">
                            <h5>Your Details</h5>
                            <p>All fields are required.</p>
                        
                        </div>

                        <div class="back-form-btn "><button  class="btn big-btn-form btn-fill btn-radius btn-small">Back</button></div>
                
                        <div class="details-from  ">
                            <form @submit = ${onSubmit} action="" class="grid grid--cols-2">
                    
                        
                                <div class=" form-item first-name">
                                    <input type="text" id="first-name" name="first-name"  placeholder="First Name">
                                </div>
                    
                                <div class=" form-item  last-name">
                                    <input type="text" id="last-name" name="last-name" class="" placeholder="Last Name">
                                </div>
                    
                                <div class=" form-item  email">
                                    <input type="email" id="email" name="email" class="email" placeholder="E-mail">
                                </div>
                    
                                <div class=" form-item  phone">
                                    <input type="phone" id="phone" name="phone" class="phone" placeholder="Phone Number">
                                </div>
                                <div class="next-step-btn"><input type="submit" class="btn  big-btn-form btn-fill btn-radius btn-small" value="Finish"></div>
                    
                    
                    
                    
                            </form>
                        </div>
                
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div id = 'notify ' class="notify btn-radius example"><p></p></div>

`

export async function formCustomerPage(ctx){


    if(!sessionStorage.getItem('availabilityId')){
        ctx.page.redirect('/')
    }
    let availability = await getAvailabilityById(sessionStorage.getItem('availabilityId'));
    let ticket = await getTicketById(sessionStorage.getItem('ticketId'));
    let seat = sessionStorage.getItem('seatNumber');

    ctx.render(formTemplate(availability,ticket,seat, onSubmit))

    

    let backBtn = document.getElementsByClassName('back-form-btn')[0];

    backBtn.addEventListener('click', () =>{
        backToSeatsPage();
    })
    
function backToSeatsPage(){
    ctx.page.redirect(`/get-ticket`);
}

async function onSubmit(e){

    e.preventDefault();


    const data = new FormData(e.target);

    const firstName = data.get('first-name');
    const lastName = data.get('last-name');
    const email = data.get('email');
    const phoneNumber = data.get('phone');


    if(firstName == '' || lastName == '' || email == '' ||  phoneNumber == ''){
            return alertNotify('Fields cannot be empty!')
    }else{

        let reservation = {
            date : encodeURIComponent(availability.date),
            hall : encodeURIComponent(availability.hall),
            seat,
            firstName,
            lastName,
            phoneNumber : encodeURIComponent(phoneNumber),
            customerEmail : encodeURIComponent(email),
            hour : encodeURIComponent(availability.time),
            cinemaName : encodeURIComponent(availability.cinemaBuilding.name),
            ticket : encodeURIComponent(ticket.category),
            availabilityId : sessionStorage.getItem('availabilityId')
        }

       let getReservation = await createReservation(reservation);
       sessionStorage.setItem('reservationId',getReservation.id);

  
       window.location.replace('/finish');
    }
}




}

