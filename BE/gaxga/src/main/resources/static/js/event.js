//마우스 오버 이미지 바꾸기
const ing_event=document.querySelector('.ingEvent');
const exit_event=document.querySelector('.exit_event');
const change = document.querySelector(".image_box1 .change_image");

const ing_box = document.querySelector('#ing_box');
const exit_box = document.querySelector('#exit_box');

const image_box1 = document.querySelector(".side_image1");
const image_box2 = document.querySelector(".side_image2");
const image_box3 = document.querySelector(".side_image3");

const image_src1 = document.querySelector(".side_image1 img").src;
const image_src2 = document.querySelector(".side_image2 img").src;
const image_src3 = document.querySelector(".side_image3 img").src;

const button1 = document.querySelector("#num1");
const button2 = document.querySelector("#num2");
const button3 = document.querySelector("#num3");

const myDiv1 = document.querySelector('.text1');
const myDiv2 = document.querySelector('.text2');
const myDiv3 = document.querySelector('.text3');

ing_event.addEventListener("click", function(){
  ing_box.style.display="inline-block"
  exit_box.style.display = "none";
})

exit_event.addEventListener("click", function(){
  exit_box.style.display ="inline-block";
  ing_box.style.display ="none";
})

// 마우스 오버되면 상세보기 끄기 / 이미지 바꾸기
image_box1.addEventListener("mouseover", function(){
  let imageSrc = decodeURIComponent(new URL(image_src1).pathname);
  change.src="/img/이벤트진행중배너1L.png"
  myDiv2.style.display = "none"
  myDiv3.style.display = "none"
  //마우스 오버 시 div 클래스 변경
  button1.style.display ="inline-block"
  button2.style.display ="none"
  button3.style.display ="none"
  if(imageSrc.includes("/img/이벤트진행중배너1s.png")){
    change.src = "/img/이벤트진행중배너1L.png"
  }else{
  change.src = "/img/이벤트디폴트배너L.png"
  button1.style.display ="none"
  button2.style.display ="none"
  button3.style.display ="none"
  }

});

image_box2.addEventListener("mouseover", function(){
  let imageSrc = decodeURIComponent(new URL(image_src2).pathname);

  change.src="/img/진행중이벤트최종2.png"
  //마우스오버 상세정보 사라지기
  myDiv1.style.display = "none"
  myDiv3.style.display = "none"
  //마우스 오버 시 div 클래스 변경
  button1.style.display ="none"
  button2.style.display ="inline-block"
  button3.style.display ="none"
  if(imageSrc.includes("/img/작은 영수증.png")){
    console.log(imageSrc)
    change.src = "/img/작은 영수증.png"
  }else{
    console.log(imageSrc)
    change.src = "/img/이벤트디폴트배너L.png"
    button1.style.display ="none"
    button2.style.display ="none"
    button3.style.display ="none"
  }
});
image_box3.addEventListener("mouseenter", function(){
  let imageSrc = decodeURIComponent(new URL(image_src3).pathname);

  change.src="/img/이벤트진행중배너3L.png"

  myDiv1.style.display = "none"
  myDiv2.style.display = "none"
  //마우스 오버 시 div 클래스 변경
  button1.style.display ="none"
  button2.style.display ="none"
  button3.style.display ="inline-block"
  if(imageSrc.includes("/img/이벤트진행중배너3s.png")){
    change.src = "/img/이벤트진행중배너3L.png"
  }else{
    change.src = "/img/이벤트디폴트배너L.png"
    button1.style.display ="none"
    button2.style.display ="none"
    button3.style.display ="none"
  }
});

//버튼으로 상세 정보 출력
function btnClick1() {
  const myDiv = document.querySelector('.text1');

  const isVisible = window.getComputedStyle(myDiv).display === 'none';

  // 상세정보가 보이지 않는 경우에만 보이도록 설정
  if(!isVisible) {
    myDiv.style.display = 'none';
  }else {
    myDiv.style.display = 'inline-block';
  }
}
function btnClick2() {
  const myDiv = document.querySelector('.text2');

  const isVisible = window.getComputedStyle(myDiv).display === 'none';

  // 상세정보가 보이지 않는 경우에만 보이도록 설정
  if(!isVisible) {
    myDiv.style.display = 'none';
  }else {
    myDiv.style.display = 'inline-block';
  }
}
function btnClick3() {
  const myDiv = document.querySelector('.text3');

  const isVisible = window.getComputedStyle(myDiv).display === 'none';

  // 상세정보가 보이지 않는 경우에만 보이도록 설정
  if(!isVisible) {
    myDiv.style.display = 'none';
  }else {
    myDiv.style.display = 'inline-block';
  }
}




/*
// 게시글 정보 (가정)
const posts = [
  { id: 1, userId: 1, likes: 10 },
  { id: 2, userId: 2, likes: 5 },
  { id: 3, userId: 3, likes: 8 },
  // 추가적인 게시글 정보를 여기에 추가
];

// 사용자 정보 (가정)
const users = [
  { id: 1, name: "인떠***", email: "user1@example.com" },
  { id: 2, name: "신혱***", email: "user2@example.com" },
  { id: 3, name: "태이***", email: "user3@example.com" },
  // 추가적인 사용자 정보를 여기에 추가
];

// 이벤트 기간 설정
const startDate = new Date("2024-05-10");
const endDate = new Date("2024-06-10");

// 게시판 업데이트 함수
function updateBoard() {
  // 게시판을 업데이트하는 코드 작성
}

// 당첨자 선정 함수
function selectWinners() {
  // 이벤트 기간 내 게시글 필터링
  const eventPosts = posts.filter(post => {
    const postDate = new Date(post.date);
    return postDate >= startDate && postDate <= endDate;
  });

  // 좋아요 수를 기준으로 정렬
  eventPosts.sort((a, b) => b.likes - a.likes);

  // 상위 3명의 당첨자 선택
  const winners = eventPosts.slice(0, 3);

  // 당첨자 이름을 화면에 출력
  for (let i = 0; i < winners.length; i++) {
    const winnerElement = document.getElementById(`winner${i + 1}`);
    if (winnerElement) {
      const winnerUser = users.find(user => user.id === winners[i].userId);
      if (winnerUser) {
        winnerElement.textContent = winnerUser.name;
      }
    }
  }
}

// 페이지 로드 시 당첨자 선정 여부 확인
window.onload = function() {
  const now = new Date();
  if (now > endDate) {
    selectWinners(); // 이벤트 종료 후 당첨자 선정
  } else {
    updateBoard(); // 이벤트 기간 중에는 게시판 업데이트
  }
};
 */