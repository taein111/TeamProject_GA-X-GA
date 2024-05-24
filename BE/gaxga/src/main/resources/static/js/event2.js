const exit_image_box1 = document.querySelector(".side_exit_image1");
const exit_image_box2 = document.querySelector(".side_exit_image2");
const exit_image_box3 = document.querySelector(".side_exit_image3");
const exit_change = document.querySelector('#image_box2')
const exit_change2 = document.querySelector('#image_box3')
const exit_change3 = document.querySelector('#image_box4')

// 종료된 이벤트에서 마우스 오버되면 이미지랑 내용 바꾸기
exit_image_box1.addEventListener("mouseover", function(){
    exit_change.style.display="inline-block";
    exit_change2.style.display="none";
    exit_change3.style.display="none";
})

exit_image_box2.addEventListener("mouseover", function(){
    exit_change.style.display="none";
    exit_change2.style.display="inline-block";
    exit_change3.style.display="none";
})

exit_image_box3.addEventListener("mouseover", function(){
    exit_change.style.display="none";
    exit_change2.style.display="none";
    exit_change3.style.display="inline-block";
})