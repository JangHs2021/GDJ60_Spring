const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentListResult = document.getElementById("commentListResult");
const contentsConfirm = document.getElementById("contentsConfirm");
const closeModal = document.getElementById("closeModal");
// const pageLink = document.querySelectorAll(".page-link");

// 댓글 등록
replyAdd.addEventListener("click", function(){

    // JS에서 사용할 가상의 Form 태그 생성
    const form = new FormData(); // html에 <form></form> 생성
    form.append("contents", replyContents.value); // <form><input type="text" name="contents" value=""></form>
    form.append("bookNumber", replyAdd.getAttribute("data-book-bookNumber")); // <form><input type="text" name="contents" value=""> <input type="text" name="bookNumber" value=""></form>

    fetch('../bankBookComment/add', {
        method : "POST",
        // headers : {"Content-type" : "application/x-www-form-urlencoded"},
        body : form
    }).then((response) => response.text())
    .then((res) => {
        if(res.trim() > 0) {
            alert('댓글이 등록 되었습니다');
            replyContents.value = '';
            getList(1);
        } else {
            alert('댓글 등록이 실패했습니다');
        }
    });

    // let xhttp = new XMLHttpRequest();

    // xhttp.open("POST", "../bankBookComment/add");

    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    // xhttp.send("contents="+replyContents.value+"&bookNumber="+replyAdd.getAttribute("data-book-bookNumber"));

    // xhttp.addEventListener("readystatechange", function(){
    //     if(this.readyState == 4 && this.status == 200) {
    //         // console.log(this.responseText);
    //         if(this.responseText.trim() == 1) {
    //             alert('댓글이 등록 되었습니다');
    //             replyContents.value = '';
    //             getList(1);
    //         } else {
    //             alert('댓글 등록이 실패했습니다');
    //         }
    //     }
    // })
});

getList(1);

function getList(page){
    // let count = 0;

    fetch("/bankBookComment/list?bookNumber="+replyAdd.getAttribute("data-book-bookNumber")+"&page="+page, {
        // GET 과 HEAD 메서드는 body 속성을 가질 수 없음
        method : "GET"
    }).then((response) => response.text())
    .then((res) => {
        commentListResult.innerHTML = res.trim();
    });

    // let xhttp = new XMLHttpRequest();

    // xhttp.open("GET", "/bankBookComment/list?bookNumber="+replyAdd.getAttribute("data-book-bookNumber")+"&page="+page);

    // xhttp.send();

    // xhttp.addEventListener("readystatechange", function(){
    //     if(this.readyState == 4 && this.status == 200) {
    //         commentListResult.innerHTML = this.responseText.trim();
    //         count++;
    //     }
    // })

    // 0이 출력 : 비동기 방식이기 떄문
    // console.log("count : " , count);
};

commentListResult.addEventListener("click", function(e){
    let pageLink = e.target
    if(pageLink.classList.contains("page-link")){
        let page = pageLink.getAttribute("data-board-page");
        getList(page);
    }
});

// delete
commentListResult.addEventListener("click", function(e){
    let del = e.target
    if(del.classList.contains("del")){
        fetch("../bankBookComment/delete", {
            method : "POST",
            headers : {"Content-type" : "application/x-www-form-urlencoded"},
            body : "num="+del.getAttribute("data-comment-num")
            // 응답객체에서 Data 추출
        }).then((response) => response.text())
        // 추출한 Data 사용
        .then((res) => {
            if(res.trim() > 0) {
                alert('댓글이 삭제 되었습니다');
                getList(1);
            } else {
                alert('댓글 삭제가 실패했습니다');
            }
        }).catch(() => {
            alert('삭제가 실패했습니다');
        });


        // let xhttp = new XMLHttpRequest();

        // xhttp.open("POST", "../bankBookComment/delete");

        // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        // xhttp.send("num="+del.getAttribute("data-comment-num"));

        // xhttp.addEventListener("readystatechange", function(){
        //     if(this.readyState == 4 && this.status == 200) {
        //         if(this.responseText.trim() == 1) {
        //             alert('댓글이 삭제 되었습니다');
        //             getList(1);
        //         } else {
        //             alert('댓글 삭제가 실패했습니다');
        //         }
        //     }
        // });
    }
});

