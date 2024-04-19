// search
// 검색어 입력란과 subject 요소를 가져옵니다.
const sI = document.querySelector('.right input[type="search"]');
const subject = document.querySelector('.subject .left');

// 검색어가 변경될 때마다 필터링 함수를 호출합니다.
sI.addEventListener('input', filterSubjects);

// 검색어에 따라 subject 요소를 필터링하는 함수입니다.
function filterSubjects() {
    const searchTerm = sI.value.toLowerCase(); // 검색어를 소문자로 변환합니다.
    const subjectItems = subject.querySelectorAll('a'); // subject 내의 링크 요소들을 가져옵니다.

    subjectItems.forEach(item => {
        const text = item.textContent.toLowerCase(); // 링크의 텍스트를 소문자로 변환합니다.
        // 검색어가 포함된 항목만 표시합니다.
        if (text.includes(searchTerm)) {
            item.style.display = 'flex';
        } else {
            item.style.display = 'none';
        }
    });
}

function showMarket() {
    // 모든 subject 요소를 가져옵니다.
    var allSubjects = document.querySelectorAll('.subject');

    // 모든 subject 요소를 숨깁니다.
    allSubjects.forEach(function(subject) {
        subject.style.display = 'none';
    });

    // 시장이 포함된 요소들만 보이도록 설정합니다.
    var marketSubjects = document.querySelectorAll('.subject ');
    marketSubjects.forEach(function(marketSpan) {
        // 시장이 포함된 subject 요소의 부모 요소로 이동하여 보이도록 설정합니다.
        marketSpan.closest('.subject').style.display = 'block';
    });
}


