$(function () {
  let count = 1;
  let price = $(".discounted").html().replace(",", "") * 1; // *1 을 해줌으로써 문자열에서 숫자값으로 강제형변환 해주기위함.(형태가 숫자로변경)
  $(".total_price b").html(comma(price));
  let point_rate = $(".save_point").attr("data-point-rate");
  let point = Math.floor(price * point_rate / 100);
  $(".save_point b").html(point + "원");

  $("#plus").click(function () {
    count++;
    if (count >= $(".stock").html()) count = $(".stock").html();
    $("#count").html(count);
    $(".total_price b").html(comma(price * count));

    point = Math.floor(price * point_rate / 100 * count);

    $(".save_point b").html(comma(point) + "원");
  })
  $("#minus").click(function () {
    count--;
    if (count < 1) count = 1;
    $("#count").html(count);
    $(".total_price b").html(comma(price * count));


    point = Math.floor(price * point_rate / 100 * count);
    $(".save_point b").html(comma(point) + "원");
  })

  $("#shopping_bag").click(function () {
    if (memberInfo.seq == "" || memberInfo.seq == null || memberInfo.seq == undefined) {
      alert("로그인후 사용하실수 있습니다.")

      return;
    }

    let data = {
      sc_mi_seq: memberInfo.seq,
      sc_pi_seq: $(".detail_container").attr("data-prod-seq"),
      sc_count: $("#count").html()
      // input 타입은 val()함수로 값을가져오고 나머지는 html() 함수로 값을 가져온다.
    }
    console.log(data);
    $.ajax({
      type: "post",
      url: "/cart/add",
      data: JSON.stringify(data),
      contentType: "application/json",
      success: function (r) {
        alert(r.message);
        location.reload();
      }
    })
  })

  $(".regular_regist").click(function () {
    let si_seq = $("#seller_seq").val();
    let mi_seq = $("#mi_seq").val();
    if (mi_seq == null || mi_seq == '' || mi_seq == undefined) {
      alert("로그인후 이용하실수있습니다.")
      return;
    }

    // console.log(si_seq , mi_seq)

    let data = {
      rc_si_seq: si_seq,
      rc_mi_seq: mi_seq
    }

    $.ajax({
      type: "post",
      url: "/regular/regist",
      contentType: "application/json",
      data: JSON.stringify(data),
      success: function (r) {
        alert(r.message)
      }
    })
  })
})

function comma(x) {
  return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
}