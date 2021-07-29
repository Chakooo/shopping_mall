$(function () {
    $("#review_managed").addClass("current")
    let si_seq = $("#seller_seq").val();
    console.log(si_seq)

    $(".raw_btn").click(function () {
        $(".answer").css("display", "none");
        $(this).parent().parent().next().css("display", "table-row");
    })
    for(let i=0; i<$(".raw_btn").length;i++){
        rev_seq = $(".raw_btn").attr("rev-seq");
        rev_seq1 =$(".rev_seq").val();
   }
    $(".rev_seq").click(function () {
       
        console.log("rev_seq: "+ rev_seq)
        console.log("rev_seq1: "+ rev_seq1)
        $.ajax({
            type: "get",
            url: "/review/select?si_seq=" + si_seq + "&rev_seq=" + rev_seq,
            success: function (r) {    
                
                $(this).parent().parent().next().css("display", "table-row");

            }

        })

    })











})