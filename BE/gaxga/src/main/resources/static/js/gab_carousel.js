let currentIndex = 0;
const categoryItems = document.querySelectorAll('.intro .center .list');
const totalItems = categoryItems.length;
const localNames = document.querySelectorAll('#ga_loc');
const localNamesArray = Array.from(localNames); // NodeList를 배열로 변환
const localNamesString = localNamesArray.map(item => item.innerText).join(', '); // 각 요소의 텍스트 콘텐츠를 배열로 가져온 후 join 메서드를 사용하여 문자열로 결합
const article = document.querySelectorAll('#article a');

function showCategory(index) {
    categoryItems.forEach((item, idx) => {
        item.style.display = 'none';
        if (idx === index) {
            item.style.display = 'inline-block';
            let currentName = item.innerText;
            console.log(currentName)
            console.log(localNamesString)
            if(localNamesString.includes(currentName)){
                console.log(`${currentName}지역이 일치한다, 출력` )
                // 해당 지역이 일치하는 article 요소 보여주기
                article.forEach(articleItem => {
                    if (articleItem.innerText.includes(currentName)) {
                        articleItem.style.display = 'flex';
                    } else {
                        articleItem.style.display = 'none';
                    }
                });
            }else{
                console.log("지역이 일치하지 않는다, 출력하지 않는다")
                // 지역이 일치하지 않는 article 요소 숨기기
                article.forEach(articleItem => {
                    articleItem.style.display = 'none';
                });
            }
        }

    });

}

function prevCategory() {
    currentIndex = (currentIndex - 1 + totalItems) % totalItems;
    showCategory(currentIndex);
}


function nextCategory() {
    currentIndex = (currentIndex + 1) % totalItems;
    showCategory(currentIndex);
}

// 페이지 로드 시 첫 번째 카테고리 항목 보이기
showCategory(currentIndex);
