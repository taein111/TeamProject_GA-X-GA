var ga_image_BOX = document.getElementById("image");
var ga_article_Box = document.querySelectorAll(".locationAreaList a");
var ga_change_Box = document.querySelector(".changeImg").innerText;

ga_article_Box.forEach(function(box){
    box.addEventListener("mouseover", function(){
        ga_change_Box = this.querySelector(".changeImg").innerText;
        ga_image_BOX.src = ga_change_Box;
    });
});