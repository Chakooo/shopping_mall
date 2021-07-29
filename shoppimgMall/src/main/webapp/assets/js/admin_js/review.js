$(function () {
    $("#review_managed").addClass("current")
    let si_seq = $("#seller_seq").val();
    console.log(si_seq)

   
    
    $(".raw_btn").click(function () {
        $(".answer").html("");
        $(".answer").css("display", "none");
        $(this).parent().parent().next().css("display", "table-row");
        
        rev_seq = $(this).attr("rev-seq");       
        console.log("rev_seq: "+ rev_seq)
        rev=$(this)
     
        $.ajax({
            type: "get",
            url: "/review/select?si_seq=" + si_seq + "&rev_seq=" + rev_seq,
            success: function (r) {    
                if(r.ra_vo.ra_content!=null||r.ra_vo.ra_content!=undefined||r.ra_vo.ra_content!=''){
                    
                $(".answer").html("");
                $(".answer").html(r.ra_vo.ra_content)
            }
            
             }
        })
    })











})