<template>
  <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="订单编号" prop="orderno">
      <el-input v-model="ruleForm.orderno" readonly></el-input>
    </el-form-item>
    <el-form-item label="销售员编号" prop="sno">
      <el-input v-model="ruleForm.sno"></el-input>
    </el-form-item>
    <el-form-item label="客户编号" prop="mno">
      <el-input v-model="ruleForm.mno"></el-input>
    </el-form-item>
    <el-form-item label="图书编号" prop="bno">
      <el-input v-model="ruleForm.bno"></el-input>
    </el-form-item>
    <el-form-item label="日期" prop="saletime">
      <el-input v-model="ruleForm.saletime"></el-input>
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
        orderno:'',
        mno: '',
        bno: '',
        sno:'',
        saletime:''
      },
      rules: {
        mno: [
          { required: true, message: '客户编号不能为空', trigger: 'blur' }
        ],
        bno: [
          { required: true, message: '图书编号不能为空', trigger: 'blur' }
        ],
        sno: [
          { required: true, message: '销售人员编号不能为空', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.post('http://localhost:8082/superadmin/modifysale',_this.ruleForm).then(function (resp){
            _this.$alert('修改成功', '提示', {
              confirmButtonText: '确定',
              callback: action => {
                _this.$router.push('/salesRecord')
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
    axios.get('http://localhost:8082/superadmin/getSaleById/'+this.$route.query.orderno).then(function (resp){
      _this.ruleForm=resp.data
    })

  }
}
</script>
