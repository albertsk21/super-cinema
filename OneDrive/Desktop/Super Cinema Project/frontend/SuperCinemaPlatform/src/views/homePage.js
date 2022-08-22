import { html , render} from "../../node_modules/lit-html/lit-html.js";
import { getAllCinemas, getAllMovies, getMovieById, getMoviesByCinema, getMoviesByCriteria } from "../api/data.js";
import { detectPressHourButton } from "../functions/functions.js";
import { runMobileNavBar } from "../functions/mobileNavbar.js";
import alertNotify from "../functions/notifyAlert.js";
import runSlideShow from "../functions/slideShow.js";
import { closeWindow, editUrlFromWindow, showWindow } from "../functions/windowTrailer.js";


const homePageTemplate  = (specialMovie,movies, cinemaBuildings , searchMovieByCinema, hideFunction , searchMovieByCriteriaSelect, getAll) => html`
            <header class="header header-container">

            <div class="header-logo logo"><img src="./content/brand-logo/full-logo.jpeg" alt="Super Cinema Logo"></div>

            </header>
            <section class="second-header-section hide-mobile-nav open-mobile-nav  ">
            <nav class="main-nav ">

                <buuton  class=" mobile-nav ">
                    <ion-icon class="icon-mobile-nav" name="close-outline"></ion-icon>
                    <ion-icon class="icon-mobile-nav" name="ellipsis-horizontal-outline"></ion-icon>
                
                </buuton>
                <div class="empty-nav-bar"></div>
                <ul class="main-nav-list header-container "  >
                
                    <li><a class="btn-link btn btn-fill btn-nav first-btn-nav" href="#"><span>offers</span></a></li>
                    <li><a class="btn-link btn btn-fill btn-nav" href="#"><span>gifts</span></a></li>
                    <li><a class="btn-link btn btn-fill btn-nav" href="#"><span>blog</span></a></li>
                    <li><a class="btn-link btn btn-fill btn-nav" href="#"><span>about us</span></a></li>
                    <li><a class="btn-link btn btn-fill btn-nav" href="#"><span>news</span></a></li>
                    <li><a class="btn-link btn btn-fill btn-nav" href="#"><span>Forum Film</span></a></li>
                    <li><a class="btn-link btn btn-fill btn-nav" href="#"><span>vip</span></a></li>
                    <li><a class="btn-link btn btn-fill btn-nav" href="#"><span>Comunity</span></a></li>
                </ul>
            </nav>
</section>
<section>
            <div class="slide-show-container">


    
                <div class="carousel-item active-carousel-item fade  ">
                    <img src="./content/slideshow-images/belle.jpg" alt="">  
                    <a href="#" class="btn-book  btn-link btn-fill btn-big btn-radius" >Book Now</a>
                     <div class="h4-carousel">
                         <h4 >belle</h4>
                     </div>
                 </div>
    

                 <div class="carousel-item  fade">
                      <img src="./content/slideshow-images/batman.jpg " alt="">  
                      <a href="#" class="btn-book  btn-link btn-fill btn-big btn-radius" >Get Details</a>
                     <div class="h4-carousel">
                         <h4 >The Batman</h4>
                     </div>
                 </div>

                 <div class="carousel-item fade"> 

                    <img src="./content/slideshow-images/bts.jpg" alt="">  
                    <div class="h4-carousel up-text">
                        <h4 >bts permission to dance on stage-seoul:live</h4>
                    </div>
                    <a href="#" class="btn-book  btn-link btn-fill btn-big btn-radius" >Buy Ticket</a>
               </div>
               <div class="carousel-item  fade">
                  
                    <img src="./content/slideshow-images/uncharted.jpg" alt="">  
                    <div class="h4-carousel font-border">
                        <h4 >uncharted</h4>
                    </div>
                    <a href="#" class="btn-book  btn-link btn-fill btn-big btn-radius" >Book Now</a>
             </div>
      
          
            <button  id= "btn-forward"class=" btn btn-arrow btn-forward"><ion-icon  name="chevron-forward-outline"></ion-icon></button>
            <button id = "btn-back" class=" btn btn-arrow btn-back"><ion-icon  name="chevron-back-outline"></ion-icon></button>
  
            <div class="carousel-indicators">
                <button type="button" class="carousel-inidicator active-dot" data-bs-slide-to="0" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" class="carousel-inidicator" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" class="carousel-inidicator" data-bs-slide-to="2" aria-label="Slide 3"></button>
                <button type="button" class="carousel-inidicator" data-bs-slide-to="2" aria-label="Slide 4"></button>
            </div>
  
        </div>
 
        </section>        


         <section class="in-our-programs-section ">
 
            <div class="our-programs-container programs-container">
               <div class="title-programs"> <h3>Now in our program</h3></div>

              <form @submit = ${searchMovieByCinema} action="" class="form-programs">
                    <div>
                        <h5>Choose a cinema</h5>
                        <select name="cinemas" id="cinemas" class="cinemas">
                        <option value='none'>Example</option>
                        ${cinemaBuildings.length == 0 ? '' : cinemaBuildings.map(cinemaBuilding => {return cinemaTemplate(cinemaBuilding.name)})}
                        </select>
                    </div>

                  
                    <div class="button-search">
                            <button href="#" id="hide-btn" @click = ${hideFunction} class="btn btn-link btn-fill btn-big btn-radius hide-btn">Hide</button>
                            <button class="btn btn-link btn-fill btn-big btn-radius">search</button> 
                    </div>
              </form>
            </div>


            <div id="programs-container" class="search-container programs-container" >


            </div>
         </section>
         <section class="movies-section container">
                 


                 <div class="slogan"><h2><span>Entertainment</span> for everyone</h2></div>
                 
                 <div class="search-movie-container">
                     <div class="book-now"><h6>Now Booking</h6></div>
                 <form action="" @submit =  ${searchMovieByCriteriaSelect} class="search-movie-form">
                   
                         <select name="type" id="tye" class="genre-selector  ">
                             <option value="">Type</option>
                             <option  class="option" value="Action">Action</option>
                             <option class="option" value="Crime">Crime</option>
                             <option class="option" value="Concert">Concert</option>
                             <option class="option" value="Adventure">Adventure</option>
                             <option class="option" value="Animation">Animation</option>
                             <option class="option" value="Comedy">Comedy</option>
                             <option class="option" value="Sci-Fi">Sci-Fi</option>
                             <option class="option" value="Fantasy">Fantasy</option>
                         </select>
                         <select name="age-restriction" id="age-restriction" class="age-restriction-selector">
                             <option value="">Age Restriction</option>
                             <option  class="option" value="AP-12">Ap-12</option>
                             <option class="option" value="AG">AG</option>
                             <option class="option" value="15+">15+</option>
                         </select>
                         <select name="production" id="production" class="production-select">
                             <option value="">Production</option>
                             <option value="2022">2022</option>
                             <option value="2021">2021</option>
                         </select>
                         <select name="native-language" id="native-language" class="native-language-selector">
                             <option value="">Language</option>
                             <option value="EN">English</option>
                             <option value="KO">Korean</option>
                             <option value="JAP">Japanese</option>
                         </select>
                       
                         <div class="select-buttons">    
                     <div> <a @click = ${getAll} class="btn btn-all-size btn-outline btn-small ">All</a></div>
                     <div>  <button class=" apply-btn btn  btn-fill btn-small btn-radius">Apply</button></div>
                   
                     </div>
                 </form>
                 </div>
                 <div id= 'firstRenderResult' class="result-searched-movie grid grid--cols-4">
                        ${movies.map(movie => {return searchMovieByCriteriaTemplate(movie)})}


                 </div>
                 

                 <div  id= 'mainRenderResult'class="result-searched-movie grid grid--cols-4">
                     
                 </div>
                 
          </section>
          <section class="one-movie-section container">

                <div class="one-movie-container grid grid--cols-2">
                    <div class="one-movie-image"><img src="${specialMovie.urlImage}" alt="Spider-man: no way home"></div> 
                    <div class="content-one-movie">
                        <div class="small-title-one-movie"><h6>Now in Cinema</h6></div>
                        <div class="one-movie-title"><h4>${specialMovie.title}</h5></div>
                        <div class="one-movie-summary"><p>${specialMovie.description.length > 240 ?   specialMovie.description.substr(0,specialMovie.description.length -340) + '...':specialMovie.description}</p></div>
                        <div class="buttons-one-movie">
                            <button @click = ${showWindow} class="btn btn-outline btn-big "><ion-icon class="play-icon" name="play"></ion-icon>Watch trailer</button>
                            <a href="/${specialMovie.id}" class="btn btn-outline--yellow btn-link btn-big">show more deatils</a>
                        </div>
                    </div>
                </div>
        </section>

        <section class="photo-step-section container">


            <div class="grid grid--cols-3 steps-container ">
                <div class="container-step-photo"><img src="./content/steps/1.jpeg" alt="Book Online"></div>
                <div class="container-step-photo"><img src="./content/steps/2.jpeg" alt="Beast Seats"></div>
                <div class="container-step-photo"><img src="./content/steps/3.jpeg" alt="From You Comofort"></div>
            </div>

    </section>
    <div id = 'notify ' class="notify btn-radius example"><p></p></div>

    <div class="window-container ">
                <div class="open-trailer" >
                    
                    <embed class="video-homepage" src=""></embed>
                 <div>   <button  @click = ${closeWindow} id="close-trailer" class="btn btn-fill-red btn-small btn-radius btn--close-icon"><ion-icon class="close-icon" name="close-outline"></ion-icon></button></div>
                 </div>
    </div>


    <footer class="footer-container">
        <div class="footer-grid grid">

            <div class="logo-icons-footer">
                    <div class="footer-logo logo"><img src="./content/brand-logo/full-logo.jpeg" alt="Super Cinema Logo"></div>
                    <div class=footer-icons>
                        <ion-icon name="logo-instagram"></ion-icon>
                        <ion-icon name="logo-facebook"></ion-icon>
                        <ion-icon name="logo-tiktok"></ion-icon>
                        <ion-icon name="logo-youtube"></ion-icon>
                    </div>
            </div>


            <div class="ul-footer ">
                <div class="footer-title"><h5>Movies</h5></div>
                <ul>
                    <li><a href="javascript:void(0)">Drama</a></li>
                    <li><a href="javascript:void(0)">Adventure</a></li>
                    <li><a href="javascript:void(0)">Comedy</a></li>
                    <li><a href="javascript:void(0)">Action</a></li>
                </ul>
            </div>
            <div class="ul-footer ">
                <div class="footer-title"><h5>Support</h5></div>
                <ul>
                    <li><a href="javascript:void(0)">Help Center</a></li>
                    <li><a href="javascript:void(0)">FAQ</a></li>
                    <li><a href="javascript:void(0)">Contact Is</a></li>
                    <li><a href="javascript:void(0)">Ticket Support</a></li>
                </ul>
            </div>
            <div class="ul-footer ">
                <div class="footer-title"><h5>About Super Cinema</h5></div>
                <ul>
                    <li><a href="javascript:void(0)">About Us</a></li>
                    <li><a href="javascript:void(0)">Careers</a></li>
                    <li><a href="javascript:void(0)">News & Article</a></li>
                    <li><a href="javascript:void(0)">Legal Notice</a></li>
                </ul>
            </div>
        </div>

        <div class="copyright">
            <div class="grid">
                <ul>
                    <li><a href="javascript:void(0)">Term of Use</a></li>
                    <li><a href="javascript:void(0)">Privacy Policy</a></li>
                    <li><a href="javascript:void(0)">Cookie Policy</a></li>
                </ul>
            </div>

            <div class="copyright-text">
                <p>Copyright &#xa9; 2022. All rights reserved</p>
            </div>
        </div>
</footer>


`;

