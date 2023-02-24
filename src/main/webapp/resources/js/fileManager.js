const add = document.getElementById("add");
const fileList = document.getElementById("fileList");

let count = 0;
let max = 1;
let param = 'pic';

function setParam(p){
    param = p;
}

function setMax(m){
    max = m;
}

let idx = 0;

fileList.addEventListener("click", function(e){

    if(e.target.classList.contains('dels')) {
        let id = e.target.getAttribute("data-delete-id");
        document.getElementById(id).remove();
        idx--
        console.log("delete : ", id);
    }
});


add.addEventListener("click", function(){

    if(idx >= max){
        alert("첨부파일은 최대 " + max + "개 까지만 가능합니다")
        return;
    }

    count++;

    // div
    let div = document.createElement('div');
    let attr = document.createAttribute('class');
    let attr1 = document.createAttribute("id");
    
    attr.value = 'col-md-12 mt-5';
    attr1.value = 'del' + idx;

    div.setAttributeNode(attr);
    div.setAttributeNode(attr1);

    // label
    let label = document.createElement('label');
    let text = document.createTextNode('Image');
    let attr2 = document.createAttribute('for');
    let attr3 = document.createAttribute('class');

    attr2.value = 'files';
    attr3.value = 'form-label';

    label.setAttributeNode(attr2);
    label.setAttributeNode(attr3);
    
    // input
    let input = document.createElement('input');
    let attr4 = document.createAttribute('type');
    let attr5 = document.createAttribute('class');
    let attr6 = document.createAttribute('name');
    let attr7 = document.createAttribute('id');

    attr4.value = 'file';
    attr5.value = 'form-control';
    attr6.value = "files";
    attr7.value = 'files';

    input.setAttributeNode(attr4);
    input.setAttributeNode(attr5);
    input.setAttributeNode(attr6);
    input.setAttributeNode(attr7);

    // button
    let button = document.createElement('button');
    let attr8 = document.createAttribute('type');
    let attr9 = document.createAttribute("data-delete-id");
    let attr10 = document.createAttribute("class");
    let text2 = document.createTextNode('X');

    attr8.value = 'button';
    attr9.value = "del" + idx;
    attr10.value = "dels";
 
    button.setAttributeNode(attr8);
    button.setAttributeNode(attr9);
    button.setAttributeNode(attr10);
    idx++;

    // 조립
    fileList.appendChild(div);
    div.appendChild(label);
    label.appendChild(text);
    div.appendChild(input);
    button.appendChild(text2);
    div.appendChild(button);
    
    fileList.prepend(div);

});

