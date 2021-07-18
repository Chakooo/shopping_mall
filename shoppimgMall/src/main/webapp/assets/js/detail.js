$(function(){
    let count = 1;
    let price = $(".discounted").html().replace(",","")*1; // *1 을 해줌으로써 문자열에서 숫자값으로 강제형변환 해주기위함.(형태가 숫자로변경)
    // span태그안의 값을 가져오려면 .html()로 접근해야한다.
    $(".total_price b").html(price);
    let point_rate = $(".save_point").attr("data-point-rate");
    let point = Math.floor(price * point_rate / 100);
    $(".save_point b").html(point+"원");
    
      $("#plus").click(function(){
        count++;
        if(count >=$(".stock").html())count = $(".stock").html();        
        $("#count").html(count);
        $(".total_price b").html(price*count);
         
         point = Math.floor(price * point_rate / 100 *count);
       
            $(".save_point b").html(point+"원");        
    })
    $("#minus").click(function(){
        count--;
        if(count <1)count=1;
        $("#count").html(count);       
        $(".total_price b").html(price*count);
        
        
        point = Math.floor(price * point_rate / 100 *count);
        $(".save_point b").html(point+"원");
    })

    $("#shopping_bag").click(function(){
      if(memberInfo.seq =="" ||memberInfo.seq==null||memberInfo.seq==undefined){
        alert("로그인후 사용하실수 있습니다.")
     
        return;
      }

      let data={
        sc_mi_seq: memberInfo.seq,
        sc_pi_seq:$(".detail_container").attr("data-prod-seq"),
        sc_count:$("#count").html()
        // input 타입은 val()함수로 값을가져오고 나머지는 html() 함수로 값을 가져온다.
      }
      console.log(data);
      $.ajax({
        type:"post",
        url:"/cart/add",
        data:JSON.stringify(data),
        contentType:"application/json",
        success:function(r){
          alert(r.message);
          location.reload();
        }
      })
    })
})