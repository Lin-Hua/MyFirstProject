<template>
  <div>
    <el-table
      :data="members"
      border
      style="width: 90%">
      <el-table-column
        fixed
        prop="mno"
        label="序号"
        min-width="120">
      </el-table-column>
      <el-table-column
        prop="mname"
        label="姓名"
        min-width="120">
      </el-table-column>
      <el-table-column
        prop="contact"
        label="联系电话"
        min-width="120"
      >
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        min-width="120">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
          <el-button @click="deleteAccount(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'AccountList',
  methods: {
    deleteAccount(row){
      const _this =this
      axios.get('http://localhost:8082/superadmin/deletemember/?id='+row.mno).then(function (resp) {
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
        path:'/AccountUpdata',
        query:{
          mno:row.mno
        }
      })
    }
  },
  data () {
    return {
      msg: 'Hello word',
      members: [],
      open_list:["1"]
    }
  },
  created () {
    const _this = this
    // eslint-disable-next-line no-unused-expressions,no-undef
    axios.get('http://localhost:8082/superadmin/listmember').then(function (resp) {
      _this.members = resp.data
    })
  }
}
</script>

<style scoped>

</style>
