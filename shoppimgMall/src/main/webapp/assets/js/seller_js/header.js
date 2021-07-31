$(function(){
  let si_seq =$("#si_seq").val();
  let si_grade =$("#si_grade").val();
  let seller =$("#seller").val();
  console.log(seller)
  if(seller != '' && si_grade==0){
    location.href="/seller/registration/"+si_seq;
  }
  if(seller != '' && si_grade==99){
    location.href="/admin"
  }
  
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