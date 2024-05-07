var likeBefore = document.querySelector('#like_before')
var likeAfter = document.querySelector('#like_after')

//좋아요 버튼 이벤트처리
likeBefore.addEventListener("click",function(){
    likeBefore.style.display ="none";
    likeAfter.style.display="inline-block";
    const like ={
        userId : document.querySelector("#like_input").value,
        gabowatdagoId: document.querySelector("#new-comment-gabowatdago_id").value
};
    console.log(like);
    const url = "/api/gabowatdago/like"
    fetch(url, {
        method: "POST",
        headers :{
            "Content-Type" : "application/json"
        },
        body: JSON.stringify(like)
    }).then(responce =>{
        const msg = (responce.ok)? "좋아요 추가 성공" : "좋아요 추가 실패";
        alert(msg);
    })
})

likeAfter.addEventListener("click", function(){
    likeAfter.style.display="none";
    likeBefore.style.display="inline-block";
    const like = {
        userId: document.querySelector("#like_input").value,
        gabowatdagoId: document.querySelector("#new-comment-gabowatdago_id").value
    };
    console.log(like);
    const url = "/api/gabowatdago/like"
    fetch(url, {
        method: "DELETE",
        headers :{
            "Content-Type" : "application/json"
        },
        body: JSON.stringify(like)
    }).then(responce =>{
        const msg = (responce.ok)? "좋아요 삭제 성공" : "좋아요 삭제 실패";
        alert(msg);
    })

})