export async function homePage(ctx){
    let cinemaBuildings = await getAllCinemas();
    let movies = await getAllMovies();
    let specialMovie = await getMovieById(9);


 
    ctx.render(homePageTemplate(specialMovie,movies,cinemaBuildings,searchMovieByCinema,hideFunction,searchMovieByCriteriaSelect,getAll));

    editUrlFromWindow(specialMovie.urlVideo);
    runSlideShow()
    runMobileNavBar();

    function redirect(id){
        ctx.page.redirect('/get-ticket/' + id);
    }
}

// -----------------------------------
//              TEMPLATES
// -----------------------------------

let  movieTemplateSearchByCinema  = (movie) => html`
                <div class="movie-item">
                    <div class="image-search-item"><img src="${movie.urlImage}" alt="The Batman"></div>
                     <div class="details-movie">
                         <div class="title-item"><h5>${movie.title}</h5></div>
                         <div class="date-item"><p>${movie.date}</p></div>
                         <div class="button-hours">
                         ${movie.hours.map(hours => {
                               return html `<button id =" ${hours.split(",")[1]}" href="./details/${hours.split(",")[1]}" class=" btn-hour btn-link btn-fill btn-small btn-radius">${hours.split(",")[0]}</button>`
                          })}
                         </div>
                    </div>
                </div>
`

