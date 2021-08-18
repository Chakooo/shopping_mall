$(function () {
  let si_seq =$("#si_seq").val();
  let si_grade =$("#si_grade").val();
  let seller =$("#seller").val();
  console.log(seller)

  if(seller != '' && si_grade==0){
    location.href="/seller/registration/"+si_seq;
  }
  if(seller != '' && si_grade==2){
    location.href="/seller/waiting/"+si_seq;
  }
  


  
  $("#cate_all, .categories").mouseover(function () {
    $(".categories").css("display", "block")
  })
  $("#cate_all, .categories").mouseout(function () {
    $(".categories").css("display", "")
  })


  $("#shop_all, .seller").mouseover(function () {
    $(".seller").css("display", "block")
  })
  $("#shop_all, .seller").mouseout(function () {
    $(".seller").css("display", "")
  })






  $("#logout").click(function () {
    if (confirm("로그아웃 하시겠습니까?"))   
    {
      location.href = "/member/logout";
    }
  })
})