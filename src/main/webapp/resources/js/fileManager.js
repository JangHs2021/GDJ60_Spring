// const add = document.getElementById("add");
// const fileList = document.getElementById("fileList");

let idx = 0;
let count = 0;
let max = 1;

function setCount(c){
    count = c;
}

function setMax(m){
    max = m;
}

$(".deleteCheck").click(function() {

    let result = confirm("파일이 영구 삭제 됩니다");
    let ch = $(this);

    if(result){
        let fileNum = $(this).val();
        $.ajax({
            type : 'POST',
            url : './boardFileDelete',
            data : {
                fileNum : fileNum
            },
            success : function(response){
                if(response.trim() > 0){
                    alert("삭제 되었습니다");
                    // this : ajax 객체 자기 자신
                    console.log(ch)
                    ch.parent().parent().remove();
                    count--
                } else {
                    alert("삭제 실패<br> 관리자에게 문의 하세요");
                }
            },
            error : function(){

            }
        })
    }

    // fetch
    // if(result) {
    //     fetch("URL?p=1", {
    //         method : 'GET'
    //     }).then((response) => response.text())
    //     .then((res) => {
    //     })
    // }

    // $.get("URL?p=1", function(response){
    // })

    // fetch
    // fetch("URL", {
    //     method : 'POST',
    //     headers : {"Content-type" : "application/x-www-form-urlencoded"},
    //     body : "p=1"
    // }).then((response) => response.text())
    // .then((res) => {})

    // $.post("URL", {p=1}", function(res){
    // })  
    
});

// $(".deleteCheck").click(function() {
   
//     if($(this).prop('checked')){
//         let result = confirm("파일이 영구 삭제 됩니다")

//         if(result) {
//             count--;
//         } else {
//             $(this).prop("checked", false);
//         }   
//     } else if (count == 5) {
//         idx--;
//         $("#del"+idx).remove();
//         return;
//     } else {
//         count++;
//     }
// });

// fileList.addEventListener("click", function(e){

//     if(e.target.classList.contains('dels')) {
//         e.target.parentNode.remove();
//         // let id = e.target.getAttribute("data-delete-id");
//         // document.getElementById(id).remove();
//         count--
//     }
// });

$("#fileList").on("click", ".dels", function(){
    // let id = $(this).attr("data-delete-id");
    // $("#"+id).remove();
    $(this).parent().remove();
    count--;
});

// add.addEventListener("click", function(){

//     if(count >= max){
//         alert("첨부파일은 최대 " + max + "개 까지만 가능합니다")
//         return;
//     }

//     // div
//     let div = document.createElement('div');
//     let attr = document.createAttribute('class');
//     let attr1 = document.createAttribute("id");
    
//     attr.value = 'col-md-12 mt-5';
//     attr1.value = 'del' + count;

//     div.setAttributeNode(attr);
//     div.setAttributeNode(attr1);

//     // label
//     //let label = document.createElement('label');
//     //let text = document.createTextNode('Image');
//     //let attr2 = document.createAttribute('for');
//     //let attr3 = document.createAttribute('class');

//     //attr2.value = 'files';
//     //attr3.value = 'form-label';

//     //label.setAttributeNode(attr2);
//     //label.setAttributeNode(attr3);
    
//     // input
//     let input = document.createElement('input');
//     let attr4 = document.createAttribute('type');
//     let attr5 = document.createAttribute('class');
//     let attr6 = document.createAttribute('name');
//     let attr7 = document.createAttribute('id');

//     attr4.value = 'file';
//     attr5.value = 'form-control';
//     attr6.value = "files";
//     attr7.value = 'files';

//     input.setAttributeNode(attr4);
//     input.setAttributeNode(attr5);
//     input.setAttributeNode(attr6);
//     input.setAttributeNode(attr7);

//     // button
//     let button = document.createElement('button');
//     let attr8 = document.createAttribute('type');
//     let attr9 = document.createAttribute("data-delete-id");
//     let attr10 = document.createAttribute("class");
//     let text2 = document.createTextNode('X');

//     attr8.value = 'button';
//     attr9.value = "del" + count;
//     attr10.value = "btn btn-outline-danger dels";
 
//     button.setAttributeNode(attr8);
//     button.setAttributeNode(attr9);
//     button.setAttributeNode(attr10);
//     count++;

//     // 조립
//     fileList.appendChild(div);
//     //div.appendChild(label);
//     //label.appendChild(text);
//     div.appendChild(input);
//     button.appendChild(text2);
//     div.appendChild(button);
    
//     fileList.prepend(div);

// });

$("#add").click(() => {

    if(count >= max){
        alert("첨부파일은 최대 " + max + "개 까지만 가능합니다")
        return;
    }

    count++;

    let child = '<div class="col-md-12 mt-5" id="del'+idx+'">';
        child = child + '<input type="file" class="form-control" name="addfiles" id="addfiles">';
        child = child + '<button type="button" class="btn btn-outline-danger dels" data-delete-id="del'+idx+'">X</button>';
        child = child + '</div>';

    $("#fileList").append(child);

    idx++;

});

