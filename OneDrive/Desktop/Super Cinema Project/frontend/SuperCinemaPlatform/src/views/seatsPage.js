import { html} from "../../node_modules/lit-html/lit-html.js";
import { getAvailabilityById, getSeatsByAvailabilityId } from "../api/data.js";
import alertNotify from "../functions/notifyAlert.js";

    let seatsTemplate = (availability) => html`
    

    <section class="seats-section">
        <div class="main-seats-container">
            <div class="seats-container-flex">
                <div class="hall-name"><p>hall: ${availability.hall}</p></div>
                <div class="door"></div>
                <div class="cinema-display"></div>


                <div class="seats">
                    
                <div class=" numbers numbers-left">
                    <div><p>1</p></div>
                    <div><p>2</p></div>
                    <div><p>3</p></div>
                    <div><p>4</p></div>
                    <div><p>5</p></div>
                    <div><p>6</p></div>
                </div>
                <div class=" numbers numbers-right">
                    <div><p>1</p></div>
                    <div><p>2</p></div>
                    <div><p>3</p></div>
                    <div><p>4</p></div>
                    <div><p>5</p></div>
                    <div><p>6</p></div>
                </div>
                    <div class=" col col--w-40 grid--cols-10 grid">
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                     </div>
                    <div class=" numbers-seat-grid col col--w-40 grid--cols-10 grid">
                        <div class="nunber-seat">1</div>
                        <div class="nunber-seat">2</div>
                        <div class="nunber-seat">3</div>
                        <div class="nunber-seat">4</div>
                        <div class="nunber-seat">5</div>
                        <div class="nunber-seat">6</div>
                        <div class="nunber-seat">7</div>
                        <div class="nunber-seat">8</div>
                        <div class="nunber-seat">9</div>
                        <div class="nunber-seat">10</div>

                     </div>

                    <div class=" col  col--w-60 grid--cols-15 grid">
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                     </div>
                     <div class=" numbers-seat-grid col col--w-40 grid--cols-15 grid">
                        <div class="nunber-seat">11</div>
                        <div class="nunber-seat">12</div>
                        <div class="nunber-seat">13</div>
                        <div class="nunber-seat">14</div>
                        <div class="nunber-seat">15</div>
                        <div class="nunber-seat">16</div>
                        <div class="nunber-seat">17</div>
                        <div class="nunber-seat">18</div>
                        <div class="nunber-seat">19</div>
                        <div class="nunber-seat">20</div>
                        <div class="nunber-seat">21</div>
                        <div class="nunber-seat">22</div>
                        <div class="nunber-seat">23</div>
                        <div class="nunber-seat">24</div>
                        <div class="nunber-seat">25</div>

                     </div>
                    <div class=" col  col--w-60 grid--cols-15 grid">
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                     </div>
                     <div class=" numbers-seat-grid col col--w-40 grid--cols-15 grid">
                        <div class="nunber-seat">26</div>
                        <div class="nunber-seat">27</div>
                        <div class="nunber-seat">28</div>
                        <div class="nunber-seat">29</div>
                        <div class="nunber-seat">30</div>
                        <div class="nunber-seat">31</div>
                        <div class="nunber-seat">32</div>
                        <div class="nunber-seat">33</div>
                        <div class="nunber-seat">34</div>
                        <div class="nunber-seat">35</div>
                        <div class="nunber-seat">36</div>
                        <div class="nunber-seat">37</div>
                        <div class="nunber-seat">38</div>
                        <div class="nunber-seat">39</div>
                        <div class="nunber-seat">40</div>

                     </div>
                    <div class=" col  col--w-60 grid--cols-20 grid">
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                     </div>
                     <div class=" numbers-seat-grid col col--w-40 grid--cols-20 grid">
                        <div class="nunber-seat">41</div>
                        <div class="nunber-seat">42</div>
                        <div class="nunber-seat">43</div>
                        <div class="nunber-seat">44</div>
                        <div class="nunber-seat">45</div>
                        <div class="nunber-seat">46</div>
                        <div class="nunber-seat">47</div>
                        <div class="nunber-seat">48</div>
                        <div class="nunber-seat">49</div>
                        <div class="nunber-seat">50</div>
                        <div class="nunber-seat">51</div>
                        <div class="nunber-seat">52</div>
                        <div class="nunber-seat">53</div>
                        <div class="nunber-seat">54</div>
                        <div class="nunber-seat">55</div>
                        <div class="nunber-seat">56</div>
                        <div class="nunber-seat">57</div>
                        <div class="nunber-seat">58</div>
                        <div class="nunber-seat">59</div>
                        <div class="nunber-seat">60</div>

                     </div>
                    <div class=" col  col--w-60 grid--cols-20 grid">
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                     </div>
                     <div class=" numbers-seat-grid col col--w-40 grid--cols-20 grid">
                        <div class="nunber-seat">61</div>
                        <div class="nunber-seat">62</div>
                        <div class="nunber-seat">63</div>
                        <div class="nunber-seat">64</div>
                        <div class="nunber-seat">65</div>
                        <div class="nunber-seat">66</div>
                        <div class="nunber-seat">67</div>
                        <div class="nunber-seat">68</div>
                        <div class="nunber-seat">69</div>
                        <div class="nunber-seat">70</div>
                        <div class="nunber-seat">71</div>
                        <div class="nunber-seat">72</div>
                        <div class="nunber-seat">73</div>
                        <div class="nunber-seat">74</div>
                        <div class="nunber-seat">75</div>
                        <div class="nunber-seat">76</div>
                        <div class="nunber-seat">77</div>
                        <div class="nunber-seat">78</div>
                        <div class="nunber-seat">79</div>
                        <div class="nunber-seat">80</div>

                     </div>
                    <div class=" col  col--w-60 grid--cols-20 grid">
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                        <div class="seat"></div>
                     </div>
                     <div class=" numbers-seat-grid col col--w-40 grid--cols-20 grid">
                        <div class="nunber-seat">81</div>
                        <div class="nunber-seat">82</div>
                        <div class="nunber-seat">83</div>
                        <div class="nunber-seat">84</div>
                        <div class="nunber-seat">85</div>
                        <div class="nunber-seat">86</div>
                        <div class="nunber-seat">87</div>
                        <div class="nunber-seat">88</div>
                        <div class="nunber-seat">89</div>
                        <div class="nunber-seat">90</div>
                        <div class="nunber-seat">91</div>
                        <div class="nunber-seat">92</div>
                        <div class="nunber-seat">93</div>
                        <div class="nunber-seat">94</div>
                        <div class="nunber-seat">95</div>
                        <div class="nunber-seat">96</div>
                        <div class="nunber-seat">97</div>
                        <div class="nunber-seat">98</div>
                        <div class="nunber-seat">99</div>
                        <div class="nunber-seat">100</div>

                     </div>

                </div>

            </div>
        </div>
        <div class="next-step-btn"><button  id = 'next-step-btn' class="btn btn-fill btn-radius btn-small">Select a seat </button></div>

        <div id = 'notify ' class="notify btn-radius example"><p></p></div>
     </section>
    `;


