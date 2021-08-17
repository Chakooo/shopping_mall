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
                '<td><img src="/assets/images/free-icon-curved-arrow-1621584.png" alt=""></td>'+
                '<td class="rejoinder"> 답 변 </td>'+
                '<td colspan="3">' + r.data.ra_content + '</td>'+
                '<td></td>'
                $this.parent().parent().next().append(tag)
            
            }

        })
    })

})