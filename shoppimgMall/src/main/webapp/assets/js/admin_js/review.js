$(function () {
  
    


    $("#review_managed").addClass("current")
    let si_seq = $("#seller_seq").val();
    console.log(si_seq)



    $(".raw_btn").click(function () {
        $(".answer").css("display", "none");
        // $(this).parent().parent().next().css("display", "table-row");
        rev_seq = $(this).attr("rev-seq");
        console.log("rev_seq: " + rev_seq)
        let $this = $(this)
        $.ajax({
            type: "get",
            url: "/review/select?si_seq=" + si_seq + "&rev_seq=" + rev_seq,
            success: function (r) {
                console.log(r.data)
                $this.parent().parent().next().css("display", "none");

                if (r.data == null || r.data == undefined || r.data == '') {
                    $(".answer").css("display", "none");
                    $(".answer_check").css("display", "none");
                    $this.parent().parent().next().css("display", "table-row");
                }
                else{
                    $this.parent().parent().next().next().html('');
                    $(".answer_check").css("display", "none");
                    $this.parent().parent().next().next().css("display", "table-row");
                    let tag = '<p class="p_tag">'+r.data.ra_content+'</p><button>수정</button><button>삭제</button>'
                    $this.parent().parent().next().next().append(tag)
                }
            }
        })
    })


    $(".answer_regist").click(function(){
        let rev_seq = $(this).attr("rev-seq");
        let content=$(this).parent().children("textarea").val();
        alert(content)
        let data={
            ra_si_seq:si_seq,
            ra_content:content,
            ra_rev_seq:rev_seq      
        }
      
        $.ajax({
            type:"post",
            url:"/review/answer/regist",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r){
                alert(r.message)
                $.ajax({
                    type:"patch",
                    url:"/review/status/update?rev_seq="+rev_seq,
                    success:function(r){
                       
                        location.reload()
                    }

                })

            }


        })

    })

})










    // $(".answer").css("display", "none");
    // $this.parent().parent().next().next().css("display", "table-row");








