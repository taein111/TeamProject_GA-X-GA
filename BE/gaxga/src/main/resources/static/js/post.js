// 날짜 스크립트
var today = new Date();
const date = document.querySelector(".date");
var year = today.getFullYear();
var month = ('0' + (today.getMonth() + 1)).slice(-2);
var day = ('0' + today.getDate()).slice(-2);
var dateString = year + '-' + month + '-' + day;
date.innerText = `${dateString}`;


//----------------------------------------------------------------------지도
//지도를 미리 생성
var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new daum.maps.Map(mapContainer, mapOption);
//주소-좌표 변환 객체를 생성
var geocoder = new daum.maps.services.Geocoder();
//마커를 미리 생성
var marker = new daum.maps.Marker({
    position: new daum.maps.LatLng(37.537187, 127.005476),
    map: map
});


function sample5_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function (data) {

            var addr = data.address; // 최종 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 주소 정보를 해당 필드에 넣는다.
            document.getElementById("sample5_address").value = addr;
            // 주소로 상세 정보를 검색
            geocoder.addressSearch(data.address, function (results, status) {
                // 정상적으로 검색이 완료됐으면
                if (status === daum.maps.services.Status.OK) {

                    var result = results[0]; //첫번째 결과의 값을 활용

                    // 해당 주소에 대한 좌표를 받아서
                    const coords = new daum.maps.LatLng(result.y, result.x);
                    // 지도를 보여준다.
                    mapContainer.style.display = "block";
                    map.relayout();
                    // 지도 중심을 변경한다.
                    map.setCenter(coords);
                    // 마커를 결과값으로 받은 위치로 옮긴다.
                    marker.setPosition(coords)

                    //폼 작성 시 위도 경도 데이터 보낼 변수 선언
                    var lat = result.x;
                    var lng = result.y;
                    console.log(lat);
                    console.log(lng);

                    document.getElementById("latitude").value = lat;
                    document.getElementById("longitude").value = lng;
                }
                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if (data.buildingName !== '' && data.apartment === 'Y') {
                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if (extraRoadAddr !== '') {
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if (addr !== '') {
                    document.getElementById("sample5_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample5_extraAddress").value = '';
                }


            });
        }

    }).open();
}

document.getElementById("submitButton").addEventListener("click", function(event) {
    var latitude = document.getElementById("latitude").value;
    var longitude = document.getElementById("longitude").value;

    // 위도와 경도가 비어있는지 확인
    if (!latitude || !longitude) {
        event.preventDefault(); // 폼 제출 중단
        alert("장소를 등록해주세요."); // 사용자에게 알림
    }
});








