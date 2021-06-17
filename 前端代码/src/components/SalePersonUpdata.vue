<template>
  <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="姓名" prop="sno" >
      <el-input v-model="ruleForm.sno" readonly></el-input>
    </el-form-item>
    <el-form-item label="姓名" prop="sname" >
      <el-input v-model="ruleForm.sname"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="sex">
      <el-input v-model="ruleForm.sex"></el-input>
    </el-form-item>
    <el-form-item label="年龄" prop="age">
      <el-input v-model="ruleForm.age"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="phone">
      <el-input v-model="ruleForm.phone"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      ruleForm: {
        bno:'',
        sname: '',
        sex: '',
        age: '',
        phone: '',
      },
      rules: {
        sname: [
          { required: true, message: '姓名不能为空', trigger: 'blur' }
        ],
        sex: [
          { required: true, message: '性别不能为空', trigger: 'blur' }
        ],
        age: [
          { required: true, message: '年龄不能为空', trigger: 'blur' }
        ],
        phone: [
          { required: true, message: '电话不能为空', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.post('http://localhost:8082/superadmin/modifysalesperson',_this.ruleForm).then(function (resp){
            _this.$alert('修改成功', '提示', {
              confirmButtonText: '确定',
              callback: action => {
                _this.$router.push('/salePersonList')
              }
            });
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  created () {
    const _this = this
    axios.get('http://localhost:8082/superadmin/getSalePersonById/'+this.$route.query.sno).then(function (resp){
      _this.ruleForm=resp.data
    })

  }
}
</script>
