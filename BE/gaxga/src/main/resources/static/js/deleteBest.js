document.addEventListener('DOMContentLoaded', function() {
    // DOMContentLoaded == 문서가 완전히 로드된 후에 스크립트가 실행되도록 함
    const deleteButtons = document.querySelectorAll('#bestDeleteBtn');
    deleteButtons.forEach(button => {
        button.addEventListener('click', (event) => {
            // event.preventDefault();
            const boardDeleteBtn = event.target;
            const board_Id = boardDeleteBtn.getAttribute("data-Board-Id");

            // const board = {
            //     Board_Id: Board_Id
            // };

            console.log(board_Id);
            const url = `/api/gabowatdago/${board_Id}`;
            fetch(url, {
                method: "DELETE"
                // headers: {
                //     "Content-Type": "application/json"
                // },
                // body: JSON.stringify(board)
            }).then(response => {
                const msg = (response.ok) ? "삭제 성공" : "삭제 실패";
                alert(msg);
                if (response.ok) {
                    window.location.reload();
                }
            });
        });
    });
});
