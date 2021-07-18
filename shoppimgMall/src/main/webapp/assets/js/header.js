$(function () {
  $("#cate_all, .categories").mouseover(function () {
    $(".categories").css("display", "block")
  })
  $("#cate_all, .categories").mouseout(function () {
    $(".categories").css("display", "")
  })
  $("#logout").click(function () {
    if (confirm("로그아웃 하시겠습니까?")) {
      location.href = "/member/logout";
    }
  })
})