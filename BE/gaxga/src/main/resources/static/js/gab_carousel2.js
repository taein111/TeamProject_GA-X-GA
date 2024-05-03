let currentIndex = 0;
let categoryItems = document.querySelectorAll('.intro .center .list a');
let themaItmes = document.querySelectorAll('.thema a span');
let article = document.querySelectorAll('.subject .left a');

const totalItems = categoryItems.length;


function showCategory(index) {
    categoryItems.forEach((item) => {
        item.style.display = 'none';
    });
    categoryItems[index].style.display = 'inline-block';
}


// 필터링 함수 정의
function filterByLocal(filter) {
    article.forEach((locals) => {
        if (filter === "지역") {
            locals.style.display = 'flex'; // "지역"일 경우 모든 지역을 표시
        } else if (filter === "*" || filter === locals.getAttribute("data-type")) {
            locals.style.display = 'flex'; // 일치하는 경우 표시
        } else {
            locals.style.display = 'none'; // 일치하지 않는 경우 숨김
        }
    });
}


function filterBythema(filter){
    article.forEach((themas)=> {
        if(filter === "*" || filter === themas.getAttribute("data-type")){
            themas.style.display = "flex";
        }else{
            themas.style.display = "none";
        }
    });
}


function prevCategory() {
    currentIndex = (currentIndex - 1 + totalItems) % totalItems;
    showCategory(currentIndex);
    const filter = categoryItems[currentIndex].getAttribute("data-filter"); // 다음 카테고리의 data-filter 속성 값
    filterByLocal(filter); // 필터링 함수 호출
}


function nextCategory() {
    currentIndex = (currentIndex + 1) % totalItems;
    showCategory(currentIndex);
    const filter = categoryItems[currentIndex].getAttribute("data-filter"); // 다음 카테고리의 data-filter 속성 값
    filterByLocal(filter); // 필터링 함수 호출
    }


themaItmes.forEach((thema)=>{
    addEventListener("click", ()=>{
        const filter = categoryItems[currentIndex].getAttribute("data-filter"); // 다음 카테고리의 data-filter 속성 값
        filterBythema(filter); // 필터링 함수 호출
    })
});






// 페이지 로드 시 첫 번째 카테고리 항목 보이기
showCategory(currentIndex);