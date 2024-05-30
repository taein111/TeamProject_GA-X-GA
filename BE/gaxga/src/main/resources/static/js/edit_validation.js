function validateForm() {
    var localSelect = document.querySelector('select[name="local"]');
    var themaSelect = document.querySelector('select[name="thema"]');

    if (localSelect.value === "지역" || themaSelect.value === "테마") {
        alert('지역과 테마를 선택해주세요.');
        return false; // 폼 제출 방지
    }

    return true; // 폼 제출 허용
}
