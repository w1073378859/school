// // 医保卡号验证标识
// let idMedicareRes = true;
// $(function(){
//     // 时间段处理
//     let date = new Date();
//     let hour = date.getHours();
//     // 当前时间为下午，隐藏上午时间段
//     if(hour > 12){
//         $("#sign option[value = 1]").hide();
//     }
//
//
//     // 返回按钮事件
//     $("#back").on("click",function(){
//         window.location.href = projectName + "/api/users/index";
//     });
//
//     //动态加载就诊科室列表json
//     $.ajax({
//         type:"GET",//请求类型
//         url: projectName + "/api/department/getDepartmentList.json",//请求的url
//         dataType:"json",//ajax接口（请求url）返回的数据类型
//         success:function(data){//data：返回数据（json对象）
//             if(data.code == 200){
//                 data = data.data;
//                 var options = "<option value=\"\">--请选择--</option>";
//                 for(var i = 0; i < data.length; i++){
//                     options += "<option value=\""+data[i].id+"\">"+data[i].name+"</option>";
//                 }
//                 $("#departmentId").html(options);
//             }
//         },
//         error:function(){//当访问时候，404，500 等非200的错误状态码
//             alert("加载用户类型失败！");
//         }
//     });
//
//
//     // 根据身份证号查询就诊卡信息
//     $("#idCard").on("change",function () {
//         $("#idMedicare").val("");
//         $("#idMedicare").removeAttr("readonly")
//
//         var idCard = $("#idCard").val();
//         $.ajax({
//             type: "POST",//请求类型
//             url: projectName + "/api/patient/getPatientByIdCard.json",//请求的url
//             data: {idCard: idCard},
//             dataType: "json",//ajax接口（请求url）返回的数据类型
//             success: function (data) {//data：返回数据（json对象）
//                 if (data.code == 200) {
//                     var data = data.data;
//                     $("#name").val(data.name);
//                     $("#phone").val(data.phone);
//                     $("#relatives_birthday").val(data.birthday);
//                     var sex = "";
//                     if(data.sex == 1){
//                         sex = "女";
//                     } else {
//                         sex = "男";
//                     }
//                     $("#relatives_gender").val(sex);
//                     $("#address").val(data.address);
//
//                     // 若有医保卡，则不需要输入
//                     if(data.idMedicare != null && data.idMedicare != ''){
//                         $("#idMedicare").val(data.idMedicare);
//                         $("#idMedicare").attr("readonly","readonly");
//                     }
//
//                     $("#patientId").val(data.id);
//                 } else {
//                     alert("就诊卡信息查询失败,请先创建就诊卡!")
//                 }
//             },
//             error:function(){
//                 alert("就诊卡信息查询失败,请先创建就诊卡!");
//             }
//         });
//     });
// });
//
// // 提交表单校验
// $("#addRegisterForm").submit(function () {
//     if(!idMedicareRes){
//         return false;
//     }
// });
//
// // 医保卡号重复校验
// $("#idMedicare").on("change",function () {
//     let idMedicare = $("#idMedicare").val();
//     $.ajax({
//         type: "POST",//请求类型
//         url: projectName + "/api/patient/getPatientByIdMedicare.json",//请求的url
//         data: {idMedicare: idMedicare},
//         dataType: "json",//ajax接口（请求url）返回的数据类型
//         success: function (data) {//data：返回数据（json对象）
//             if (data.code == 200) {
//                 var data = data.data;
//                 if(data != null){
//                     idMedicareRes = false;
//                     $("#idMedicareSpan").show();
//                     $("#idMedicareSpan").text("该医保卡号已存在，请重新输入...");
//                 }
//             } else {
//                 idMedicareRes = true;
//                 $("#idMedicareSpan").hide();
//             }
//         },
//         error:function(){
//             alert("就诊卡信息查询失败");
//         }
//     });
// });
//
//
// // 选择完就诊科室和时间段后，动态加载医生列表
// function signFun() {
//     $("#roomNameDiv").hide();
//
//     var sign = $("#sign").find("option:checked").val();
//     var departmentId = $("#departmentId").find("option:checked").val();
//     // console.log("departmentId:" + departmentId)
//
//     if(departmentId == ""){
//         alert("请先选择就诊科室")
//     }
//
//     // 选择完时间段，动态加载医生列表
//     if(sign != 0 && departmentId != ""){
//         $.ajax({
//             type: "POST",//请求类型
//             url: projectName + "/api/schedule/getDoctorList.json",//请求的url
//             data:{departmentId:departmentId,sign:sign},
//             dataType: "json",//ajax接口（请求url）返回的数据类型
//             success:function(data){//data：返回数据（json对象）
//                 if(data.code == 200){
//                     data = data.data;
//                     console.log(data);
//                     var options = "<option value=\"\">--请选择--</option>";
//                     for(var i = 0; i < data.length; i++){
//                         options += "<option value=\""+data[i].userId+"\" data-down=\""+data[i].roomName+"\" data-sche=\""+data[i].id+"\" data-roomid=\""+data[i].roomId+"\" >"+data[i].doctorName+"</option>";
//                     }
//                     $("#doctorId").html(options);
//                 } else {
//                     var options = "<option value=\"\">--请重新选择时间段--</option>";
//                     $("#doctorId").html(options);
//                     alert("无可用就诊医生，请重新选择时间段");
//                 }
//             },
//             error:function(){//当访问时候，404，500 等非200的错误状态码
//                 var options = "<option value=\"\">--请重新选择时间段--</option>";
//                 $("#doctorId").html(options);
//                 alert("无可用就诊医生，请重新选择时间段");
//             }
//         });
//     }
// }
//
// // 重新选择就诊科室
// function departmentIdFun() {
//     $("#sign").val("");
//     var options = "<option value=\"\">--请先选择就诊科室和时间段--</option>";
//     $("#doctorId").html(options);
//     // $("#doctorId").val("");
//     $("#roomNameDiv").hide();
// }
//
// // 选择完就诊医师，动态加载就诊房间、ScheduleId和roomId
// function doctorFun() {
//     // 就诊房间名称
//     var roomName = $("#doctorId").find("option:selected").data("down");
//     // scheduleId
//     var scheduleId = $("#doctorId").find("option:selected").data("sche");
//     // console.log("scheduleId:" + scheduleId);
//     $("#scheduleId").val(scheduleId);
//     // roomId
//     var roomId = $("#doctorId").find("option:selected").data("roomid");
//     // console.log("roomId:" + roomId);
//     $("#roomId").val(roomId);
//
//     if(roomName != 0){
//         $("#roomName").val(roomName);
//         $("#roomNameDiv").show();
//     } else {
//         $("#roomNameDiv").hide();
//     }
// }
//
// // 点击使用医保按钮
// function isMedicareFun() {
//     $("#idMedicareDiv").show();
//     $("#idMedicare").attr('required','true');
//     // 是否使用医保卡 1-->未使用，2-->使用
//     $("#isMedicare").val(2);
//
//     $.ajax({
//         type: "POST",//请求类型
//         url: projectName + "/api/register/createFee.json",//请求的url
//         data:{sign:"medicare"},
//         dataType: "json",//ajax接口（请求url）返回的数据类型
//         success:function(data){//data：返回数据（json对象）
//             if(data.code == 200){
//                 data = data.data;
//                 $("#fee").val(data.fee);
//                 $("#medicareFee").val(data.medicareFee);
//                 $("#payFee").val(data.payFee);
//             } else {
//                 alert("挂号费加载失败");
//             }
//         },
//         error:function(){//当访问时候，404，500 等非200的错误状态码
//             alert("挂号费加载失败");
//         }
//     });
//
//     $("#feeDiv").show();
//     $("#medicareFeeDiv").show();
//     $("#payFeeDiv").show();
//
//     // 显示保存按钮
//     $("#send").attr("style", "visibility: visible;");
//
// }
//
// function noMedicareFun() {
//     $("#idMedicareDiv").hide();
//     $("#idMedicare").removeAttr("required");
//     // 是否使用医保卡 1-->未使用，2-->使用
//     $("#isMedicare").val(1);
//
//     $.ajax({
//         type: "POST",//请求类型
//         url: projectName + "/api/register/createFee.json",//请求的url
//         dataType: "json",//ajax接口（请求url）返回的数据类型
//         success:function(data){//data：返回数据（json对象）
//             console.log(data);
//             if(data.code == 200){
//                 data = data.data;
//                 $("#fee").val(data.fee);
//                 $("#medicareFee").val(data.medicareFee);
//                 $("#payFee").val(data.payFee);
//             } else {
//                 alert("挂号费加载失败");
//             }
//         },
//         error:function(){//当访问时候，404，500 等非200的错误状态码
//             alert("挂号费加载失败");
//         }
//     });
//
//     $("#feeDiv").show();
//     $("#medicareFeeDiv").show();
//     $("#payFeeDiv").show();
//
//     // 显示保存按钮
//     $("#send").attr("style", "visibility: visible;");
// }

