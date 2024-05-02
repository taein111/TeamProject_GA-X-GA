let currentIndex = 0;
const categoryItems = document.querySelectorAll('.intro .center .list a');
const totalItems = categoryItems.length;
const localNames = document.querySelectorAll('#ga_loc');
const localNamesArray = Array.from(localNames); // NodeList를 배열로 변환
const localNamesString = localNamesArray.map(item => item.innerText).join(', '); // 각 요소의 텍스트 콘텐츠를 배열로 가져온 후 join 메서드를 사용하여 문자열로 결합
const article = document.querySelectorAll('#article a');
const themeItems = document.querySelectorAll('.thema a'); // 테마를 나타내는 HTML 요소들을 선택합니다.

function showCategory(index) {
    // 모든 article 요소를 먼저 숨깁니다.
    article.forEach(articleItem => {
        articleItem.style.display = 'none';
    });

    categoryItems.forEach((item, idx) => {
        item.style.display = 'none';
        if (idx === index) {
            item.style.display = 'inline-block';
            let currentName = item.innerText;
            console.log(currentName)
            console.log(localNamesString)
            if (currentName === '지역') { // '지역' 항목일 경우 모든 article을 보여줌
                article.forEach(articleItem => {
                    articleItem.style.display = 'flex';
                });
            } else if (localNamesString.includes(currentName)) {
                console.log(`${currentName}지역이 일치한다, 출력`)
                // 해당 지역이 일치하는 article 요소 보여주기
                article.forEach(articleItem => {
                    if (articleItem.innerText.includes(currentName)) {
                        articleItem.style.display = 'flex';
                    } else {
                        articleItem.style.display = 'none';
                    }
                });
            } else {
                console.log("지역이 일치하지 않는다, 출력하지 않는다")
            }
        }
    });
}
