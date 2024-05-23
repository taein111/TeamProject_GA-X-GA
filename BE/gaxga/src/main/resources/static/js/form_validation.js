function validateForm() {
    var localSelect = document.querySelector('select[name="local"]');
    var themaSelect = document.querySelector('select[name="thema"]');

    if (localSelect.value === "지역" || themaSelect.value === "테마") {
        alert('지역과 테마를 선택해주세요.');
        return false; // 폼 제출 방지
    }

    return true; // 폼 제출 허용
}

// document.addEventListener('DOMContentLoaded', function() {
//     var fileInput = document.querySelector('input[type="file"]');
//     var validExtensions = ['jpg', 'jpeg', 'png', 'gif']; // 허용되는 파일 확장자 목록
//
//     fileInput.addEventListener('change', function() {
//         if (fileInput.files.length > 0) {
//             for (var i = 0; i < fileInput.files.length; i++) {
//                 var file = fileInput.files[i];
//                 var fileExtension = file.name.split('.').pop().toLowerCase();
//                 if (!validExtensions.includes(fileExtension)) {
//                     alert('이미지 파일만 업로드 가능합니다. (jpg, jpeg, png, gif)');
//                     fileInput.value = ''; // 파일 선택 초기화
//                     return; // 추가 처리 중단
//                 }
//             }
//         }
//     });
// });