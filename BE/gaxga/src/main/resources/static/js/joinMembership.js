const findAddressBtn = document.querySelector("#find_Address");

findAddressBtn.addEventListener("click", sample6_execDaumPostcode);
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById("postal").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailAddress").focus();
        }
    }).open();
}


document.getElementById("submitBtn").addEventListener("click", function (){
    const userEmail = document.getElementById("userEmail").value;
    const emailType = document.getElementById("emailType").value;
    document.getElementById("combinedEmail").value = userEmail + "@" + emailType;
    console.log(userEmail + "@" + emailType);
});

// // 아이디 입력란에서 포커스를 잃을 때 중복 체크 요청을 보냄
// document.getElementById("gaId").addEventListener("blur", function() {
//     const userId = this.value;
//     checkId(userId);
// });
// const checkId = (userId) => {
//     $.ajax({
//         type: "GET",
//         url: "/joinMembership/checkId?userId=" + userId,
//         success: function(response) {
//             if (response === true) {
//                 alert("사용 가능한 아이디입니다.");
//             } else {
//                 alert("이미 사용 중인 아이디입니다.");
//             }
//         },
//         error: function() {
//             alert("서버 오류가 발생했습니다.");
//         }
//     });
// };