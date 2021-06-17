<template>
  <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
  <el-form-item label="书名" prop="bname">
    <el-input v-model="ruleForm.bname"></el-input>
  </el-form-item>
    <el-form-item label="类型" prop="type">
      <el-input v-model="ruleForm.type"></el-input>
    </el-form-item>
    <el-form-item label="进价" prop="buyPrice">
      <el-input v-model="ruleForm.buyPrice"></el-input>
    </el-form-item>
    <el-form-item label="售价" prop="sellprice" class="item">
      <el-input v-model="ruleForm.sellprice"></el-input>
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
        bname: '',
        type: '',
        buyPrice: '',
        sellprice: '',
      },
      rules: {
        bname: [
          { required: true, message: '书名不能为空', trigger: 'blur' }
        ],
        type: [
          { required: true, message: '类型不能为空', trigger: 'blur' }
        ],
        buyPrice: [
          { required: true, message: '进价不能为空', trigger: 'blur' }
        ],
        sellprice: [
          { required: true, message: '售价不能为空', trigger: 'blur' }
        ]
      }
    };
  },

  methods: {
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
            axios.post('http://localhost:8082/superadmin/addbooks',_this.ruleForm).then(function (resp){
                _this.$alert('添加成功', '提示', {
                  confirmButtonText: '确定',
                  callback: action => {
                    _this.$router.push('/bookList')
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
  }
}
</script>
<style>
.el-form-item__label{
  color: white;
}
</style>
