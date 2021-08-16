// cart.js
$(function () {
    // let total =0;
    // for(let i = 0;i<$(".origin_price").length; i++){
    //     let price =$(".origin_price").eq(i).html() *1;
    //     total+= price;
    // }

    // $("#total_price > span").html(total);
    // // 전체 토탈 계산한 값을 변수에 담아 total_price 자리에 위치한다.

    // let discounted_total=0;
    // for(let i = 0;i<$(".final_price").length; i++){
    //     let price =$(".final_price").eq(i).html() *1;
    //     discounted_total+= price;
    // }

    // let total_discount = total-discounted_total;
    // $("#total_discount > span").html("-"+total_discount);
    calcPayment();




    $(".delete").click(function () {
        if (!confirm("삭제하시겠습니까?")) return;
        let pi_seq = $(this).attr("data-seq");
        let mi_seq = $(this).attr("data-user-seq");
        $.ajax({
            type: "delete",
            url: "/cart/remove?pi_seq=" + pi_seq + "&mi_seq=" + mi_seq,
            success: function (r) {
                alert(r.message)
                location.reload();
            }
        })
    })
    $(".plus").click(function () {

        let pi_seq = $(this).attr("data-seq");
        let mi_seq = $(this).attr("data-user-seq");
        // let cnt = $(this).parent().find(".cnt").html() * 1; // *1을 해줌으로서 문자열에서 숫자타입으로 강제변경시킨다.
        let cnt = $(this).parent().find(".cnt").val() * 1; // <<인풋타입으로 변경하면 val로 값을 찾아와야한다.
        let stock = $(this).attr("data-stock");
        cnt++;
        if (cnt > stock) {
            alert("최대주무순수량은" + stock + "개 입니다.")
            cnt = stock;
            return;
        }

        // $(this).parent().find(".cnt").html(cnt);
        $(this).parent().find(".cnt").val(cnt);
        let $this = $(this);
        $.ajax({
            type: "patch",
            url: "/cart/increase?pi_seq=" + pi_seq + "&mi_seq=" + mi_seq,
            success: function (r) {

                // let $this = $(this); 선언후 this를 쓴이유는 
                //  일반적으로 $(this)를 쓰면 ajax의 this를 지칭하기 때문에 ajax 밖에서 선언해주고 해당 this에 해당하는
                //  데이터를 가져온다. 

                let final_price = $this.parent().attr("data-final-price");
                let origin_price = $this.parent().attr("data-origin-price");

                $this.parent().parent().find(".final_price").html(final_price * cnt)
                $this.parent().parent().find(".origin_price").html(origin_price * cnt)
                calcPayment();
            }
        })
        // .html(); 해당 html값 = ${item.sc_count}을 가져온다.
        //그냥 cnt만 가져올경우 모든 장바구니상품의 cnt를 가져오기때문에 !! ,부모객체로 올라가서 해당하는 cnt값만 가져올수있다. 
        // alert("제품번호 : " + pi_seq + ", 회원번호 : " + mi_seq + ", 수량 : " + cnt)



    })
    $(".minus").click(function () {
        let pi_seq = $(this).attr("data-seq");
        let mi_seq = $(this).attr("data-user-seq");
        // let cnt = $(this).parent().find(".cnt").html() * 1;  *1을 해줌으로서 문자열에서 숫자타입으로 강제변경시킨다.
        let cnt = $(this).parent().find(".cnt").val() * 1; // *1을 해줌으로서 문자열에서 숫자타입으로 강제변경시킨다.
        cnt--;
        if (cnt < 1) {
            cnt = 1;
            return;
        }
        // $(this).parent().find(".cnt").html(cnt); <<input 타입이 아닐때
        $(this).parent().find(".cnt").val(cnt);
        let $this = $(this);
        $.ajax({
            type: "patch",
            url: "/cart/decrease?pi_seq=" + pi_seq + "&mi_seq=" + mi_seq,
            success: function (r) {
                let final_price = $this.parent().attr("data-final-price");
                let origin_price = $this.parent().attr("data-origin-price");
                $this.parent().parent().find(".final_price").html(final_price * cnt)
                $this.parent().parent().find(".origin_price").html(origin_price * cnt)
                calcPayment();
            }
        })


        // .html(); 해당 html값 = ${item.sc_count}을 가져온다.
        //그냥 cnt만 가져올경우 모든 장바구니상품의 cnt를 가져오기때문에 !! ,부모객체로 올라가서 해당하는 cnt값만 가져올수있다. 
        // alert("제품번호 : " + pi_seq + ", 회원번호 : " + mi_seq + ", 수량 : " + cnt)

    })
    $(".cnt").keydown(function (e) {
        if (e.keyCode == 13) {
            let cnt = $(this).val();
            if (isNaN(cnt)) {
                cnt = 1;
                alert("숫자만 입력하세요");
            }
            let pi_seq = $(this).attr("data-seq")
            let mi_seq = $(this).attr("data-user-seq");
            let stock = $(this).attr("data-stock") * 1;

            if (cnt > stock) {
                alert("최대구매수량은" + stock + "개 입니다")
                cnt = stock;
            }
            if (cnt < 1) {
                alert("최소구매수량은 1개입니다.")
                cnt = 1;
            }
            $(this).val(cnt);
            let $this = $(this);
            $.ajax({
                type: "patch",
                url: "/cart/change?pi_seq=" + pi_seq + "&mi_seq=" + mi_seq + "&cnt=" + cnt,
                success: function (r) {
                    r.status
                    alert("수량이 변경되었습니다.")

                    let final_price = $this.parent().attr("data-final-price");
                    let origin_price = $this.parent().attr("data-origin-price");

                    $this.parent().parent().find(".final_price").html(final_price * cnt)
                    $this.parent().parent().find(".origin_price").html(origin_price * cnt)
                    calcPayment();
                }

            })
        }
    })

    function calcPayment() {
        let total = 0;
        for (let i = 0; i < $(".origin_price").length; i++) {
            let price = $(".origin_price").eq(i).html() * 1;
            total += price;
        }

        $("#total_price > span").html(total);
        // 전체 토탈 계산한 값을 변수에 담아 total_price 자리에 위치한다.

        let discounted_total = 0;
        for (let i = 0; i < $(".final_price").length; i++) {
            let price = $(".final_price").eq(i).html() * 1;
            discounted_total += price;
        }

        let total_discount = total - discounted_total;

        let val ;
        if(total_discount==0){
            val  =  total_discount
        }
        else{
            val = "-" + total_discount
        }
        
        $("#total_discount > span").html(val);
        $(".payment").html(discounted_total+'원');
        
        

        
    }


    $("#order_btn").click(function () {
        let len = $(".cart_prod").length;
        console.log(len)
        if (len == 0) {
            alert("장바구니에 상품이 없습니다.")
            return;
        }
        if (!confirm("상품을 주문하시겠습니까?")) {
            return;
        }        
        //  ajax 통신을 for 문을 이용하여 장바구니에 있는 모든 상품을 없애준다.
        for (let i = 0; i < len; i++) {
            let mi_seq = $(".cart_prod").eq(i).attr("data-mi-seq");
            let pi_seq = $(".cart_prod").eq(i).attr("data-seq");
            let si_seq = $(".cart_prod").eq(i).attr("data-si-seq");
            let count = $(".cart_prod").eq(i).find(".cnt").val();
            let pi_name = $(".cart_prod").eq(i).attr("data-pi-name");
            console.log(pi_name)
            // alert("mi_seq" + mi_seq + ", pi_seq : "+pi_seq+", count : "+count);
            $.ajax({
                type: "delete",
                url: "/cart/remove?mi_seq=" + mi_seq + "&pi_seq=" + pi_seq,
                success: function (r) {
                    console.log(r.message);
                }
            })
            let data = {
                oi_mi_seq: mi_seq,
                oi_pi_seq: pi_seq,
                oi_delivery_no: "0000000000",
                oi_prod_count: count
            }
            let productCnt={
                pc_pi_seq:pi_seq,
                pc_mi_seq:mi_seq,
                pc_si_seq:si_seq,
                pc_count:count
            }
            $.ajax({
                type: "post",
                url: "/order",
                data:JSON.stringify(data),
                contentType: "application/json",
                success: function (r) {
                    
                    $.ajax({                        
                        type:"post",
                        url:"/order/product/count",
                        contentType: "application/json",
                        data:JSON.stringify(productCnt),
                        success:function(r){
                            console.log(r.message)                            
                        }
                    })
                }
            })

        }
        alert("주문이 완료되었습니다");
    })




    // 카카오 페이 연결

    $("#kakaoPay").click(function(){   
        let len = $(".cart_prod").length;      
        let pay = $(".payment").html();
        let mi_seq = $("#mi_seq").val();
        let payment = pay.slice(0,pay.length-1);
        console.log(payment)
        
        let item = 'EE 마켓 상품'
        
            if (len == 0) {
                alert("장바구니에 상품이 없습니다.")
                return;
            }
            if (!confirm("결제하시겠습니까?")) {
                return;
            }   
        $.ajax({
            url:'/kakaopay?pay='+payment+'&item='+item +'&seq='+mi_seq,
            dataType: 'json',
            success:function(r){     
                var parse= JSON.parse(r.data)
                var box =parse.next_redirect_pc_url                
                window.open(box) 
                                   
            },
            error:function(error){
                console.log(error)
            }
        })   
    })
})
