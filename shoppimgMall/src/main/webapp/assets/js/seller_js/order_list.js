$(function () {
    $("#order_managed").addClass("current")
    $("#status_change button").click(function () {       
        let status = $(this).attr("data-status");
        let oi_seq = $(this).parent().parent().attr("data-oi-seq");
        // let pi_seq =$(this).parent().parent().attr("data-pi-seq");
        // let mi_seq =$(this).parent().parent().attr("data-mi-seq");
        //  alert("Status : "+status+" / oi_seq : "+oi_seq+" / pi_seq : "+pi_seq+" / mi_seq : "+mi_seq)

        $.ajax({
            type:"patch",
            url:"/order/status?status="+status+"&oi_seq="+oi_seq,
            success:function(r){
                location.reload();
            }
        })
    })


})