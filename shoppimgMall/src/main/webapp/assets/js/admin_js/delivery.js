$(function(){
    
    isDupName = true;
   
        $("#delivery").addClass("current");          
        $.ajax({
            type:"get",
            url:"/delivery/api/list",
            success:function(r){
                for(let i=0;i<r.data.length;i++){
                    let tag= //ctrl+art로 전체 선택후 
                    '<tr>'+
                        '<td>'+r.data[i].di_seq+'</td>'+
                        '<td>'+r.data[i].di_name+'</td>'+
                        '<td>'+r.data[i].di_phone+'</td>'+
                        '<td>'+r.data[i].di_price+'원</td>'+
                        '<td>'+r.data[i].delivery_prod_cnt+'</td>'+                                
                        '<td><button class="delivery_delete" data-seq="'+r.data[i].di_seq+'" '+(r.data[i].delivery_prod_cnt!=0?"disabled":"")+'>삭제</button></td>'+
                    '</tr>'
                    $(".delivery_tbody").append(tag);
                }
                $(".delivery_delete").click(function(){
                    let seq=$(this).attr("data-seq");
                    if(confirm("삭제하시겠습니까?")){
                        $.ajax({
                            url:"/delivery/api/delete?seq="+seq,
                            type:"delete",
                            success:function(r){
                                alert(r.message)
                                location.reload();
                            }
                        })
                    }
                })
            }
        })


        document.getElementById("dub_chk").addEventListener("click", function () {
            let di_name = document.getElementById("di_name").value;
            if (di_name == '' || di_name == null || di_name == undefined) {
                alert("업체명을 입력하세요.")
                return;
            }
            $.ajax({
                type: "get",
                url: "/delivery/api/check?name=" + di_name,
                success: function (r) {
                    alert(r.message)
                    console.log(r.status)
                    isDupName = false;
                }
            })
        })
        document.getElementById("di_name").addEventListener("input", function () {
            isDupName = true;
        })
        document.getElementById("add").addEventListener("click", function () {
            if (isDupName == true) {
                alert("업체명 중복체크를 하세요.")
                return;
            }
            let di_name = document.getElementById("di_name").value;
            let di_phone = document.getElementById("di_phone").value;
            let di_price = document.getElementById("di_price").value;
            if (di_name == '' || di_name == null || di_name == undefined) {
                alert("업체명을 입력하세요.")
                return;
            }
            if (di_phone == '' || di_phone == null || di_phone == undefined) {
                alert("업체번호를 입력하세요.")
                return;
            }
            if (di_price == '' || di_price == null || di_price == undefined) {
                alert("배송비를 입력하세요.")
                return;
            }

            let data = {
                di_name,
                di_phone,
                di_price
            }
            $.ajax({
                type: "post",
                url: "/delivery/api/add",
                data: JSON.stringify(data),
                contentType: "application/json",
                success: function (r) {
                    alert(r.message)
                    location.reload();
                },
                error: function (e) {
                    console.log(e);
                }
            })
        })
    })
