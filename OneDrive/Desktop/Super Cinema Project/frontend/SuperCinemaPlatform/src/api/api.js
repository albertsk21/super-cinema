

export const settings = {
    host : ''
}

async function request(url,options){

    try{
        
        const response = await fetch(url,options);
        if(response.ok == false){
            const error = await response.json()
            throw new Error(error.message);
        }
        try{
            const data = await response.json();
            return data;

        }catch(err){
            return response;
        }
    }catch(err){
        alert(err.message);
        throw err;
    }

}
function geOptions(method = 'get',body){
    let options ={
        method,
        headers : {}
    }

    options.headers['Access-Control-Allow-Origin'] = '*';
    if(body){
        options.headers['Content-Type'] = 'applications/json';
        options.body = JSON.stringify(body);
    }
    return options;

}

export async function get(url){
    return await request(url,geOptions());
}

export async function put(url, data){
    return await request(url,geOptions("put",data));
}


export async function post(url, data){
    return await request(url,geOptions("post",data));
}
export async function del(url, data){
    return await request(url,geOptions("del"));
}

