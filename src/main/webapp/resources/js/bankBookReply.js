const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentListResult = document.getElementById("commentListResult");
// const pageLink = document.querySelectorAll(".page-link");

replyAdd.addEventListener("click", function(){
    let xhttp = new XMLHttpRequest();

    xhttp.open("POST", "../bankBookComment/add");

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send("contents="+replyContents.value+"&bookNumber="+replyAdd.getAttribute("data-book-bookNumber"));

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState == 4 && this.status == 200) {
            // console.log(this.responseText);
            if(this.responseText.trim() == 1) {
                alert('댓글이 등록 되었습니다')
                replyContents.value = '';
                getList(1);
            } else {
                alert('댓글 등록이 실패했습니다')
            }
        }
    })
});

getList(1);

function getList(page){
    let count = 0;

    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "/bankBookComment/list?bookNumber="+replyAdd.getAttribute("data-book-bookNumber")+"&page="+page);

    xhttp.send();

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState == 4 && this.status == 200) {
            commentListResult.innerHTML = this.responseText.trim();
            count++;
        }
    })

    // 0이 출력 : 비동기 방식이기 떄문
    console.log("count : " , count);
}

commentListResult.addEventListener("click", function(e){
    let pageLink = e.target
    if(pageLink.classList.contains("page-link")){
        let page = pageLink.getAttribute("data-board-page");
        getList(page);
    }
});

commentListResult.addEventListener("click", function(e){
    let del = e.target
    if(del.classList.contains("del")){
        let xhttp = new XMLHttpRequest();

        xhttp.open("POST", "../bankBookComment/delete");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("num="+del.getAttribute("data-comment-num"));

        xhttp.addEventListener("readystatechange", function(){
            if(this.readyState == 4 && this.status == 200) {
                if(this.responseText.trim() == 1) {
                    alert('댓글이 삭제 되었습니다')
                    getList(1);
                } else {
                    alert('댓글 삭제가 실패했습니다')
                }
            }
        });
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
//                     alert('댓글이 수정 되었습니다')
//                     replyContents.value = '';
//                     getList(1);
//                 } else {
//                     alert('댓글 수정을 실패했습니다')
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

commentListResult.addEventListener("click", function(e){
    let update = e.target
    if(update.classList.contains("update")){
        let num = update.getAttribute("data-comment-update")

        let contents = document.getElementById("contents" + num);
        
        contents.firstChild.removeAttribute("readonly");

        let btn = document.createElement("button");
        let attr = document.createAttribute("class");
        let text = document.createTextNode("확인");
        attr.value = 'btn btn-primary';
        
        btn.setAttributeNode(attr);

        btn.appendChild(text);
        contents.appendChild(btn);

        btn.addEventListener("click", function(){
           
            let xhttp = new XMLHttpRequest();

            xhttp.open("POST", "../bankBookComment/update");

            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        
            xhttp.send("num="+num+"&contents="+contents.firstChild.value);

            xhttp.addEventListener("readystatechange", function(){
                if(this.readyState == 4 && this.status == 200) {
                    if(this.responseText.trim() == 1) {
                        alert('댓글이 수정 되었습니다')
                        getList(1);
                    } else {
                        alert('댓글 수정을 실패했습니다')
                    }
                }
            });
        });
    }
});

