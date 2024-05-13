const image1 = document.querySelector(".slider__img").innerText

let images =[
  `../${image1}`,
  "../img/loc/서울/서울-도봉산.jpg",
  "../img/loc/서울/서울-북한산.jpg",
  "../img/loc/서울/서울-롯데월드.jpg",
  "../img/loc/서울/서울-자팡이.jpg",
];

function imageSlider(parent, images){
  let currentIndex = 0;
  // 선택자
  let slider = {
      parent: parent,
      images: parent.querySelector(".slider__img"),
      thumbnails: parent.querySelector(".slider__thumb"),
      prevBtn: parent.querySelector(".slider__btn .prev"),
      nextBtn: parent.querySelector(".slider__btn .next")
  };
  // 이미지 출력하기
  slider.images.innerHTML = images.map((image, index) => {
      return `<img src="${image}" alt="이미지${index}">`;
  }).join("");

  // 이미지 활성화(active)하기
  let imageNodes = slider.images.querySelectorAll("img");
  imageNodes[currentIndex].classList.add("active");

  // 썸네일 이미지 출력하기
  slider.thumbnails.innerHTML = slider.images.innerHTML;

  // 썸네일 활성화(active)하기
  let thumnailNodes = slider.thumbnails.querySelectorAll("img");
  thumnailNodes[currentIndex].classList.add("active");

  // 썸네일 이미지 클릭하기_forEach()
  thumnailNodes.forEach((thumb, index) => {
      thumb.addEventListener("click", function(){
          thumnailNodes[currentIndex].classList.remove("active");
          thumnailNodes[index].classList.add("active");

          imageNodes[currentIndex].classList.remove("active");
          currentIndex = index;
          imageNodes[currentIndex].classList.add("active");
      });
  });

  // 왼쪽 버튼 클릭하기
  slider.prevBtn.addEventListener("click", () => {
      imageNodes[currentIndex].classList.remove("active");
      currentIndex--;
      
      // 0 4 3 2 1 0 4 3 2 1...
      if(currentIndex < 0) currentIndex = images.length - 1;

      imageNodes[currentIndex].classList.add("active");

      // 썸네일 버튼 클릭하기
      thumnailNodes[currentIndex].classList.remove("active");
      thumnailNodes[currentIndex].classList.add("active");
  });

  // 오른쪽 버튼 클릭하기
  slider.nextBtn.addEventListener("click", () => {
      imageNodes[currentIndex].classList.remove("active");
      thumnailNodes[currentIndex].classList.remove("active");

      // 1 2 3 4 0 1 2 3 4...
      currentIndex = (currentIndex + 1) % images.length;

      imageNodes[currentIndex].classList.add("active");
      thumnailNodes[currentIndex].classList.add("active");
  });
};
imageSlider(document.querySelector(".slider__wrap"), images);


// ------------------------------------------------------지도------------------

// 지도를 표시할 div 요소
var lat = parseFloat(document.getElementById('latitude').value);
var lng = parseFloat(document.getElementById('longitude').value);

document.getElementById("test").addEventListener("click", function (){
    console.log(lng);
    console.log(lat);
})
// 좌표로 지도를 생성하고 마커 표시
let mapContainer = document.getElementById('maps'),
    mapOption = {
    center: new daum.maps.LatLng(lng,lat),
    level: 2 // 지도의 확대 레벨
};

let map = new daum.maps.Map(mapContainer, mapOption);

let markerPosition = new daum.maps.LatLng(lng,lat);

// 마커 생성
let marker = new daum.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정
marker.setMap(map);



//-----------------------------------------------------------------------
// 삭제버튼 클릭 알림창
function delOk(){
    return confirm('삭제하시면 복구할 수 없습니다.\n정말로 삭제하시겠습니까??');
}
// 댓글  작성 기능
const commentCreateBtn = document.querySelector("#comment-save");

commentCreateBtn.addEventListener("click", function () {
    const comment = {
        nickname: document.querySelector("#client").value,
        body: document.querySelector("#comment").value,
        gabowatdagoId: document.querySelector("#new-comment-gabowatdago_id").value
    };

    console.log(comment);
    const url = "/api/gabowatdago/" + comment.gabowatdagoId + "/cmts";
    fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(comment)
    }).then(response => {
        if (response.ok) {
            alert("댓글 등록 완료");
            // 댓글이 성공적으로 등록되었을 때 페이지를 새로 고침
            window.location.reload();
        } else {
            alert("댓글 등록 실패");
        }
    });
});
const commentDeleteBtns = document.querySelectorAll("#deleteBtn")
//삭제 버튼 이벤트 처리
commentDeleteBtns.forEach(btn => {
    btn.addEventListener("click", (event) =>{ //이벤트 객체 받아와서
        // 이벤트 발생 요소 선택
        const commentDeleteBtn = event.target; //삭제 버튼 변수화
        //삭제 댓글 id 가져오기
        const commentId = commentDeleteBtn.getAttribute("data-comment-id");
        console.log(`삭제 버튼 클릭 : ${commentId}번 댓글`);
        //삭제 REST API 호출
        const url = `/api/cmts/${commentId}`
        fetch(url, {
            method: "DELETE"
        }).then(response => {
            //댓글 삭제 실패 처리
            if(!response.ok){
                alert("댓글 삭제 실패");
                return;
            }
            const msg = "댓글 삭제 완료";
            alert(msg);
            window.location.reload();
        })
    });
});

