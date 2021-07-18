
// http://blog.naver.com/PostView.nhn?blogId=realuv&logNo=220699272999 <<정규표현식 확인할때 봐라

$(function(){
    let idCheck = false;
    let emailCheck=false;
    $("#join").click(function(){
        // alert("클릭했다")
        if(idCheck==false){
            alert("아이디 중복체크를 해주세요")
            return;
        }
       
        const pattern = /\s/g; //공백체크 정규표현식


        let user_id = $("#user_id").val()
        if(user_id==""||user_id==null||user_id==undefined){
            alert("아이디를 입력주세요")
            return;
        }
        if(user_id.match(pattern)){
            alert("아이디에는 공백이 들어갈 수 없습니다.")
            return;
        }
        
        let user_pwd = $("#user_pwd").val()
        if(user_pwd==""||user_pwd==null||user_pwd==undefined){
            alert("비밀번호를 입력주세요")
            return;
        }
        if(user_pwd.match(pattern)){
            alert("비밀번호에는 공백이 들어갈 수 없습니다.")
            return;
        }
        let user_pwd_confirm = $("#user_pwd_confirm").val();
        if(user_pwd!=user_pwd_confirm){
            alert("비밀번호와 비밀번호 확인이 일치하지않습니다.")
            return;
        }

        let user_name = $("#user_name").val()
        if(user_name==""||user_name==null||user_name==undefined){
            alert("이름를 입력주세요")
            return;
        }
        if(user_name.match(pattern)){
            alert("이름에는 공백이 들어갈 수 없습니다.")
            return;
        }
        

        const patternEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;         
        
        let user_email = $("#user_email").val()
        if(user_email==""||user_email==null||user_email==undefined){
            alert("이메일을 입력주세요")
            return;
        }
        if(user_email.match(pattern)){
            alert("이메일에는 공백이 들어갈 수 없습니다.")
            return;
        }
        if(!user_email.match(patternEmail)){ 
            // not을 붙여서 변수 이메일형식에 맞게 입력이 되지않았을때를 검사한다.
            alert("올바른 이메일형식을 입력하세요\n 예시)aaa@service.com")
            return;
        }
        if(emailCheck==false){
            alert("이메일 중복체크를 해주세요")
            return;        }
        let user_birth_year=$("#user_birth_year").val();
        let user_birth_month=$("#user_birth_month").val();
        let user_birth_date=$("#user_birth_date").val();
        let user_address=$("#user_address").val();
        let user_phone=$("#user_phone").val();
        let user_card=$("#user_card").val();
        let user_account=$("#user_account").val();
        if(!inputValidation(user_birth_year,"생년월일")){return;}
        if(!inputValidation(user_birth_month,"생년월일")){return;}
        if(!inputValidation(user_birth_date,"생년월일")){return;}
        if(!inputValidation(user_address,"주소")){return;}
        if(!inputValidation(user_phone,"전화번호")){return;}
        // if(!inputValidation(user_card,"")){return;} 필수항목이 아니다
        // if(!inputValidation(user_account,"")){return;}필수항목이 아니다        
        let user_gen=$("#user_gen option:selected").val();

        let birth = user_birth_year+leadingZero(user_birth_month)+leadingZero(user_birth_date);
        //user_birth_month 가 10보다 작으면 앞에 0을 붙인다.
        // (user_birth_month<10?"0"+user_birth_month:""+user_birth_month)+
        // //user_birth_date 가 10보다 작으면 앞에 0을 붙인다.
        // (user_birth_date<10?"0"+user_birth_date:""+user_birth_date)


         
         console.log(birth)
        let data={
        mi_id:user_id,
        mi_pwd:user_pwd,
        mi_name:user_name,
        mi_email:user_email,
        mi_address:user_address,
        mi_birth:birth,
        mi_gen:user_gen,
        mi_phone:user_phone,
        mi_pay_card:user_card,
        mi_pay_account:user_account
             }

             $.ajax({
                type:'post',
                url:'/member/join',
                data:JSON.stringify(data),
                contentType:'application/json',
                success:function(r){
                    alert(r.message)
                    if(r.status){
                        location.href="/";
                    }                    
                },
                error:function(e){
                    console.log(e)
                }
             })
        })
        $("#chk_id").click(function(){
            // alert("클릭");
            const pattern = /\s/g; //공백체크 정규표현식
        let user_id = $("#user_id").val()
        if(user_id==""||user_id==null||user_id==undefined){
            alert("아이디를 입력주세요")
            return;
        }
        if(user_id.match(pattern)){
            alert("아이디에는 공백이 들어갈 수 없습니다.")
            return;
        }

        $.ajax({
            type:"get",
            url:"/member/id_check?id="+user_id,
            success:function(r){
                alert(r.message)
                if(r.status==false){
                    idCheck=false;
                }
                else{
                    idCheck=true;
                }
            }

        })
        })
        $("#chk_email").click(function(){
            // alert("클릭")
            const pattern = /\s/g;
            const patternEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;          
            let user_email = $("#user_email").val()
            if(user_email==""||user_email==null||user_email==undefined){
                alert("이메일을 입력주세요")
                return;
            }
            if(user_email.match(pattern)){
                alert("이메일에는 공백이 들어갈 수 없습니다.")
                return;
            }
            if(!user_email.match(patternEmail)){ 
                // not을 붙여서 변수 이메일형식에 맞게 입력이 되지않았을때를 검사한다.
                alert("올바른 이메일형식을 입력하세요\n 예시)aaa@service.com")
                return;
            }
            $.ajax({
                type:"get",
                url:"/member/email_check?email="+user_email,
                success:function(r){
                    alert(r.message)
                   emailCheck=r.status;
                    }                   
            })
        })
        $("#user_id").change(function(){
            idCheck=false;
        })
        $("#user_email").change(function(){
            emailCheck=false;
        })
    });
    
    function leadingZero(n){
        //입력받은 데이터를 숫자형태로 형변환
        let num = Number(n);
        //10미만의 숫자이면,앞쪽에 0을 붙인 문자열로 내보내고,
        //10미만의 숫자이면 문자열 형태로 변환해서 내보낸다.
        return num<10?"0"+num:""+num;
        }
    function inputValidation(input, type){
        if(input =="" || input == null || input ==undefined){
            alert(type+"을/를 입력해주세요");
            return false;
        }
        return true;
    }

