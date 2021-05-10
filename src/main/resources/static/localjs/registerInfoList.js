// $(function(){
// 	let departmentId = $("#departmentId").val();
//
// 	// 动态加载就诊医生列表
// 	$.ajax({
// 		type: "POST",//请求类型
// 		url: projectName + "/api/users/getDoctorList.json",//请求的url
// 		data:{departmentId:departmentId},
// 		dataType: "json",//ajax接口（请求url）返回的数据类型
// 		success:function(data){//data：返回数据（json对象）
// 			if(data.code == 200){
// 				data = data.data;
// 				var options = "<option value=\"\">--请选择--</option>";
// 				for(var i = 0; i < data.length; i++){
// 					options += "<option value=\""+data[i].id+"\" >"+data[i].userName+"</option>";
// 				}
// 				$("#doctorId").html(options);
//
// 				// 回显查询条件就诊医师
// 				var queryDoctorId = $("#queryDoctorId").val();
// 				$("#doctorId").val(queryDoctorId);
// 			} else {
// 				alert("就诊医生查询失败");
// 			}
// 		},
// 		error:function(){//当访问时候，404，500 等非200的错误状态码
// 			alert("就诊医生查询失败");
// 		}
// 	});
// });
//
// // 查看详情按钮事件
// $('.viewRegister').on("click", function () {
// 	let id = $(this).data('down');
// 	window.location.href= projectName + "/api/register/registerView/"+ id;
// })
//
// // 开始问诊按钮事件
// $('.consultationAdd').on("click", function () {
// 	let id = $(this).data('down');
// 	window.location.href= projectName + "/api/consultation/consultationAdd?id=" + id;
// })


var app = new Vue({
	el:"#app",
	data:{
		departmentId:'',
		idCard:'',
		doctorId:'',
		status:0,
		list:[],
		pages:{},
		id:''
	},
	methods:{

		pageNav(num){
			this.$refs.getRegisterInfoList.pageNum.value = num;
			this.$refs.getRegisterInfoList.submit();
		},
		//获取医生列表
		getDoctorList(){
			axios.get(projectName+'/api/users/getDoctorList.json',{params: {departmentId:0}})
				.then(rs => {
					let data = rs.data.data;
					let htm = `<option value="">--请选择---</option>`;
					for (let i = 0; i < data.length; i++) {
						htm +=`<option value="${data[i].id}">${data[i].userName}</option>`;
					}
					$("#doctorId").html(htm);
				})
				.catch(error =>{
					alert("获取医生失败！");
				})
		},
		//获取列表
		getRegisterInfoList(pageNum){
			axios.get(projectName+'/api/register/getRegisterList.json',
				{params: {pageNum:pageNum,idCard: this.idCard,departmentId:0,userId:this.doctorId,status:this.status}})
				.then(rs =>{
					this.$data.list = rs.data.list;
					this.$data.pages = rs.data;

				})
				.catch(error =>{
					alert("获取挂号列表失败！");
				})
		},
		rsView(id){
			window.location.href= projectName + "/api/register/registerView/"+ id;
		},
		consultationAdd(id){
			window.location.href= projectName + "/api/consultation/consultationAdd?id=" + id;
		}
	},
	watch:{
		departmentId(){
			this.getDoctorList();
			this.getRegisterInfoList(1);
		},
		idCard(){
			if(this.idCard.length==15 || this.idCard.length == 18 || this.idCard.length==0){
				this.getRegisterInfoList(1);
			}
		},
		doctorId(){
			this.getRegisterInfoList(1);
		},
		status(){
			this.getRegisterInfoList(1);
		}
	},
	created(){
		this.getDoctorList();
		this.getRegisterInfoList(1);
	}
})

