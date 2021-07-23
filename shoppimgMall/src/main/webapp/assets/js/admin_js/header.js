$(function(){
  
$("#logout").click(function () {
    if (confirm("로그아웃 하시겠습니까?"))   
    {
      location.href = "/member/logout";
    }
  })
$("#login").click(function(){
    location.href="/seller/login"
})
})