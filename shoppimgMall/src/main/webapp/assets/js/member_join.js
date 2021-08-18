
// http://blog.naver.com/PostView.nhn?blogId=realuv&logNo=220699272999 <<정규표현식 확인할때 봐라

$(function () {
    let idCheck = false;
    let emailCheck = false;
    $("#join").click(function () {
        // alert("클릭했다")
        if (idCheck == false) {
            alert("아이디 중복체크를 해주세요")
            return;
        }

        const pattern = /\s/g; //공백체크 정규표현식


        let user_id = $("#user_id").val()
        if (user_id == "" || user_id == null || user_id == undefined) {
            alert("아이디를 입력주세요")
            return;
        }
        if (user_id.match(pattern)) {
            alert("아이디에는 공백이 들어갈 수 없습니다.")
            return;
        }

        let user_pwd = $("#user_pwd").val()
        if (user_pwd == "" || user_pwd == null || user_pwd == undefined) {
            alert("비밀번호를 입력주세요")
            return;
        }
        if (user_pwd.match(pattern)) {
            alert("비밀번호에는 공백이 들어갈 수 없습니다.")
            return;
        }
        let user_pwd_confirm = $("#user_pwd_confirm").val();
        if (user_pwd != user_pwd_confirm) {
            alert("비밀번호와 비밀번호 확인이 일치하지않습니다.")
            return;
        }

        let user_name = $("#user_name").val()
        if (user_name == "" || user_name == null || user_name == undefined) {
            alert("이름를 입력주세요")
            return;
        }
        if (user_name.match(pattern)) {
            alert("이름에는 공백이 들어갈 수 없습니다.")
            return;
        }


        const patternEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

        let user_email = $("#user_email").val()
        if (user_email == "" || user_email == null || user_email == undefined) {
            alert("이메일을 입력주세요")
            return;
        }
        if (user_email.match(pattern)) {
            alert("이메일에는 공백이 들어갈 수 없습니다.")
            return;
        }
        if (!user_email.match(patternEmail)) {
            // not을 붙여서 변수 이메일형식에 맞게 입력이 되지않았을때를 검사한다.
            alert("올바른 이메일형식을 입력하세요\n 예시)aaa@service.com")
            return;
        }
        if (emailCheck == false) {
            alert("이메일 중복체크를 해주세요")
            return;
        }
        let user_birth_year = $("#user_birth_year").val();
        let user_birth_month = $("#user_birth_month").val();
        let user_birth_date = $("#user_birth_date").val();
        let user_address = $("#sample6_address").val() + ' ' + $("#sample6_detailAddress").val()
        let address = $("#sample6_address").val();
        if (address == "" || address == null || address == undefined) {
            alert("주소를 입력하세요")
            return;
        }
        let user_phone = $("#user_phone").val();
        let user_card = $("#user_card").val();
        let user_account = $("#user_account").val();
        if (!inputValidation(user_birth_year, "생년월일")) { return; }
        if (!inputValidation(user_birth_month, "생년월일")) { return; }
        if (!inputValidation(user_birth_date, "생년월일")) { return; }
        if (!inputValidation(user_address, "주소")) { return; }
        if (!inputValidation(user_phone, "전화번호")) { return; }
        // if(!inputValidation(user_card,"")){return;} 필수항목이 아니다
        // if(!inputValidation(user_account,"")){return;}필수항목이 아니다        
        let user_gen = $("#user_gen option:selected").val();

        let birth = user_birth_year + leadingZero(user_birth_month) + leadingZero(user_birth_date);
        //user_birth_month 가 10보다 작으면 앞에 0을 붙인다.
        // (user_birth_month<10?"0"+user_birth_month:""+user_birth_month)+
        // //user_birth_date 가 10보다 작으면 앞에 0을 붙인다.
        // (user_birth_date<10?"0"+user_birth_date:""+user_birth_date)



        console.log(birth)
        let data = {
            mi_id: user_id,
            mi_pwd: user_pwd,
            mi_name: user_name,
            mi_email: user_email,
            mi_address: user_address,
            mi_birth: birth,
            mi_gen: user_gen,
            mi_phone: user_phone,
            mi_pay_card: user_card,
            mi_pay_account: user_account
        }

        $.ajax({
            type: 'post',
            url: '/member/join',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function (r) {
                if (r.status) {
                    alert(r.message)
                    location.href = "/";
                }
            },
            error: function (e) {
                console.log(e)
            }
        })
    })
    $("#chk_id").click(function () {
        // alert("클릭");
        const pattern = /\s/g; //공백체크 정규표현식
        let user_id = $("#user_id").val()
        if (user_id == "" || user_id == null || user_id == undefined) {
            alert("아이디를 입력주세요")
            return;
        }
        if (user_id.match(pattern)) {
            alert("아이디에는 공백이 들어갈 수 없습니다.")
            return;
        }

        $.ajax({
            type: "get",
            url: "/member/id_check?id=" + user_id,
            success: function (r) {
                alert(r.message)
                if (r.status == false) {
                    idCheck = false;
                }
                else {
                    idCheck = true;
                }
            }

        })
    })
    $("#chk_email").click(function () {
        // alert("클릭")
        const pattern = /\s/g;
        const patternEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
        let user_email = $("#user_email").val()
        if (user_email == "" || user_email == null || user_email == undefined) {
            alert("이메일을 입력주세요")
            return;
        }
        if (user_email.match(pattern)) {
            alert("이메일에는 공백이 들어갈 수 없습니다.")
            return;
        }
        if (!user_email.match(patternEmail)) {
            // not을 붙여서 변수 이메일형식에 맞게 입력이 되지않았을때를 검사한다.
            alert("올바른 이메일형식을 입력하세요\n 예시)aaa@service.com")
            return;
        }
        $.ajax({
            type: "get",
            url: "/member/email_check?email=" + user_email,
            success: function (r) {
                if (r.status == true) {
                    emailCheck = r.status;

                    $.ajax({
                        type: 'post',
                        url: '/sendEmail',
                        data: {
                            mi_email: user_email
                        },
                        contentType: "applicaion/json"
                    });
                    alert(user_email)
                    alert("인증번호가 전송되었습니다.")
                    isCertification = true; //추후 인증 여부를 알기위한 값
                    // 이메일 중복 체크후 인증보내기



                }
                else {
                    alert(r.message)
                }

            }
        })
    })
    $("#user_id").change(function () {
        idCheck = false;
    })
    $("#user_email").change(function () {
        emailCheck = false;
    })

    $("#address").click(function () {
        new daum.Postcode({
            oncomplete: function (data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if (data.userSelectedType === 'R') {
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if (data.buildingName !== '' && data.apartment === 'Y') {
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if (extraAddr !== '') {
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;

                } else {
                    document.getElementById("sample6_extraAddress").value = '참고사항 없음';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    })


    $("#test").click(function () {
      
        let mail = 'alexpark0926@gmail.com'

        $.ajax({
            type: 'post',
            url: '/sendEmail?mail='+mail,
            success:function(r){

                alert("인증번호가 전송되었습니다.")
            }

        });
      
    });

});

function leadingZero(n) {
    //입력받은 데이터를 숫자형태로 형변환
    let num = Number(n);
    //10미만의 숫자이면,앞쪽에 0을 붙인 문자열로 내보내고,
    //10미만의 숫자이면 문자열 형태로 변환해서 내보낸다.
    return num < 10 ? "0" + num : "" + num;
}
function inputValidation(input, type) {
    if (input == "" || input == null || input == undefined) {
        alert(type + "을/를 입력해주세요");
        return false;
    }
    return true;
}