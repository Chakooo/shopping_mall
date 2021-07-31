// reco.js
$(function () {

    $("#reco_managed").addClass("current")
    let si_seq = $("#seller_seq").val();
    console.log(si_seq)
    loadRecommandList();



    function loadRecommandList() {
        $("#recommand_tbody").html("");
        $.ajax({
            type: "get",
            url: "/product/api/recommand?si_seq=" + si_seq,
            success: function (r) {
                console.log(r.list)
                for (let i = 0; i < r.list.length; i++) {
                    let tag =
                        '<tr>' +
                        '<td>' + r.list[i].pi_seq + '</td>' +
                        '<td>' + r.list[i].pi_name + '</td>' +
                        '<td><img src="/image/' + r.list[i].pi_img_uri + '"></td>' +
                        '<td>' + r.list[i].category_name + '</td>' +
                        '<td>' + r.list[i].seller_name + '</td>' +
                        '<td><button class="delete" data-seq="' + r.list[i].pi_seq + '">삭제</button></td>' +
                        '<tr>';
                    $("#recommand_tbody").append(tag)
                }
                $(".delete").click(function () {
                    if (!confirm("삭제하시겠습니까?")) return;
                    let prod_seq = $(this).attr("data-seq");
                    $.ajax({
                        type: "delete",
                        url: "/product/api/recommand?prod_seq=" + prod_seq+"&si_seq="+si_seq,
                        success: function (r) {
                            alert(r.message)
                            location.reload()
                        }
                    })
                })
            }
        })


    }


    $(".add").click(function () {
        $(".add_recommand").show();
        loadNotRecommand()
    })


    function loadNotRecommand(keyword) {       
      
        if (keyword == undefined || keyword == null) {
            keyword = "";
        }
        $(".product_list").html(""); //초기화시키고 가져와야된다. 밑에 계속내용이 추가되기때문에
        $.ajax({
            type: "get",
            url: "/product/api/not_recommand/"+ si_seq + "?keyword=" + keyword,
            success: function (r) {
                console.log(r)
                for (let i = 0; i < r.list.length; i++) {
                    let tag =
                        '<tr>' +
                        '<td>' + r.list[i].pi_seq + '</td>' +
                        '<td>' + r.list[i].pi_name + '</td>' +
                        '<td><img src="/image/' + r.list[i].pi_img_uri + '"></td>' +
                        '<td>' + r.list[i].category_name + '</td>' +
                        '<td>' + r.list[i].seller_name + '</td>' +
                        '<td><button class="reco_add" data-seq="' + r.list[i].pi_seq + '">추천상품에 추가</button></td>' +
                        '<tr>';
                    $(".product_list").append(tag)
                }
                $(".reco_add").click(function () {
                    let seq = $(this).attr("data-seq")
                    // alert("추가")
                    $.ajax({
                        type: 'put',
                        url: '/product/api/recommand?prod_seq=' + seq+"&si_seq="+si_seq,
                        success: function (r) {
                            alert(r.message)
                            loadNotRecommand(); //함수 재실행해서 창을 띄운다.
                            loadRecommandList(); //뒤에 있는 추천창도 리로드시켜주면서 업로드해준다.
                        }
                    })
                })
            }
        })
    }

    $("#search").click(function(){   
        let keyword =$("#keyword").val();
        loadNotRecommand(keyword)
    })

    $(".close").click(function(){
        $(".add_recommand").hide();
        location.reload() 
    })
    $("#keyword").keyup(function(e){
        console.log(e.keyCode)
        if(e.keyCode==13){ 
            $("#search").trigger("click")            
        }
    })


})