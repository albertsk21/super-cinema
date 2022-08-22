import { html} from "../../node_modules/lit-html/lit-html.js";
import { getAvailabilityById, getReservationById } from "../api/data.js";



let finishTemplate = (availability,reservation) => html`
        <section class="form-section"> 

<div class="main-form-container">
    <div class="container-flex container-finish">
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
                 <div><p>seat: ${reservation.seatNumber}</p></div>
                 <div><p>type ticket: ${reservation.ticket.category}</p></div>
                 <div><p>price ticket: ${reservation.ticket.price} 	&euro;</p></div>
                 <div><p>e-mail: ${reservation.customer.email}</p></div>
                 <div><p>full name: ${reservation.customer.firstName} ${reservation.customer.lastName}</p></div>
                 <div><p>phone number:  ${reservation.customer.phoneNumber}</p></div>
            </div>
            <div class="col-2-finish">
            <div class="main-details-finish  ">
                
                <div class="finish-box"> 
                    <div class="check-box"><ion-icon name="checkbox-outline"></ion-icon></div>
                    <div>
                        <div><h5>Thank you ${reservation.customer.firstName}!</h5></div>
                        <div><h5>Your reservation has been processed</h5></div>
                        <div><h5>Enjoy your movie :D</h5></div>
                    </div>
                </div>
             
            </div>


                <div class="next-step-btn"><a href = "/" class=" btn big-btn-form btn-link btn-fill btn-radius btn-small">Back to the HomePage</a></div>

         

            </div>
        </div>
    </div>
</div>
</section>

`

export async function finishPage(ctx){
    let availability = await getAvailabilityById(sessionStorage.getItem('availabilityId'));
    let reservation = await getReservationById(sessionStorage.getItem('reservationId'));



    ctx.render(finishTemplate(availability,reservation))
    sessionStorage.clear();
}