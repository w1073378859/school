// $(function(){
//
// 	//动态加载就诊科室列表json
// 	$.ajax({
// 		type:"GET",//请求类型
// 		url: projectName + "/api/department/getDepartmentList.json",//请求的url
// 		dataType:"json",//ajax接口（请求url）返回的数据类型
// 		success:function(data){//data：返回数据（json对象）
// 			if(data.code == 200){
// 				data = data.data;
// 				var options = "<option value=\"\">--请选择--</option>";
// 				for(var i = 0; i < data.length; i++){
// 					options += "<option value=\""+data[i].id+"\">"+data[i].name+"</option>";
// 				}
// 				$("#departmentId").html(options);
//
// 				// 回显查询条件就诊科室
// 				var queryDepartmentId = $("#queryDepartmentId").val();
// 				$("#departmentId ").val(queryDepartmentId);
// 				// console.log(queryDepartmentId);
//
// 				if(queryDepartmentId != 0){
// 					$.ajax({
// 						type: "POST",//请求类型
// 						url: projectName + "/api/users/getDoctorList.json",//请求的url
// 						data:{departmentId:queryDepartmentId},
// 						dataType: "json",//ajax接口（请求url）返回的数据类型
// 						success:function(data){//data：返回数据（json对象）
// 							if(data.code == 200){
// 								data = data.data;
// 								var options = "<option value=\"\">--请选择--</option>";
// 								for(var i = 0; i < data.length; i++){
// 									options += "<option value=\""+data[i].id+"\" >"+data[i].userName+"</option>";
// 								}
// 								$("#doctorId").html(options);
//
// 								// 回显查询条件就诊医师
// 								var queryDoctorId = $("#queryDoctorId").val();
// 								// console.log(queryDoctorId);
// 								$("#doctorId ").val(queryDoctorId);
// 							} else {
// 								alert("就诊医生查询失败");
// 							}
// 						},
// 						error:function(){//当访问时候，404，500 等非200的错误状态码
// 							alert("就诊医生查询失败");
// 						}
// 					});
// 				}
// 			}
// 		},
// 		error:function(){//当访问时候，404，500 等非200的错误状态码
// 			alert("加载用户类型失败！");
// 		}
// 	});
//
// });
// // 根据就诊科室查询就诊医生列表
// function departmentFun() {
// 	var departmentId = $('select option:selected').val();
//
// 	if(departmentId != 0){
// 		console.log(departmentId);
// 		$.ajax({
// 			type: "POST",//请求类型
// 			url: projectName + "/api/users/getDoctorList.json",//请求的url
// 			data:{departmentId:departmentId},
// 			dataType: "json",//ajax接口（请求url）返回的数据类型
// 			success:function(data){//data：返回数据（json对象）
// 				//console.log(data);
// 				if(data.code == 200){
// 					data = data.data;
// 					var options = "<option value=\"\">--请选择--</option>";
// 					for(var i = 0; i < data.length; i++){
// 						options += "<option value=\""+data[i].id+"\" >"+data[i].userName+"</option>";
// 					}
// 					$("#doctorId").html(options);
// 				} else {
// 					alert("就诊医生查询失败");
// 				}
// 			},
// 			error:function(){//当访问时候，404，500 等非200的错误状态码
// 				alert("就诊医生查询失败");
// 			}
// 		});
// 	}
// }
//
// // 查看详情按钮事件
// $('.viewRegister').on("click", function () {
// 	let id = $(this).data('down');
// 	window.location.href= projectName + "/api/register/registerView/"+ id;
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
			this.$refs.getRegisterList.pageNum.value = num;
			this.$refs.getRegisterList.submit();
		},
		//动态加载就诊科室列表
		getDepartmentList(){
			axios.get(projectName+'/api/department/getDepartmentList.json')
				.then(rs => {
					if(rs.data.code==200){
						let data = rs.data.data;
						let htm = `<option value="">--请选择--</option>`;
						for (let i = 0; i < data.length; i++) {
							htm +=`<option value="${data[i].id}">${data[i].name}</option>`;
						}
						$("#departmentId").html(htm);
					}

				})
				.catch(error =>{
					alert("获取就诊科室失败！");
				})
		},
		//获取医生列表
		getDoctorList(){

			axios.get(projectName+'/api/users/getDoctorList.json',{params: {departmentId:this.departmentId}})
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
		getRegisterList(pageNum){
				axios.get(projectName+'/api/register/getRegisterList.json',
					{params: {pageNum:pageNum,idCard: this.idCard,departmentId:this.departmentId,userId:this.doctorId,status:this.status}})
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
		}
	},
	watch:{
		departmentId(){
				this.getDoctorList();
				this.getRegisterList(1);
		},
		idCard(){
			if(this.idCard.length==15 || this.idCard.length == 18  || this.idCard.length==0){
				this.getRegisterList(1);
			}
		},
		doctorId(){
			this.getRegisterList(1);
		},
		status(){
			this.getRegisterList(1);
		}
	},
	created(){
		this.getDepartmentList();
		this.getRegisterList(1);
	}
})

