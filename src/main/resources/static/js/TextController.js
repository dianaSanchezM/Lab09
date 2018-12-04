/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var TextControllerModule = (function () {
    var submitText = function(){
        var text = document.getElementById("text").value;
        var callback = {
            onSuccess: function(){
                console.log("text created");
                showTable();
            },
            onFailed: function(exception){
                console.log(exception);
                alert("There is a problem with our servers. We apologize for the inconvince, please try again later"); 
            }
        };
        RestControllerModule.postText(text,callback);
    };
    
    var showTable = function(){
        var callback={
            onSuccess: function(info){
                $("#table").empty();
                console.log("data returned");
                var table= document.getElementById("table");
                for (i=0; i<10;i++) {
                    var row = document.createElement("tr");
                    var text = document.createElement("td");
                    var cellText = document.createTextNode(info[i]["text"]);
                    text.appendChild(cellText);
                    var date= document.createElement("tr");
                    var dateText= document.createTextNode(info[i]["date"]);
                    date.appendChild(dateText);
                    row.appendChild(text);
                    row.appendChild(date);
                    //row added to end of table body
                    table.appendChild(row);
                }
            },
            onFailed: function(exception){
                console.log(exception);
                alert("There is a problem with our servers. We apologize for the inconvince, please try again later"); 
            }
        };
        RestControllerModule.getTexts(callback);
    };
    
    return{
        submitText: submitText,
        showTable: showTable
    };
})();

