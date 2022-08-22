
import {render } from '../node_modules/lit-html/lit-html.js';
import page from '../node_modules/page/page.mjs';
import { homePage } from "./views/homePage.js";
import { ticketPage } from "./views/ticketPage.js";
import { seatsPage } from "./views/seatsPage.js";
import { formCustomerPage } from "./views/formPage.js";
import { finishPage } from './views/finishPage.js';
import * as api from '../src/api/data.js'
import { moviePage } from './views/movieSection.js'


window.api = api;


    let main  = document.body;
   
    page("/",decoratorContext,homePage);
    page('/get-ticket',decoratorContext,ticketPage);
    page('/seats', decoratorContext,seatsPage);
    page('/form', decoratorContext,formCustomerPage);
    page('/finish', decoratorContext,finishPage);
    page('/:id',decoratorContext,moviePage);
    
    
    page.start();

    async function decoratorContext(ctx,next){
        ctx.render = (content) => render(content,main);
        next();
    }





