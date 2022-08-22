import { html ,render} from '../../node_modules/lit-html/lit-html.js';
import { getAllCinemas, getMovieById, getMoviesByCinema, getMoviesByNameAndCinema } from '../api/data.js';
import { detectPressHourButton } from '../functions/functions.js';
import { runMobileNavBar } from '../functions/mobileNavbar.js';
import alertNotify from '../functions/notifyAlert.js';
import { editUrlForEmbed, editUrlFromWindow } from '../functions/windowTrailer.js';



let templateMovie = (movie,cinemas,searchMovieByCinema,hideFunction)=>html`
   <div id = 'notify ' class="notify btn-radius example"><p></p></div>
<header class="header header-container">

<div class="header-logo logo"><img src="../content/brand-logo/full-logo.jpeg" alt="Super Cinema Logo"></div>

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


<section id="video" class=" video video-section container">


   <div class="top-details-movie"><h6>${movie.title}</h6> <button class="btn btn-high-big movie-btn-book btn-outline--yellow btn-big ">Book now</button></div>
   <div class="trailer-movie"> <embed src="${editUrlForEmbed(movie.urlVideo)}" ></div>
   <div class="details-movie-page ">
       <div class="details-tile"><h6>More details about ${movie.title}</h6></div>
       <div class=" grid details-box-grid ">
           <div class="details-movie-main grid grid--cols-2 ">
               <div class="details-first-child row">
                    <div class="release-date-box details-mini-box">
                        <div class="star-icon icon-details "><ion-icon name="star-outline"></ion-icon></div>
                        <div>
                            <div class="release-date-tile details-mini-box-title">Release date</div>
                            <div class="release-date details-mini-box">${movie.releaseDate}</div>
                        </div>
                    </div>
                    <div class="dusration-movie-box">
                        <div class="duration-movie-box details-mini-box">
                            <div class="icon-details clock-icon"><ion-icon name="time-outline"></ion-icon></div>
                            <div>
                                <div class="duration-movie-tile details-mini-box-title">Time duration</div>
                                <div class="duration-movie details-mini-box">${movie.duration} min</div>
                            </div>
                        </div>
                    </div>
                <div class="description">${movie.description}</div>
               </div>
             
               <div class="row details-last-child">
                   <div class="original-title">Original title: <span class="content-details">${movie.title}</span></div>
                   <div class="Filme genre">Film genre: ${movie.movieGenre}</div>
                   <div class="cast">Cast: ${movie.cast}</div>
                   <div class="production">Production: ${movie.production} </div>
                   <div class="Original language">Original language: ${movie.nativeLanguage}</div>
                   <div class="Age restrictions">Age restrictions: ${movie.ageRestriction}</div>
               </div>
           </div>
           <div class="photo"><img src="${movie.urlImage}" alt=""></div>
       </div>
   </div>

</section>



<section class="in-our-programs-section ">

    <div class="our-programs-container programs-container">
       <div class="title-programs"> <h3>Get your reservation</h3></div>

      <form @submit = ${searchMovieByCinema} action="" class="form-programs">
            <div>
                <h5>Choose a cinema</h5>
                <select name="cinemas" id="cinemas" class="cinemas">
                <option value='none'>Example</option>
                    ${cinemas.map(cinema => cinemaTemplate(cinema))}
                </select>
            </div>

            <div class="button-search">
                <button @click = ${hideFunction} class="btn btn-link btn-fill btn-big btn-radius hide-btn">Hide</button>
                <button class="btn btn-link btn-fill btn-big btn-radius">search</button>
         
            </div>
      </form>
    </div>


    <div id="programs-container" class="search-container programs-container" >


    </div>
 </section>




 <section class="movies container " style="display: none;">

    <div class="movie-container grid ">
        <div class="animations movie-items"></div>
        <div class="Action movie-items"></div>
        <div class="Sci-fi movie-items"></div>
    </div>

 </section>


 <footer class="footer-container">
    <div class="footer-grid grid">

        <div class="logo-icons-footer">
                <div class="footer-logo logo"><img src="../content/brand-logo/full-logo.jpeg" alt="Super Cinema Logo"></div>
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
`

export async function moviePage(ctx){

    let movie  = await getMovieById(ctx.params.id); 
    let cinemas = await getAllCinemas();
    ctx.render(templateMovie(movie,cinemas,searchMovieByCinema,hideFunction));
    runMobileNavBar();

    window.scrollTo({
        top:0
    })
    async function searchMovieByCinema(e){
        e.preventDefault();
    
        let data = new FormData(e.target);
        let cinema = data.get('cinemas');
        let movies = await getMoviesByNameAndCinema(cinema,movie.title);
    
        let hideBtn = document.getElementsByClassName('hide-btn')[0];
      
    

        detectPressHourButton();
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

}

let  movieTemplateSearchByCinema  = (movie) => html`
            <div class="movie-item">
                 <div class="reservation-item">
                 <div class="date-item"><p>${movie.date}</p></div>
                         ${movie.hours.map(hours => {
                               return html `<button id ="${hours.split(",")[1]}"  class=" btn-hour btn-link btn-fill btn-small btn-radius ">${hours.split(",")[0]}</button>`
                          })}
            </div>
`



function clickHours(id){
    sessionStorage.setItem('availabilityId',id)
    window.location.replace('/get-ticket');

}






const cinemaTemplate = (cinema) => html`
   <option value=${cinema.name}>${cinema.name}</option>`;



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


