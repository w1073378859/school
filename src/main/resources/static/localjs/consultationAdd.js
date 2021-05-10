// // 添加医嘱按钮事件
// $("#addMedicalAdvice").on("click",function () {
// 	let chiefComplaint = $("#chiefComplaint").val();
// 	let diagnosis = $("#diagnosis").val();
// 	let registryId = $("#registryId").val();
// 	let userId = $("#userId").val();
// 	// console.log("chiefComplaint" + chiefComplaint);
// 	// console.log("diagnosis" + diagnosis);
// 	// console.log("registryId" + registryId);
//
// 	$.ajax({
// 		type: "POST",//请求类型
// 		url: projectName + "/api/consultation/medicalAdviceAdd.json",//请求的url
// 		data:{registryId:registryId, userId:userId, chiefComplaint:chiefComplaint, diagnosis:diagnosis},
// 		dataType: "json",//ajax接口（请求url）返回的数据类型
// 		success:function(data){//data：返回数据（json对象）
// 			if(data.code == 200){
// 				alert("添加医嘱成功");
// 				data = data.data;
// 				$("#chiefComplaint").val(data.chiefComplaint);
// 				$("#diagnosis").val(data.diagnosis);
// 			} else {
// 				alert("添加医嘱失败");
// 			}
// 		},
// 		error:function(){//当访问时候，404，500 等非200的错误状态码
// 			alert("添加医嘱失败");
// 		}
// 	});
// });
//
// $("#back").on("click",function(){
// 	window.location.href = projectName + "/api/register/registerInfoList";
// });

var app = new Vue({
	el:"#app",
	data:{
		chiefComplaint:'',
		diagnosis:''
	},
	methods:{
		medicalAdviceAdd(){
			let registryId = $("#registryId").val();
			let userId = $("#userId").val();

			let urlSearchParams = new URLSearchParams();
			urlSearchParams.append('registryId',registryId);
			urlSearchParams.append('userId',userId);
			urlSearchParams.append('chiefComplaint',this.chiefComplaint);
			urlSearchParams.append('diagnosis',this.diagnosis);
			axios.post(projectName+ "/api/consultation/medicalAdviceAdd.json",urlSearchParams)
				.then(rs =>{
					console.log(rs);
					if(rs.data.code == 200){
						alert("添加或修改医嘱成功");
						data = rs.data.data;
						this.$data.chiefComplaint = data.chiefComplaint;
						this.$data.diagnosis = data.diagnosis;
					} else {
						alert("添加医嘱失败");
					}
				})
				.catch(er =>{
					alert("添加医嘱失败！");
				})
		},
		back(){
			window.location.href = projectName + "/api/register/registerInfoList";
		},
		medicalAdvice(){
			let id = $("#registryId").val();
			axios.get(projectName+"/api/consultation/medicalAdvice.json",{params: {id:id}})
				.then(rs =>{
					console.log(rs);
					data = rs.data;
					this.$data.chiefComplaint = data.chiefComplaint;
					this.$data.diagnosis = data.diagnosis;
				})
				.catch(er =>{

				})
		}

	},
	watch:{

	}
	,
	created(){
		this.medicalAdvice();
	}
})

	
	