axios.interceptors.request.use(config =>{
    NProgress.start();
    return config;
});

axios.interceptors.request.use(reps =>{
    NProgress.done();
    return reps;
})

var app = new Vue({
    el:'#app',
    data:{
        idMres:false,
        idCard:'',
        departmentVal:'',
        name:'',
        phone:'',
        bir:'',
        sex:'',
        address:'',
        sign:'',
        doctorVal:'',
        patientId:'',
        scheduleId:'',
        roomId:'',
        zje:'50',
        bx:'',
        sf:'',
        isMedicare:'',
        idMedicareVal:''
    },
    methods:{
        getDepartmentList(){
            axios.get(projectName+'/api/department/getDepartmentList.json')
                .then(response => {
                    let data = response.data.data;
                    let htm = `<option value="" selected>-请选择就诊科室-</option>`;
                    for (let i = 0; i < data.length; i++) {
                        htm+=`<option value="${data[i]["id"]}">${data[i]["name"]}</option>`;
                    }
                    $("#departmentId").html(htm);

                })
                .catch(error => {
                    console.log(error);
                })
        },
        getPatientByIdCard(){
            let urlSearchParams = new URLSearchParams();
            urlSearchParams.append('idCard',this.idCard);
            axios.post(projectName+'/api/patient/getPatientByIdCard.json',urlSearchParams)
                .then(response =>{
                    let data = response.data;
                    let idM = data.data.idMedicare;
                    //console.log(response);
                    if(data.code == 200){
                        this.$data.name = data.data.name;
                        this.$data.phone = data.data.phone;
                        this.$data.bir = data.data.birthday;
                        if(data.data.sex==1){
                            this.$data.sex = "女";
                        }else if(data.data.sex==2){
                            this.$data.sex = "男";
                        }

                        this.$data.address = data.data.address;
                        this.$data.patientId = data.data.id;

                        if(idM != null && idM != ''){
                           this.$data.idMedicareVal = idM;
                           this.$data.idMres = true;
                            $("#idMedicare").attr("readonly","readonly");
                        }else
                        if(idM=="" || idM==null){
                            this.$data.idMedicareVal ="";

                        }

                    }else {
                        alert("就诊卡信息查询失败,请先创建就诊卡!");
                    }
                })
                .catch(error => {
                    alert("就诊卡信息查询失败,请先创建就诊卡!");
                })
        },
        getDoctorList(){
            let departmentVal = this.departmentVal;
            let sign = this.sign;
            if(departmentVal==null || departmentVal==''){
                alert("请先选择就诊科室");
                $("#sign").html("<option value=\"\" selected>--请选择--</option>\n" +
                    "                <option value=\"1\">上午</option>\n" +
                    "                <option value=\"2\">下午</option>");
            }
            axios.get(projectName+'/api/schedule/getDoctorList.json',{params: {departmentId:departmentVal,sign:sign}})
                .then(rs => {
                       if (rs.data.code != 200) {
                           alert(rs.data.msg);
                       } else {
                           let htm = `<option value="">--请先选择就诊科室和时间段--</option>`;
                           let data = rs.data.data;
                           for (let i = 0; i < rs.data.data.length; i++) {
                               htm += `<option data-roomid='${rs.data.data[i].roomId}' data-scheduleid='${rs.data.data[i].id}' data-room='${rs.data.data[i].roomName}' value="${data[i].userId}">${data[i].doctorName}</option>`;
                           }
                           $("#doctorId").html(htm);
                       }
                })
                .catch(error => {
                    alert(rs.data.msg);
                })
        },
        getPatientByIdMedicare(){
            let idMedicare = this.idMedicareVal;
            axios.get(projectName+'/api/patient/getPatientByIdMedicare.json',{params: {idMedicare:idMedicare}})
                .then(rs => {
                    if(rs.data.code!=200){
                        $("#idMedicareSpan").hide();
                    }else if(!this.$data.idMres) {
                            $("#idMedicareSpan").show();
                            $("#idMedicareSpan").text("该医保卡号已存在，请重新输入...");
                        }

                })
                .catch(error => {
                    alert("就诊卡信息查询失败");
                })
        },
        updTime(){
                   //时间段处理
            let date = new Date();
            let hour = date.getHours();
            // 当前时间为下午，隐藏上午时间段
            if(hour > 12){
                $("#sign option[value = 1]").hide();
            }
        },
        isMedicareFun(){
            $("#idMedicareDiv").show();
            if(this.idMedicareVal==""){

                this.getPatientByIdCard();
            }
            $("#feeDiv").show();
            $("#medicareFeeDiv").show();
            $("#payFeeDiv").show();
            $("#send").attr("style", "visibility: visible;");
            this.isMedicare = 1;
            this.bx = 40;
            this.sf = 10;
        },
        noMedicareFun(){
            $("#idMedicareDiv").hide();
            this.idMedicareVal = "";
            $("#feeDiv").show();
            $("#medicareFeeDiv").show();
            $("#payFeeDiv").show();
            $("#send").attr("style", "visibility: visible;");
            this.isMedicare = 2;
            this.bx = 0;
            this.sf = 50;
        }
    },
    watch: {
        "idCard"() {
            if (this.idCard.length == 18) {
                this.getPatientByIdCard();
            }
        },
        "departmentVal"() {
            this.sign = '';
        },
        "sign"() {
            this.getDoctorList();

        },
        "doctorVal"() {
            if (this.doctorVal != null) {
                $("#roomNameDiv").show();
                $("#roomName").val($("#doctorId").find("option:selected").data("room"));
                this.scheduleId = $("#doctorId").find("option:selected").data("scheduleid");
                this.roomId = $("#doctorId").find("option:selected").data("roomid");
            }

        },
        idMedicareVal() {
            if(this.idMedicareVal=="" || this.idMedicareVal==null){
                $("#idMedicare").removeAttr("readonly","readonly");
            }
            if(this.isMedicare != 2){
                this.getPatientByIdMedicare();
            }
        }
    },
    created(){
        this.getDepartmentList();
        //初始化时间
        this.updTime();

    }
});