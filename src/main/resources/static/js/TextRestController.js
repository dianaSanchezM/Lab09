/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var RestControllerModule = (function (){
    
    var postText = function (text, callback){
        axios.post('/info',text)
            .then(function(){
                callback.onSuccess();
            })
            .catch(function(error){
                callback.onFailed(error);
                console.log(error);
            });
    };
    return {
        postText: postText
    };
})();

