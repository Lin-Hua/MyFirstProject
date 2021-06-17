<template>
  <div>
    <el-table
      :data="salePerson"
      border
      style="width: 90%">
      <el-table-column
        fixed
        prop="sno"
        label="序号"
        min-width="120">
      </el-table-column>
      <el-table-column
        prop="sname"
        label="书名"
        min-width="120">
      </el-table-column>
      <el-table-column
        prop="sex"
        label="性别"
        min-width="120">
      </el-table-column>
      <el-table-column
        prop="age"
        label="年龄"
        min-width="120">
      </el-table-column>
      <el-table-column
        prop="phone"
        label="电话"
        min-width="120">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        min-width="120">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
          <el-button @click="deleteSalePerson(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'SalePersonList',
  methods: {
    deleteSalePerson(row){
      const _this =this
      axios.get('http://localhost:8082/superadmin/deletesalesperson/?id='+row.sno).then(function (resp) {
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
        path:'/salePersonUpdata',
        query:{
          sno:row.sno
        }
      })
    }
  },
  data () {
    return {
      msg: 'Hello word',
      salePerson: [],
      open_list:["3"]
    }
  },
  created () {
    const _this = this
    // eslint-disable-next-line no-unused-expressions,no-undef
    axios.get('http://localhost:8082/superadmin/listsalesperson').then(function (resp) {
      _this.salePerson = resp.data
    })
  }
}
</script>

<style scoped>

</style>