// commentListResult.addEventListener("click", function(e){
//     let update = e.target
//     if(update.classList.contains("update")){
//         let xhttp = new XMLHttpRequest();

//         xhttp.open("POST", "../bankBookComment/update");

//         xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

//         xhttp.send("num="+update.getAttribute("data-comment-update")+"&contents="+replyContents.value);

//         xhttp.addEventListener("readystatechange", function(){
//             if(this.readyState == 4 && this.status == 200) {
//                 if(this.responseText.trim() == 1) {
//                     alert('댓글이 수정 되었습니다');
//                     replyContents.value = '';
//                     getList(1);
//                 } else {
//                     alert('댓글 수정을 실패했습니다');
//                 }
//             }
//         });
//     }
// });

// commentListResult.addEventListener("click", function(e){
//     let update = e.target
//     if(update.classList.contains("update")){
//         let num = update.getAttribute("data-comment-update")

//         let contents = document.getElementById("contents" + num);
        
//         contents.innerHTML = '<textarea>' +  contents.innerHTML + '</textarea>';
//     }
// });

// commentListResult.addEventListener("click", function(e){
//     let update = e.target
//     if(update.classList.contains("update")){
//         let num = update.getAttribute("data-comment-update")

//         let contents = document.getElementById("contents" + num);
        
//         contents.firstChild.removeAttribute("readonly");

//         let btn = document.createElement("button");
//         let attr = document.createAttribute("class");
//         let text = document.createTextNode("확인");
//         attr.value = 'btn btn-primary';
        
//         btn.setAttributeNode(attr);

//         btn.appendChild(text);
//         contents.appendChild(btn);

//         btn.addEventListener("click", function(){
           
//             let xhttp = new XMLHttpRequest();

//             xhttp.open("POST", "../bankBookComment/update");

//             xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        
//             xhttp.send("num="+num+"&contents="+contents.firstChild.value);

//             xhttp.addEventListener("readystatechange", function(){
//                 if(this.readyState == 4 && this.status == 200) {
//                     if(this.responseText.trim() == 1) {
//                         alert('댓글이 수정 되었습니다');
//                         getList(1);
//                     } else {
//                         alert('댓글 수정을 실패했습니다');
//                     }
//                 }
//             });
//         });
//     }
// });

commentListResult.addEventListener("click", function(e){
    let update = e.target
    if(update.classList.contains("update")){
        let num = update.getAttribute("data-comment-update");

        let contents = document.getElementById("contents" + num); // td
        let contentsTextArea = document.getElementById("contents"); // Modal textarea
        contentsTextArea.value = contents.innerText;

        contentsConfirm.setAttribute("data-comment-update", num);

    }
});

contentsConfirm.addEventListener("click", function(){
    let updateContents = document.getElementById("contents").value;
    let num = contentsConfirm.getAttribute("data-comment-update");

    fetch("../bankBookComment/update", {
        method : "POST",
        headers : {"Content-type" : "application/x-www-form-urlencoded"},
        body : "num="+num+"&contents="+updateContents
    }).then((response) => response.text())
    .then((res) => {
        if(res.trim() > 0) {
            alert('댓글이 수정 되었습니다');
            closeModal.click();
            getList(1);
        } else {
            alert('댓글 수정을 실패했습니다');
        }
    }).catch(() => {
        alert('수정을 실패했습니다');
    });

    // let xhttp = new XMLHttpRequest();

    // xhttp.open("POST", "../bankBookComment/update");

    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    // xhttp.send("num="+num+"&contents="+updateContents);

    // xhttp.addEventListener("readystatechange", function(){
    //     if(this.readyState == 4 && this.status == 200) {
    //         if(this.responseText.trim() == 1) {
    //             alert('댓글이 수정 되었습니다');
    //             closeModal.click();
    //             getList(1);
    //         } else {
    //             alert('댓글 수정을 실패했습니다');
    //         }
    //     }
    // });    
});