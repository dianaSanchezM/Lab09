/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var RestControllerModule = (function (){
    
    var postText = function (text, callback){
        axios.post('/info',text)
            .then(function(response){
                callback.onSuccess(response.data);
            })
            .catch(function(error){
                callback.onFailed(error);
                console.log(error);
            });
    };
    
    var getTexts = function (callback){
        axios.get('/info')
            .then(function(info){
                callback.onSuccess(info.data);
            })
            .catch(function(error){
                callback.onFailed(error.data);
                console.log(error.data)
            });
    };
    return {
        postText: postText,
        getTexts: getTexts
    };
})();

