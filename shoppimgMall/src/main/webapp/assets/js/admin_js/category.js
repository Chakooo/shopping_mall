$(function(){
    $("#category").addClass("current");  //css 클래스추가

    $.ajax({
        type:"get",
        url: "/category/api/list",
        success: function (r) {


            console.log(r.data[0].cate_seq)
            console.log(r.data[0].cate_name)


            for (let i = 0; i < r.data.length; i++) {
                console.log(r.data[i].cate_seq, r.data[i].cate_name)
                let tag = 
                '<tr><td>' + r.data[i].cate_seq + '</td>'+
                 '<td>' + r.data[i].cate_name + '</td>'+
                 '<td>'+ r.data[i].cate_prod_cnt+'</td>'+
                 '<td>'+
                 '<button data-seq="' + r.data[i].cate_seq + '" class="cate_del"'+(r.data[i].cate_prod_cnt!=0?"disabled":"")+'>삭제</button></td></tr>';
                $('#cate_table_body').append(tag); //제이쿼리로 html추가
            }
            $(".cate_del").click(function () {
                // alert("delete"); 정상작동 되는지 확인
                //제이쿼리 cate_del이라는 모든 클래스를 선택할수있다.
                // for(let i=0; i<document.getElementsByClassName("cate_del").length; i++){}
                //  document.getElementsByClassName("cate_del")[i].addEventListener("click",function(){
                //  alert("delete")
                //  })               자바스크립트로는 이렇게 표시해야한다. 어려워서 제이쿼리로 사용이 편함

             ($(this).attr("data-seq")) //클래스가 cate_del 인것중에 현재 클릭 이벤트를 발생시킨 태그 , 1개를 뜻함
                                                      //.attr("data-seq")는 지정된 data_seq값을 가져온다는뜻.   
                if(confirm("삭제하시겠습니까?")){ // 확인누르면 true 취소누르면 false값이 담긴다.                                   
                    $.ajax({                                      
                       type:"delete",                                      
                       url:"/category/api/delete?seq="+$(this).attr("data-seq"),
                       success:function(r){
                           alert(r.message)
                           location.reload();
                       },
                       error:function(r){
                        alert("등록된 상품이있어 삭제할수없습니다.")
                       }
                   })
                }
                });
        },
        eroor: function (e) {

        }
    })

    document.getElementById("add").addEventListener("click", function () {
        let name = document.getElementById("cate_name").value;
        if (name == '' || name == null || name == undefined) {
            alert("카테고리명을 입력하세요.")
            return;
        }
        $.ajax({
            type: "get",
            url: "/category/api/add?name=" + name,
            success: function (data) {
                alert(data.message);
                location.reload();
            },
            error: function (data) {
                console.log(data);
            }
        })
    });
});