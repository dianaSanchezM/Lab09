/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var TextControllerModule = (function () {
    var submitText = function(){
        var text = document.getElementById("text").value;
        console.log(text);
        var callback = {
            onSuccess: function(){
                alert("Text created");
            },
            onFailed: function(exception){
                console.log(exception);
                alert("There is a problem with our servers. We apologize for the inconvince, please try again later"); 
            }
        };
        RestControllerModule.postText(text,callback);
    };
    
    return{
        submitText: submitText
    }
})();

