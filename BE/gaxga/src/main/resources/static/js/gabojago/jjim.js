var jjimBefore = document.querySelector('#jjim_before')
var jjimAfter = document.querySelector('#jjim_after')

window.addEventListener("load", function() {
    const userId = document.querySelector("#jjim_input").value;
    const gabojagoId = document.querySelector("#gabojago_id_id").value;
    const jjimStatus = localStorage.getItem(`jjimStatus_${userId}_${gabojagoId}`);
    if (jjimStatus === "jjim") {
        jjimBefore.style.display = "none";
        jjimAfter.style.display = "inline-block";
    } else {
        jjimBefore.style.display = "inline-block";
        jjimAfter.style.display = "none";
    }
});

//좋아요 버튼 이벤트처리
jjimBefore.addEventListener("click",function(){
    jjimBefore.style.display ="none";
    jjimAfter.style.display="inline-block";
    const jjim ={
        userId : document.querySelector("#jjim_input").value,
        gabojagoId: document.querySelector("#gabojago_id").value
    };
    console.log(jjim);
    const url = "/api/gabojagoing/jjim"
    fetch(url, {
        method: "POST",
        headers :{
            "Content-Type" : "application/json"
        },
        body: JSON.stringify(jjim)
    }).then(response =>{
        const msg = (response.ok)? "좋아요 추가 성공" : "좋아요 추가 실패";
        alert(msg);
    })
})

jjimAfter.addEventListener("click", function(){
    jjimAfter.style.display="none";
    jjimBefore.style.display="inline-block";
    const jjim = {
        userId: document.querySelector("#jjim_input").value,
        gabojagoId: document.querySelector("#gabojago_id").value
    };
    console.log(jjim);
    const url = "/api/gabojagoing/jjim"
    fetch(url, {
        method: "DELETE",
        headers :{
            "Content-Type" : "application/json"
        },
        body: JSON.stringify(jjim)
    }).then(response =>{
        const msg = (response.ok)? "좋아요 삭제 성공" : "좋아요 삭제 실패";
        alert(msg);
    })
})

