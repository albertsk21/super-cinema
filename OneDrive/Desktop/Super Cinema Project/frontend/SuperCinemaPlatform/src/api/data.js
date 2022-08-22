import * as api from './api.js';


const host = 'http://localhost:8080';
api.settings.host = host;


export async function getHoursMovieByCriteria(title,date,cinema){
    title = title.replace(" ","%20");
    date = date.replaceAll("\/","%2F");
    cinema = cinema.replaceAll(" ","%20");
    return await api.get(host + `/availabilities/hours?title=${title}&date=${date}&cinema=${cinema}`)
}

export async function getAllCinemas(){
    return await api.get(host + '/cinemaBuildings');
}
export async function getMoviesByCinema(cinemaName){
    return await api.get(host + `/availabilities/movies?cinemaName=${encodeURIComponent(cinemaName)}&movieName= `);
}
export async function getMoviesByNameAndCinema(cinemaName,movieName){
    return await api.get(host + `/availabilities/movies?cinemaName=${encodeURIComponent(cinemaName)}&movieName=${encodeURIComponent(movieName)}`);
}
export async function getAvailabilitesByCinema(cinemaName){
    cinemaName = cinemaName.replace(" ","%20");
    return await api.get(host + `/availabilities?cinemaName=${cinemaName}`);
}
export async function getMoviesByCriteria(type, age, production, language){
    return await api.get(host + `/movies?type=${type}&age=${age}&production=${production}&language=${language}` )
}
export async function getAllMovies(){
    return await api.get(host + '/movies/all-movies');
}
export async function getMovieById(id){
    return await api.get(host + `/movies/${id}`);
}
export async function getAllTickets(){
    return await api.get(host + '/tickets');
}
export async function getAvailabilityById(id){
    return await api.get(host + '/availabilities/' + id);
}
export async function  getTicketById(id){
    return await api.get(host + '/tickets/' + id);
}
export async function createReservation(data){
    return await api.get(host + `/reservations/create?date=${data.date}&hall=${data.hall}&seatNumber=${data.seat}&firstName=${data.firstName}&lastName=${data.lastName}&phoneNumber=${data.phoneNumber}&customerEmail=${data.customerEmail.replaceAll("@","%40")}&hour=${data.hour}&availabilityId=${data.availabilityId}&ticket=${data.ticket}`);
}

export async function getReservationById(id){
    return await api.get(host +`/reservations/${Number(id)}`  )
}
export async function getSeatsByAvailabilityId(availabilityId){
    return await api.get(host + '/reservations/seats?availabilityId=' + availabilityId);
}