const cinemaTemplate = (cinema) => html`
   <option value=${cinema}>${cinema}</option>`;

let searchMovieByCriteriaTemplate = (movie) => html`
                        <div class="search-movie-item">
                            <div class="image-search-movie-item"><a href="./${movie.id}"><img src="${movie.urlImage}" alt="The Batman"></a></div>
                            <div class="movie-item-search-title"><a  class="link-movie " href="./${movie.id}">${movie.title}</a></div>
                        </div>`;



// -----------------------------------
//              FUNCTIONS
// -----------------------------------

async function searchMovieByCinema(e){
    e.preventDefault();

    let data = new FormData(e.target);
    let cinema = data.get('cinemas');
    let movies = await getMoviesByCinema(cinema);


    let hideBtn = document.getElementsByClassName('hide-btn')[0];

    if(cinema == 'none'){
           alertNotify('Please choose a cinema!');
    }else{

        if(hideBtn.innerHTML == 'Show'){
            alertNotify('Your search is hidden!');
        }else{
            let generateMovie = (movies) => html`
            ${movies.map(movie => { return movieTemplateSearchByCinema(movie)})}`
                render(generateMovie(movies), document.getElementsByClassName("search-container")[0]);
                detectPressHourButton();
        }

    


    }


 
}



function hideFunction(e){
    e.preventDefault();
    let hideBtn = document.getElementsByClassName('hide-btn')[0];
    let programs = document.getElementById('programs-container');

    if(hideBtn.innerHTML == 'Hide'){
        hideBtn.innerHTML = 'Show';
        programs.style.display = 'none';
        hideBtn.style.backgroundColor = '#fc2d12';
        hideBtn.style.color = '#fff';

        
    }else{
        hideBtn.innerHTML = 'Hide';
        programs.style.display = '';
        hideBtn.style.backgroundColor = '#FCA312';
        hideBtn.style.color = '#000'
    }

}


