document.addEventListener('DOMContentLoaded', function() {
    // DOMContentLoaded == 문서가 완전히 로드된 후에 스크립트가 실행되도록 함
    const deleteButtons = document.querySelectorAll('#deleteBtn');

    deleteButtons.forEach(button => {
        button.addEventListener('click', function() {
            const userId = this.closest('.receiveLikeList').querySelector("#jjim_input").value;
            const gabojagoId = this.closest('.receiveLikeList').querySelector("#gabojago_id").value;
            localStorage.removeItem(`jjimStatus_${userId}_${gabojagoId}`);

            const jjim = {
                userId: userId,
                gabojagoId: gabojagoId
            };

            console.log(jjim);
            const url = "/api/gabojagoing/jjim";
            fetch(url, {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(jjim)
            }).then(response => {
                const msg = (response.ok) ? "저장 삭제 성공" : "저장 삭제 실패";
                alert(msg);
                if (response.ok) {
                    this.closest('.receiveLikeList').remove();
                }
            });
        });
    });
});