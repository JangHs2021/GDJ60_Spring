const pl = document.getElementsByClassName("page-link");
const searchForm = document.getElementById("searchForm");
const page = document.getElementById("page");

for(let p of pl) {
    p.addEventListener("click", function(){
        let v = p.getAttribute("data-board-page");
        page.value = v;
        searchForm.submit(); 
    });
}

