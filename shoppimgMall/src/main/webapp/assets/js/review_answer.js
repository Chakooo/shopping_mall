$(function () {
    $("#review_answer").addClass("current")


    $(".get_answer").click(function () {
        $(".answer_check").css("display","none")
        $(".answer_check").html("");
        let len =$(".answer").length;
        let seq = $(this).attr("rev-seq");
        console.log(seq)
        let $this = $(this)
        $.ajax({
            type: "get",
            url: "/review/getAnswer?seq=" + seq,
            success:function(r){
                console.log(r.data)
                $this.parent().parent().next().css("display","table-row")
                let tag=
                '<td><img src="/assets/images/free-icon-reply-724817.png" alt=""></td>'+
                '<td class="rejoinder"><span style="margin-bottom:10px; font-size:20px; font-weight:400">['+r.data.si_name+'] 판매자 답변 </span></td>'+
                '<td colspan="3">' + r.data.ra_content + '</td>'+
                '<td></td>'
                $this.parent().parent().next().append(tag)
            
            }

        })
    })

})