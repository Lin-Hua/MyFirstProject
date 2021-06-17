<template>
  <div>
    <el-input style="width: 80%;margin: 10px" v-model="input" placeholder="请输入图书编号"></el-input>
    <el-button @click="search('input')" type="primary" icon="el-icon-search" style="position: relative;">搜索</el-button>
    <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" >
      <el-form-item   label="编号" prop="bno">
        <el-input v-model="ruleForm.bno" readonly></el-input>
      </el-form-item>
      <el-form-item label="书名" prop="bname">
        <el-input v-model="ruleForm.bname" readonly></el-input>
      </el-form-item>
      <el-form-item label="类型" prop="type">
        <el-input v-model="ruleForm.type" readonly></el-input>
      </el-form-item>
      <el-form-item label="进价" prop="buyPrice">
        <el-input v-model="ruleForm.buyPrice" readonly></el-input>
      </el-form-item>
      <el-form-item label="售价" prop="sellprice">
        <el-input style="border: 0" v-model="ruleForm.sellprice" readonly></el-input>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import axios from 'axios'

export default {
  name: 'SearchBook',
  methods:{
    search(input){
      const _this=this
      axios.get('http://localhost:8082/superadmin/getBookById/'+this.input).then(function (resp) {
        _this.ruleForm=resp.data
      })
    },
    deletebook(row){
      const _this =this
      axios.get('http://localhost:8082/superadmin/deletebook/?id='+row.bno).then(function (resp) {
        _this.$alert('删除成功', '提示', {
          confirmButtonText: '确定',
          callback: action => {
            window.location.reload();
          }
        })
      })
    },
    edit(row) {
      this.$router.push({
        path:'/bookUpdata',
        query:{
          bno:row.bno
        }
      })
    }
  },
  data () {
    return {
      input: '',
      ruleForm: {
        bno:'',
        bname: '',
        type: '',
        buyPrice: '',
        sellprice: '',
      },
    }
  }
}
</script>

<style scoped>
</style>