export async  function seatsPage(ctx){
    
    if(!sessionStorage.getItem('availabilityId')){
        ctx.page.redirect('/')
    }
    let availabilityId = sessionStorage.getItem('availabilityId');
    let availability =  await getAvailabilityById(availabilityId);
    ctx.render(seatsTemplate(availability));
    let seats = document.getElementsByClassName('seat');
    chooseSeat(seats);

    clickNextStep(seats);


    occupiedSeats();
    

    function clickNextStep(seats){
        let btn = document.getElementById('next-step-btn');
     
        btn.addEventListener('click', () =>{
            let seatsSelected = getIndexOfSeat(seats);
            if(seatsSelected == 0){
                alertNotify('Please choose a seat!');
            }else{
                sessionStorage.setItem('seatNumber',seatsSelected);
                window.location.replace('/form');
            }
        });
   
    }



    async function occupiedSeats(){

        let seats = await getSeatsByAvailabilityId(availabilityId);

        let seatsHtml = document.getElementsByClassName('seat');
        for(let i = 0 ; i < seatsHtml.length; i++){



            if(seats.includes(String(i + 1))){
                seatsHtml[i].style.backgroundColor = 'rgb(216, 135, 3)';
            }

        }
      }

 
}
function chooseSeat(seats){


    for(let i = 0; i < seats.length ; i++){
        let currentSeat = seats[i];

        currentSeat.addEventListener('click', () =>{
            deleteSeatsExpectOne(i,seats);
            if(currentSeat.style.backgroundColor == 'rgb(50, 185, 32)'){
                currentSeat.style.backgroundColor = 'rgb(255, 255, 255)';
            }else if(currentSeat.style.backgroundColor == 'rgb(216, 135, 3)'){
                alertNotify("This seat is occupaied")
            }else{
                currentSeat.style.backgroundColor = 'rgb(50, 185, 32)';
            }
            
        })

    }
}

function deleteSeatsExpectOne(indexSeat,seats){
 
    for(let i = 0; i < seats.length ; i++){
        let seat = seats[i];
        let backgroundColor = seat.style.backgroundColor
        if(backgroundColor == 'rgb(50, 185, 32)' && i != indexSeat){
            seat.style.backgroundColor = '#fff';
        }   
    }
}
function getIndexOfSeat(seats){
    for(let i = 0; i < seats.length ; i++){
        if(seats[i].style.backgroundColor == 'rgb(50, 185, 32)'){
            
            return i + 1;
            
        }   
    }

    return 0;
}

