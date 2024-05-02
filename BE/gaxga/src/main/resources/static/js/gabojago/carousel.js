let currentIndex = 0;
let categoryItems = document.querySelectorAll('.intro .center .list');
let locationItems = document.querySelectorAll('.subject .left .locationArea');

const totalItems = categoryItems.length;
function showCategory(index) {
    categoryItems.forEach(item => {
        item.style.display = 'none';
    });
    locationItems.forEach(locations => {
        locations.style.display = 'none';
    });

    categoryItems[index].style.display = 'inline-block';
    locationItems[index].style.display = 'inline-block';

}

function prevCategory() {
    currentIndex = (currentIndex - 1 + totalItems) % totalItems;
    showCategory(currentIndex);
    const listLeft= document.querySelectorAll('.locationAreaList');
    listLeft.forEach(function (item){
        item.style.display = 'flex';
    });
    const matchText = link.innerText;

    listLeft.forEach(function (item){
        if(item.innerText === listLeft || item.innerText.includes(matchText)){
            item.style.display = 'flex';
        } else {
            item.style.display = 'none';
        }
    });
}

function nextCategory() {
    currentIndex = (currentIndex + 1) % totalItems;
    showCategory(currentIndex);
    const listRight= document.querySelectorAll('.locationAreaList');
    listRight.forEach(function (item){
        item.style.display = 'flex';
    });
}

// 페이지 로드 시 첫 번째 카테고리 항목 보이기
showCategory(currentIndex);



// function prevCategory() {
//     currentIndex = (currentIndex - 1 + totalItems) % totalItems;
//     showCategory(currentIndex);
// }
//
// function nextCategory() {
//     currentIndex = (currentIndex + 1) % totalItems;
//     showCategory(currentIndex);
// }
//
// function showCategory(index) {
//     categoryItems.forEach((item, i) => {
//         item.style.display = i === index ? 'inline-block' : 'none';
//     });
//
//     locationItems.forEach((locations, i) => {
//         locations.style.display = i === index ? 'inline-block' : 'none';
//     });
//
//     const listLeft = locationItems[index].querySelectorAll('.locationAreaList');
//     listLeft.forEach(item => {
//         item.style.display = 'flex';
//     });
// }
//
// // 페이지 로드 시 첫 번째 카테고리 항목 보이기
// showCategory(currentIndex)