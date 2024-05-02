var image_BOX = document.getElementById("image");
var article_Box = document.querySelectorAll(".locationAreaList a");
var change_Box = document.querySelector(".changeImg").innerText;

article_Box.forEach(function(article_box){
    article_box.addEventListener("mouseover", function(){
        change_Box = this.querySelector(".changeImg").innerText;
        image_BOX.src = change_Box;
    });
});