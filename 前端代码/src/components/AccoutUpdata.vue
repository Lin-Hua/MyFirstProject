<template>
  <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="编号" prop="mno">
      <el-input v-model="ruleForm.mno" readonly></el-input>
    </el-form-item>
    <el-form-item label="姓名" prop="mname">
      <el-input v-model="ruleForm.mname"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="contact">
      <el-input v-model="ruleForm.contact"></el-input>
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
        mno:'',
        mname: '',
        contact: '',
      },
      rules: {
        mname: [
          { required: true, message: '客户姓名不能为空', trigger: 'blur' }
        ],
        contact: [
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
          axios.post('http://localhost:8082/superadmin/modifymember',_this.ruleForm).then(function (resp){
            _this.$alert('修改成功', '提示', {
              confirmButtonText: '确定',
              callback: action => {
                _this.$router.push('/AccountList')
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
    axios.get('http://localhost:8082/superadmin/getMemberById/'+this.$route.query.mno).then(function (resp){
      _this.ruleForm=resp.data
    })

  }
}
</script>


