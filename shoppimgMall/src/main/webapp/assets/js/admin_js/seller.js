$(function () {
    $("#seller").addClass("current");
    $.ajax({
        type: "get",
        url: "/seller/api/list",
        success: function (r) {
            let grade ='';
          

            for (let i = 0; i < r.data.length; i++) {
                if(r.data[i].si_grade==0){
                    grade = '사업자 등록전(0번)'
                }
                if(r.data[i].si_grade==1){
                    grade = '정식 판매자(1번)'
                }
                if(r.data[i].si_grade==2){
                    grade = '사업자 확인중(2번)'
                }
                if (r.data[i].si_grade != 99) {
                    let tag =
                        '<tr>' +
                        '<td>' + r.data[i].si_seq + '</td>' +
                        '<td>' + r.data[i].si_id + '</td>' +
                        '<td>' + r.data[i].si_name + '</td>' +
                        '<td>' + r.data[i].si_address + '</td>' +
                        '<td>' + r.data[i].si_email + '</td>' +
                        '<td>' + r.data[i].si_phone + '</td>' +
                        '<td>' + grade+ '</td>' +
                        '<td>' + r.data[i].seller_prod_cnt + '</td>' +
                        '<td>' +
                        '<button class="seller_delete" data-seq="' + r.data[i].si_seq + '" ' + (r.data[i].seller_prod_cnt != 0 ? "disabled" : "") + '>삭제</button>' +
                        ' </td>' +
                        '</tr>'                      

                    $(".seller_tbody").append(tag);
                }
            }
            $(".seller_delete").click(function () {
                let seq = $(this).attr("data-seq"); //data-seq버튼을 눌렀을때의 seq번호 하나만 가져온다.               
                if (confirm("삭제하시겠습니까?")) {
                    $.ajax({
                        type: "delete",
                        url: "/seller/api/delete?seq=" + seq,
                        success: function (r) {
                            alert(r.message);
                            location.reload();
                        }
                    })
                }
            })
        }
    })
    $.ajax({
        type: "get",
        url: "/seller/selectImage",
        success: function (r) {
            console.log(r.data)
            for (let i = 0; i < r.data.length; i++) {
            let data =
            '<tr>' +
            '<td>' + r.data[i].si_seq + '</td>' +
            '<td>' + r.data[i].si_id + '</td>' +
            '<td>' + r.data[i].si_name + '</td>' +
            '<td>' + r.data[i].si_address + '</td>' +
            '<td>' + r.data[i].si_email + '</td>' +
            '<td>' + r.data[i].si_phone + '</td>' +
            '<td class="preview"><img src="/image/'+ r.data[i].sr_uri +'/'+r.data[i].si_seq+'"></td>'+
            '<td><button class="seller_grade" si_id="'+r.data[i].si_id+'">판매자 등록</button></td>'+
            '</tr>'
            $('.img_tbody').append(data);
            console.log(r.data[i].sr_uri)
            console.log(r.data[i].si_seq)
            }
            $(".seller_grade").click(function(){
                let grade = 1;
                let si_id = $(this).attr("si_id")
                if(!confirm("정식 판매자로 등록하시겠습니까? "))return;
                $.ajax({
                    type:"patch",
                    url:"/seller/grade/update?si_id="+si_id + "&grade="+grade,
                    success:function(r){
                        alert(r.message)
                        location.reload()
                    }

                })
            })
        }
    })




})