async function searchMovieByCriteriaSelect(e){
    e.preventDefault();


    let searchContainer = document.getElementById('mainRenderResult');
    let items = document.getElementsByClassName('search-movie-item');


    



    const data = new FormData(e.target);
    const type = data.get('type');
    const ageRestriction = data.get('age-restriction');
    const production = data.get('production');
    const nativeLanguage = data.get('native-language');

    if(type == '' && ageRestriction == '' && production == '' && nativeLanguage == ''){
      return  alertNotify('Please choose by criteria!')
    }




    let resultContainer =  document.getElementsByClassName('result-searched-movie');
  
 
    if(resultContainer.length == 2){
       resultContainer[0].remove();
    }
  

    let movies = await getMoviesByCriteria(type,encodeURIComponent(ageRestriction),production,nativeLanguage);
  
    let output = (movie) => html`
        ${ movie.length == 0 ? html`<div class = 'not-found-movies'><h6>Nothing found :(</h6></div>` : movie.map(movie => {return searchMovieByCriteriaTemplate(movie)})}
    `;

    render(output(movies),searchContainer);

}


async function getAll(){

    let movies = await getAllMovies();
    let items = document.getElementsByClassName('search-movie-item');
    let searchContainer = document.getElementById('mainRenderResult');
    

    let resultContainer =  document.getElementsByClassName('result-searched-movie');
  
    if(resultContainer.length == 2){
       resultContainer[0].remove();
    }
  
    

  
    let output = (movies) => html`
        ${movies.map(movie => {return searchMovieByCriteriaTemplate(movie)})}
    `;

    render(output(movies),searchContainer);


}

